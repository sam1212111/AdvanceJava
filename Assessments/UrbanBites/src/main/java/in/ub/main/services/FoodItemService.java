package in.ub.main.services;

import java.util.List;

import org.springframework.data.domain.Page;

import in.ub.main.dto.FoodItemDto;

public interface FoodItemService {

    FoodItemDto addFoodItem(Long restaurantId, FoodItemDto dto);

    FoodItemDto updateFoodItem(Long id, FoodItemDto dto);

    void deleteFoodItem(Long id);

    FoodItemDto patchFoodItem(Long id, FoodItemDto dto);
    
    Page<FoodItemDto> getAllFoodItems(int page, int size);

}