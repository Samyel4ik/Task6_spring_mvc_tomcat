package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import web.model.Car;
import web.service.CarService;
import web.service.CarServiceImp;

import java.util.List;

@Controller
public class CarController {
    private final CarService carService;
    @Autowired
    public CarController(CarServiceImp carServiceImp) {
        this.carService = carServiceImp;
    }



    @GetMapping("/cars")
    public String getAllCars(@RequestParam(name = "count", required = false, defaultValue = "5") int count, Model model) {
        List<Car> cars = carService.getCars(count);



        System.out.println("Number of cars retrieved:" + cars.size()); // Логирование размера списка

        model.addAttribute("cars", cars);
        return "cars";
    }
}
