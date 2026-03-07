package in.ub.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ub.main.entities.FoodItem;

public interface FoodItemRepository extends JpaRepository<FoodItem, Long> {

    
}