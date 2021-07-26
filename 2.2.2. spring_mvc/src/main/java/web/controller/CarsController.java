package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import services.CarService;

@Controller
public class CarsController {
    CarService carService = new CarService();
    @GetMapping(value = "/cars")
    public String printCars(Model model, @RequestParam(value = "quality", required = false) Integer quality) {
        model.addAttribute("cars", carService.getCars(quality));
        return "cars";
    }
}
