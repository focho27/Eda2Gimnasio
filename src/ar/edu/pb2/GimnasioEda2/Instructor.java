package ar.edu.pb2.GimnasioEda2;

public class Instructor extends Empleado {
	private Integer codigoInstructor;
	private Double sueldo;

	public Instructor(Integer dni, String nombreYApellido, Integer telefono, String direccion, Tarjeta tarjeta,
			Integer codigoInstructor, Double Sueldo) {
		super(dni, nombreYApellido, telefono, direccion, tarjeta);
		this.codigoInstructor = codigoInstructor;
		this.sueldo = Sueldo;
	}

	public void setCodigoInstructor(Integer codigoInstructor) {
		this.codigoInstructor = codigoInstructor;
	}

	public Double getSueldo() {
		return sueldo;
	}

	public void setSueldo(Double sueldo) {
		this.sueldo = sueldo;
	}

	@Override
	public Integer getCodigo() {
		return this.codigoInstructor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((codigoInstructor == null) ? 0 : codigoInstructor.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Instructor other = (Instructor) obj;
		if (codigoInstructor == null) {
			if (other.codigoInstructor != null)
				return false;
		} else if (!codigoInstructor.equals(other.codigoInstructor))
			return false;
		return true;
	}

}
