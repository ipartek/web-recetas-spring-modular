package com.ipartek.formacion.alberto.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.formacion.alberto.domain.Ingrediente;
import com.ipartek.formacion.alberto.domain.Receta;
import com.ipartek.formacion.alberto.domain.Usuario;

/**
 * Test para el pojo Receta
 * 
 * @author Curso
 *
 */
public class RecetaTest {

	static final long ID = 2;
	static final String NOMBRE = "Tortilla patatas";
	static final String IMAGEN = "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcTnAvi3z2rEKI0Mp5vmsF15eFxgNyq01FfRQROAaiFjhy5k5iuPLA";
	static final String IMAGEN_DEFAULT = "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcTnAvi3z2rEKI0Mp5vmsF15eFxgNyq01FfRQROAaiFjhy5k5iuPLA";
	static final String DESCRIPCION = "Lorem ipsun...";

	private static Receta receta = null;
	private static ArrayList<Ingrediente> ingredientes = null;
	private static Usuario usuario = null;

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
	 * creamos una nueva receta antes de cada test
	 * 
	 * @throws Exception
	 *             lanza excepcion en caso de error
	 */
	@Before()
	public void setUp() throws Exception {
		receta = new Receta();
	}

	/**
	 * Pasamos a null el atributo receta despues de cada test
	 * 
	 * @throws Exception
	 *             lanza excepcion en caso de error
	 */
	@After()
	public void tearDown() throws Exception {
		receta = null;
	}

	/**
	 * Comprobamos los constructores del pojo Receta
	 */
	@Test()
	public void testConstructor() {
		assertEquals(-1, receta.getId());
		assertEquals("", receta.getNombre());
		assertEquals(IMAGEN_DEFAULT, receta.getImagen());
		assertEquals("", receta.getDescripcion());
		assertNull(receta.getIngredientes());
		assertNull(receta.getUsuario());
	}

	/**
	 * Comprobamos los getters y setter del pojo Usuario
	 */
	@Test()
	public void testSetterGetter() {

		receta.setId(ID);
		assertEquals(ID, receta.getId());

		receta.setNombre(NOMBRE);
		assertEquals(NOMBRE, receta.getNombre());

		receta.setImagen(IMAGEN);
		assertEquals(IMAGEN, receta.getImagen());

		receta.setDescripcion(DESCRIPCION);
		assertEquals(DESCRIPCION, receta.getDescripcion());

		Ingrediente i1 = new Ingrediente();
		i1.setNombre("patatas");

		Ingrediente i2 = new Ingrediente();
		i2.setNombre("perejil");

		ingredientes = new ArrayList<Ingrediente>();
		ingredientes.add(i1);
		ingredientes.add(i2);

		receta.setIngredientes(ingredientes);
		assertEquals(ingredientes, receta.getIngredientes());

		usuario = new Usuario();
		usuario.setNombre("pepe");

		receta.setUsuario(usuario);
		assertEquals(usuario, receta.getUsuario());

	}

}
