package ar.edu.pb2.GimnasioEda2;

import java.util.ArrayList;

public abstract class Clase {
	protected ArrayList<Empleado> profesores;
	protected ArrayList<Cliente> alumnos;
	protected Double precio;
	protected String nombre;

	public abstract Double precioClase();

	public abstract Boolean agregarAlumnoAClase(Cliente alumno);

	public abstract Boolean agregarProfesorAClase(Empleado profesor);
//hacer distintas clases
}
