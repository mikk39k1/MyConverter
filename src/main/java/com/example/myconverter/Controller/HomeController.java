package com.example.myconverter.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index(){
        return "home/index";
    }

    @PostMapping("/convertTemperature")
    public String convertTemperature(@RequestParam String temperature, @RequestParam String unit, Model model){
        double value = Double.parseDouble(temperature);
        double result = 0;

        if (unit.equalsIgnoreCase("C")){
            result = (value * 9/5) + 32;
            unit = "Fahrenheit";
        } else {
            result = (value - 32) * 5/9;
            unit = "Celsius";
        }

        model.addAttribute("result", result + " " + unit);
        return "home/index";
    }


}
