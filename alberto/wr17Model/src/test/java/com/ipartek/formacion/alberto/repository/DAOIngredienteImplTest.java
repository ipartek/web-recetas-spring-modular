package com.ipartek.formacion.alberto.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ipartek.formacion.alberto.domain.Ingrediente;
import com.ipartek.formacion.alberto.repository.DAOIngrediente;

/**
 * @author Curso
 *
 */
// @RunWith(value = SpringJUnit4ClassRunner.class)
// @ContextConfiguration(locations = "classpath:application-context-test.xml")
public class DAOIngredienteImplTest {

	private static DAOIngrediente daoIngrediente;
	private static ApplicationContext context;
	private Ingrediente ingrediente;
	private static ArrayList<Ingrediente> ingredientes;

	private int contadorInicial = -1;
	private int contador = -1;
	// private long idNuevo = -1;

	private static final String NOMBRE = "azucar";
	private static final String CANTIDAD = "mucho";
	private static final boolean GLUTEN_TRUE = true;
	private static final boolean GLUTEN_FALSE = false;
	private static final int ID = 5;

	/**
	 * @throws java.lang.Exception
	 *             e
	 */
	@BeforeClass()
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("classpath:application-context-test.xml");

		assertNotNull(context);

		daoIngrediente = (DAOIngrediente) context.getBean("daoIngrediente");

		assertNotNull(daoIngrediente.getAll("ASC"));
	}

	/**
	 * @throws java.lang.Exception
	 *             e
	 */
	@AfterClass()
	public static void tearDownAfterClass() throws Exception {
		context = null;
		daoIngrediente = null;
	}

	/**
	 * @throws java.lang.Exception
	 *             e
	 */
	@Before()
	public void setUp() throws Exception {
		ingrediente = new Ingrediente();
		ingrediente.setNombre(NOMBRE);
		ingrediente.setCantidad(CANTIDAD);
		ingrediente.setGluten(GLUTEN_FALSE);
		ingrediente.setId(ID);

		// Contar Ingredientes iniciales de la BBDD.

		ingredientes = new ArrayList<Ingrediente>();
		ingredientes = (ArrayList<Ingrediente>) daoIngrediente.getAll("DESC");
		contadorInicial = ingredientes.size();

		// Crear usuario nuevo
		assertTrue("No inserta nuevo Ingrediente en la bbdd", daoIngrediente.insert(ingrediente));
		// idNuevo = usuario.getId();
		// assertEquals(idNuevo, usuario.getId());
		ingredientes = (ArrayList<Ingrediente>) daoIngrediente.getAll("ASC");
		contador = ingredientes.size();
		assertTrue("Deberia haber un nuevo Ingrediente", contador > contadorInicial);
	}

	/**
	 * @throws java.lang.Exception
	 *             e
	 */
	@After()
	public void tearDown() throws Exception {

		// Eliminar usuario insertado
		assertTrue("No elimina nuevo ingrediente en la bbdd", daoIngrediente.delete(ingrediente.getId()));

		ingrediente = null;
		ingredientes = null;

	}

	/**
	 * Test para comprobar el getAll (listar todos los ingredientes)
	 */
	@Test()
	public void testgetAll() {
		assertEquals("class com.ipartek.formacion.alberto.repository.DAOIngredienteImpl",
				this.daoIngrediente.getClass().toString());

		ArrayList<Ingrediente> lista = (ArrayList<Ingrediente>) this.daoIngrediente.getAll("ASC");
		assertNotNull("No deberia retornar null", lista);
		assertTrue(lista.size() >= 0);

	}

}
