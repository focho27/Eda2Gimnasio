package ar.edu.pb2.GimnasioEda2;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
	private Double gastosVariosTotales;
	private String listadoDeGastos;

	public Gimnasio(String nombre, String direccion) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.clases = new HashSet<>();
		this.alumnos = new HashSet<>();
		this.empleados = new HashSet<>();
		this.saldo = 0.0;
		this.clasesAPagar = new ArrayList<>();
		this.codigoFactura = 0;
		this.diaActual = Calendar.getInstance();
		this.gastosVariosTotales = 0.0;
		this.listadoDeGastos = "";
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

	public Boolean agregarClase(Clase clase) {
		if (analizarSiExisteTipoDeObjetoEnColeccion(clase)) {
			return false;
		} else if (buscarClase(analizarCodigoClase(clase)) == null) {
			return clases.add(clase);
		} else {
			return false;
		}
	}

	public Integer analizarCodigoClase(Clase clase) {
		if (clase instanceof ClaseDeBoxeo) {
			return ((ClaseDeBoxeo) clase).getCodigo();
		} else if (clase instanceof ClaseDeMusculacion) {
			return ((ClaseDeMusculacion) clase).getCodigo();
		} else if (clase instanceof ClaseDeNatacion) {
			return ((ClaseDeNatacion) clase).getCodigo();
		} else if (clase instanceof ClaseDeSpinning) {
			return ((ClaseDeSpinning) clase).getCodigo();
		} else if (clase instanceof ClaseDeYoga) {
			return ((ClaseDeYoga) clase).getCodigo();
		} else if (clase instanceof ClaseDeAerobico) {
			return ((ClaseDeAerobico) clase).getCodigo();
		}
		return 0;
	}

	public Boolean analizarSiExisteTipoDeObjetoEnColeccion(Clase claseAAnalizar) {
		for (Clase clase : clases) {
			if (clase instanceof ClaseDeBoxeo) {
				if (claseAAnalizar instanceof ClaseDeBoxeo) {
					return true;
				}
			} else if (clase instanceof ClaseDeMusculacion) {
				if (claseAAnalizar instanceof ClaseDeMusculacion) {
					return true;
				}
			} else if (clase instanceof ClaseDeNatacion) {
				if (claseAAnalizar instanceof ClaseDeNatacion) {
					return true;
				}
			} else if (clase instanceof ClaseDeSpinning) {
				if (claseAAnalizar instanceof ClaseDeSpinning) {
					return true;
				}
			} else if (clase instanceof ClaseDeYoga) {
				if (claseAAnalizar instanceof ClaseDeYoga) {
					return true;
				}
			} else if (clase instanceof ClaseDeAerobico) {
				if (claseAAnalizar instanceof ClaseDeAerobico) {
					return true;
				}
			}
		}
		return false;
	}

	public Clase buscarClase(Integer codigo) {
		for (Clase clase : clases) {
			if (clase != null) {
				if (clase instanceof ClaseDeBoxeo) {
					if (((ClaseDeBoxeo) clase).getCodigo().equals(codigo)) {
						return clase;
					}
				} else if (clase instanceof ClaseDeMusculacion) {
					if (((ClaseDeMusculacion) clase).getCodigo().equals(codigo)) {
						return ((ClaseDeMusculacion) clase);
					}
				} else if (clase instanceof ClaseDeNatacion) {
					if (((ClaseDeNatacion) clase).getCodigo().equals(codigo)) {
						return ((ClaseDeNatacion) clase);
					}
				} else if (clase instanceof ClaseDeSpinning) {
					if (((ClaseDeSpinning) clase).getCodigo().equals(codigo)) {
						return ((ClaseDeSpinning) clase);
					}
				} else if (clase instanceof ClaseDeYoga) {
					if (((ClaseDeYoga) clase).getCodigo().equals(codigo)) {
						return ((ClaseDeYoga) clase);
					}
				} else if (clase instanceof ClaseDeAerobico) {
					if (((ClaseDeAerobico) clase).getCodigo().equals(codigo)) {
						return ((ClaseDeAerobico) clase);
					}
				}
			}
		}
		return null;
	}

	public Boolean agregarCliente(Cliente alumno) {
		return alumnos.add(alumno);
	}

	public Cliente buscarCliente(Integer dni) {
		for (Cliente cliente : alumnos) {
			if (cliente.getDni().equals(dni)) {
				return cliente;
			}
		}
		return null;
	}

	public Boolean agregarEmpleado(Empleado empleado) {
		return empleados.add(empleado);
	}

	public Empleado buscarEmpleado(Integer codigoEmpleado) {
		for (Empleado empleado : empleados) {
			if (empleado instanceof Instructor) {

				if (((Instructor) empleado).getCodigo().equals(codigoEmpleado)) {

					return ((Instructor) empleado);
				}
			}
			if (empleado instanceof Recepcionista) {
				if (((Recepcionista) empleado).getCodigo().equals(codigoEmpleado)) {
					return ((Recepcionista) empleado);
				}
			}

		}
		return null;
	}

	public void agregarSaldo(Double dinero) {
		saldo += dinero;
	}

	public Date diaActual() {
		return diaActual.getTime();
	}

	public void aumentarDias(Integer dias) {
		diaActual.add(Calendar.DAY_OF_MONTH, dias);
	}

	public void aumentarHoras(Integer horas) {
		diaActual.add(Calendar.HOUR, horas);
	}

	public void colorcarDiaEnAnio(Integer year, Integer month, Integer date, Integer hourOfDay, Integer minute) {

		diaActual.set(year, month, date, hourOfDay, minute);
	}

	public Boolean analizarVencimiento(Tarjeta tarjeta) {
		if (tarjeta != null) {

			if (tarjeta.getCalendario().before(tarjeta.getVencimiento())) {
				return true;
			} else {
				bloquearIngreso(tarjeta);
				return false;
			}

		}
		return false;
	}

	public Double calcularSueldos() {
		Double sueldos = 0.0;
		for (Empleado empleado : empleados) {
			if (empleado instanceof Instructor) {
				sueldos += ((Instructor) empleado).getSueldo();
			}
			if (empleado instanceof Recepcionista) {
				sueldos += ((Recepcionista) empleado).getSueldo();
			}
		}
		return sueldos;
	}

	public Boolean emitirTarjetaCliente(Tarjeta tarjeta, Integer codigo) {
		if (buscarCliente(codigo) != null && tarjeta != null) {
			buscarCliente(codigo).recibirTarjetaDelGimnasio(tarjeta);
			return true;
		}
		return false;
	}

	public void bloquearIngreso(Tarjeta tarjeta) {
		tarjeta.setBloqueo(true);
	}

	public Boolean desbloquearTarjeta(Integer codigoRecepcionista, Integer dni) {
		if (buscarEmpleado(codigoRecepcionista) != null && buscarCliente(dni) != null) {
			return ((Recepcionista) buscarEmpleado(codigoRecepcionista))
					.desbloquearTarjeta(buscarCliente(dni).getTarjeta());
		}
		return false;
	}

	public Boolean agregarClasesAPagar(Integer codigoClase) {
		if (buscarClase(codigoClase) != null) {
			return clasesAPagar.add(buscarClase(codigoClase));

		}
		return false;
	}

	public Boolean renovarMesDeCero(Tarjeta tarjeta, Integer codigoRecepcionista, Integer dni, Double dinero) {
		// primero agregar clases en clases a pagar
		Calendar calendarioVencimientoNuevo = Calendar.getInstance();
		if (tarjeta != null) {
			calendarioVencimientoNuevo.add(Calendar.DAY_OF_MONTH, 31);
			enviarFactura(codigoRecepcionista, dni, clasesAPagar);
			abonarFactura(dni, codigoRecepcionista, dinero);
			tarjeta.setVencimiento(calendarioVencimientoNuevo);
			return true;
		}
		return false;
	}

	public Double gananciaActual() {
		return this.saldo = this.saldo - (this.gastosVariosTotales + calcularSueldos());
	}

	public ArrayList<Clase> getClasesAPagar() {
		// TODO Auto-generated method stub
		return clasesAPagar;
	}

	public HashSet<Clase> getClases() {
		// TODO Auto-generated method stub
		return clases;
	}

	public Boolean enviarFactura(Integer codigoRecepcionista, Integer codigoCliente, ArrayList<Clase> clasesAPagar) {
		codigoFactura++;
		if (buscarCliente(codigoCliente) != null && buscarEmpleado(codigoRecepcionista) != null) {
			Factura factura = new Factura(codigoFactura, buscarCliente(codigoCliente), clasesAPagar);

			return ((Recepcionista) buscarEmpleado(codigoRecepcionista)).agregarFacturaARecepcion(factura);

		}
		return false;
	}

	public Boolean abonarFactura(Integer dni, Integer codigoRecepcionista, Double dinero) {
		if (buscarCliente(dni) != null && buscarEmpleado(codigoRecepcionista) != null) {
			if (((Recepcionista) buscarEmpleado(codigoRecepcionista)).buscarFacturaConCliente(dni)
					.pagarFactura(dinero)) {

				agregarSaldo(((Recepcionista) buscarEmpleado(codigoRecepcionista)).buscarFacturaConCliente(dni)
						.saldoTotalDeFactura());

				return true;
			}
		}
		return false;
	}

	public Boolean habilitarClase(ArrayList<Clase> clasesPagas, Integer dni, Integer CodigoRecepcionista) {
		if (((Recepcionista) buscarEmpleado(CodigoRecepcionista)).buscarFacturaConCliente(dni).getAbonada()) {
			return buscarCliente(dni).getTarjeta().agregarClasesVarias(clasesPagas);
		}
		return false;
	}

	public Boolean renovarMesConClasesExistentes(Tarjeta tarjeta, Integer codigoRecepcionista, Integer dni,
			Double dinero) {
		ArrayList<Clase> clasesARenovar = new ArrayList<>();
		Calendar calendarioVencimientoNuevo = Calendar.getInstance();
		if (tarjeta != null) {
			clasesARenovar.addAll(tarjeta.getClasesHabilitadas());
			enviarFactura(codigoRecepcionista, dni, clasesARenovar);
			abonarFactura(dni, codigoRecepcionista, dinero);
			calendarioVencimientoNuevo.add(Calendar.DAY_OF_MONTH, 31);
			tarjeta.setVencimiento(calendarioVencimientoNuevo);
			return true;
		}
		return false;
	}

	public void agregarGastosVarios(String descripcion, Double precio) {
		this.gastosVariosTotales += precio;
		this.listadoDeGastos += descripcion + "\t" + " $" + precio + " \n";
	}

	public String leerListadoDeGastos() {
		return listadoDeGastos;
	}

	public Double getSaldo() {
		return saldo;
	}
	
	public Boolean recibirActaMedica(Integer dni, Integer codigoRecepcionista) {
		if(buscarCliente(dni)!=null && buscarEmpleado(codigoRecepcionista)!=null) {
		return ((Recepcionista)buscarEmpleado(codigoRecepcionista)).recibirActaMedica(dni);
		}
		return false;
	}
	public Boolean scannerIngreso(Tarjeta tarjeta,Integer codigoClase) {
		if(tarjeta!=null && buscarClase(codigoClase)!=null ) {
			if(tarjeta.getBloqueo().equals(false) && analizarVencimiento(tarjeta)) {
			 if(tarjeta.buscarClase(codigoClase)){
				 return true;
			 }
			 else {
				 bloquearIngreso(tarjeta);
			 }
			 
			}
			
	}
		
		return false;
	}		
	
	public void setClases(HashSet<Clase> clases) {
		this.clases = clases;
	}

	public HashSet<Cliente> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(HashSet<Cliente> alumnos) {
		this.alumnos = alumnos;
	}

	public HashSet<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(HashSet<Empleado> empleados) {
		this.empleados = empleados;
	}
	public void setClasesAPagar(ArrayList<Clase> clasesAPagar) {
		this.clasesAPagar = clasesAPagar;
	}

	public Integer getCodigoFactura() {
		return codigoFactura;
	}

	public void setCodigoFactura(Integer codigoFactura) {
		this.codigoFactura = codigoFactura;
	}
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Calendar getDiaActual() {
		return diaActual;
	}

	public void setDiaActual(Calendar diaActual) {
		this.diaActual = diaActual;
	}
	public void setGastosVariosTotales(Double gastosVariosTotales) {
		this.gastosVariosTotales = gastosVariosTotales;
	}

	public String getListadoDeGastos() {
		return listadoDeGastos;
	}

	public void setListadoDeGastos(String listadoDeGastos) {
		this.listadoDeGastos = listadoDeGastos;
	}
	public Double getGastosVariosTotales() {
		return gastosVariosTotales;
	}


}
