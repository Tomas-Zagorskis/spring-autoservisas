package lt.codeacademy.springautoservisas.controllers;

import lombok.AllArgsConstructor;
import lt.codeacademy.springautoservisas.services.RecordService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortDefault;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@AllArgsConstructor
@Controller
@Secured("ROLE_ADMIN")
@RequestMapping("/private/records")
public class RecordController {

    private RecordService recordService;

    @GetMapping
    public String showRecordsPage(
            @SortDefault(sort = "regTime", direction = Sort.Direction.DESC)
            Pageable pageable, Model model) {

        model.addAttribute("records", recordService.getAllRecords(pageable));
        return "records";
    }

    @GetMapping("/{id}")
    public String showClientRecords(
            @SortDefault(sort = "regTime", direction = Sort.Direction.DESC)
            Pageable pageable, Model model,
            @PathVariable UUID id) {

        model.addAttribute("records", recordService.getRecordsByClientId(pageable, id));
        return "records";
    }
}
