package ecommerce.sports.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ecommerce.sports.model.SportProducts;

@Repository
public interface SportsRepository extends JpaRepository<SportProducts, Long> {

}
