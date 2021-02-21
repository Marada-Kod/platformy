package edu.uph.ii.lab1.repository;

import edu.uph.ii.lab1.models.Order;
import edu.uph.ii.lab1.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUser(User user);
}
