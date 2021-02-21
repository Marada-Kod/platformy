package edu.uph.ii.lab1.repository;

import edu.uph.ii.lab1.models.User;
import edu.uph.ii.lab1.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
