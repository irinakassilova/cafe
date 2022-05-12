package com.example.cafe.dto;

import com.example.cafe.model.Place;
import lombok.*;

@Getter
@Setter
@ToString
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PlaceDTO {
    private Integer id;
    private String name;
    private String image;
    private String description;

    public static PlaceDTO from(Place place) {
        return builder()
                .id(place.getId())
                .name(place.getName())
                .image(place.getImage())
                .description(place.getDescription())
                .build();
    }

//    private static String calcStoreImagePath(Place place) {
//        if (!place.getImage().isBlank()) {
//            return place.getImage();
//        }
//        return String.format("/images/store%d.png", Math.abs(place.getName().hashCode() % 4));
//    }
}
