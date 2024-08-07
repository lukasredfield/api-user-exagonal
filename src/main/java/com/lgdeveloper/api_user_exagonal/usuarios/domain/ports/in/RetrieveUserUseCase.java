package com.lgdeveloper.api_user_exagonal.usuarios.domain.ports.in;



import com.lgdeveloper.api_user_exagonal.usuarios.domain.model.User;

import java.util.List;
import java.util.Optional;

public interface RetrieveUserUseCase {
    Optional<User> getUserById(Long id);
    List<User> getAllUsers();
}
