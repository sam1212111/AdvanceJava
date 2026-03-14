package in.service.passenger.dto;

public class CarDto {
    private Long id;
    private String carName;
    private String brand;
    private String model;
    private Double pricePerDay;
    private Boolean available;

 
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getCarName() { return carName; }
    public void setCarName(String carName) { this.carName = carName; }
    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }
    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }
    public Double getPricePerDay() { return pricePerDay; }
    public void setPricePerDay(Double pricePerDay) { this.pricePerDay = pricePerDay; }
    public Boolean getAvailable() { return available; }
    public void setAvailable(Boolean available) { this.available = available; }
}