package lt.codeacademy.springautoservisas.controllers;

import lombok.AllArgsConstructor;
import lt.codeacademy.springautoservisas.CompanyInfo;
import lt.codeacademy.springautoservisas.entities.Client;
import lt.codeacademy.springautoservisas.services.ClientService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.UUID;

@AllArgsConstructor
@Controller
@RequestMapping("/clients")
public class ClientController {

    private final ClientService clientService;
    private final CompanyInfo companyInfo;

    @ModelAttribute("companyInfo")
    public CompanyInfo addCompanyDataToModel() {
        return companyInfo;
    }

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
    public String createClient(Client client, RedirectAttributes redirectAttributes) {

        clientService.createClient(client);
        redirectAttributes.addFlashAttribute("message", "msg.client.create.success");
        redirectAttributes.addFlashAttribute("fullName", client.getFullName());
        return "redirect:/clients";
    }

    @GetMapping("/{id}")
    public String showClientDetails(@PathVariable UUID id, Model model) {

        model.addAttribute("client", clientService.getClientById(id));
        return "clientForm";
    }

    @PostMapping("/{id}")
    public String updateClient(Client client, RedirectAttributes redirectAttributes) {

        clientService.saveClient(client);
        redirectAttributes.addFlashAttribute("message", "msg.client.update.success");
        redirectAttributes.addFlashAttribute("fullName", client.getFullName());
        return "redirect:/clients";
    }

    @PostMapping("/delete/{id}")
    public String removeClient(@PathVariable UUID id, RedirectAttributes redirectAttributes) {

        redirectAttributes.addFlashAttribute("fullName", clientService.getClientById(id).getFullName());
        clientService.removeClient(id);
        redirectAttributes.addFlashAttribute("message", "msg.client.delete.success");
        return "redirect:/clients";
    }

}
