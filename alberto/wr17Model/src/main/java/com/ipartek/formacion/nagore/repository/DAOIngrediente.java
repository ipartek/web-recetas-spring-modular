package com.ipartek.formacion.nagore.repository;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataIntegrityViolationException;

import com.ipartek.formacion.nagore.domain.Ingrediente;

/**
 * Interfaz del DAOIngrediente
 * 
 * @author Curso
 *
 */
public interface DAOIngrediente {

	/**
	 * Recoge los parametros del fichero de configuracion de la BBDD y los
	 * inicializa
	 * 
	 * @param ds
	 *            DataSource
	 */
	void setDataSource(DataSource ds);

	/**
	 * Listado de ingredientes
	 * 
	 * @param order
	 *            orden ascendente o descendente
	 * @return List<Ingrediente> ordenados de forma descendente o descendente
	 */
	List<Ingrediente> getAll(String order);

	/**
	 * Listado de ingredientes de una Receta
	 * 
	 * @param idReceta
	 *            id de la receta
	 * @return List<Ingrediente>
	 */
	List<Ingrediente> getAllByReceta(long idReceta);

	/**
	 * Recupera un Ingrediente de la bbdd, sin la 'cantidad' asociada a una
	 * Receta
	 * 
	 * @param id
	 *            ingrediente
	 * @return Ingrediente, null si no existe
	 */
	Ingrediente getById(long id);

	/**
	 * Recupera una List<Ingrediente> de la bbdd buscandolo por el nombre
	 * 
	 * @param nombre
	 *            nombre del ingrediente a buscar
	 * @param ordenASC
	 *            Orden ascendente o descendente
	 * @return List<Ingrediente>, lista vacia si no existe
	 */
	List<Ingrediente> buscarPorNombre(String nombre, boolean ordenASC);

	/**
	 * Inserta un Ingrediente
	 * 
	 * @param i
	 *            Ingrediente
	 * @return true si se inserta en la BBDD, false si no se inserta
	 */
	boolean insert(Ingrediente i);

	/**
	 * Modifica un Ingrediente
	 * 
	 * @param i
	 *            Ingrediente
	 * @return true si se modifica en la BBDD, false si no se modifica
	 */
	boolean update(Ingrediente i);

	/**
	 * Elimina un Ingrediente
	 * 
	 * @param id
	 *            id del Ingrediente
	 * @return true si lo elimina, false en caso contrario
	 * @throws DataIntegrityViolationException
	 *             cuando un ingrediente es usada en alguna receta lanza
	 *             excepcion, puesto que tiene una constrain o restriccion en la
	 *             BBDD "fk_ingrediente_has_receta_ingrediente"
	 */
	boolean delete(long id) throws DataIntegrityViolationException;

	/**
	 * Elimina un Ingrediente correspondiente a una Receta
	 * 
	 * @param idReceta
	 *            id de la Receta
	 * @param idIngrediente
	 *            id del Ingrediente
	 * @return true si lo elimina, false en caso contrario
	 * 
	 */
	boolean deleteByReceta(long idReceta, long idIngrediente);

	/**
	 * Modifica los ingredientes de una Receta
	 * 
	 * @param idReceta
	 *            id de la Receta
	 * @param i
	 *            Ingrediente
	 * @return true si lo modifica, false en caso contrario
	 * 
	 */
	boolean updateByReceta(long idReceta, Ingrediente i);

	/**
	 * Añadir nuevo ingrediente a la Receta
	 * 
	 * @param idReceta
	 *            id de la Receta
	 * @param i
	 *            Ingrediente
	 * @return true si añade, false en caso contrario
	 */
	boolean insertByReceta(long idReceta, Ingrediente i);

	/**
	 * Recupera todos los ingredientes que no este usando la Receta
	 * 
	 * @param idReceta
	 *            id receta
	 * @return List<Ingrediente>
	 */
	List<Ingrediente> getAllByNotInReceta(long idReceta);

	/**
	 * Recupera Ingrediente de una Receta, con su 'cantidad'
	 * 
	 * @param idReceta
	 *            id de la receta
	 * @param idIngrediente
	 *            id ingrediente
	 * @return Ingrediente, null si no existe
	 */
	Ingrediente getByReceta(long idReceta, long idIngrediente);

	/**
	 * Numero total de ingredientes
	 * 
	 * @return total ingredientes
	 */
	int getTotalIngrediente();

}
