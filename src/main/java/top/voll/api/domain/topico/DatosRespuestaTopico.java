package top.voll.api.domain.topico;


import top.voll.api.domain.curso.DatosCurso;
import top.voll.api.domain.usuario.DatosAutor;

import java.time.LocalDateTime;
import java.time.LocalTime;

public record DatosRespuestaTopico(Long id, String titulo, String mensaje, LocalDateTime fecha, String estatus, DatosAutor autor, DatosCurso curso) {
}
