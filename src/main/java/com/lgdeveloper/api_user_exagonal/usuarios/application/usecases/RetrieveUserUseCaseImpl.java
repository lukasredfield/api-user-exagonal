package com.lgdeveloper.api_user_exagonal.usuarios.application.usecases;



import com.lgdeveloper.api_user_exagonal.usuarios.domain.model.User;
import com.lgdeveloper.api_user_exagonal.usuarios.domain.ports.in.RetrieveUserUseCase;
import com.lgdeveloper.api_user_exagonal.usuarios.domain.ports.out.UserRepositoryPort;

import java.util.List;
import java.util.Optional;

public class RetrieveUserUseCaseImpl implements RetrieveUserUseCase {

    private final UserRepositoryPort userRepositoryPort;

    public RetrieveUserUseCaseImpl(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepositoryPort.findById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepositoryPort.findAll();
    }

}
