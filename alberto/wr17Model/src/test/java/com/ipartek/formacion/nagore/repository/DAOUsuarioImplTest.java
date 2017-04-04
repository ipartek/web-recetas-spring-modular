package com.ipartek.formacion.nagore.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ipartek.formacion.nagore.domain.Receta;
import com.ipartek.formacion.nagore.domain.Usuario;

/**
 * Test para comprobar el funcionamiento del DAO
 * 
 * @author Curso
 */
// @RunWith(value = SpringJUnit4ClassRunner.class)
// @ContextConfiguration(locations = "classpath:application-context-test.xml")
public class DAOUsuarioImplTest {

	// @Autowired()
	private static DAOUsuario daoUsuario;
	private static DAOReceta daoReceta;

	private static ApplicationContext context;

	private static Usuario usuario;
	private static Usuario usuarioNuevo;
	private static ArrayList<Usuario> usuarios;

	private static int contadorInicial = -1;
	private static int contador = -1;
	private static long idNuevo = -1;

	private static final String NOMBRE = "Pepe";
	private static final String EMAIL = "pepe@gmail.com";
	private static final String PASSWORD = "123";
	private static final String IMAGEN = "url_img";

	private static final String RECETA_NOMBRE = "Pechuga de pollo";
	private static final String RECETA_IMAGEN = "url_img";
	private static final String RECETA_DESCRIPCION = "Lorem ipsun...";

	private static Receta receta1 = null;
	private static ArrayList<Receta> recetas = null;

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

		daoUsuario = (DAOUsuario) context.getBean("daoUsuario");
		daoReceta = (DAOReceta) context.getBean("daoReceta");

		assertNotNull(daoUsuario.getAll());

		usuarioNuevo = new Usuario();
		usuarioNuevo.setNombre(NOMBRE);
		usuarioNuevo.setEmail(EMAIL);
		usuarioNuevo.setPassword(PASSWORD);
		usuarioNuevo.setImagen(IMAGEN);

		receta1 = new Receta();
		receta1.setNombre(RECETA_NOMBRE);
		receta1.setImagen(RECETA_IMAGEN);
		receta1.setDescripcion(RECETA_DESCRIPCION);

		recetas = new ArrayList<Receta>();
		recetas.add(receta1);

		// usuarioNuevo.setRecetas(recetas);

		// Contar usuarios iniciales de la BBDD.

		usuarios = new ArrayList<Usuario>();
		usuarios = (ArrayList<Usuario>) daoUsuario.getAll();
		contadorInicial = usuarios.size();

		// Crear usuario nuevo
		assertTrue("No inserta nuevo usuario en la bbdd", daoUsuario.insert(usuarioNuevo));
		receta1.setUsuario(usuarioNuevo);
		assertTrue("No inserta nueva receta en la bbdd", daoReceta.insert(receta1));
		idNuevo = usuarioNuevo.getId();
		usuarios = (ArrayList<Usuario>) daoUsuario.getAll();
		contador = usuarios.size();
		assertTrue("Deberia haber un nuevo usuario", contador > contadorInicial);
	}

	/**
	 * Se finaliza despues de todos los test
	 * 
	 * @throws Exception
	 *             lanza excepcion en caso de error
	 */
	@AfterClass()
	public static void tearDownAfterClass() throws Exception {

		// Eliminar usuario insertado
		assertTrue("No inserta nueva receta en la bbdd", daoReceta.delete(receta1.getId()));
		assertTrue("No elimina nuevo usuario en la bbdd", daoUsuario.delete(usuario.getId()));

		usuario = null;
		usuarios = null;
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
	 * Test para comprobar la recuperacion de todos los usuarios con los datos
	 * minimos
	 */
	@Test()
	public void testgetAll() {
		assertEquals("class com.ipartek.formacion.nagore.repository.DAOUsuarioImpl", daoUsuario.getClass().toString());

		ArrayList<Usuario> lista = (ArrayList<Usuario>) daoUsuario.getAll();
		assertNotNull("No deberia retornar null", lista);
		assertTrue(lista.size() >= 0);

	}

	/**
	 * Test para comprobar la recuperacion de todos los usuarios con los datos
	 * minimos y restringido el password
	 */
	@Test()
	public void testGetAllRestricted() {

		ArrayList<Usuario> lista = (ArrayList<Usuario>) daoUsuario.getAllRestricted();
		assertNotNull("No deberia retornar null", lista);
		assertEquals("", lista.get(0).getPassword());
		assertTrue(lista.size() >= 0);

	}

	/**
	 * Test para comprobar la recuperacion de todos los usuarios Listado de
	 * usuarios con todas sus recetas
	 */
	@Test()
	public void testGetAllWithRecetas() {

		ArrayList<Usuario> lista = (ArrayList<Usuario>) daoUsuario.getAllWithRecetas();
		assertNotNull("No deberia retornar null", lista);
		assertNotNull("No deberia retornar null en Recetas", lista.get(0).getRecetas());
		assertTrue(lista.get(0).getRecetas().size() >= 0);
		assertTrue(lista.size() >= 0);

	}

	/**
	 * Test para comprobar la recuperacion de un usuario por su id.
	 */
	@Test()
	public void testGetById() {
		usuario = daoUsuario.getById(idNuevo);
		assertNotNull("No deberia retornar null", usuario);
		assertEquals(NOMBRE, usuario.getNombre());
		assertEquals(EMAIL, usuario.getEmail());
		assertEquals(PASSWORD, usuario.getPassword());
		assertEquals(IMAGEN, usuario.getImagen());
	}

	/**
	 * Test para comprobar la recuperacion de un usuario por su id restringiendo
	 * el password
	 */
	@Test()
	public void testGetByIdRestricted() {

		usuario = daoUsuario.getByIdRestricted(idNuevo);
		assertNotNull("No deberia retornar null", usuario);

		assertEquals(NOMBRE, usuario.getNombre());
		assertEquals(EMAIL, usuario.getEmail());
		assertEquals("", usuario.getPassword());
		assertEquals(IMAGEN, usuario.getImagen());
	}

	/**
	 * Test para comprobar la recuperacion de un usuario correspondiente a una
	 * Receta
	 */
	@Test()
	public void testGetUserByReceta() {

		usuario = daoUsuario.getUserByReceta(receta1.getId());
		assertNotNull("No deberia retornar null", usuario);
		assertEquals(NOMBRE, usuario.getNombre());
		assertEquals(EMAIL, usuario.getEmail());
		assertEquals(PASSWORD, usuario.getPassword());
		assertEquals(IMAGEN, usuario.getImagen());
	}

	/**
	 * Test para comprobar la modificacion de un usuario.
	 */
	@Test()
	public void testUpdate() {

		usuarioNuevo.setNombre("Pepito");
		assertTrue(daoUsuario.update(usuarioNuevo));

		usuario = daoUsuario.getById(idNuevo);
		assertNotNull("No deberia retornar null", usuario);
		assertEquals("Pepito", usuario.getNombre());
		assertEquals(EMAIL, usuario.getEmail());
		assertEquals(PASSWORD, usuario.getPassword());
		assertEquals(IMAGEN, usuario.getImagen());
	}

	/**
	 * Test para comprobar si un usuario existe en la BBDD
	 */
	@Test()
	public void testExist() {
		assertNotNull(daoUsuario.exist(NOMBRE));
		assertNull(daoUsuario.exist("Nombre falso"));

	}

}
