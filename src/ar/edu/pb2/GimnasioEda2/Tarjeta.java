package ar.edu.pb2.GimnasioEda2;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Tarjeta {
	private Boolean actaMedica;
	private Integer codigo;
	private Integer dni;
	private final Integer DIA= 31;
	private Boolean bloqueo;
	private  Calendar calendario;
	private Boolean libre;
	private  Calendar vencimiento;
	private ArrayList <Clase> clasesHabilitadas;
	private Integer cantidadDeClasesAnotadas;
	//clases con implements
	//Hacer Descuento
	public Tarjeta (Integer codigo,Integer dni, Date fecha_Inicio) {
		this.codigo = codigo;
		this.dni = dni;
		this.calendario =Calendar.getInstance();
		this.vencimiento = Calendar.getInstance();
		this.vencimiento.add(Calendar.DAY_OF_YEAR, DIA);
		this.bloqueo = false;
		this.libre = false;
		this.clasesHabilitadas = new ArrayList<>();
		this.actaMedica=false;
		this.cantidadDeClasesAnotadas =0;
	}
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public Integer getDni() {
		return dni;
	}
	public void setDni(Integer dni) {
		this.dni = dni;
	}
	public Date sumarRestarDiasFecha (Integer dias) {
		calendario.add(Calendar.DAY_OF_MONTH,dias);
		
		return calendario.getTime();
	}
	
	public Date sumarRestarDiasFechaVencimiento (Integer dias) {
		calendario.add(Calendar.DAY_OF_MONTH,dias);
		
		return vencimiento.getTime();
	}
	public Date diaActual() {
		return calendario.getTime();
	}
	public Date diaVencimiento() {
		return vencimiento.getTime();
	}
	
	
	public Boolean getBloqueo() {
		return bloqueo;
	}
	public void setBloqueo(Boolean bloqueo) {
		this.bloqueo = bloqueo;
	}
	
	
	
	public Boolean getLibre() {
		return libre;
	}
	public void setLibre(Boolean libre) {
		this.libre = libre;
	}
	


	public Boolean getActaMedica() {
		return actaMedica;
	}
	public void setActaMedica(Boolean actaMedica) {
		this.actaMedica = actaMedica;
	}
	public Boolean agregarClase(Clase clase) {
		return clasesHabilitadas.add(clase);
	}
	public Boolean agregarClasesVarias(ArrayList<Clase> clasesPagas) {
		 clasesHabilitadas = clasesPagas;
		 return true;
	}
	public Boolean buscarClase (Integer codigoDeClase) {
		
		for (Clase clase : clasesHabilitadas) {
			if(clase!=null) {
			if(clase instanceof ClaseDeBoxeo) {
			if(((ClaseDeBoxeo)clase).getCodigo().equals(codigoDeClase)) {
				return true;
			}
				}
		else if(clase instanceof ClaseDeMusculacion) {
			if(((ClaseDeMusculacion)clase).getCodigo().equals(codigoDeClase)) {
				return true;
			}
		}
		else if(clase instanceof ClaseDeNatacion) {
			if(((ClaseDeNatacion)clase).getCodigo().equals(codigoDeClase)) {
				return true;
			}
		}
		else if(clase instanceof ClaseDeSpinning) {
			if(((ClaseDeSpinning)clase).getCodigo().equals(codigoDeClase)) {
				return true;
			}
		}
		else if(clase instanceof ClaseDeYoga) {
			if(((ClaseDeYoga)clase).getCodigo().equals(codigoDeClase)) {
				return true;
			}
		}
		else if(clase instanceof ClaseDeAerobico) {
			if(((ClaseDeAerobico)clase).getCodigo().equals(codigoDeClase)) {
				return true;
			}
		}
			
			}
		}
			return false;
		}
		
	public ArrayList<Clase> getClasesHabilitadas() {
		return clasesHabilitadas;
	}
	public void setClasesHabilitadas(ArrayList<Clase> clasesHabilitadas) {
		this.clasesHabilitadas = clasesHabilitadas;
	}
	
	
	
	public  Calendar getCalendario() {
		return calendario;
	}
	public  void setCalendario(Calendar calendario) {
		this.calendario = calendario;
	}
	public  Calendar getVencimiento() {
		return vencimiento;
	}
	public  void setVencimiento(Calendar vencimiento) {
		this.vencimiento = vencimiento;
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
		Tarjeta other = (Tarjeta) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	
	

			
			
}

