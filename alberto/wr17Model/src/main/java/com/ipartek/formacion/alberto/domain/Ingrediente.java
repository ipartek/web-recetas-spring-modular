package com.ipartek.formacion.alberto.domain;

import javax.validation.constraints.Size;

/**
 * Pojo Ingredientes
 * 
 * @author Curso
 *
 */
public class Ingrediente {

	private static final int MIN_SIZE = 3;
	private static final int MAX_SIZE = 255;

	private long id;

	@Size(min = MIN_SIZE, max = MAX_SIZE, message = "Size.nombre")
	private String nombre;

	private boolean gluten;

	private String cantidad;

	/**
	 * Constructor sin parametros
	 */
	public Ingrediente() {
		super();
		this.id = -1;
		this.nombre = "";
		this.gluten = true;
		this.cantidad = "a ojimetro...";
	}

	/**
	 * Constructor con parametros
	 * 
	 * @param id
	 *            id del ingrediente
	 * @param nombre
	 *            nombre del ingrediente
	 * @param gluten
	 *            gluten del ingrediente
	 */
	public Ingrediente(long id, String nombre, boolean gluten) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.gluten = gluten;
		this.cantidad = "a ojimetro...";
	}

	/**
	 * Getter del parametro id del ingrediente
	 * 
	 * @return id del ingrediente
	 */
	public long getId() {
		return this.id;
	}

	/**
	 * Setter del parametro id del ingrediente
	 * 
	 * @param id
	 *            id del ingrediente
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Getter del parametro nombre del ingrediente
	 * 
	 * @return nombre del ingrediente
	 */
	public String getNombre() {
		return this.nombre;
	}

	/**
	 * Setter del parametro nombre del ingrediente
	 * 
	 * @param nombre
	 *            nombre del ingrediente
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Getter del parametro gluten del ingrediente
	 * 
	 * @return gluten del ingrediente
	 */
	public boolean isGluten() {
		return this.gluten;
	}

	/**
	 * Setter del parametro gluten del ingrediente
	 * 
	 * @param gluten
	 *            true si contiene gluten, false si no contiene gluten
	 */
	public void setGluten(boolean gluten) {
		this.gluten = gluten;
	}

	/**
	 * Getter del parametro cantidad del ingrediente
	 * 
	 * @return cantidad del ingrediente
	 */
	public String getCantidad() {
		return this.cantidad;
	}

	/**
	 * Setter del parametro cantidad del ingrediente
	 * 
	 * @param cantidad
	 *            cantidad del ingrediente
	 */
	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}

	@Override()
	public String toString() {
		return "Ingrediente [id=" + this.id + ", nombre=" + this.nombre + ", gluten=" + this.gluten + ", cantidad="
				+ this.cantidad + "]";
	}
}
