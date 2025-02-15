package com.example.thirdProject.Controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/home")
    public String getHome(){
        return "home";
    }
    @GetMapping("/shop")
    public String getShop(){
        return "shop";
    }
}
