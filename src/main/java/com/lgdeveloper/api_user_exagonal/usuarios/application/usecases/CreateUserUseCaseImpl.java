package com.lgdeveloper.api_user_exagonal.usuarios.application.usecases;


import com.lgdeveloper.api_user_exagonal.usuarios.domain.model.User;
import com.lgdeveloper.api_user_exagonal.usuarios.domain.ports.in.CreateUserUseCase;
import com.lgdeveloper.api_user_exagonal.usuarios.domain.ports.out.UserRepositoryPort;

public class CreateUserUseCaseImpl implements CreateUserUseCase {

    private final UserRepositoryPort userRepositoryPort;

    public CreateUserUseCaseImpl(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    public User createUser(User user) {
        return userRepositoryPort.save(user);
    }
}
