package top.voll.api.domain.respuesta;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import top.voll.api.domain.topico.Topico;
import top.voll.api.domain.usuario.Autor;

import java.time.LocalDateTime;
import java.util.List;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Respuesta {

	private Long id;
	private String mensaje;
	private Topico topico;
	private LocalDateTime fechaCreacion = LocalDateTime.now();
	private Autor autor;
	private Boolean solucion = false;

	public Respuesta(List<DatosRespuesta> respuestas) {
		if (respuestas != null && !respuestas.isEmpty()) {
			this.mensaje = respuestas.get(0).mensaje();
			this.topico = respuestas.get(0).topico();
			this.fechaCreacion = respuestas.get(0).fechaCreacion();
			this.autor = respuestas.get(0).autor();
			this.solucion = respuestas.get(0).solucion();
		}
	}

	public Respuesta(String mensaje, Topico topico, LocalDateTime fechaCreacion, Autor autor, Boolean solucion) {
		this.mensaje = mensaje;
		this.topico = topico;
		this.fechaCreacion = fechaCreacion;
		this.autor = autor;
		this.solucion = solucion;
	}
}
