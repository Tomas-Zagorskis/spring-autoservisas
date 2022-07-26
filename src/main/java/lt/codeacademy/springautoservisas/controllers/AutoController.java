package lt.codeacademy.springautoservisas.controllers;

import lombok.AllArgsConstructor;
import lt.codeacademy.springautoservisas.entities.Auto;
import lt.codeacademy.springautoservisas.entities.Client;
import lt.codeacademy.springautoservisas.services.AutoService;
import lt.codeacademy.springautoservisas.services.ClientService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@AllArgsConstructor
@Controller
@RequestMapping("/autos")
public class AutoController {

    private final AutoService autoService;
    private final ClientService clientService;

    @GetMapping
    public String showAutosPage(
            @SortDefault(sort = "regTime", direction = Sort.Direction.DESC)
            Pageable pageable, Model model, String keyword) {

        if (keyword != null) {
            model.addAttribute("autos", autoService.findByKeyword(pageable, keyword));
        } else {
            model.addAttribute("autos", autoService.getAutos(pageable));
        }
        return "autos";
    }

    @GetMapping("/new")
    public String showNewAutoForm(Model model) {

        model.addAttribute("auto", new Auto());
        model.addAttribute("clients", clientService.getClients(Pageable.unpaged()));
        return "autoForm";
    }

    @PostMapping("/new")
    public String addAuto(Auto auto, Client client, RedirectAttributes redirectAttributes) {

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        auto.setRegTime(now.format(format));
        autoService.addAuto(auto, client);
        redirectAttributes.addFlashAttribute("message", "msg.auto.create.success");
        redirectAttributes.addFlashAttribute("plateNr", auto.getPlateNr().toUpperCase());
        return "redirect:/autos";
    }

    @GetMapping("/{id}")
    public String showAutoDetails(@PathVariable String id, Model model) {

        model.addAttribute("auto", autoService.getAutoById(id));
        model.addAttribute("clients", clientService.getClients(Pageable.unpaged()));
        return "autoForm";
    }

    @PostMapping("/{id}")
    public String updateAuto(@PathVariable() String id, Auto auto, RedirectAttributes redirectAttributes) {

        auto.setPlateNr(id);
        autoService.saveAuto(auto);
        redirectAttributes.addFlashAttribute("message", "msg.auto.update.success");
        redirectAttributes.addFlashAttribute("plateNr", id.toUpperCase());
        return "redirect:/autos";
    }

    @PostMapping
    public String setFixedAuto(Auto auto, RedirectAttributes redirectAttributes) {

        auto.setFixed(true);
//        auto.setCosts();
        redirectAttributes.addFlashAttribute("message", "msg.auto.update.success");
        redirectAttributes.addFlashAttribute("plateNr", auto.getPlateNr().toUpperCase());
        return "redirect:/autos";
    }

    @PostMapping("/reclaim/{id}")
    public String reclaimAuto(@PathVariable String id, RedirectAttributes redirectAttributes) {

        autoService.reclaimAuto(id);
        redirectAttributes.addFlashAttribute("message", "msg.auto.reclaim.success");
        redirectAttributes.addFlashAttribute("plateNr", id.toUpperCase());
        return "redirect:/autos";
    }
}