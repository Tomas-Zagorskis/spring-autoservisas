package lt.codeacademy.springautoservisas.controllers;

import lombok.AllArgsConstructor;
import lt.codeacademy.springautoservisas.CompanyInfo;
import lt.codeacademy.springautoservisas.entities.Auto;
import lt.codeacademy.springautoservisas.entities.Client;
import lt.codeacademy.springautoservisas.exceptions.AutoNotFoundException;
import lt.codeacademy.springautoservisas.services.AutoService;
import lt.codeacademy.springautoservisas.services.ClientService;
import lt.codeacademy.springautoservisas.services.HistoryService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;


@AllArgsConstructor
@Controller
@RequestMapping("/autos")
public class AutoController {

    private final AutoService autoService;
    private final ClientService clientService;
    private final HistoryService historyService;
    private final CompanyInfo companyInfo;

    @ModelAttribute("companyInfo")
    public CompanyInfo addCompanyDataToModel() {
        return companyInfo;
    }

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
    public String addAuto(@Valid Auto auto, BindingResult errors, Model model,
                          Client client, RedirectAttributes redirectAttributes) {

        if (errors.hasErrors()) {
            model.addAttribute("clients", clientService.getClients(Pageable.unpaged()));
            return "autoForm";
        }
        autoService.addAuto(auto, client);
        historyService.addStory(client.getId(), auto);
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
        historyService.update(auto);
        autoService.saveAuto(auto);
        redirectAttributes.addFlashAttribute("message", "msg.auto.update.success");
        redirectAttributes.addFlashAttribute("plateNr", id.toUpperCase());
        return "redirect:/autos";
    }


    @PostMapping("/reclaim/{id}")
    public String reclaimAuto(@PathVariable String id, RedirectAttributes redirectAttributes) {

        Auto autoToReclaim = autoService.getAutoById(id);
        if (!autoToReclaim.isFixed()) {
            redirectAttributes.addFlashAttribute("failMessage", "msg.auto.reclaim.fail");

            return "redirect:/autos";
        }
        historyService.update(autoToReclaim);
        autoService.reclaimAuto(id);
        redirectAttributes.addFlashAttribute("message", "msg.auto.reclaim.success");
        redirectAttributes.addFlashAttribute("plateNr", id.toUpperCase());
        return "redirect:/autos";
    }


    @ExceptionHandler(AutoNotFoundException.class)
    public String autoNotFound(AutoNotFoundException e, Model model) {

        model.addAttribute("messageCode", e.getMessage());
        model.addAttribute("id", e.getAutoId());

        return "error";
    }
}