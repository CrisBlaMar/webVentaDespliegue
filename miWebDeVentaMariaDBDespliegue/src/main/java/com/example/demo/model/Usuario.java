package com.example.demo.model;


import java.util.Objects;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "usuarios")
public class Usuario {


	@Column(name="contrasenia")
	private String contrasenia;
	
	@Id
	@Column(name="user", nullable= false)
	private String user;
	
	@Column(name="nombre", nullable= false)
	private String nombre;
	
	@Column(name="telefono", nullable = false)
	private String telefono;

	@Column(name="email", nullable = false)
	private String email;
	
	@Column(name="direccion", nullable = false)
	private String direccion;
	


	
	/**
	 * Constructor con parámetros
	 * @param contrasenia
	 * @param usuario
	 * @param nombre
	 * @param telefono
	 * @param email
	 * @param direccion
	 */
	public Usuario(String contrasenia, String usuario, String nombre, String telefono, String email, String direccion) {
		super();
		this.contrasenia = contrasenia;
		this.user = usuario;
		this.nombre = nombre;
		this.telefono = telefono;
		this.email = email;
		this.direccion = direccion;
	}
	


	/**
	 * Constructor vacío
	 */
	public Usuario() {}

	/**
	 * Constructor para probar usuario y contrasenia
	 * @param usuario
	 * @param contrasenia
	 */
	public Usuario (String usuario, String contrasenia, String nombre) {
		this.contrasenia= contrasenia;
		this.user= usuario;
		this.nombre= nombre;
	}

	/**
	 * GETS Y SETS
	 */
	
	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}


	public String getUsuario() {
		return user;
	}

	
	public void setUsuario(String usuario) {
		this.user = usuario;
	}

	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	
	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	/**
	 * ToString
	 */
	@Override
	public String toString() {
		return "El usuario: " + user + ", con contraseña: " + contrasenia + ", con nombre: " + nombre
				+ ", teléfono=" + telefono + ", email=" + email + " y dirección=" + direccion;
	}
	
	/**
	 * HASHCODE Y EQUALS
	 */
	@Override
	public int hashCode() {
		return Objects.hash(user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(user, other.user);
	}
	

	
}
