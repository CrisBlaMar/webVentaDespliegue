package com.example.demo.service;



import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioRepository;


@Service
public class UsuarioService {

	/**
	 * Inyectamos el repositorio de usuario
	 */
	@Autowired
	private UsuarioRepository usuarioReposi;
	
	
	/**
	 * Método que recibe un username para devolver el usuario que coincida con ese username
	 * @param username -> clave primaria e identificativa de cada usuario
	 * @return nos devuelve el usuario que coincide con ese username
	 */
	public Usuario getUsuarioByUsername(String username){
		
		return usuarioReposi.findById(username).orElse(null);
		
	}
	
	
	/**
	 * Método para añadir un usuario a la base de datos
	 * @param usuario
	 * @return
	 */
	public Usuario addUsuario (Usuario usuario) {
		
		return usuarioReposi.save(usuario);
	}
	
	
	/**
	 * Este método nos comprueba que existe el usuario con ese nombre de usuario.
	 * @param usuario
	 * @return nos devuelve el usuario que conincide con ese nombre
	 */
	public Usuario getByUsuario (String usuario) {
		
		Usuario resultado = null;
		
		boolean isEncontrado = false;
		int indice = 0;
		
		while(!isEncontrado && indice<usuarioReposi.findAll().size()) {
			if(Objects.equals(usuarioReposi.findAll().get(indice).getUsuario(), usuario)) {
				isEncontrado = true;
				resultado = usuarioReposi.findAll().get(indice);
			}else {
				indice++;
			}
		}
		
		return resultado;	
	}
	
	
	/**
	 * Método para comprobar si existe un usuario con esa contraseña
	 * @param usuario
	 * @param contrasenia
	 * @return nos devuelve true o false en función de si lo encuentra o no
	 */
	public boolean hayUsuario (String usuario, String contrasenia) {
		 
		
		boolean resul= false;
		int indice= 0;
		
		while(!resul && indice<usuarioReposi.findAll().size()) {
			if(usuarioReposi.findAll().get(indice).getUsuario().equals(usuario) && usuarioReposi.findAll().get(indice).getContrasenia().equals(contrasenia)) {
				resul= true;
			}else {
				indice++;
			}
		}
		return resul;
			
	}
	

	

}
