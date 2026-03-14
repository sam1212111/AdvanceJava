package in.ub.main.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import in.ub.main.dto.RestaurantDto;
import in.ub.main.entities.Restaurant;
import in.ub.main.exceptionhandler.ResourceNotFoundException;
import in.ub.main.repository.RestaurantRepository;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    public RestaurantDto addRestaurant(RestaurantDto dto) {

        Restaurant restaurant = new Restaurant();

        restaurant.setName(dto.getName());
        restaurant.setLocation(dto.getLocation());
        restaurant.setRating(dto.getRating());

        Restaurant savedRestaurant = restaurantRepository.save(restaurant);

        RestaurantDto response = new RestaurantDto(
                savedRestaurant.getId(),
                savedRestaurant.getName(),
                savedRestaurant.getLocation(),
                savedRestaurant.getRating()
        );

        return response;
    }

    public Page<RestaurantDto> getAllRestaurants(int page, int size) {

        PageRequest pageable = PageRequest.of(page, size);

        Page<Restaurant> restaurants = restaurantRepository.findAll(pageable);

        return restaurants.map(r -> new RestaurantDto(
                r.getId(),
                r.getName(),
                r.getLocation(),
                r.getRating()
        ));
    }
    
    public RestaurantDto updateRestaurant(Long id, RestaurantDto dto) {

        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Restaurant not found"));

        restaurant.setName(dto.getName());
        restaurant.setLocation(dto.getLocation());
        restaurant.setRating(dto.getRating());

        Restaurant saved = restaurantRepository.save(restaurant);

        return new RestaurantDto(
                saved.getId(),
                saved.getName(),
                saved.getLocation(),
                saved.getRating()
        );
    }

    public void deleteRestaurant(Long id) {

        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Restaurant not found"));

        restaurantRepository.delete(restaurant);
    }

    public RestaurantDto patchRestaurant(Long id, RestaurantDto dto) {

        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Restaurant not found"));

        if(dto.getName()!=null) restaurant.setName(dto.getName());
        if(dto.getLocation()!=null) restaurant.setLocation(dto.getLocation());
        if(dto.getRating()!=0) restaurant.setRating(dto.getRating());

        Restaurant saved = restaurantRepository.save(restaurant);

        return new RestaurantDto(
                saved.getId(),
                saved.getName(),
                saved.getLocation(),
                saved.getRating()
        );
    }
    
    public List<RestaurantDto> getAllRestaurantsForAdmin() {

        List<Restaurant> restaurants = restaurantRepository.findAll();

        return restaurants.stream().map(r ->
                new RestaurantDto(
                        r.getId(),
                        r.getName(),
                        r.getLocation(),
                        r.getRating()
                )
        ).toList();
    }
}