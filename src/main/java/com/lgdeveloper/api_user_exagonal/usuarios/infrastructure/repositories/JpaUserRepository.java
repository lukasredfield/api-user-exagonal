package com.lgdeveloper.api_user_exagonal.usuarios.infrastructure.repositories;


import com.lgdeveloper.api_user_exagonal.usuarios.infrastructure.entities.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface JpaUserRepository extends JpaRepository<UsuarioEntity, Long> {

}
