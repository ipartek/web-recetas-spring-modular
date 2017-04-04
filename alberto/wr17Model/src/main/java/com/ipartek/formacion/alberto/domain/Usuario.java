package com.ipartek.formacion.alberto.domain;

import java.util.ArrayList;

import javax.validation.constraints.Size;

/**
 * Pojo Usuario
 * 
 * @author Curso
 *
 */
public class Usuario {

	private static final int MIN_SIZE = 3;
	private static final int MAX_SIZE = 255;

	private long id;

	@Size(min = MIN_SIZE, max = MAX_SIZE, message = "Size.nombre")
	private String nombre;

	@Size(min = MIN_SIZE, max = MAX_SIZE, message = "Size.email")
	private String email;

	@Size(min = MIN_SIZE, max = MAX_SIZE, message = "Size.password")
	private String password;

	@Size(min = MIN_SIZE, max = MAX_SIZE, message = "Size.imagen")
	private String imagen;

	private ArrayList<Receta> recetas;

	/**
	 * Constructor sin parametros
	 */
	public Usuario() {
		super();
		this.id = -1;
		this.nombre = "";
		this.email = "";
		this.password = "";
		this.imagen = "";
		this.recetas = new ArrayList<Receta>();

	}

	/**
	 * Getter del parametro id del usuario
	 * 
	 * @return id del usuario
	 */
	public long getId() {
		return this.id;
	}

	/**
	 * Setter del parametro id del usuario
	 * 
	 * @param id
	 *            id del usuario
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Getter del parametro nombre del usuario
	 * 
	 * @return nombre del usuario
	 */
	public String getNombre() {
		return this.nombre;
	}

	/**
	 * Setter del parametro nombre del usuario
	 * 
	 * @param nombre
	 *            nombre del usuario
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Getter del parametro email del usuario
	 * 
	 * @return email del usuario
	 */
	public String getEmail() {
		return this.email;
	}

	/**
	 * Setter del parametro email del usuario
	 * 
	 * @param email
	 *            email del usuario
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Getter del parametro password del usuario
	 * 
	 * @return password del usuario
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * Setter del parametro password del usuario
	 * 
	 * @param password
	 *            password del usuarios
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Getter del parametro imagen del usuario
	 * 
	 * @return imagen del usuario
	 */
	public String getImagen() {
		return this.imagen;
	}

	/**
	 * Setter del parametro imagen del usuario
	 * 
	 * @param imagen
	 *            imagen del usuarios
	 */
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	/**
	 * Getter del parametro recetas del usuario
	 * 
	 * @return ArrayList<Receta> del usuario
	 */
	public ArrayList<Receta> getRecetas() {
		return this.recetas;
	}

	/**
	 * Setter del parametro recetas del usuario
	 * 
	 * @param recetas
	 *            ArrayList<Receta> del usuarios
	 */
	public void setRecetas(ArrayList<Receta> recetas) {
		this.recetas = recetas;
	}

	/**
	 * Añade nueva receta a la lista de las Recetas.
	 * 
	 * @param receta
	 *            ArrayList<Receta>
	 */
	public void addReceta(Receta receta) {

		if (this.recetas == null) {
			this.recetas = new ArrayList<Receta>();
		}

		if (receta != null) {
			this.recetas.add(receta);
		}

	}

	@Override()
	public String toString() {
		return "Usuario [id=" + this.id + ", nombre=" + this.nombre + ", email=" + this.email + ", password="
				+ this.password + ", imagen=" + this.imagen + ", recetas=" + this.recetas + "]";
	}

}
