package in.ub.main.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import in.ub.main.dto.FoodItemDto;
import in.ub.main.entities.FoodItem;
import in.ub.main.exceptionhandler.ResourceNotFoundException;
import in.ub.main.repository.FoodItemRepository;

@Service
public class FoodItemServiceImpl implements FoodItemService {

    @Autowired
    private FoodItemRepository foodItemRepository;

    public FoodItemDto addFoodItem(Long restaurantId, FoodItemDto dto) {

        FoodItem foodItem = new FoodItem();

        foodItem.setName(dto.getName());
        foodItem.setPrice(dto.getPrice());
        foodItem.setCategory(dto.getCategory());

        FoodItem saved = foodItemRepository.save(foodItem);

        return new FoodItemDto(
                saved.getId(),
                saved.getName(),
                saved.getPrice(),
                saved.getCategory()
        );
    }

    
    public FoodItemDto updateFoodItem(Long id, FoodItemDto dto) {

        FoodItem item = foodItemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Food item not found"));

        item.setName(dto.getName());
        item.setPrice(dto.getPrice());
        item.setCategory(dto.getCategory());

        FoodItem saved = foodItemRepository.save(item);

        return new FoodItemDto(
                saved.getId(),
                saved.getName(),
                saved.getPrice(),
                saved.getCategory()
        );
    }

    public void deleteFoodItem(Long id) {

        FoodItem item = foodItemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Food item not found"));

        foodItemRepository.delete(item);
    }

    public FoodItemDto patchFoodItem(Long id, FoodItemDto dto) {

        FoodItem item = foodItemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Food item not found"));

        if(dto.getName()!=null) item.setName(dto.getName());
        if(dto.getPrice()!=0) item.setPrice(dto.getPrice());
        if(dto.getCategory()!=null) item.setCategory(dto.getCategory());

        FoodItem saved = foodItemRepository.save(item);

        return new FoodItemDto(
                saved.getId(),
                saved.getName(),
                saved.getPrice(),
                saved.getCategory()
        );
    }
    
    public Page<FoodItemDto> getAllFoodItems(int page, int size) {

        Pageable pageable = PageRequest.of(page, size);

        Page<FoodItem> foodItems = foodItemRepository.findAll(pageable);

        return foodItems.map(item ->
                new FoodItemDto(
                        item.getId(),
                        item.getName(),
                        item.getPrice(),
                        item.getCategory()
                )
        );
    }
}