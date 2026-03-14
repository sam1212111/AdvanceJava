package in.service.carrental.service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import in.service.carrental.client.PassengerClientService;
import in.service.carrental.dto.CarDto;
import in.service.carrental.dto.PassengerDto;
import in.service.carrental.entity.Car;
import in.service.carrental.repository.CarRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final PassengerClientService passengerClient;

    public CarServiceImpl(CarRepository carRepository,
                          PassengerClientService passengerClient) {
        this.carRepository = carRepository;
        this.passengerClient = passengerClient;
    }

    @Override
    public CarDto addCar(CarDto carDto) {
        Car car = new Car();
        car.setCarName(carDto.getCarName());
        car.setBrand(carDto.getBrand());
        car.setModel(carDto.getModel());
        car.setPricePerDay(carDto.getPricePerDay());
        car.setAvailable(carDto.getAvailable());
        Car savedCar = carRepository.save(car);
        CarDto dto = new CarDto();
        dto.setId(savedCar.getId());
        dto.setCarName(savedCar.getCarName());
        dto.setBrand(savedCar.getBrand());
        dto.setModel(savedCar.getModel());
        dto.setPricePerDay(savedCar.getPricePerDay());
        dto.setAvailable(savedCar.getAvailable());
        return dto;
    }

    @Override
    public List<CarDto> getAllCars() {
        return carRepository.findAll()
                .stream()
                .map(car -> {
                    CarDto dto = new CarDto();
                    dto.setId(car.getId());
                    dto.setCarName(car.getCarName());
                    dto.setBrand(car.getBrand());
                    dto.setModel(car.getModel());
                    dto.setPricePerDay(car.getPricePerDay());
                    dto.setAvailable(car.getAvailable());
                    return dto;
                })
                .collect(Collectors.toList());
    }

    @Override
    public CarDto getCarById(Long id) {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Car not found"));
        CarDto dto = new CarDto();
        dto.setId(car.getId());
        dto.setCarName(car.getCarName());
        dto.setBrand(car.getBrand());
        dto.setModel(car.getModel());
        dto.setPricePerDay(car.getPricePerDay());
        dto.setAvailable(car.getAvailable());
        return dto;
    }

    @Override
    public CarDto updateCar(Long id, CarDto carDto) {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Car not found"));
        car.setCarName(carDto.getCarName());
        car.setBrand(carDto.getBrand());
        car.setModel(carDto.getModel());
        car.setPricePerDay(carDto.getPricePerDay());
        car.setAvailable(carDto.getAvailable());
        Car updatedCar = carRepository.save(car);
        CarDto dto = new CarDto();
        dto.setId(updatedCar.getId());
        dto.setCarName(updatedCar.getCarName());
        dto.setBrand(updatedCar.getBrand());
        dto.setModel(updatedCar.getModel());
        dto.setPricePerDay(updatedCar.getPricePerDay());
        dto.setAvailable(updatedCar.getAvailable());
        return dto;
    }

    @Override
    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }

    @Override
    @CircuitBreaker(name = "passenger-service",
                    fallbackMethod = "fallbackGetAllPassengers")
    public List<PassengerDto> getAllPassengers() {
        return passengerClient.getAllPassengers();
    }

    @Override
    @CircuitBreaker(name = "passenger-service",
                    fallbackMethod = "fallbackGetPassengerById")
    public PassengerDto getPassengerById(Long id) {
        return passengerClient.getPassengerById(id);
    }
    
    public List<PassengerDto> fallbackGetAllPassengers(Throwable t) {
        System.out.println("Fallback triggered: " + t.getMessage());
        return Collections.emptyList();
    }

    public PassengerDto fallbackGetPassengerById(Long id, Throwable t) {
        System.out.println("Fallback triggered: " + t.getMessage());
        PassengerDto fallback = new PassengerDto();
        fallback.setId(id);
        fallback.setName("Unknown Passenger");
        fallback.setEmail("N/A");
        fallback.setPhone("N/A");
        return fallback;
    }
}