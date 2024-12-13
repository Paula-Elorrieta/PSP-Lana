package ariketa1;

import java.io.Serializable;
import java.util.Date;

public class Persona implements Serializable {
	private static final long serialVersionUID = 1646384092668845627L;
	String nif;
	String nombre;
	String apellido;
	Date fechaNaciniento;
	char genero;

	public Persona(String nif, String nombre, String apellido, Date fechaNaciniento, char genero) {
		this.nif = nif;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNaciniento = fechaNaciniento;
		this.genero = genero;
	}

	public Persona() {
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Date getFechaNaciniento() {
		return fechaNaciniento;
	}

	public void setFechaNaciniento(Date fechaNaciniento) {
		this.fechaNaciniento = fechaNaciniento;
	}

	public char getGenero() {
		return genero;
	}

	public void setGenero(char genero) {
		this.genero = genero;
	}

	@Override
	public String toString() {
		return "Persona [nif=" + nif + ", nombre=" + nombre + ", apellido=" + apellido + ", fechaNaciniento="
				+ fechaNaciniento + ", genero=" + genero + "]";
	}

}