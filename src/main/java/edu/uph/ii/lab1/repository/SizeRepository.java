package edu.uph.ii.lab1.repository;

import edu.uph.ii.lab1.models.CostumeSize;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SizeRepository extends JpaRepository<CostumeSize, Long> {
}
