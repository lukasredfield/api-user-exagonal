package com.lgdeveloper.api_user_exagonal.usuarios.infrastructure.config;

import com.lgdeveloper.api_user_exagonal.usuarios.application.services.UserService;
import com.lgdeveloper.api_user_exagonal.usuarios.application.usecases.CreateUserUseCaseImpl;
import com.lgdeveloper.api_user_exagonal.usuarios.application.usecases.DeleteUserUseCaseImpl;
import com.lgdeveloper.api_user_exagonal.usuarios.application.usecases.RetrieveUserUseCaseImpl;
import com.lgdeveloper.api_user_exagonal.usuarios.application.usecases.UpdateUserUseCaseImpl;
import com.lgdeveloper.api_user_exagonal.usuarios.domain.ports.out.UserRepositoryPort;
import com.lgdeveloper.api_user_exagonal.usuarios.infrastructure.repositories.JpaUserRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class UsuarioApplicationConfig {

    @Bean
    public UserService userService(UserRepositoryPort userRepositoryPort) {
        return new UserService(
                new CreateUserUseCaseImpl(userRepositoryPort),
                new RetrieveUserUseCaseImpl(userRepositoryPort),
                new UpdateUserUseCaseImpl(userRepositoryPort),
                new DeleteUserUseCaseImpl(userRepositoryPort)
        );
    }
    @Bean
    public UserRepositoryPort userRepositoryPort(JpaUserRepositoryAdapter jpaUserRepositoryAdapter) {
        return jpaUserRepositoryAdapter;
    }
}
