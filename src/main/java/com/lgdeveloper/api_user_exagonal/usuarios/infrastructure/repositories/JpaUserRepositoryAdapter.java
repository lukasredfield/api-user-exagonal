package com.lgdeveloper.api_user_exagonal.usuarios.infrastructure.repositories;

import com.lgdeveloper.api_user_exagonal.usuarios.application.mappers.UserMapper;
import com.lgdeveloper.api_user_exagonal.usuarios.domain.model.User;
import com.lgdeveloper.api_user_exagonal.usuarios.domain.ports.out.UserRepositoryPort;
import com.lgdeveloper.api_user_exagonal.usuarios.infrastructure.entities.UsuarioEntity;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class JpaUserRepositoryAdapter implements UserRepositoryPort {

    private final JpaUserRepository jpaUserRepository;
    private final UserMapper userMapper;

    public JpaUserRepositoryAdapter(JpaUserRepository jpaUserRepository, UserMapper userMapper) {
        this.jpaUserRepository = jpaUserRepository;
        this.userMapper = userMapper;
    }

    @Override
    public User save(User user) {
        UsuarioEntity usuarioEntity = userMapper.modelToEntity(user);
        UsuarioEntity savedUsuarioEntity = jpaUserRepository.save(usuarioEntity);
        return userMapper.entityToModel(savedUsuarioEntity);
    }

    @Override
    public Optional<User> findById(Long id) {
        return jpaUserRepository.findById(id)
                .map(userMapper::entityToModel);
    }

    @Override
    public List<User> findAll() {
        return jpaUserRepository.findAll().stream()
                .map(userMapper::entityToModel)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<User> update(Long id, User user) {
        if (jpaUserRepository.existsById(user.getId())) {
            UsuarioEntity usuarioEntity = userMapper.modelToEntity(user);
            UsuarioEntity updatedUsuarioEntity = jpaUserRepository.save(usuarioEntity);
            return Optional.of(userMapper.entityToModel(updatedUsuarioEntity));
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteById(Long id) {
        if (jpaUserRepository.existsById(id)) {
            jpaUserRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
