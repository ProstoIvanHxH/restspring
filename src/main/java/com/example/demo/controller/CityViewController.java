package com.example.demo.controller;


import com.example.demo.exceptions.CityNotFoundException;
import com.example.demo.model.CityInfo;
import com.example.demo.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class CityViewController {
    private final CityService cityService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("cities", cityService.getAllCities());
        return "index";
    }

    @GetMapping("/city/%7Bid%7D?name={}")
    public String cityDetails(@PathVariable String id, Model model) throws CityNotFoundException {
        CityInfo city = cityService.getCityByName(id);
        if (city == null) throw new CityNotFoundException();
        model.addAttribute("city", city);
        return "city";
    }
//
//    @GetMapping("/search")
//    public String search(@RequestParam String query, Model model) {
//        List<CityInfo> results = cityService.searchCities(query);
//        model.addAttribute("cities", results);
//        return "index";
//    }

    @ExceptionHandler(CityNotFoundException.class)
    public String handleError() {
        return "error";
    }
}