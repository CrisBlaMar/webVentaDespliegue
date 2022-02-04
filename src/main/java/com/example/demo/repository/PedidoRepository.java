package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.example.demo.model.Pedidos;
import com.example.demo.model.Usuario;

@Repository
public interface PedidoRepository extends JpaRepository<Pedidos, Long>{
	
	@Query("SELECT ped FROM Pedidos ped WHERE usuario_pedido =:usuario ORDER BY fecha DESC")
	public List <Pedidos> getPedidosUsuario (String usuario);

}