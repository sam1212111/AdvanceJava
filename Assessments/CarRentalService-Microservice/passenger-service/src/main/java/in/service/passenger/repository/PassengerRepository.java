package in.service.passenger.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.service.passenger.entity.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger,Long> {

}
