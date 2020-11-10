package ar.edu.pb2.GimnasioEda2;

import java.util.HashSet;

public class Recepcionista extends Empleado {
	private Integer codigoRecepcionista;
	private Double sueldo;
	private HashSet <Factura> facturas;
	public Recepcionista(Integer dni, String nombreYApellido, Integer telefono, String direccion,Tarjeta tarjeta,Integer codigoRecepcionista,Double Sueldo) {
		super(dni, nombreYApellido, telefono, direccion,tarjeta);
		this.codigoRecepcionista =codigoRecepcionista;
		this.sueldo = Sueldo;
		this.facturas = new HashSet<>();
	}
	@Override
	public Integer getCodigo() {
		return this.codigoRecepcionista;
	}
	public void setCodigoRecepcionista(Integer codigoRecepcionista) {
		this.codigoRecepcionista = codigoRecepcionista;
	}
	
	public Boolean agregarFacturaARecepcion(Factura factura) {
		return facturas.add(factura);
	}
	
	public Double getSueldo() {
		return this.sueldo;
	}
	public void setSueldo(Double sueldo) {
		this.sueldo = sueldo;
	}
	
	//buscar la factura del cliente en base al dni 
	public Factura buscarFacturaConCliente(Integer dni) {
		for (Factura factura : facturas) {
			if(factura.getCliente().getDni().equals(dni)) {
				return factura;
			}
		}
		return null;
	}
	
	//con la tarjeta en base a si ya pago las clases que se desbloquee la tarjeta para hacer las clases
	public Boolean desbloquearTarjeta(Tarjeta tarjeta) {
		tarjeta.setBloqueo(false);
		return true;
	}
	
	public Boolean recibirActaMedica(Integer dni) {
		for (Factura factura : facturas) {
			if(factura.getCliente().getDni().equals(dni)) {
				factura.getCliente().getTarjeta().setActaMedica(true);
				return true;
			}
		}
		return false;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((codigoRecepcionista == null) ? 0 : codigoRecepcionista.hashCode());
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
		Recepcionista other = (Recepcionista) obj;
		if (codigoRecepcionista == null) {
			if (other.codigoRecepcionista != null)
				return false;
		} else if (!codigoRecepcionista.equals(other.codigoRecepcionista))
			return false;
		return true;
	}
				
}
