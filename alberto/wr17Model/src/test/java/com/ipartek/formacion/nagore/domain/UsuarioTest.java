package com.ipartek.formacion.nagore.domain;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.formacion.nagore.domain.Receta;
import com.ipartek.formacion.nagore.domain.Usuario;

/**
 * Test para el pojo Usuario
 * 
 * @author Curso
 *
 */
public class UsuarioTest {

	static final long ID = 2;
	static final String NOMBRE = "Pepe";
	static final String EMAIL = "pepe@gmail.com";
	static final String PASSWORD = "123";
	static final String IMAGEN = "url_img";

	private static Usuario usuario = null;
	private static ArrayList<Receta> recetas = null;

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
	 * creamos un nuevo usuario y un ArrayList<Receta> antes de cada test
	 * 
	 * @throws Exception
	 *             lanza excepcion en caso de error
	 */
	@Before()
	public void setUp() throws Exception {
		usuario = new Usuario();
		recetas = new ArrayList<Receta>();
	}

	/**
	 * Pasamos a null el atributo usuario y recetas despues de cada test
	 * 
	 * @throws Exception
	 *             lanza excepcion en caso de error
	 */
	@After()
	public void tearDown() throws Exception {
		usuario = null;
		recetas = null;
	}

	/**
	 * Comprobamos los constructores del pojo Usuario
	 */
	@Test()
	public void testConstructor() {
		assertEquals(-1, usuario.getId());
		assertEquals("", usuario.getNombre());
		assertEquals("", usuario.getEmail());
		assertEquals("", usuario.getPassword());
		assertEquals("", usuario.getImagen());
		assertEquals(recetas, usuario.getRecetas());
	}

	/**
	 * Comprobamos los getters y setter del pojo Usuario
	 */
	@Test()
	public void testSetterGetter() {
		usuario.setId(ID);
		assertEquals(ID, usuario.getId());

		usuario.setNombre(NOMBRE);
		assertEquals(NOMBRE, usuario.getNombre());

		usuario.setEmail(EMAIL);
		assertEquals(EMAIL, usuario.getEmail());

		usuario.setPassword(PASSWORD);
		assertEquals(PASSWORD, usuario.getPassword());

		usuario.setImagen(IMAGEN);
		assertEquals(IMAGEN, usuario.getImagen());

		Receta r = new Receta();
		r.setNombre("Tortilla patatas");

		Receta r2 = new Receta();
		r2.setNombre("bacalao al pil pil");

		recetas.add(r);
		recetas.add(r2);

		usuario.setRecetas(recetas);
		assertEquals(recetas, usuario.getRecetas());
	}

}
