package ar.edu.pb2.GimnasioEda2;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;

public class Gimnasio {
	private String nombre;
	private String direccion;
	private HashSet<Clase> clases;
	private HashSet<Cliente> alumnos;
	private HashSet<Empleado> empleados;
	private ArrayList<Clase> clasesAPagar;
	private Integer codigoFactura;
	private Double saldo;
	private Calendar diaActual;
	public Gimnasio(String nombre,String direccion) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.clases = new HashSet<>();
		this.alumnos = new HashSet<>();
		this.empleados = new HashSet<>();
		this.clasesAPagar = new ArrayList<>();
		this.saldo = 0.0;
		this.clasesAPagar = new ArrayList<>();
		this.codigoFactura = 0;
		this.diaActual = Calendar.getInstance();
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
		
}
