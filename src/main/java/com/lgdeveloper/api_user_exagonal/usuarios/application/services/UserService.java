package com.lgdeveloper.api_user_exagonal.usuarios.application.services;



import com.lgdeveloper.api_user_exagonal.usuarios.domain.model.User;
import com.lgdeveloper.api_user_exagonal.usuarios.domain.ports.in.CreateUserUseCase;
import com.lgdeveloper.api_user_exagonal.usuarios.domain.ports.in.DeleteUserUseCase;
import com.lgdeveloper.api_user_exagonal.usuarios.domain.ports.in.RetrieveUserUseCase;
import com.lgdeveloper.api_user_exagonal.usuarios.domain.ports.in.UpdateUserUseCase;

import java.util.List;
import java.util.Optional;

public class UserService implements CreateUserUseCase, RetrieveUserUseCase, UpdateUserUseCase, DeleteUserUseCase {

    private final CreateUserUseCase createUserUseCase;
    private final RetrieveUserUseCase retrieveUserUseCase;
    private final UpdateUserUseCase updateUserUseCase;
    private final DeleteUserUseCase deleteUserUseCase;


    public UserService(CreateUserUseCase createUserUseCase, RetrieveUserUseCase retrieveUserUseCase,
                       UpdateUserUseCase updateUserUseCase, DeleteUserUseCase deleteUserUseCase) {
        this.createUserUseCase = createUserUseCase;
        this.retrieveUserUseCase = retrieveUserUseCase;
        this.updateUserUseCase = updateUserUseCase;
        this.deleteUserUseCase = deleteUserUseCase;
    }

    @Override
    public User createUser(User user) {
        return createUserUseCase.createUser(user);
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return retrieveUserUseCase.getUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return retrieveUserUseCase.getAllUsers();
    }


    @Override
    public Optional<User> updateUser(Long id, User updatedUser) {
        return updateUserUseCase.updateUser(id, updatedUser);
    }

    @Override
    public boolean deleteUser(Long id) {
        return deleteUserUseCase.deleteUser(id);
    }
}
