package in.service.carrental.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import in.service.carrental.dto.CarDto;
import in.service.carrental.dto.PassengerDto;
import in.service.carrental.service.CarService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/cars")
@Validated
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping
    public ResponseEntity<CarDto> addCar(@Valid @RequestBody CarDto carDto) {
        return ResponseEntity.ok(carService.addCar(carDto));
    }

    @GetMapping
    public ResponseEntity<List<CarDto>> getAllCars() {
        return ResponseEntity.ok(carService.getAllCars());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarDto> getCarById(@PathVariable Long id) {
        return ResponseEntity.ok(carService.getCarById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarDto> updateCar(@PathVariable Long id, @Valid @RequestBody CarDto carDto) {
        return ResponseEntity.ok(carService.updateCar(id, carDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);
        return ResponseEntity.ok("Car deleted successfully");
    }

    @GetMapping("/rentalcardetails")
    public ResponseEntity<List<CarDto>> rentalCarDetails() {
        return ResponseEntity.ok(carService.getAllCars());
    }

@GetMapping("/passengers")
public ResponseEntity<List<PassengerDto>> getAllPassengers() {
    return ResponseEntity.ok(carService.getAllPassengers());
}

@GetMapping("/passengers/{passengerId}")
public ResponseEntity<PassengerDto> getPassengerById(
        @PathVariable Long passengerId) {
    return ResponseEntity.ok(carService.getPassengerById(passengerId));
}
}