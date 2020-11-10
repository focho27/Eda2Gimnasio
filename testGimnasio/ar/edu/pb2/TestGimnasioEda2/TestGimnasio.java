package ar.edu.pb2.TestGimnasioEda2;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
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
import ar.edu.pb2.GimnasioEda2.Factura;
import ar.edu.pb2.GimnasioEda2.Recepcionista;

public class TestGimnasio {

	@Test
	public void queSeCreeGimnasio() {
		Gimnasio gimnasio = new Gimnasio("Lo de Pepe", "Peribebuy 6000");

		assertNotNull(gimnasio);
	}

	@Test
	public void queSeCreeClaseDeBoxeo() {
		Clase clase = new ClaseDeBoxeo(10, 20.0, "Boxeo");
		assertNotNull(clase);
	}

	@Test
	public void queSeCreeClaseDeAerobico() {
		Clase clase = new ClaseDeAerobico(20, 20.0, "Aerobico");
		assertNotNull(clase);
	}

	@Test
	public void queSeCreeClaseDeSpinning() {
		Clase clase = new ClaseDeSpinning(30, 20.0, "Spinning");
		assertNotNull(clase);
	}

	@Test
	public void queSeCreeClaseDeMusculacion() {
		Clase clase = new ClaseDeMusculacion(40, 20.0, "Musculacion");
		assertNotNull(clase);
	}

	@Test
	public void queSeCreeClaseDeNatacion() {
		Clase clase = new ClaseDeNatacion(50, 20.0, "Natacion");
		assertNotNull(clase);
	}

	@Test
	public void queSeCreeClaseDeYoga() {
		Clase clase = new ClaseDeYoga(60, 20.0, "Yoga");
		assertNotNull(clase);
	}

	@Test
	public void queSeCreeTarjeta() {
		Date fecha_Inicio = new Date();
		Tarjeta tarjeta = new Tarjeta(1, 41506304, fecha_Inicio);
		assertNotNull(tarjeta);
	}

	@Test
	public void queSeCreeEmpleadoTipoInstructor() {
		Date fecha_Inicio = new Date();
		Tarjeta tarjeta = new Tarjeta(1, 41506304, fecha_Inicio);
		Empleado empleado = new Instructor(41506304, "CarlitosPeña", 1169785493, "Rivadavia 9894,", tarjeta, 1,
				60000.0);
		assertNotNull(empleado);
	}

	@Test
	public void queSeCreeCliente() {
		Cliente cliente = new Cliente(30493823, "Diegote", 1169584736, "Juan B. Justo 4141");
		assertNotNull(cliente);
	}

	public void queSeCreeFactura() {
		Cliente cliente = new Cliente(30493823, "Diegote", 1169584736, "Juan B. Justo 4141");
		ArrayList<Clase> clasesAAnotar = new ArrayList<Clase>();
		Factura factura = new Factura(123, cliente, clasesAAnotar);
		assertNotNull(factura);
	}

	@Test
	public void testQueAgregueClase() {
		Clase clase = new ClaseDeBoxeo(10, 20.0, "Boxeo");
		Gimnasio gimnasio = new Gimnasio("Lo de Pepe", "Peribebuy 6000");

		assertTrue(gimnasio.agregarClase(clase));
	}

	@Test
	public void agregarClasesAGimnasio() {
		Gimnasio gimnasio = new Gimnasio("Lo de Pepe", "Peribebuy 6000");
		Clase claseBoxeo = new ClaseDeBoxeo(10, 1000.0, "Boxeo");
		Clase claseAerobico = new ClaseDeAerobico(20, 1200.0, "Aerobico");
		Clase claseSpinning = new ClaseDeSpinning(30, 1300.0, "Spinning");
		Clase claseMusculacion = new ClaseDeMusculacion(40, 1400.0, "Musculacion");
		Clase claseNatacion = new ClaseDeNatacion(50, 1500.0, "Natacion");
		Clase claseYoga = new ClaseDeYoga(60, 1600.0, "Yoga");

		gimnasio.agregarClase(claseBoxeo);
		gimnasio.agregarClase(claseAerobico);
		gimnasio.agregarClase(claseSpinning);
		gimnasio.agregarClase(claseMusculacion);
		gimnasio.agregarClase(claseNatacion);
		gimnasio.agregarClase(claseYoga);

		assertEquals(6, gimnasio.getClases().size());
	}

