package by.itstep.sasha.demoboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CarController {
    @GetMapping("/add-car")
    public String addCar() {
        return "form/add-car";
    }
}
