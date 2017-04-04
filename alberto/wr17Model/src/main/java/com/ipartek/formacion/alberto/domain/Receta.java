package com.ipartek.formacion.alberto.domain;

import java.util.ArrayList;

import javax.validation.constraints.Size;

/**
 * Pojo Receta
 * 
 * @author Curso
 *
 */
public class Receta {

	private static final int MIN_SIZE_NOMBRE = 3;
	private static final int MIN_SIZE_IMAGEN = 4;
	private static final int MIN_SIZE_DESCRIPCION = 100;
	private static final int MAX_SIZE = 255;
	private static final int MAX_SIZE_DESCRIPCION = 65535;

	private long id;

	@Size(min = MIN_SIZE_NOMBRE, max = MAX_SIZE, message = "Size.nombre")
	private String nombre;

	@Size(min = MIN_SIZE_IMAGEN, max = MAX_SIZE, message = "Size.imagen")
	private String imagen;

	@Size(min = MIN_SIZE_DESCRIPCION, max = MAX_SIZE_DESCRIPCION, message = "Size.descripcion")
	private String descripcion;

	private ArrayList<Ingrediente> ingredientes;

	private Usuario usuario;

	/**
	 * Constructor sin parametros
	 */
	public Receta() {
		super();
		this.id = -1;
		this.nombre = "";
		this.imagen = "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcTnAvi3z2rEKI0Mp5vmsF15eFxgNyq01FfRQROAaiFjhy5k5iuPLA";
		this.descripcion = "";
		this.ingredientes = null;
		this.usuario = null;
	}

	/**
	 * Getter del parametro id de la receta
	 * 
	 * @return id de la receta
	 */
	public long getId() {
		return this.id;
	}

	/**
	 * Setter del parametro id de la receta
	 * 
	 * @param id
	 *            id de la receta
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Getter del parametro nombre de la receta
	 * 
	 * @return nombre de la receta
	 */
	public String getNombre() {
		return this.nombre;
	}

	/**
	 * Setter del parametro nombre de la receta
	 * 
	 * @param nombre
	 *            nombre de la receta
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Getter del parametro imagen de la receta
	 * 
	 * @return imagen de la receta
	 */
	public String getImagen() {
		return this.imagen;
	}

	/**
	 * Setter del parametro imagen de la receta
	 * 
	 * @param imagen
	 *            imagen de la receta
	 */
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	/**
	 * Getter del parametro descripcion de la receta
	 * 
	 * @return descripcion de la receta
	 */
	public String getDescripcion() {
		return this.descripcion;
	}

	/**
	 * Setter del parametro descripcion de la receta
	 * 
	 * @param descripcion
	 *            descripcion de la receta
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Getter del parametro ingredientes de la receta
	 * 
	 * @return ArrayList<Ingrediente> de la receta
	 */
	public ArrayList<Ingrediente> getIngredientes() {
		return ingredientes;
	}

	/**
	 * Setter del parametro ingredientes de la receta
	 * 
	 * @param ingredientes
	 *            ArrayList<Ingrediente> de la receta
	 */
	public void setIngredientes(ArrayList<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}

	/**
	 * Getter del parametro usuario de la receta
	 * 
	 * @return Usuario de la receta
	 */
	public Usuario getUsuario() {
		return this.usuario;
	}

	/**
	 * Setter del parametro usuario de la receta
	 * 
	 * @param usuario
	 *            Usuario de la receta
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override()
	public String toString() {
		return "Receta [id=" + this.id + ", nombre=" + this.nombre + ", imagen=" + this.imagen + ", descripcion="
				+ this.descripcion + ", usuario=" + this.usuario + "]";
	}

}
