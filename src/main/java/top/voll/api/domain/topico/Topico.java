package top.voll.api.domain.topico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import top.voll.api.domain.usuario.Autor;
import top.voll.api.domain.respuesta.Respuesta;
import top.voll.api.domain.curso.Curso;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Table(name="topicos")
@Entity(name="Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private LocalDateTime fechaCreacion = LocalDateTime.now();
    @Enumerated(EnumType.STRING)
    private StatusTopico status = StatusTopico.NO_RESPONDIDO;
    @Embedded
    private Autor autor;
    @Embedded
    private Curso curso;
    private List<Respuesta> respuestas = new ArrayList<>();

    public Topico(DatosmTopico datosmTopico) {

        this.titulo = datosmTopico.titulo();
        this.mensaje = datosmTopico.mensaje();
        this.fechaCreacion = datosmTopico.fecha();
        this.status = datosmTopico.statusTopico();
        this.autor = new Autor(datosmTopico.autor());
        this.curso = new Curso(datosmTopico.curso());
        this.respuestas = (List<Respuesta>) new Respuesta(datosmTopico.respuestas());
    }

    public void actualizarDatos(DatosActualizarTopico datosActualizarTopico) {
        if(datosActualizarTopico.titulo()!=null){
            this.titulo = datosActualizarTopico.titulo();
        }
        if(datosActualizarTopico.mensaje()!=null){
           this.mensaje = datosActualizarTopico.mensaje();
        }
        if(datosActualizarTopico.fechaCreacion()!=null){
            this.fechaCreacion = datosActualizarTopico.fechaCreacion();
        }
        if(datosActualizarTopico.estatus()!=null){
            this.status = StatusTopico.valueOf(datosActualizarTopico.estatus().toString());
        }
        if(datosActualizarTopico.autor()!=null){
           this.autor = autor.actualizarDatostopic(datosActualizarTopico.autor());
        }
        if(datosActualizarTopico.curso()!=null){
            this.curso = curso.actualizarDatosTopic(datosActualizarTopico.curso());
        }

    }


}
