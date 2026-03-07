package in.ub.main.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class RestaurantDto {

    private Long id;

    @NotBlank(message = "Restaurant name cannot be empty")
    private String name;

    @NotBlank(message = "Location cannot be empty")
    private String location;

    @Positive(message = "Rating must be positive")
    private double rating;

    public RestaurantDto() {
    }

    public RestaurantDto(Long id, String name, String location, double rating) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.rating = rating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}