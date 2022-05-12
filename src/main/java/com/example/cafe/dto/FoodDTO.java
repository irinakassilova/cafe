package com.example.cafe.dto;

import com.example.cafe.model.Food;
import lombok.*;

@Getter
@Setter
@ToString
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FoodDTO {

    private int id;
    private String name;
    private String image;
    private String description;
    private float price;
    private PlaceDTO place;

    public static FoodDTO from(Food food) {
        return builder()
                .id(food.getId())
                .name(food.getName())
                .image(food.getImage())
                .description(food.getDescription())
                .price(food.getPrice())
                .place(PlaceDTO.from(food.getPlace()))
                .build();
    }
}
