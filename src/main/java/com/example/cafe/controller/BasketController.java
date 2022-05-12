package com.example.cafe.controller;

import com.example.cafe.model.Basket;
import com.example.cafe.service.BasketService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.nio.file.AccessDeniedException;

@Controller
@AllArgsConstructor
public class BasketController {
    private final BasketService basketService;

    @GetMapping("/basket")
    public String getBasket(Model model) {
        model.addAttribute("baskets", basketService.getAll());
        return "basket";
    }

    @PostMapping("/basket/add/{principal}")
    public String addFoodToBasket(@PathVariable String principal, @RequestParam(value = "id",required = false) int id, int count, Authentication authentication, HttpSession session) throws AccessDeniedException {
        if (authentication != null) {
            basketService.createBasket(id, count, principal);
            return "redirect:/basket";
        } else {
            return "redirect:/login";
        }
    }

    @GetMapping("/basket/{id}")
    public String getBasketById(@PathVariable int id, Model model) {
        Basket basket = basketService.getById(id).get();
        model.addAttribute("basket", basket);
        return "basket";
    }
}


