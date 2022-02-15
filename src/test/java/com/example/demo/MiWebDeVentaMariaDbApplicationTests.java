package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MiWebDeVentaMariaDbApplicationTests {

	private Usuario usuario;
	
	@BeforeEach
	public void init() {
		this.usuario = new Usuario("crisblamar");
	}
	
	@Test
	void testGetUserName() {
		assertEquals("crisblamar", usuario.getUserName());
	}

}
