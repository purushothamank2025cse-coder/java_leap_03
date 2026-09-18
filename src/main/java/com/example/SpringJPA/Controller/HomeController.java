package com.example.SpringJPA.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/menu")
    public String menu() {
        return "food";
    }

    @GetMapping("/view-menu")
    public String viewMenu() {
        return "menu";
    }

    @GetMapping("/add-food")
    public String addFood() {
        return "add-food";
    }

    @GetMapping("/edit-food/{id}")
    public String editFood() {
        return "edit-food";
    }
}
