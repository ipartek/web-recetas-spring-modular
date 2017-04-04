package com.ipartek.formacion.nagore.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.formacion.nagore.domain.Ingrediente;

/**
 * Test para el pojo Ingrediente
 * 
 * @author Curso
 *
 */
public class IngredienteTest {

	static final long ID = 2;
	static final String NOMBRE = "Pimiento";
	static final boolean GLUTEN = false;
	static final String CANTIDAD = "1kg";
	static final String CANTIDAD_DEFAULT = "a ojimetro...";

	private static Ingrediente ingrediente = null;

	/**
	 * Se ejecuta antes de todos los test
	 * 
	 * @throws Exception
	 *             lanza excepcion en caso de error
	 */
	@BeforeClass()
	public static void setUpBeforeClass() throws Exception {

	}

	/**
	 * Se finaliza despues de todos los test
	 * 
	 * @throws Exception
	 *             lanza excepcion en caso de error
	 */
	@AfterClass()
	public static void tearDownAfterClass() throws Exception {

	}

	/**
	 * creamos un nuevo ingrediente antes de cada test
	 * 
	 * @throws Exception
	 *             lanza excepcion en caso de error
	 */
	@Before()
	public void setUp() throws Exception {
		ingrediente = new Ingrediente();
	}

	/**
	 * Pasamos a null el atributo ingrediente despues de cada test
	 * 
	 * @throws Exception
	 *             lanza excepcion en caso de error
	 */
	@After()
	public void tearDown() throws Exception {
		ingrediente = null;
	}

	/**
	 * Comprobamos los constructores del pojo Usuario
	 */
	@Test()
	public void testConstructor() {
		assertEquals(-1, ingrediente.getId());
		assertEquals("", ingrediente.getNombre());
		assertTrue(ingrediente.isGluten());
		assertEquals(CANTIDAD_DEFAULT, ingrediente.getCantidad());
	}

	/**
	 * Comprobamos los getters y setter del pojo Ingrediente
	 */
	@Test()
	public void testSetterGetter() {
		ingrediente.setId(ID);
		assertEquals(ID, ingrediente.getId());

		ingrediente.setNombre(NOMBRE);
		assertEquals(NOMBRE, ingrediente.getNombre());

		ingrediente.setGluten(GLUTEN);
		assertEquals(GLUTEN, ingrediente.isGluten());

		ingrediente.setCantidad(CANTIDAD);
		assertEquals(CANTIDAD, ingrediente.getCantidad());

	}

}
