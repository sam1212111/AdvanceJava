package in.ub.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import in.ub.main.dto.RestaurantDto;
import in.ub.main.services.RestaurantService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping
    public ResponseEntity<Page<RestaurantDto>> getAllRestaurants(
    		@RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {

        return ResponseEntity.ok(restaurantService.getAllRestaurants(page, size));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<RestaurantDto> addRestaurant(
            @Valid @RequestBody RestaurantDto dto) {

        return ResponseEntity.ok(restaurantService.addRestaurant(dto));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<RestaurantDto> updateRestaurant(
            @PathVariable Long id,
            @Valid @RequestBody RestaurantDto dto) {

        return ResponseEntity.ok(restaurantService.updateRestaurant(id, dto));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PatchMapping("/{id}")
    public ResponseEntity<RestaurantDto> patchRestaurant(
            @PathVariable Long id,
            @RequestBody RestaurantDto dto) {

        return ResponseEntity.ok(restaurantService.patchRestaurant(id, dto));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRestaurant(@PathVariable Long id) {

        restaurantService.deleteRestaurant(id);
        return ResponseEntity.ok("Restaurant deleted successfully");
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin")
    public ResponseEntity<List<RestaurantDto>> getAllRestaurantsForAdmin() {
        return ResponseEntity.ok(restaurantService.getAllRestaurantsForAdmin());
    }
}