	@Test
	public void queNoSeAdmitanClasesDuplicadasNiPorTipoDeObjetoNiPorCodigo() {
		Gimnasio gimnasio = new Gimnasio("Lo de Pepe", "Peribebuy 6000");
		Clase claseBoxeo = new ClaseDeBoxeo(10, 1000.0, "Boxeo");
		// misma instancia no se puede solo hay 1 clase por instancia
		Clase claseBoxeo2 = new ClaseDeBoxeo(20, 2000.0, "Boxeo");
		// misma instancia no se puede solo hay 1 clase por instancia
		Clase claseBoxeo3 = new ClaseDeBoxeo(30, 3000.0, "Boxeo");

		Clase claseYoga = new ClaseDeYoga(20, 1600.0, "Yoga");

		Clase claseYoga2 = new ClaseDeYoga(10, 1600.0, "Yoga");
		Clase claseYoga3 = new ClaseDeYoga(40, 1600.0, "Yoga");

		gimnasio.agregarClase(claseBoxeo);
		gimnasio.agregarClase(claseBoxeo2);
		gimnasio.agregarClase(claseBoxeo3);
		gimnasio.agregarClase(claseYoga);
		gimnasio.agregarClase(claseYoga2);
		gimnasio.agregarClase(claseYoga3);

		assertEquals(2, gimnasio.getClases().size());
	}

	@Test
	public void buscarClase() {
		Clase clase = new ClaseDeAerobico(10, 20.0, "Boxeo");
		Gimnasio gimnasio = new Gimnasio("Lo de Pepe", "Peribebuy 6000");
		gimnasio.agregarClase(clase);

		gimnasio.buscarClase(((ClaseDeAerobico) clase).getCodigo());
		assertEquals(clase, gimnasio.buscarClase(((ClaseDeAerobico) clase).getCodigo()));
	}

	@Test
	public void queSePuedaAgregarUnCliente() {
		Gimnasio gimnasio = new Gimnasio("Lo de Pepe", "Peribebuy 6000");
		Cliente cliente = new Cliente(30493823, "Diegote", 1169584736, "Juan B. Justo 4141");
		assertTrue(gimnasio.agregarCliente(cliente));
	}

	@Test
	public void buscarCliente() {
		Gimnasio gimnasio = new Gimnasio("Lo de Pepe", "Peribebuy 6000");
		Cliente cliente = new Cliente(30493823, "Diegote", 1169584736, "Juan B. Justo 4141");
		gimnasio.agregarCliente(cliente);
		assertEquals(cliente, gimnasio.buscarCliente(30493823));
	}

	@Test
	public void queSePuedaAgregarEmpleado() {
		Date fecha_Inicio = new Date();
		Tarjeta tarjeta = new Tarjeta(1, 41506304, fecha_Inicio);
		Gimnasio gimnasio = new Gimnasio("Lo de Pepe", "Peribebuy 6000");
		Empleado empleado = new Instructor(41506304, "CarlitosPeña", 1169785493, "Rivadavia 9894,", tarjeta, 1,
				60000.0);
		assertTrue(gimnasio.agregarEmpleado(empleado));
	}

	@Test
	public void queSePuedaBuscarEmpleado() {
		Date fecha_Inicio = new Date();
		Tarjeta tarjeta = new Tarjeta(1, 41506304, fecha_Inicio);
		Gimnasio gimnasio = new Gimnasio("Lo de Pepe", "Peribebuy 6000");
		Empleado empleado = new Instructor(41506304, "CarlitosPeña", 1169785493, "Rivadavia 9894,", tarjeta, 1,
				60000.0);
		gimnasio.agregarEmpleado(empleado);

		assertEquals(empleado, gimnasio.buscarEmpleado(1));
	}

