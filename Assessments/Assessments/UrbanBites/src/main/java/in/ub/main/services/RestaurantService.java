package in.ub.main.services;

import java.util.List;

import org.springframework.data.domain.Page;

import in.ub.main.dto.RestaurantDto;

public interface RestaurantService {

    RestaurantDto addRestaurant(RestaurantDto dto);

    Page<RestaurantDto> getAllRestaurants(int page, int size);
    RestaurantDto updateRestaurant(Long id, RestaurantDto dto);

    void deleteRestaurant(Long id);

    RestaurantDto patchRestaurant(Long id, RestaurantDto dto);
    List<RestaurantDto> getAllRestaurantsForAdmin();
    

}