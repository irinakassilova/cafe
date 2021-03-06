package com.example.cafe.controller;

import com.example.cafe.exception.ResourceNotFoundException;
import com.example.cafe.repository.PlaceRepository;
import com.example.cafe.service.FoodService;
import com.example.cafe.service.PlaceService;
import com.example.cafe.service.PropertiesService;
import com.example.cafe.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.nio.file.AccessDeniedException;
import java.security.Principal;

@Controller
@RequestMapping
@AllArgsConstructor
public class FrontendController {

    private final PlaceService placeService;
    private final FoodService foodService;
    private final UserService userService;
    private final PlaceRepository placeRepository;

    private final PropertiesService propertiesService;

    private static <T> void constructPageable(Page<T> list, int pageSize, Model model, String uri) {
        if (list.hasNext()) {
            model.addAttribute("nextPageLink", constructPageUri(uri, list.nextPageable().getPageNumber(), list.nextPageable().getPageSize()));
        }

        if (list.hasPrevious()) {
            model.addAttribute("prevPageLink", constructPageUri(uri, list.previousPageable().getPageNumber(), list.previousPageable().getPageSize()));
        }

        model.addAttribute("hasNext", list.hasNext());
        model.addAttribute("hasPrev", list.hasPrevious());
        model.addAttribute("items", list.getContent());
        model.addAttribute("defaultPageSize", pageSize);
    }

    private static String constructPageUri(String uri, int page, int size) {
        return String.format("%s?page=%s&size=%s", uri, page, size);
    }

    @GetMapping
    public String index(Model model, Pageable pageable, HttpServletRequest uriBuilder, Principal principal) {
        var places = placeService.getPlaces(pageable);
        var uri = uriBuilder.getRequestURI();
        constructPageable(places, propertiesService.getDefaultPageSize(), model, uri);
        model.addAttribute("principal", principal);
        return "index";
    }

    @GetMapping("/places/{id:\\d+?}")
    public String placePage(@PathVariable int id, Model model, Pageable pageable, HttpServletRequest uriBuilder, Principal principal) {
        model.addAttribute("place", placeService.getPlace(id));
        var uri = uriBuilder.getRequestURI();
        var foods = foodService.getFoods(id, pageable);
        constructPageable(foods, propertiesService.getDefaultPageSize(), model, uri);
        model.addAttribute("principal", principal);
        return "place";
    }

    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    private ResponseEntity<String> handleAccessDeniedException(AccessDeniedException ex) {
        return ResponseEntity.unprocessableEntity()
                .body(ex.getMessage());
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    private String handleRNF(ResourceNotFoundException ex, Model model) {
        model.addAttribute("resource", ex.getResource());
        model.addAttribute("id", ex.getId());
        return "resource-not-found";
    }
}

