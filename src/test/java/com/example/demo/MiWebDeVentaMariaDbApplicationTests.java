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
		assertEquals("crisblamar", usuario.getUserName());
>>>>>>> 3f258b8a69d3c3e6ca799cea9c812f366b9d9520
	}



}
