package ar.edu.pb2.GimnasioEda2;

public abstract class Empleado {
	protected String nombreYApellido, direccion;
	protected Integer dni, telefono;

	protected Tarjeta tarjeta;

	public Empleado(Integer dni, String nombreYApellido, Integer telefono, String direccion, Tarjeta tarjeta) {
		this.dni = dni;
		this.nombreYApellido = nombreYApellido;
		this.telefono = telefono;
		this.direccion = direccion;
		this.tarjeta = tarjeta;
	}

	public abstract Integer getCodigo();

	protected String getNombreYApellido() {
		return nombreYApellido;
	}

	protected void setNombreYApellido(String nombreYApellido) {
		this.nombreYApellido = nombreYApellido;
	}

	protected String getDireccion() {
		return direccion;
	}

	protected void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	protected Integer getDni() {
		return dni;
	}

	protected void setDni(Integer dni) {
		this.dni = dni;
	}

	protected Integer getTelefono() {
		return telefono;
	}

	protected void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

	protected Tarjeta getTarjeta() {
		return tarjeta;
	}

	protected void setTarjeta(Tarjeta tarjeta) {
		this.tarjeta = tarjeta;
	}
}