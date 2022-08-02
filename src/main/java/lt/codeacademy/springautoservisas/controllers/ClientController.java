package lt.codeacademy.springautoservisas.controllers;

import lombok.AllArgsConstructor;
import lt.codeacademy.springautoservisas.entities.Client;
import lt.codeacademy.springautoservisas.exceptions.ClientNotFoundException;
import lt.codeacademy.springautoservisas.services.ClientService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.UUID;

@AllArgsConstructor
@Controller
@RequestMapping("/private/clients")
public class ClientController {

    private final ClientService clientService;


    @GetMapping
    public String showClientsPage(
            @SortDefault(sort = "surname", caseSensitive = false)
            Pageable pageable, Model model, String keyword) {

        if (keyword != null) {
            model.addAttribute("clients", clientService.findByKeyword(pageable, keyword));
        } else {
            model.addAttribute("clients", clientService.getClients(pageable));
        }
        return "clients";
    }

    @GetMapping("/new")
    public String showNewClientForm(Model model) {

        model.addAttribute("client", new Client());
        return "clientForm";
    }

    @PostMapping("/new")
    public String createClient(@Valid Client client, BindingResult errors,
                               RedirectAttributes redirectAttributes) {

        if (errors.hasErrors()) {
            return "clientForm";
        }
        clientService.createClient(client);
        redirectAttributes.addFlashAttribute("message", "msg.client.create.success");
        redirectAttributes.addFlashAttribute("fullName", client.getFullName());
        return "redirect:/private/clients";
    }

    @GetMapping("/{id}")
    public String showClientDetails(@PathVariable UUID id, Model model) {

        model.addAttribute("client", clientService.getClientById(id));
        return "clientForm";
    }

    @PostMapping("/{id}")
    public String updateClient(@Valid Client client, BindingResult errors,
                               RedirectAttributes redirectAttributes) {

        if (errors.hasErrors()) {
            return "clientForm";
        }
        clientService.saveClient(client);
        redirectAttributes.addFlashAttribute("message", "msg.client.update.success");
        redirectAttributes.addFlashAttribute("fullName", client.getFullName());
        return "redirect:/private/clients";
    }

    @PostMapping("/delete/{id}")
    public String removeClient(@PathVariable UUID id, RedirectAttributes redirectAttributes) {

        redirectAttributes.addFlashAttribute("fullName", clientService.getClientById(id).getFullName());
        clientService.removeClient(id);
        redirectAttributes.addFlashAttribute("message", "msg.client.delete.success");
        return "redirect:/private/clients";
    }

    @ExceptionHandler(ClientNotFoundException.class)
    public String clientNotFound(ClientNotFoundException e, Model model) {

        model.addAttribute("messageCode", e.getMessage());
        model.addAttribute("id", e.getClientId());

        return "error/recordNotFound";
    }
}
