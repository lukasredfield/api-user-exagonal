package com.lgdeveloper.api_user_exagonal.usuarios.domain.ports.in;



import com.lgdeveloper.api_user_exagonal.usuarios.domain.model.User;

import java.util.Optional;

public interface UpdateUserUseCase {
    Optional<User> updateUser(Long id, User updatedUser);
}
