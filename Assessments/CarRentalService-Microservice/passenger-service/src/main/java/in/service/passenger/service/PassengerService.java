package in.service.passenger.service;

import java.util.List;

import in.service.passenger.dto.CarDto;
import in.service.passenger.dto.PassengerDto;

public interface PassengerService {

	  PassengerDto addPassenger(PassengerDto passengerDto);
	    List<PassengerDto> getAllPassengers();
	    PassengerDto getPassengerById(Long id);
	    PassengerDto updatePassenger(Long id, PassengerDto passengerDto);
	    void deletePassenger(Long id);

	    List<CarDto> getAllCars();
	    List<CarDto> getAvailableCars();
	    CarDto getCarById(Long id);
}
