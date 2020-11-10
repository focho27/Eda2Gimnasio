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
	
	public Boolean agregarClase(Clase clase) {
		
		if(analizarSiExisteTipoDeObjetoEnColeccion(clase)) {
			return false;
		}else if(buscarClase(analizarCodigoClase(clase))==null) {
		return clases.add(clase);
		}else {
			return false;
		}
		
	}
	
	public Integer analizarCodigoClase(Clase clase){
			if(clase instanceof ClaseDeBoxeo) {
				return ((ClaseDeBoxeo) clase).getCodigo();
			}
			else if(clase instanceof ClaseDeMusculacion) {
				
				
				return ((ClaseDeMusculacion) clase).getCodigo();
					
				
			}
			else if(clase instanceof ClaseDeNatacion) {
				return ((ClaseDeNatacion) clase).getCodigo();
				
				}
			
			else if(clase instanceof ClaseDeSpinning) {
				return ((ClaseDeSpinning) clase).getCodigo();
			}
			else if(clase instanceof ClaseDeYoga) {
				return ((ClaseDeYoga) clase).getCodigo();
			}
			else if(clase instanceof ClaseDeAerobico) {
				return ((ClaseDeAerobico) clase).getCodigo();
			}
		
			return 0;
	}
	
	public Boolean analizarSiExisteTipoDeObjetoEnColeccion(Clase claseAAnalizar){
		for (Clase clase : clases) {
			
		
			if(clase instanceof ClaseDeBoxeo) {
				if(claseAAnalizar instanceof ClaseDeBoxeo) {
				return true;
				}
			}
			else if(clase instanceof ClaseDeMusculacion) {
				
				if(claseAAnalizar instanceof ClaseDeMusculacion) {
					return true;
					}
				
			}
			else if(clase instanceof ClaseDeNatacion) {
				
				if(claseAAnalizar instanceof ClaseDeNatacion) {
					return true;
					}
				}
			
			else if(clase instanceof ClaseDeSpinning) {
				if(claseAAnalizar instanceof ClaseDeSpinning) {
					return true;
					}
			}
			else if(clase instanceof ClaseDeYoga) {
				if(claseAAnalizar instanceof ClaseDeYoga) {
					return true;
					}
			}
			else if(clase instanceof ClaseDeAerobico) {
				if(claseAAnalizar instanceof ClaseDeAerobico) {
					return true;
					}
			}
		}
			return false;
	}
	

	public Clase buscarClase(Integer codigo) {
		
		for (Clase clase : clases) {
			if(clase!=null) {
			if(clase instanceof ClaseDeBoxeo) {
				
				if(((ClaseDeBoxeo)clase).getCodigo().equals(codigo)) {
					return clase;
				}
				
			}
			else if(clase instanceof ClaseDeMusculacion) {
				if(((ClaseDeMusculacion)clase).getCodigo().equals(codigo)) {
					return ((ClaseDeMusculacion)clase);
				}
			}
			else if(clase instanceof ClaseDeNatacion) {
				if(((ClaseDeNatacion)clase).getCodigo().equals(codigo)) {
					return ((ClaseDeNatacion)clase);
				}
			}
			else if(clase instanceof ClaseDeSpinning) {
				if(((ClaseDeSpinning)clase).getCodigo().equals(codigo)) {
					return ((ClaseDeSpinning)clase);
				}
			}
			else if(clase instanceof ClaseDeYoga) {
				if(((ClaseDeYoga)clase).getCodigo().equals(codigo)) {
					return ((ClaseDeYoga)clase);
				}
			}
			else if(clase instanceof ClaseDeAerobico) {
				if(((ClaseDeAerobico)clase).getCodigo().equals(codigo)) {
					return ((ClaseDeAerobico)clase);
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
	
	public Boolean agregarCliente(Cliente alumno) {
		return alumnos.add(alumno);
}

public Cliente buscarCliente(Integer dni) {
		for (Cliente cliente : alumnos) {
			if(cliente.getDni().equals(dni)) {
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
		if(empleado instanceof Instructor) {
			
			if(((Instructor)empleado).getCodigo().equals(codigoEmpleado)) {
				
				return ((Instructor)empleado);
			}
		}
		if(empleado instanceof Recepcionista) {
			if(((Recepcionista)empleado).getCodigo().equals(codigoEmpleado)) {
				return ((Recepcionista)empleado);
			}
		}
		
	}
	return null;
}

}
