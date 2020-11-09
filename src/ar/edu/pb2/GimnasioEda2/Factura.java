package ar.edu.pb2.GimnasioEda2;

import java.util.ArrayList;

public class Factura {
	private Boolean abonada;
	private Cliente cliente;
	private ArrayList<Clase> clases;
	private Integer codigoFactura;

	private Double precio;

	public Factura(Integer codigoFactura, Cliente cliente, ArrayList<Clase> clasesAAnotar) {
		this.codigoFactura = codigoFactura;
		this.abonada = false;
		this.cliente = cliente;
		this.clases = clasesAAnotar;
		this.precio = 0.0;

	}

	public String leerFactura(Integer codigoDeFactura) {
		return "Cliente: " + cliente.getNombreYApellido() + "/n" + "Estado de cuota: " + abonada + "/n"
				+ "Cantidad de clases inscriptas: " + clases.size() + "/n";
	}

	public Double descuentoFacturaPorCantidad(Integer cantidad, Double precioClase) {

		if (cantidad >= 2 && cantidad < 4) {

			precioClase = precioClase * 0.8;
			return precioClase;
		}
		if (cantidad >= 4) {

			precioClase = precioClase * 0.6;
			return precioClase;
		}
		return precioClase;
	}

	public Double saldoTotalDeFactura() {
		Integer contadorDeClasesAAnotar = 0;
		precio = 0.0;
		for (Clase clase : clases) {
			if (clase != null) {
				if (clase instanceof ClaseDeBoxeo) {
					precio += ((ClaseDeBoxeo) clase).precioClase();
					contadorDeClasesAAnotar++;
				} else if (clase instanceof ClaseDeMusculacion) {
					precio += ((ClaseDeMusculacion) clase).precioClase();
					contadorDeClasesAAnotar++;
				} else if (clase instanceof ClaseDeNatacion) {
					precio += ((ClaseDeNatacion) clase).precioClase();
					contadorDeClasesAAnotar++;
				} else if (clase instanceof ClaseDeSpinning) {
					precio += ((ClaseDeSpinning) clase).precioClase();
					contadorDeClasesAAnotar++;
				} else if (clase instanceof ClaseDeYoga) {
					precio += ((ClaseDeYoga) clase).precioClase();
					contadorDeClasesAAnotar++;
				} else if (clase instanceof ClaseDeAerobico) {
					precio += ((ClaseDeAerobico) clase).precioClase();
					contadorDeClasesAAnotar++;
				}
			}
		}

		if (contadorDeClasesAAnotar >= 2 && contadorDeClasesAAnotar < 4) {
			return descuentoFacturaPorCantidad(contadorDeClasesAAnotar, precio);
		} else if (contadorDeClasesAAnotar >= 4) {
			return descuentoFacturaPorCantidad(contadorDeClasesAAnotar, precio);
		}

		return precio;
	}

	public Boolean pagarFactura(Double dinero) {
		Double vuelto;
		if (dinero.equals(saldoTotalDeFactura())) {
			abonada = true;
			return true;
		} else if (dinero > saldoTotalDeFactura()) {
			vuelto = dinero - saldoTotalDeFactura();
			vuelto(vuelto);
			abonada = true;
			return true;

		}
		return false;
	}

	public Double vuelto(Double vueltoEfectivo) {
		Double vuelto = vueltoEfectivo;
		return vuelto;
	}

	public Boolean getAbonada() {
		return abonada;
	}

	public void setAbonada(Boolean abonada) {
		this.abonada = abonada;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public ArrayList<Clase> getClases() {
		return clases;
	}

	public void setClases(ArrayList<Clase> clases) {
		this.clases = clases;
	}

	public Integer getCodigoFactura() {
		return codigoFactura;
	}

	public void setCodigoFactura(Integer codigoFactura) {
		this.codigoFactura = codigoFactura;
	}

}
