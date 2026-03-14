package in.service.carrental.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class CarDto {

    private Long id;

    @NotBlank(message = "Car name is required")
    private String carName;

    @NotBlank(message = "Brand is required")
    private String brand;

    @NotBlank(message = "Model is required")
    private String model;

    @NotNull(message = "Price per day is required")
    @Positive(message = "Price must be greater than 0")
    private Double pricePerDay;

    @NotNull(message = "Availability must be specified")
    private Boolean available;

    public CarDto() {
    }

    public Long getId() {
        return id;
    }

    public String getCarName() {
        return carName;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public Double getPricePerDay() {
        return pricePerDay;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPricePerDay(Double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
}