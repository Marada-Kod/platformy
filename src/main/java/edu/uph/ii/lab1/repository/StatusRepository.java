package edu.uph.ii.lab1.repository;

import edu.uph.ii.lab1.models.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status, Long> {
}
