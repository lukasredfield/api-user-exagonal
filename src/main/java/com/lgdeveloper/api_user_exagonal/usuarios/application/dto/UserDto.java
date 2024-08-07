package com.lgdeveloper.api_user_exagonal.usuarios.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String nombre;
    private String apellido;
    private String mail;
    private String keycloakUserId;
    private Boolean activo;
    private LocalDateTime fechaCreacion;
    private String documento;
    private String numeroMatricula;
    private String tipoUsuario;
}
