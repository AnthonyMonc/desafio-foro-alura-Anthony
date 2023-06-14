package top.voll.api.domain.curso;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Curso {

	private Long id;
	private String nombre;
	private String categoria;

	public Curso(String nombre, String categoria) {
		this.nombre = nombre;
		this.categoria = categoria;
	}


	public Curso(DatosCurso curso) {
		this.nombre = curso.nombre();
		this.categoria = curso.categoria();
	}
	public  Curso actualizarDatosTopic( DatosCurso curso) {
		this.nombre = curso.nombre();
		this.categoria = curso.categoria();
		return this;
	}
}
