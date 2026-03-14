package in.service.passenger.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import in.service.passenger.dto.CarDto;
import in.service.passenger.dto.PassengerDto;
import in.service.passenger.service.PassengerService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/passengers")
public class PassengerController {

    private final PassengerService passengerService;

    public PassengerController(PassengerService passengerService) {
        this.passengerService = passengerService;
    }

    @PostMapping
    public ResponseEntity<PassengerDto> addPassenger(@Valid @RequestBody PassengerDto passengerDto) {
        return ResponseEntity.ok(passengerService.addPassenger(passengerDto));
    }

    @GetMapping
    public ResponseEntity<List<PassengerDto>> getAllPassengers() {
        return ResponseEntity.ok(passengerService.getAllPassengers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PassengerDto> getPassengerById(@PathVariable Long id) {
        return ResponseEntity.ok(passengerService.getPassengerById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PassengerDto> updatePassenger(@PathVariable Long id, @Valid @RequestBody PassengerDto passengerDto) {
        return ResponseEntity.ok(passengerService.updatePassenger(id, passengerDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePassenger(@PathVariable Long id) {
        passengerService.deletePassenger(id);
        return ResponseEntity.ok("Passenger deleted successfully");
    }

    @GetMapping("/passengerdetails")
    public ResponseEntity<List<PassengerDto>> passengerDetails() {
        return ResponseEntity.ok(passengerService.getAllPassengers());
    }
    
    @GetMapping("/cars")
    public ResponseEntity<List<CarDto>> getAllCars() {
        return ResponseEntity.ok(passengerService.getAllCars());
    }

    @GetMapping("/cars/available")
    public ResponseEntity<List<CarDto>> getAvailableCars() {
        return ResponseEntity.ok(passengerService.getAvailableCars());
    }

    @GetMapping("/cars/{carId}")
    public ResponseEntity<CarDto> getCarById(@PathVariable Long carId) {
        return ResponseEntity.ok(passengerService.getCarById(carId));
    }
}