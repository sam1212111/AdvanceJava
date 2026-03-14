package in.service.carrental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.service.carrental.entity.Car;

@Repository
public interface CarRepository extends JpaRepository<Car,Long> {

}
