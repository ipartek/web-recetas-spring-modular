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

import com.ipartek.formacion.alberto.domain.Receta;
import com.ipartek.formacion.alberto.domain.Usuario;
import com.ipartek.formacion.alberto.repository.DAOReceta;
import com.ipartek.formacion.alberto.repository.DAOUsuario;

/**
 * Test para comprobar el funcionamiento del DAO
 * 
 * @author Curso
 */
// @RunWith(value = SpringJUnit4ClassRunner.class)
// @ContextConfiguration(locations = "classpath:application-context-test.xml")
public class DAORecetaImplTest {

	// @Autowired()
	private static DAOReceta daoReceta;
	private static DAOUsuario daoUsuario;

	private static ApplicationContext context;

	private static Receta receta;
	private static Receta recetaNueva;
	private static ArrayList<Receta> recetas;

	private static int contadorInicial = -1;
	private static int contador = -1;
	private static long idNuevo = -1;
	private static long user_idNuevo = -1;

	private static final String NOMBRE = "Pechuga de pollo";
	private static final String IMAGEN = "url_img";
	private static final String DESCRIPCION = "Lorem ipsun...";

	// private static ArrayList<Ingrediente> ingredientes;

	private static Usuario usuario;
	private static final String USER_NOMBRE = "Pepe";
	private static final String USER_EMAIL = "pepe@gmail.com";
	private static final String USER_PASSWORD = "123";
	private static final String USER_IMAGEN = "url_img";

	/**
	 * Se ejecuta antes de todos los test
	 * 
	 * @throws Exception
	 *             lanza excepcion en caso de error
	 */
	@BeforeClass()
	public static void setUpBeforeClass() throws Exception {

		context = new ClassPathXmlApplicationContext("classpath:application-context-test.xml");

		assertNotNull(context);

		daoReceta = (DAOReceta) context.getBean("daoReceta");
		daoUsuario = (DAOUsuario) context.getBean("daoUsuario");

		assertNotNull(daoReceta.getAll());

		recetaNueva = new Receta();
		recetaNueva.setNombre(NOMBRE);
		recetaNueva.setImagen(IMAGEN);
		recetaNueva.setDescripcion(DESCRIPCION);

		usuario = new Usuario();
		usuario.setNombre(USER_NOMBRE);
		usuario.setEmail(USER_EMAIL);
		usuario.setImagen(USER_IMAGEN);
		usuario.setPassword(USER_PASSWORD);

		// Contar recetas iniciales de la BBDD.

		recetas = new ArrayList<Receta>();
		recetas = (ArrayList<Receta>) daoReceta.getAll();
		contadorInicial = recetas.size();

		// Crear receta nueva
		assertTrue("No inserta nuevo usuario en la bbdd", daoUsuario.insert(usuario));
		user_idNuevo = usuario.getId();

		recetaNueva.setUsuario(usuario);
		assertTrue("No inserta nueva receta en la bbdd", daoReceta.insert(recetaNueva));
		idNuevo = recetaNueva.getId();
		recetas = (ArrayList<Receta>) daoReceta.getAll();
		contador = recetas.size();
		assertTrue("Deberia haber una nueva receta", contador > contadorInicial);
	}

	/**
	 * Se finaliza despues de todos los test
	 * 
	 * @throws Exception
	 *             lanza excepcion en caso de error
	 */
	@AfterClass()
	public static void tearDownAfterClass() throws Exception {

		// Eliminar usuario y Receta insertado
		assertTrue("No elimina nueva receta en la bbdd", daoReceta.delete(idNuevo));
		assertTrue("No elimina nuevo usuario en la bbdd", daoUsuario.delete(user_idNuevo));

		recetaNueva = null;
		usuario = null;
		recetas = null;
		context = null;

	}

	/**
	 * Se ejecuta antes de cada test
	 * 
	 * @throws Exception
	 *             lanza excepcion en caso de error
	 */
	@Before()
	public void setUp() throws Exception {

	}

	/**
	 * Se ejecuta despues de cada test
	 * 
	 * @throws Exception
	 *             lanza excepcion en caso de error
	 */
	@After()
	public void tearDown() throws Exception {

	}

	/**
	 * Test para comprobar la recuperacion de todos las recetas sin usuarios
	 */
	@Test()
	public void testgetAll() {
		assertEquals("class com.ipartek.formacion.alberto.repository.DAORecetaImpl", daoReceta.getClass().toString());

		ArrayList<Receta> lista = (ArrayList<Receta>) daoReceta.getAll();
		assertNotNull("No deberia retornar null", lista);
		assertTrue(lista.size() >= 0);

	}

	/**
	 * Test para comprobar la recuperacion de todos las recetas con usuarios
	 */
	@Test()
	public void testGetAllWithUser() {

		ArrayList<Receta> lista = (ArrayList<Receta>) daoReceta.getAllWithUser();
		assertNotNull("No deberia retornar null", lista);
		assertNotNull("No deberia retornar null el usuario", lista.get(0).getUsuario());
		assertTrue(lista.size() >= 0);

	}

	/**
	 * Test para comprobar la recuperacion de una receta por su id.
	 */
	@Test()
	public void testGetById() {
		receta = daoReceta.getById(idNuevo);
		assertNotNull("No deberia retornar null", receta);
		assertEquals(NOMBRE, receta.getNombre());
		assertEquals(IMAGEN, receta.getImagen());
		assertEquals(DESCRIPCION, receta.getDescripcion());
	}

	/**
	 * Test para comprobar la modificacion de una receta.
	 */
	@Test()
	public void testUpdate() {
		recetaNueva.setNombre("pollo a la barbacoa");
		assertTrue(daoReceta.update(recetaNueva));

		receta = daoReceta.getById(idNuevo);
		assertNotNull("No deberia retornar null", receta);

		assertEquals("pollo a la barbacoa", receta.getNombre());
		assertEquals(IMAGEN, receta.getImagen());
		assertEquals(DESCRIPCION, receta.getDescripcion());
	}

	/**
	 * Test para comprobar la recuperacion de todas las recetas de un usuario
	 */
	@Test()
	public void testGetRecetasUser() {

		ArrayList<Receta> lista = (ArrayList<Receta>) daoReceta.getRecetasUser(user_idNuevo);
		assertNotNull("No deberia retornar null", lista);
		assertTrue(lista.size() >= 0);

	}

}
