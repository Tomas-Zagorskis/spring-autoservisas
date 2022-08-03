package lt.codeacademy.springautoservisas.controllers;

import lombok.AllArgsConstructor;
import lt.codeacademy.springautoservisas.entities.User;
import lt.codeacademy.springautoservisas.exceptions.UserNotFoundException;
import lt.codeacademy.springautoservisas.repos.RoleRepository;
import lt.codeacademy.springautoservisas.services.UserService;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@AllArgsConstructor
@Controller
@Secured("ROLE_ADMIN")
@RequestMapping("/private/users")
public class UserController {

    private final UserService userService;
    private final RoleRepository roleRepository;

    @GetMapping
    public String showUserList(Pageable pageable, Model model) {

        model.addAttribute("users", userService.listAll(pageable));
        return "users";
    }

    @GetMapping("/new")
    public String showNewForm(Model model) {

        model.addAttribute("user", new User());
        model.addAttribute("roles", roleRepository.findAll());
        return "userForm";
    }

    @PostMapping("/new")
    public String saveUser(User user, RedirectAttributes redirectAttributes) {


        userService.saveNewUser(user);
        redirectAttributes.addFlashAttribute("message", "msg.user.save.success");
        redirectAttributes.addFlashAttribute("username", user.getUsername());
        return "redirect:/private/users";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") String id, Model model) {

        User user = userService.getUser(id);
        model.addAttribute("user", user);
        model.addAttribute("roles", roleRepository.findAll());
        return "userForm";
    }
    @PostMapping("/edit/{id}")
    public String saveEditedUser(@PathVariable("id") String id, RedirectAttributes redirectAttributes) {

        userService.saveUser(userService.getUser(id));
        redirectAttributes.addFlashAttribute("message", "msg.user.save.success");
        redirectAttributes.addFlashAttribute("username", id);
        return "redirect:/private/users";
    }

    @PostMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") String id, RedirectAttributes redirectAttributes) {

            redirectAttributes.addFlashAttribute("username", id);
            userService.delete(id);
            redirectAttributes.addFlashAttribute("message", "msg.user.delete.success");
        return "redirect:/private/users";
    }

    @ExceptionHandler(UserNotFoundException.class)
    public String userNotFound(UserNotFoundException e, Model model) {

        model.addAttribute("messageCode", e.getMessage());
        model.addAttribute("id", e.getUserId());

        return "error/recordNotFound";
    }
}
