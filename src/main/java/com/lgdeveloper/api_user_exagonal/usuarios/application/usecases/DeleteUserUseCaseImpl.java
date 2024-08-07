package com.lgdeveloper.api_user_exagonal.usuarios.application.usecases;


import com.lgdeveloper.api_user_exagonal.usuarios.domain.ports.in.DeleteUserUseCase;
import com.lgdeveloper.api_user_exagonal.usuarios.domain.ports.out.UserRepositoryPort;

public class DeleteUserUseCaseImpl implements DeleteUserUseCase {

    private final UserRepositoryPort userRepositoryPort;

    public DeleteUserUseCaseImpl(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    public boolean deleteUser(Long id) {
        return userRepositoryPort.deleteById(id);
    }
}
