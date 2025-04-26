package com.example.demo.controller;

import com.example.demo.model.CityInfo;
import com.example.demo.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cities")
@RequiredArgsConstructor
public class CityController {

    private final CityService cityService;

    @GetMapping
    public List<CityInfo> getAllCities() {
        return cityService.getAllCities();
    }


    @GetMapping("/{name}")
    public CityInfo getCityByName(@PathVariable String name) {
        return cityService.getCityByName(name);
    }

    @GetMapping("/time/{name}")
    public String getCityTime(@PathVariable String name) {
        return cityService.getCityByName(name).getLocalTime()+"\n"+cityService.getCityByName(name).getUtcTime();
    }
}