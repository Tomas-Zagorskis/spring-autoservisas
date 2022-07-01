package lt.codeacademy.springautoservisas;

import lombok.AllArgsConstructor;
import lt.codeacademy.springautoservisas.auto.AutoController;
import lt.codeacademy.springautoservisas.user.UserController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@AllArgsConstructor
@Controller
@RequestMapping("")
public class MainController {


    @GetMapping
    public String showHomePage() {

        return "index";
    }
}
