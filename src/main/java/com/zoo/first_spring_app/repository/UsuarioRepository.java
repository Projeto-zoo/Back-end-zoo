package com.zoo.first_spring_app.repository;

import com.zoo.first_spring_app.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
