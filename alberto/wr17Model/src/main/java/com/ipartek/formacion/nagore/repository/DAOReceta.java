package com.ipartek.formacion.nagore.repository;

import java.util.List;

import javax.sql.DataSource;

import com.ipartek.formacion.nagore.domain.Receta;

/**
 * Interfaz para el DAOReceta
 * 
 * @author Curso
 *
 */
public interface DAOReceta {

	/**
	 * Recoge los parametros del fichero de configuracion de la BBDD y los
	 * inicializa
	 * 
	 * @param ds
	 *            DataSource
	 */
	void setDataSource(DataSource ds);

	/**
	 * Listado de todas las recetas sin Usuarios
	 * 
	 * @return List<Receta> si hay datos, si no List inicializada not null
	 */
	List<Receta> getAll();

	/**
	 * Listado de todas las recetas con usuarios
	 * 
	 * @return List<Receta> si hay datos, si no List inicializada not null
	 */
	List<Receta> getAllWithUser();

	/**
	 * Detalle de una Receta
	 * 
	 * @param id
	 *            id de la Receta
	 * @return Receta
	 */
	Receta getById(long id);

	/**
	 * Inserta una Receta
	 * 
	 * @param r
	 *            Receta
	 * @return true si se inserta en la BBDD, false si no se inserta
	 */
	boolean insert(Receta r);

	/**
	 * Modifica una Receta
	 * 
	 * @param r
	 *            Receta
	 * @return true si se modifica en la BBDD, false si no se modifica
	 */
	boolean update(Receta r);

	/**
	 * Elimina una Receta
	 * 
	 * @param id
	 *            id de la Receta
	 * @return true si elimina de la BBDD, false si no lo elimina
	 */
	boolean delete(long id);

	/**
	 * Buscamos todas las recetas que tenga el usuario.<br>
	 * 
	 * @param idUsuario
	 *            id del Usuario
	 * @return List<Receta>
	 */
	List<Receta> getRecetasUser(long idUsuario);

}
