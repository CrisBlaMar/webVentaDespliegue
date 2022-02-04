package com.example.demo.model;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "pedidos")
public class Pedidos {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long referencia;
	

	
	@Column(name="direccionEnvio")
	private String direccionEnvio;
	
	@Column(name="fecha")
	private Date fecha;
	
	@Column(name="envio")
	private String envio;
	
	@Column(name="telefono")
	private String telefono;
	
	@Column(name="email")
	private String email;
	
	@Column(name="total")
	private double total;
	
	@ManyToOne
	@JoinColumn(name="usuarioPedido")
	private Usuario usuario;
	
	@OneToMany
    @JoinColumn(name= "idPedido")
	private List<CantProdu> listaCantProdu = new ArrayList<>();
	

	
	/**
	 * Constructor vacio
	 */
	public Pedidos () {
		this.fecha= new Date();
	}

	/**
	 * Constructor que le pasamos solo la referencia
	 * @param referencia
	 */
	public Pedidos(int referencia) {
		this.referencia= referencia;
	}

	/**
	 * Constructor que le pasamos la lista de cant produ (linea de pedido)
	 * @param listaCantProdu
	 */
	public Pedidos(List<CantProdu> listaCantProdu) {
		super();
		this.listaCantProdu = listaCantProdu;
	}

	
	
	
	
	
	/**
	 * Constructor con parámetros
	 * @param direccionEnvio
	 * @param fecha
	 * @param envio
	 * @param telefono
	 * @param email
	 */
	public Pedidos(String direccionEnvio, String envio, String telefono, String email) {
		super();
		this.direccionEnvio = direccionEnvio;
		this.envio = envio;
		this.telefono = telefono;
		this.email = email;
	}

	/**
	 * Gets y Sets
	 * @return
	 */

	public long getReferencia() {
		return referencia;
	}

	public void setReferencia(long referencia) {
		this.referencia = referencia;
	}

	public String getDireccionEnvio() {
		return direccionEnvio;
	}

	public void setDireccionEnvio(String direccionEnvio) {
		this.direccionEnvio = direccionEnvio;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getEnvio() {
		return envio;
	}

	public void setEnvio(String envio) {
		this.envio = envio;
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<CantProdu> getListaCantProdu() {
		return listaCantProdu;
	}

	public void setListaCantProdu(List<CantProdu> listaCantProdu) {
		this.listaCantProdu = listaCantProdu;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	/**
	 * HashCode y Equals
	 */
	@Override
	public int hashCode() {
		return Objects.hash(referencia);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedidos other = (Pedidos) obj;
		return referencia == other.referencia;
	}

	

	/**
	 * ToString
	 */
	@Override
	public String toString() {
		return "Pedidos [referencia=" + referencia + ", direccionEnvio=" + direccionEnvio + ", fecha=" + fecha
				+ ", envio=" + envio + ", telefono=" + telefono + ", email=" + email + ", total=" + total + ", usuario="
				+ usuario + "]";
	}



	
	
	
	
}
