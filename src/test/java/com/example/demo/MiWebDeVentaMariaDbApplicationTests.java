package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.demo.model.Usuario;

@SpringBootTest
class MiWebDeVentaMariaDbApplicationTests {

	private Usuario usuario;
	
	@BeforeEach
	public void init() {
		this.usuario = new Usuario("crisblamar");
	}
	
	@Test
	void testGetUserName() {
<<<<<<< HEAD
		assertEquals("crisblamar", usuario.getUsuario());
=======
		assertEquals("ruieh", usuario.getUsuario());
>>>>>>> 0f415f313e53cf6b1d3b9f38a60158037bf9d2d2
	}



}
