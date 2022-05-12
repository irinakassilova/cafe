package com.example.cafe.controller;

import com.example.cafe.dto.FoodDTO;
import com.example.cafe.model.Food;
import com.example.cafe.model.Place;
import com.example.cafe.model.User;
import com.example.cafe.repository.UserRepository;
import com.example.cafe.service.FoodService;
import com.example.cafe.service.PlaceService;
import com.example.cafe.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
//@PreAuthorize("hasAuthority('ADMIN')")
@RequestMapping("/admin")
@AllArgsConstructor
public class AdminController {
    private final UserService service;
    private final UserRepository userRepository;
    private final FoodService foodService;
    private final PlaceService placeService;

    @GetMapping
    public String userList() {
        return "admin";
    }

    @GetMapping("/place")
    public String placeList(Model model) {
        model.addAttribute("places", placeService.findAll());
        return "listPlace";
    }

    @GetMapping("place/{place}")
    public String placeEdit(@PathVariable Place place, Model model) {
        model.addAttribute("place", place);
        return "editPlace";
    }

    @GetMapping("/food")
    public String userList(Model model) {
        model.addAttribute("foods", userRepository.findAll());
        return "listFood";
    }

    @GetMapping("food/{food}")
    public String foodEdit(@PathVariable Food food, Model model) {
        model.addAttribute("food", food);
        return "listFood";
    }

    @GetMapping("/food/add")
    public String viewFoodsAdd(Model model) {
        model.addAttribute("places", placeService.findAll());
        return "create_food";
    }

    @PostMapping("/food/add")
    public String addFood(@Valid FoodDTO foodDTO) {
        foodService.addFood(foodDTO);
        return "redirect:/" + foodDTO.getPlace();
    }

    @PostMapping("/food/delete")
    public String deleteFood(@RequestParam int foodId)  {
        int redirectingPlaceId = foodService.getFoodsPlaceId(foodId);
        foodService.deleteFood(foodId);
        return "redirect:/" + redirectingPlaceId;
    }
}

