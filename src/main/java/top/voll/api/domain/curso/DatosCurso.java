package top.voll.api.domain.curso;

import jakarta.validation.constraints.NotBlank;

public record DatosCurso(
         @NotBlank
         String nombre,
        @NotBlank
         String categoria) {
}
