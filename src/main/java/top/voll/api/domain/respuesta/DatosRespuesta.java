package top.voll.api.domain.respuesta;

import top.voll.api.domain.topico.Topico;
import top.voll.api.domain.usuario.Autor;

import java.time.LocalDateTime;

public record DatosRespuesta(Long id,
                             String mensaje,
                             Topico topico,
                             LocalDateTime fechaCreacion,
                             Autor autor,
                             Boolean solucion) {
}
