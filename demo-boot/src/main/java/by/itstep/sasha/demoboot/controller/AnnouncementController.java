package by.itstep.sasha.demoboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AnnouncementController {
    @GetMapping("/announcement")
    public String addNewAnnouncement() {
        return "form/announcement-add-form";
    }
}
