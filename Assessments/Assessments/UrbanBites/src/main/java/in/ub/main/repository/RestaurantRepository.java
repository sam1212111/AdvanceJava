package in.ub.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ub.main.entities.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}