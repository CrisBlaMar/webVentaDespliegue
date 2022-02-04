package com.example.demo.service;



import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.CantProdu;
import com.example.demo.model.Pedidos;
import com.example.demo.model.Producto;
import com.example.demo.model.Usuario;
import com.example.demo.repository.CantProduRepository;
import com.example.demo.repository.PedidoRepository;

@Service
public class PedidosService {
	
	/**
	 * Inyectamos el repositorio de pedido.
	 */
	@Autowired
	private PedidoRepository pedidoReposi;
	
	/**
	 * Inyectamos el repositorio de cantProdu (linea de pedido)
	 */
	@Autowired
	private CantProduRepository cantproduReposi;

	
	
	@Autowired
	private ProductoService servicioProdu;
	
	
	
	
	/**
	 * Devuelve todos los pedidos de un usuario
	 * @return
	 */
	public List<Pedidos> getPedidosUsuario (String usuario) {
		
		return this.pedidoReposi.getPedidosUsuario(usuario);
	}
	
	
	/**
	 * Método para buscar un pedido a partir de una referencia
	 * @param referencia
	 * @return devuelve el pedido que coincida con la referencia que se le pasa 
	 */
	public Pedidos getPedidoByReferencia (long referencia) {
		return pedidoReposi.findById(referencia).orElse(null);
	}
	
	
	/**
	 * Añade un pedido a la base de datos
	 * @param pedido
	 * @return
	 */
	public Pedidos addPedido (Pedidos pedido) {
		return pedidoReposi.save(pedido);
	}
	


	/**
	 * Añade un cantProdu (linea de pedido) a un pedido
	 * @param pedido
	 * @param cantprodu
	 * @param cantidad
	 * @param producto
	 */
	public void addCantProduAPedido (Pedidos ped, CantProdu cantprodu, int cantidad, Producto producto) {
		
		cantprodu.setCant(cantidad);
		cantprodu.setProducto(producto);
		ped.getListaCantProdu().add(cantprodu);
		cantproduReposi.save(cantprodu);

		
	}
	
	/**
	 * Método para asignarle a un pedido un usuario con sus datos correspondientes.
	 * @param usuario
	 * @param precio
	 * @param pedido
	 * @return
	 */
	public Pedidos addUsuarioAPedido(Usuario usuario, double precio, Pedidos pedido) {
		
		pedido.setUsuario(usuario);
		pedido.setTotal(precio);
		
		pedido.setDireccionEnvio(usuario.getDireccion());
		pedido.setEmail(usuario.getEmail());
		pedido.setTelefono(usuario.getTelefono());
		
		return pedido;
	}
	
	
	/**
	 * Método para añadir un pedido a un usuario
	 * @param cantProdu
	 * @param usuario
	 * @return
	 */
	public Pedidos addPedidoAUsuario (int[] cantProdu, Usuario usuario) {
		
		Pedidos pedido = new Pedidos();
		
		
		List<Producto> productos = this.servicioProdu.getAllProducts();
		
		double total = 0;
		for (int i = 0; i < cantProdu.length; i++) {

			if (cantProdu[i] > 0) {
				total += productos.get(i).getPrecio()*cantProdu[i];
				CantProdu cantpro = new CantProdu();
				addCantProduAPedido (pedido, cantpro, cantProdu[i], productos.get(i));
			}
		}
		
		pedido = addUsuarioAPedido (usuario, total, pedido);
		return this.addPedido(pedido);
		
	}
	
	

	
	/**
	 * Método para editar los pedidos de un usuario
	 * @param refe
	 * @param email
	 * @param telefono
	 * @param direccion
	 * @param cantidades
	 * @param envio
	 * @param usuario
	 */
	public void editarPedido(int refe, String direccion, String telefono,  String email,  String envio) {
		
		Pedidos pedido = getPedidoByReferencia(refe);

		pedido.setDireccionEnvio(direccion);
		pedido.setEmail(email);
		pedido.setTelefono(telefono);
		pedido.setEnvio(envio);
		this.pedidoReposi.save(pedido);
		
	} 
	
	
	
	
	
	
	/**
	 * Método para borrar un pedido, primero tenemos que borrar la línea de pedido
	 * y a continuación borramos el pedido
	 * @param pedido
	 */
	public void borrarPedido (Pedidos pedido) {
			
		Iterator<CantProdu> iterator = pedido.getListaCantProdu().iterator();
		
		while(iterator.hasNext()) {
			CantProdu cantPro = iterator.next();
			this.cantproduReposi.delete(cantPro);
		}
		
		
		this.pedidoReposi.delete(pedido);
		
	
		
	}
	

}
