package com.lgdeveloper.api_user_exagonal.usuarios.domain.ports.out;



import com.lgdeveloper.api_user_exagonal.usuarios.domain.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepositoryPort {

    User save(User user);
    Optional<User> findById(Long id);
    List<User> findAll();
    Optional<User> update(Long id, User user);
    boolean deleteById(Long id);
}