	@Test
	public void queSePuedaAgregarTarjetaACliente() {
		Date fecha_Inicio = new Date();
		Tarjeta tarjeta = new Tarjeta(1, 41506304, fecha_Inicio);
		Cliente cliente = new Cliente(41506304, "Diegote", 1169584736, "Juan B. Justo 4141");
		cliente.recibirTarjetaDelGimnasio(tarjeta);
		assertNotNull(cliente.getTarjeta());
	}

	@Test
	public void queNoSePuedaAgregarTarjetaACliente() {
		Date fecha_Inicio = new Date();
		Tarjeta tarjeta = new Tarjeta(1, 41506304, fecha_Inicio);
		Cliente cliente = new Cliente(41506302, "Diegote", 1169584736, "Juan B. Justo 4141");
		cliente.recibirTarjetaDelGimnasio(tarjeta);
		assertNull(cliente.getTarjeta());
	}

	@Test
	public void queSePuedanAgregarClasesAPagar() {
		Date fecha_Inicio = new Date();
		Tarjeta tarjeta = new Tarjeta(1, 41506304, fecha_Inicio);
		Tarjeta tarjeta2 = new Tarjeta(2, 41505304, fecha_Inicio);
		Gimnasio gimnasio = new Gimnasio("Lo de Pepe", "Peribebuy 6000");
		Empleado empleado = new Recepcionista(41506304, "CarlitosPeña", 1169785493, "Rivadavia 9894,", tarjeta, 1,
				60000.0);
		Cliente cliente = new Cliente(41505304, "Diegote", 1169584736, "Juan B. Justo 4141");
		Clase claseBoxeo = new ClaseDeBoxeo(10, 1000.0, "Boxeo");
		Clase claseAerobico = new ClaseDeAerobico(20, 800.0, "Aerobico");
		gimnasio.agregarClase(claseBoxeo);
		gimnasio.agregarClase(claseAerobico);
		gimnasio.agregarEmpleado(empleado);
		gimnasio.agregarCliente(cliente);
		gimnasio.emitirTarjetaCliente(tarjeta2, 41505304);

		gimnasio.agregarClasesAPagar(10);
		gimnasio.agregarClasesAPagar(20);

		assertEquals(2, gimnasio.getClasesAPagar().size());
	}

	@Test
	public void queSePuedaEnviarLaFacturaARecepcionista() {
		Date fecha_Inicio = new Date();
		Tarjeta tarjeta = new Tarjeta(1, 41506304, fecha_Inicio);
		Tarjeta tarjeta2 = new Tarjeta(2, 41505304, fecha_Inicio);
		Gimnasio gimnasio = new Gimnasio("Lo de Pepe", "Peribebuy 6000");
		Empleado empleado = new Recepcionista(41506304, "CarlitosPeña", 1169785493, "Rivadavia 9894,", tarjeta, 1,
				60000.0);
		Cliente cliente = new Cliente(41505304, "Diegote", 1169584736, "Juan B. Justo 4141");
		Clase claseBoxeo = new ClaseDeBoxeo(10, 1000.0, "Boxeo");
		Clase claseAerobico = new ClaseDeAerobico(20, 800.0, "Aerobico");
		gimnasio.agregarClase(claseBoxeo);
		gimnasio.agregarClase(claseAerobico);
		gimnasio.agregarEmpleado(empleado);
		gimnasio.agregarCliente(cliente);
		gimnasio.emitirTarjetaCliente(tarjeta2, 41505304);

		gimnasio.agregarClasesAPagar(10);
		gimnasio.agregarClasesAPagar(20);

		assertTrue(gimnasio.enviarFactura(1, 41505304, gimnasio.getClasesAPagar()));
	}

