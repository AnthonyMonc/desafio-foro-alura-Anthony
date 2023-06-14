package top.voll.api.domain.topico;

import top.voll.api.domain.curso.DatosCurso;
import top.voll.api.domain.usuario.DatosAutor;

import java.time.LocalDateTime;

public record DatosActualizarTopico(Long id, String titulo, String mensaje, LocalDateTime fechaCreacion, String estatus, DatosAutor autor , DatosCurso curso) {

}
