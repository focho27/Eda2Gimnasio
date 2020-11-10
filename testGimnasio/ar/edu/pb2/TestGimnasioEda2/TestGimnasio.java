package ar.edu.pb2.TestGimnasioEda2;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import ar.edu.pb2.GimnasioEda2.Clase;
import ar.edu.pb2.GimnasioEda2.ClaseDeAerobico;
import ar.edu.pb2.GimnasioEda2.ClaseDeBoxeo;
import ar.edu.pb2.GimnasioEda2.ClaseDeMusculacion;
import ar.edu.pb2.GimnasioEda2.ClaseDeNatacion;
import ar.edu.pb2.GimnasioEda2.ClaseDeSpinning;
import ar.edu.pb2.GimnasioEda2.ClaseDeYoga;
import ar.edu.pb2.GimnasioEda2.Cliente;
import ar.edu.pb2.GimnasioEda2.Empleado;
import ar.edu.pb2.GimnasioEda2.Gimnasio;
import ar.edu.pb2.GimnasioEda2.Instructor;
import ar.edu.pb2.GimnasioEda2.Tarjeta;

public class TestGimnasio {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test 
	public void queSeCreeGimnasio() {
		Gimnasio gimnasio = new Gimnasio("Lo de Pepe","Peribebuy 6000");
		
		assertNotNull(gimnasio);
	}
	
	@Test 
	public void queSeCreeClaseDeBoxeo() {
		Clase clase = new ClaseDeBoxeo(10,20.0,"Boxeo");
		assertNotNull(clase);
	}
	
	@Test 
	public void queSeCreeClaseDeAerobico() {
		Clase clase = new ClaseDeAerobico(20,20.0,"Aerobico");
		assertNotNull(clase);
	}
	
	@Test 
	public void queSeCreeClaseDeSpinning() {
		Clase clase = new ClaseDeSpinning(30,20.0,"Spinning");
		assertNotNull(clase);
	}
	
	@Test 
	public void queSeCreeClaseDeMusculacion() {
		Clase clase = new ClaseDeMusculacion(40,20.0,"Musculacion");
		assertNotNull(clase);
	}
	
	@Test 
	public void queSeCreeClaseDeNatacion() {
		Clase clase = new ClaseDeNatacion(50,20.0,"Natacion");
		assertNotNull(clase);
	}
	
	@Test 
	public void queSeCreeClaseDeYoga() {
		Clase clase = new ClaseDeYoga(60,20.0,"Yoga");
		assertNotNull(clase);
	}
	
	@Test 
	public void queSeCreeTarjeta() {
		Date fecha_Inicio = new Date();
		Tarjeta tarjeta = new Tarjeta (1,41506304,fecha_Inicio);
		assertNotNull(tarjeta);
	}
	
	@Test 
	public void queSeCreeEmpleadoTipoInstructor() {
		Date fecha_Inicio = new Date();
		Tarjeta tarjeta = new Tarjeta (1,41506304,fecha_Inicio);
		Empleado empleado = new Instructor(41506304,"CarlitosPeña",1169785493,"Rivadavia 9894,",tarjeta,1,60000.0);
		assertNotNull(empleado);
	}
	
	@Test 
	public void queSeCreeCliente() {
		Cliente cliente = new Cliente(30493823,"Diegote",1169584736,"Juan B. Justo 4141");
		assertNotNull(cliente);
	}

}