	@Test
	public void verSaldo() {
		Date fecha_Inicio = new Date();
		Tarjeta tarjeta = new Tarjeta(1, 41506304, fecha_Inicio);
		Tarjeta tarjeta2 = new Tarjeta(2, 41505304, fecha_Inicio);
		Gimnasio gimnasio = new Gimnasio("Lo de Pepe", "Peribebuy 6000");
		Empleado empleado = new Recepcionista(41506304, "CarlitosPeña", 1169785493, "Rivadavia 9894,", tarjeta, 1,
				60000.0);
		Cliente cliente = new Cliente(41505304, "Diegote", 1169584736, "Juan B. Justo 4141");
		Clase claseBoxeo = new ClaseDeBoxeo(10, 1000.0, "Boxeo");
		// Clase claseAerobico = new ClaseDeAerobico(20,800.0,"Aerobico");
		gimnasio.agregarClase(claseBoxeo);
		// gimnasio.agregarClase(claseAerobico);
		gimnasio.agregarEmpleado(empleado);
		gimnasio.agregarCliente(cliente);
		gimnasio.emitirTarjetaCliente(tarjeta2, 41505304);

		gimnasio.agregarClasesAPagar(10);
		// gimnasio.agregarClasesAPagar(20);
		gimnasio.enviarFactura(1, 41505304, gimnasio.getClasesAPagar());
		assertEquals(1000.0, ((Recepcionista) empleado).buscarFacturaConCliente(41505304).saldoTotalDeFactura());
	}

	@Test
	public void quePuedaAbonarFacturaElCliente() {
		Date fecha_Inicio = new Date();
		Tarjeta tarjeta = new Tarjeta(1, 41506304, fecha_Inicio);
		Tarjeta tarjeta2 = new Tarjeta(2, 41505304, fecha_Inicio);
		Gimnasio gimnasio = new Gimnasio("Lo de Pepe", "Peribebuy 6000");
		Empleado empleado = new Recepcionista(41506304, "CarlitosPeña", 1169785493, "Rivadavia 9894,", tarjeta, 1,
				60000.0);
		Cliente cliente = new Cliente(41505304, "Diegote", 1169584736, "Juan B. Justo 4141");
		Clase claseBoxeo = new ClaseDeBoxeo(10, 1000.0, "Boxeo");
		// Clase claseAerobico = new ClaseDeAerobico(20,800.0,"Aerobico");
		gimnasio.agregarClase(claseBoxeo);
		// gimnasio.agregarClase(claseAerobico);
		gimnasio.agregarEmpleado(empleado);
		gimnasio.agregarCliente(cliente);
		gimnasio.emitirTarjetaCliente(tarjeta2, 41505304);

		gimnasio.agregarClasesAPagar(10);
		// gimnasio.agregarClasesAPagar(20);
		gimnasio.enviarFactura(1, 41505304, gimnasio.getClasesAPagar());
		assertTrue(gimnasio.abonarFactura(41505304, 1, 1000.0));

	}

	@Test
	public void queElSaldoSeaElMismoDelQueHayanAbonadoYNoTengaExcedente() {
		Date fecha_Inicio = new Date();
		Tarjeta tarjeta = new Tarjeta(1, 41506304, fecha_Inicio);
		Tarjeta tarjeta2 = new Tarjeta(2, 41505304, fecha_Inicio);
		Gimnasio gimnasio = new Gimnasio("Lo de Pepe", "Peribebuy 6000");
		Empleado empleado = new Recepcionista(41506304, "CarlitosPeña", 1169785493, "Rivadavia 9894,", tarjeta, 1,
				60000.0);
		Cliente cliente = new Cliente(41505304, "Diegote", 1169584736, "Juan B. Justo 4141");
		Clase claseBoxeo = new ClaseDeBoxeo(10, 1000.0, "Boxeo");
		Clase claseAerobico = new ClaseDeAerobico(20, 1000.0, "Aerobico");
		gimnasio.agregarClase(claseBoxeo);
		gimnasio.agregarClase(claseAerobico);
		gimnasio.agregarEmpleado(empleado);
		gimnasio.agregarCliente(cliente);
		gimnasio.emitirTarjetaCliente(tarjeta2, 41505304);

		gimnasio.agregarClasesAPagar(10);
		gimnasio.agregarClasesAPagar(20);
		gimnasio.enviarFactura(1, 41505304, gimnasio.getClasesAPagar());
		gimnasio.abonarFactura(41505304, 1, 1800.0);

		assertEquals(1600.0, gimnasio.getSaldo());
		assertEquals(2, gimnasio.getClasesAPagar().size());
	}

