package top.voll.api.domain.topico;

import java.time.LocalDateTime;

public record DatosListadoTopico(String titulo, String mensaje, LocalDateTime fechaCreacion, String estatus, top.voll.api.domain.usuario.Autor autor , top.voll.api.domain.curso.Curso curso) {

    public DatosListadoTopico(Topico topico){
        this(topico.getTitulo(),topico.getMensaje(),topico.getFechaCreacion(), topico.getStatus().toString(), topico.getAutor(), topico.getCurso());
    }

}
