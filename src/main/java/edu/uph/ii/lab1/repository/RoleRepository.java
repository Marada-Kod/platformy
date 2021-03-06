package edu.uph.ii.lab1.repository;

import edu.uph.ii.lab1.models.User;
import edu.uph.ii.lab1.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
