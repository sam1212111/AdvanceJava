package in.service.passenger.client;

import in.service.passenger.dto.CarDto;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

@FeignClient(name = "car-rental-service")
public interface CarRentalClient {

    
    @GetMapping("/cars")
    List<CarDto> getAllCars();

 
    @GetMapping("/cars/rentalcardetails")
    List<CarDto> getAvailableCars();

    @GetMapping("/cars/{id}")
    CarDto getCarById(@PathVariable Long id);
}