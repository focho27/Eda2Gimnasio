package ar.edu.pb2.GimnasioEda2;

public class Cliente {

	private String nombreYApellido, direccion;
	private Integer dni, telefono;
	private Tarjeta tarjeta;

	public Cliente(Integer dni, String nombreYApellido, Integer telefono, String direccion) {
		this.dni = dni;
		this.nombreYApellido = nombreYApellido;
		this.telefono = telefono;
		this.direccion = direccion;
	}

	public String getNombreYApellido() {
		return nombreYApellido;
	}

	public void setNombreYApellido(String nombreYApellido) {
		this.nombreYApellido = nombreYApellido;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Integer getDni() {

		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public Integer getTelefono() {
		return telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

	public Boolean recibirTarjetaDelGimnasio(Tarjeta tarjeta) {
		if (tarjeta != null && tarjeta.getDni().equals(this.dni)) {
			this.tarjeta = tarjeta;
			return true;
		}
		return false;
	}

	public Tarjeta getTarjeta() {
		return tarjeta;
	}

	public void setTarjeta(Tarjeta tarjeta) {
		this.tarjeta = tarjeta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
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
		Cliente other = (Cliente) obj;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		return true;
	}

}
