package in.service.carrental.service;

import java.util.List;

import in.service.carrental.dto.CarDto;
import in.service.carrental.dto.PassengerDto;

public interface CarService {

	 CarDto addCar(CarDto carDto);

	    List<CarDto> getAllCars();

	    CarDto getCarById(Long id);

	    CarDto updateCar(Long id, CarDto carDto);

	    void deleteCar(Long id);
	    
	    List<PassengerDto> getAllPassengers();
	    PassengerDto getPassengerById(Long id);
}
