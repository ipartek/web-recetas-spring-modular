package com.ipartek.formacion.alberto.repository;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataIntegrityViolationException;

import com.ipartek.formacion.alberto.domain.Usuario;

/**
 * Interfaz para el DAO
 * 
 * @author Curso
 *
 */
public interface DAOUsuario {

	/**
	 * Recoge los parametros del fichero de configuracion de la BBDD y los
	 * inicializa
	 * 
	 * @param ds
	 *            DataSource
	 */
	void setDataSource(DataSource ds);

	/**
	 * Listado de usuarios con los datos minimos
	 * 
	 * @return List<Usuario> ordenados de forma descendente y limitado a los
	 *         ultimos 1000 creados. Lista vacia si no existe ninguna receta.
	 */
	List<Usuario> getAll();

	/**
	 * Listado de usuarios con los datos minimos y restringido el password
	 * 
	 * @return List<Usuario> ordenados de forma descendente y limitado a los
	 *         ultimos 1000 creados. Lista vacia si no existe ninguna receta.
	 */
	List<Usuario> getAllRestricted();

	/**
	 * Listado de usuarios con todas sus recetas
	 * 
	 * @return List<Usuario> ordenados de forma descendente y limitado a los
	 *         ultimos 1000 creados. Lista vacia si no existe ninguna receta.
	 */
	List<Usuario> getAllWithRecetas();

	/**
	 * Detalle de un usuario
	 * 
	 * @param id
	 *            id del usuario
	 * @return Usuario
	 */
	Usuario getById(long id);

	/**
	 * Detalle de un usuario restringiendo el password
	 * 
	 * @param id
	 *            id del usuario
	 * @return Usuario
	 */
	Usuario getByIdRestricted(long id);

	/**
	 * Detalle de un usuario correspondiente a una receta
	 * 
	 * @param idReceta
	 *            id de la receta
	 * @return Usuario
	 */
	Usuario getUserByReceta(long idReceta);

	/**
	 * Inserta un Usuario
	 * 
	 * @param u
	 *            Usuario
	 * @return true si se inserta en la BBDD, false si no se inserta
	 */
	boolean insert(Usuario u);

	/**
	 * Modifica un Usuario
	 * 
	 * @param u
	 *            Usuario
	 * @return true si se modifica en la BBDD, false si no se modifica
	 */
	boolean update(Usuario u);

	/**
	 * Eliminamos un Usuario
	 * 
	 * @param id
	 *            identificador del Usuario
	 * @return true si lo elimina, false en caso contrario
	 * @throws DataIntegrityViolationException
	 *             cuando un usuario contiene recetas lanza excepcion, puesto
	 *             que tiene una constrain o restriccion en la BBDD
	 *             "fk_receta_usuario"
	 */
	boolean delete(long id) throws DataIntegrityViolationException;

	/**
	 * Buscamos si existe el nombre del usuario en la bbdd.<br>
	 * La busqueda NO es Case-sensitive.
	 * 
	 * @param nombre
	 *            String nombre del usuario a buscar
	 * @return Usuario si existe, null si no existe
	 */
	Usuario exist(String nombre);

}
