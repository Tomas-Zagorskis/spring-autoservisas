package lt.codeacademy.springautoservisas.controllers;

import lombok.AllArgsConstructor;
import lt.codeacademy.springautoservisas.services.HistoryService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@AllArgsConstructor
@Controller
@RequestMapping("/clients/history")
public class HistoryController {

    private HistoryService historyService;

    @GetMapping("/{id}")
    public String showHistoryPage(
            @SortDefault(sort = "regTime", direction = Sort.Direction.DESC)
            Pageable pageable, Model model,
            @PathVariable UUID id) {

        model.addAttribute("history", historyService.getHistoryByClientId(pageable, id));
        return "history";
    }
}
