package com.example.demo.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cantprodu")
public class CantProdu {
	
	/**
	 * Opción para no usar una clave primaria compuesta, generamos una nueva clave para esta tabla
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idCant;

	@ManyToOne
	@JoinColumn (name ="idPro")
	private Producto producto;
	
	
	@Column(name="cant")
	private int cant;

	
	
	
	/**Gets y sets
	 *
	 */

	public Producto getProducto() {
		return producto;
	}


	public long getIdCant() {
		return idCant;
	}


	public void setIdCant(long idCant) {
		this.idCant = idCant;
	}


	public void setProducto(Producto producto) {
		this.producto = producto;
	}


	public int getCant() {
		return cant;
	}


	public void setCant(int cant) {
		this.cant = cant;
	}


	
	/**
	 * HashCode y Equals
	 */

	@Override
	public int hashCode() {
		return Objects.hash(idCant);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CantProdu other = (CantProdu) obj;
		return idCant == other.idCant;
	}


	/** ToString
	 *
	 */
	@Override
	public String toString() {
		return "CantProdu [idCant=" + idCant + ", producto=" + producto +", cant=" + cant + "]";
	}
	

	
}
