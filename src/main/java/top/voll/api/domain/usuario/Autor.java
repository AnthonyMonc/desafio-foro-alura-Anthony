package top.voll.api.domain.usuario;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Autor {

	private Long id;
	private String nombre;
	private String email;
	private String contrasena;

	public Autor(DatosAutor autor) {
		this.nombre = autor.nombre();
		this.email = autor.email();
		this.contrasena = autor.contrasena();
	}
	public  Autor actualizarDatostopic( DatosAutor autor) {
		this.nombre = autor.nombre();
		this.email = autor.email();
		this.contrasena = autor.contrasena();
		return this;
	}
}
