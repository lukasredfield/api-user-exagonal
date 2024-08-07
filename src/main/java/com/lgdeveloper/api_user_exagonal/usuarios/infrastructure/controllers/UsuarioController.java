package com.lgdeveloper.api_user_exagonal.usuarios.infrastructure.controllers;

import com.lgdeveloper.api_user_exagonal.usuarios.application.dto.UserDto;
import com.lgdeveloper.api_user_exagonal.usuarios.application.mappers.UserMapper;
import com.lgdeveloper.api_user_exagonal.usuarios.application.services.UserService;
import com.lgdeveloper.api_user_exagonal.usuarios.domain.model.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@Tag(name = "Usuario Controller", description = "Operaciones CRUD para usuarios")
public class UsuarioController {

    private final UserService userService;
    private final UserMapper userMapper;
    private final Logger logger = LoggerFactory.getLogger(UsuarioController.class);

    public UsuarioController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @PostMapping("/crear")
    @Operation(summary = "Crear un nuevo usuario", description = "Crea un nuevo usuario en el sistema", tags = {"Usuario Controller"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Usuario creado exitosamente"),
            @ApiResponse(responseCode = "400", description = "Datos del usuario inválidos"),
            @ApiResponse(responseCode = "401", description = "No autorizado")
    })
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        logger.info("Solicitud para crear usuario: {}", userDto);
        User user = userMapper.dtoToModel(userDto);
        User createdUser = userService.createUser(user);
        UserDto createdUserDto = userMapper.modelToDto(createdUser);
        return new ResponseEntity<>(createdUserDto, HttpStatus.CREATED);
    }

    @GetMapping("/{userId}")
    @Operation(summary = "Obtener un usuario por ID", description = "Obtiene un usuario utilizando su ID", tags = {"Usuario Controller"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuario encontrado"),
            @ApiResponse(responseCode = "404", description = "Usuario no encontrado")
    })
    public ResponseEntity<UserDto> getUserById(@PathVariable Long userId) {
        logger.info("Solicitud para obtener usuario con ID: {}", userId);
        return userService.getUserById(userId)
                .map(user -> new ResponseEntity<>(userMapper.modelToDto(user), HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    @Operation(summary = "Obtener todos los usuarios", description = "Obtiene una lista de todos los usuarios", tags = {"Usuario Controller"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de usuarios obtenida exitosamente")
    })
    public ResponseEntity<List<UserDto>> getAllUsers() {
        logger.info("Solicitud para obtener todos los usuarios");
        List<User> users = userService.getAllUsers();
        List<UserDto> userDtos = users.stream()
                .map(userMapper::modelToDto)
                .collect(Collectors.toList());
        return new ResponseEntity<>(userDtos, HttpStatus.OK);
    }

    @PutMapping("/{userId}")
    @Operation(summary = "Actualizar un usuario por ID", description = "Actualiza los detalles de un usuario existente", tags = {"Usuario Controller"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuario actualizado exitosamente"),
            @ApiResponse(responseCode = "404", description = "Usuario no encontrado")
    })
    public ResponseEntity<UserDto> updateUser(@PathVariable Long userId, @RequestBody UserDto userDto) {
        logger.info("Solicitud para actualizar usuario con ID: {}", userId);
        User user = userMapper.dtoToModel(userDto);
        return userService.updateUser(userId, user)
                .map(updatedUser -> new ResponseEntity<>(userMapper.modelToDto(updatedUser), HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{userId}")
    @Operation(summary = "Eliminar un usuario por ID", description = "Elimina un usuario del sistema por su ID", tags = {"Usuario Controller"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Usuario eliminado exitosamente"),
            @ApiResponse(responseCode = "404", description = "Usuario no encontrado")
    })
    public ResponseEntity<Void> deleteUserById(@PathVariable Long userId) {
        logger.info("Solicitud para eliminar usuario con ID: {}", userId);
        if (userService.deleteUser(userId)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
