package com.example.demo;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;


import com.example.demo.model.Producto;
import com.example.demo.model.Usuario;
import com.example.demo.repository.ProductoRepository;
import com.example.demo.repository.UsuarioRepository;

@SpringBootApplication
public class MiWebDeVentaMariaDbApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(MiWebDeVentaMariaDbApplication.class, args);
	}

	
@Bean
	CommandLineRunner initData (ProductoRepository productoReposi, UsuarioRepository usuarioReposi) {
		return (args) ->{
			productoReposi.saveAll(Arrays.asList(new Producto("Peineta de buganvillas", 15.5),
					new Producto("Corona de flores blancas", 25.14),
					new Producto("Tocado flores secas", 10.50),
					new Producto("Par de horquillas de pétalos secos", 5.99),
					new Producto("Diadema de amapolas", 10.00)));
			
			usuarioReposi.saveAll(Arrays.asList(new Usuario("cris123", "crisblamar", "Cristina", "634885823", "cris@gmail.com", "calle amapola"),
				new Usuario("cvc4811", "cvilchescaro", "Carlos", "683774653", "carlos@gmail.com", "calle tamarindo")));

			
		};
	}
}
