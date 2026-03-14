package in.service.passenger.service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import in.service.passenger.client.CarRentalClient;
import in.service.passenger.dto.CarDto;
import in.service.passenger.dto.PassengerDto;
import in.service.passenger.entity.Passenger;
import in.service.passenger.repository.PassengerRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class PassengerServiceImpl implements PassengerService {

    private final PassengerRepository passengerRepository;
    private final CarRentalClient carRentalClient;

    public PassengerServiceImpl(PassengerRepository passengerRepository,
                                CarRentalClient carRentalClient) {
        this.passengerRepository = passengerRepository;
        this.carRentalClient = carRentalClient;
    }

    @Override
    public PassengerDto addPassenger(PassengerDto passengerDto) {
        Passenger passenger = new Passenger();
        passenger.setName(passengerDto.getName());
        passenger.setEmail(passengerDto.getEmail());
        passenger.setPhone(passengerDto.getPhone());
        passenger.setAge(passengerDto.getAge());
        Passenger saved = passengerRepository.save(passenger);
        PassengerDto dto = new PassengerDto();
        dto.setId(saved.getId());
        dto.setName(saved.getName());
        dto.setEmail(saved.getEmail());
        dto.setPhone(saved.getPhone());
        dto.setAge(saved.getAge());
        return dto;
    }

    @Override
    public List<PassengerDto> getAllPassengers() {
        return passengerRepository.findAll()
                .stream()
                .map(passenger -> {
                    PassengerDto dto = new PassengerDto();
                    dto.setId(passenger.getId());
                    dto.setName(passenger.getName());
                    dto.setEmail(passenger.getEmail());
                    dto.setPhone(passenger.getPhone());
                    dto.setAge(passenger.getAge());
                    return dto;
                })
                .collect(Collectors.toList());
    }

    @Override
    public PassengerDto getPassengerById(Long id) {
        Passenger passenger = passengerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Passenger not found"));
        PassengerDto dto = new PassengerDto();
        dto.setId(passenger.getId());
        dto.setName(passenger.getName());
        dto.setEmail(passenger.getEmail());
        dto.setPhone(passenger.getPhone());
        dto.setAge(passenger.getAge());
        return dto;
    }

    @Override
    public PassengerDto updatePassenger(Long id, PassengerDto passengerDto) {
        Passenger passenger = passengerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Passenger not found"));
        passenger.setName(passengerDto.getName());
        passenger.setEmail(passengerDto.getEmail());
        passenger.setPhone(passengerDto.getPhone());
        passenger.setAge(passengerDto.getAge());
        Passenger updated = passengerRepository.save(passenger);
        PassengerDto dto = new PassengerDto();
        dto.setId(updated.getId());
        dto.setName(updated.getName());
        dto.setEmail(updated.getEmail());
        dto.setPhone(updated.getPhone());
        dto.setAge(updated.getAge());
        return dto;
    }

    @Override
    public void deletePassenger(Long id) {
        passengerRepository.deleteById(id);
    }

    @Override
    @CircuitBreaker(name = "car-rental-service",
                    fallbackMethod = "fallbackGetAllCars")
    public List<CarDto> getAllCars() {
        return carRentalClient.getAllCars();
    }

    @Override
    @CircuitBreaker(name = "car-rental-service",
                    fallbackMethod = "fallbackGetAvailableCars")
    public List<CarDto> getAvailableCars() {
        return carRentalClient.getAvailableCars();
    }

    @Override
    @CircuitBreaker(name = "car-rental-service",
                    fallbackMethod = "fallbackGetCarById")
    public CarDto getCarById(Long id) {
        return carRentalClient.getCarById(id);
    }

    public List<CarDto> fallbackGetAllCars(Throwable t) {
        System.out.println("Fallback triggered: " + t.getMessage());
        return Collections.emptyList();
    }

    public List<CarDto> fallbackGetAvailableCars(Throwable t) {
        System.out.println("Fallback triggered: " + t.getMessage());
        return Collections.emptyList();
    }

    public CarDto fallbackGetCarById(Long id, Throwable t) {
        System.out.println("Fallback triggered: " + t.getMessage());
        CarDto fallback = new CarDto();
        fallback.setId(id);
        fallback.setCarName("Unavailable");
        fallback.setBrand("N/A");
        fallback.setModel("N/A");
        return fallback;
    }
   
}