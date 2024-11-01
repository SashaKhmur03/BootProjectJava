package by.itstep.sasha.demoboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SiteController {
    @GetMapping("/site")
    public String addSitePage() {
        return "form/site-creation-form";
    }
}
