package com.example.cafe.service;

import com.example.cafe.dto.PlaceDTO;
import com.example.cafe.exception.ResourceNotFoundException;
import com.example.cafe.model.Food;
import com.example.cafe.model.Place;
import com.example.cafe.repository.FoodRepository;
import com.example.cafe.repository.PlaceRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PlaceService {
    private final PlaceRepository placeRepository;
    private final FoodRepository foodRepository;

    public Page<PlaceDTO> getPlaces(Pageable pageable) {
        return placeRepository.findAll(pageable)
                .map(PlaceDTO::from);
    }

    public PlaceDTO getPlace(int id) {
        var place = placeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("place", id));
        return PlaceDTO.from(place);
    }

    public List<Place> findAll() {
        return placeRepository.findAll();
    }

    public Place getById(int placeId) {
        return placeRepository.getById(placeId);
    }

    public void addPlace(PlaceDTO placeDTO) {
        Place place = new Place();
        place.setName(placeDTO.getName());
        place.setImage(placeDTO.getImage());
        place.setDescription(placeDTO.getDescription());

        placeRepository.save(place);
    }

    public void deletePlace(int placeId) {
        Place place = placeRepository.getById(placeId);
        List<Food> placeFoods = foodRepository.findAllByPlaceId(placeId);
        if (placeFoods != null && placeFoods.size() > 0) {
            return;
        }
        foodRepository.deleteById(placeId);
    }

    public List<Food> findAllFoodsByPlaceId(int placeId) {
        return foodRepository.findAllByPlaceId(placeId);
    }

}

