package lt.codeacademy.springautoservisas;

import lombok.AllArgsConstructor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@AllArgsConstructor
@ControllerAdvice
public class AllControllersAdvice {

    private final CompanyInfo companyInfo;

    @ModelAttribute
    public void addCompanyDataToModel(HttpServletRequest request) {
        request.setAttribute("companyInfo", companyInfo);
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

}
