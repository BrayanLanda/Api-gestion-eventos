package org.gestion.eventos.api.repository;

import org.gestion.eventos.api.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
