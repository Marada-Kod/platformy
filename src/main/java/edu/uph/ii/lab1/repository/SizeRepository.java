package edu.uph.ii.lab1.repository;

import edu.uph.ii.lab1.models.User;
import edu.uph.ii.lab1.models.Size;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SizeRepository extends JpaRepository<Size, Long> {
}
