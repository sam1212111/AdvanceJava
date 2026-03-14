package in.ub.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ub.main.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
}