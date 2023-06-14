package top.voll.api.domain.topico;


import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import top.voll.api.domain.curso.DatosCurso;
import top.voll.api.domain.respuesta.DatosRespuesta;
import top.voll.api.domain.usuario.DatosAutor;

import java.time.LocalDateTime;
import java.util.List;

public record DatosmTopico(

        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        LocalDateTime fecha,
        @NotNull
        StatusTopico statusTopico,
        @NotBlank
        @Valid
        DatosAutor autor,
        @NotBlank
        @Valid
        DatosCurso curso,
        @NotNull
        @Valid
        List<DatosRespuesta> respuestas
        ) {

}
