package com.lgdeveloper.api_user_exagonal.usuarios.domain.ports.in;


import com.lgdeveloper.api_user_exagonal.usuarios.domain.model.User;

public interface CreateUserUseCase {
    User createUser(User user);
}
