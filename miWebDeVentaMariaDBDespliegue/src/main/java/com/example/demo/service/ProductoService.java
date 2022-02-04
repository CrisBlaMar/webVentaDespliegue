package com.example.demo.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Producto;
import com.example.demo.repository.ProductoRepository;

@Service
public class ProductoService {

	/**
	 * Inyectamos el repositorio de productos
	 */
	@Autowired
	private ProductoRepository productoReposi;
	
	
	
	
	/**
	 * Método para devolver todos los productos
	 */
	public List<Producto> getAllProducts() {
		return productoReposi.findAll();
	}
	
	

	public Producto getById (long id) {
		return productoReposi.findById(id).orElse(null);
	}
	
	
	/**
	 * Método para añadir un producto a la base de datos
	 * @param producto
	 * @return
	 */
	public Producto addProducto (Producto producto) {
		return productoReposi.save(producto);
	}
	
	
}
