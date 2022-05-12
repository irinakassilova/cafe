package com.example.cafe.service;

import com.example.cafe.dto.FoodDTO;
import com.example.cafe.model.Food;
import com.example.cafe.repository.FoodRepository;
import com.example.cafe.repository.PlaceRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class FoodService {
    private final FoodRepository foodRepository;
    private final PlaceRepository placeRepository;

    public Page<FoodDTO> getFoods(int id, Pageable pageable) {
        return foodRepository.findAllByPlaceId(id, pageable)
                .map(FoodDTO::from);
    }

    public void addFood(FoodDTO foodDTO) {
        Food food = new Food();
        food.setName(foodDTO.getName());
        food.setPrice((int) foodDTO.getPrice());
        food.setDescription(foodDTO.getDescription());
        food.setPlace(placeRepository.getById(foodDTO.getPlace().getId()));
        foodRepository.save(food);
    }

    public int getFoodsPlaceId(int foodId) {
        Food food = foodRepository.getById(foodId);
        return food.getPlace().getId();
    }

    public void deleteFood(int foodId) {
        foodRepository.deleteById(foodId);
    }

    public List<Food> getAll() {
        return foodRepository.findAll();
    }
}

