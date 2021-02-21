package edu.uph.ii.lab1.repository;

import edu.uph.ii.lab1.models.User;
import edu.uph.ii.lab1.models.Gender;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenderRepository extends JpaRepository<Gender, Long> {
}
