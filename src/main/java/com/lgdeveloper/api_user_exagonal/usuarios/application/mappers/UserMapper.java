package com.lgdeveloper.api_user_exagonal.usuarios.application.mappers;

import com.lgdeveloper.api_user_exagonal.usuarios.application.dto.UserDto;
import com.lgdeveloper.api_user_exagonal.usuarios.domain.model.User;
import com.lgdeveloper.api_user_exagonal.usuarios.infrastructure.entities.UsuarioEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UsuarioEntity modelToEntity(User model);

    User entityToModel(UsuarioEntity entity);

    UserDto modelToDto(User model);

    User dtoToModel(UserDto dto);
}
