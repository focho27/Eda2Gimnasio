package ar.edu.pb2.GimnasioEda2;

import java.util.ArrayList;

public class ClaseDeYoga extends Clase {

	private Integer codigo;

	public ClaseDeYoga(Integer codigo, Double precio, String nombre) {
<<<<<<< HEAD

=======
>>>>>>> 9d9f7920119c5ff8736be9f0baa14a6712c3ee88
		this.precio = precio;
		this.nombre = nombre;
		this.codigo = codigo;
		this.alumnos = new ArrayList<>();
		this.profesores = new ArrayList<>();
	}

	@Override
	public Double precioClase() {
		return this.precio;
	}

	@Override
	public Boolean agregarAlumnoAClase(Cliente alumno) {
		return alumnos.add(alumno);

	}

	@Override
	public Boolean agregarProfesorAClase(Empleado profesor) {
		return profesores.add(profesor);
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClaseDeYoga other = (ClaseDeYoga) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
}