	@Test
	public void queSePuedaHabilitarClase() {
		Date fecha_Inicio = new Date();
		Tarjeta tarjeta = new Tarjeta(1, 41506304, fecha_Inicio);
		Tarjeta tarjeta2 = new Tarjeta(2, 41505304, fecha_Inicio);
		Gimnasio gimnasio = new Gimnasio("Lo de Pepe", "Peribebuy 6000");
		Empleado empleado = new Recepcionista(41506304, "CarlitosPeña", 1169785493, "Rivadavia 9894,", tarjeta, 1,
				60000.0);
		Cliente cliente = new Cliente(41505304, "Diegote", 1169584736, "Juan B. Justo 4141");
		Clase claseBoxeo = new ClaseDeBoxeo(10, 1000.0, "Boxeo");
		Clase claseAerobico = new ClaseDeAerobico(20, 1000.0, "Aerobico");
		gimnasio.agregarClase(claseBoxeo);
		gimnasio.agregarClase(claseAerobico);
		gimnasio.agregarEmpleado(empleado);
		gimnasio.agregarCliente(cliente);
		gimnasio.emitirTarjetaCliente(tarjeta2, 41505304);

		gimnasio.agregarClasesAPagar(10);
		gimnasio.agregarClasesAPagar(20);
		gimnasio.enviarFactura(1, 41505304, gimnasio.getClasesAPagar());
		gimnasio.abonarFactura(41505304, 1, 1800.0);
		assertTrue(gimnasio.habilitarClase(gimnasio.getClasesAPagar(), 41505304, 1));
	}

	@Test
	public void queSePuedaRecibirActaMedica() {
		Date fecha_Inicio = new Date();
		Tarjeta tarjeta = new Tarjeta(1, 41506304, fecha_Inicio);
		Tarjeta tarjeta2 = new Tarjeta(2, 41505304, fecha_Inicio);
		Gimnasio gimnasio = new Gimnasio("Lo de Pepe", "Peribebuy 6000");
		Empleado empleado = new Recepcionista(41506304, "CarlitosPeña", 1169785493, "Rivadavia 9894,", tarjeta, 1,
				60000.0);
		Cliente cliente = new Cliente(41505304, "Diegote", 1169584736, "Juan B. Justo 4141");
		Clase claseBoxeo = new ClaseDeBoxeo(10, 1000.0, "Boxeo");
		Clase claseAerobico = new ClaseDeAerobico(20, 1000.0, "Aerobico");
		gimnasio.agregarClase(claseBoxeo);
		gimnasio.agregarClase(claseAerobico);
		gimnasio.agregarEmpleado(empleado);
		gimnasio.agregarCliente(cliente);
		gimnasio.emitirTarjetaCliente(tarjeta2, 41505304);

		gimnasio.agregarClasesAPagar(10);
		gimnasio.agregarClasesAPagar(20);
		gimnasio.enviarFactura(1, 41505304, gimnasio.getClasesAPagar());
		gimnasio.abonarFactura(41505304, 1, 1800.0);
		assertTrue(gimnasio.recibirActaMedica(41505304, 1));
	}

}
