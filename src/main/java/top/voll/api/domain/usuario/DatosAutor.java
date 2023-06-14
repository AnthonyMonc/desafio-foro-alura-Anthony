package top.voll.api.domain.usuario;

import jakarta.validation.constraints.NotBlank;

public record DatosAutor(
        @NotBlank
        String nombre,
        @NotBlank
        String email,
        @NotBlank
        String contrasena) {

}
