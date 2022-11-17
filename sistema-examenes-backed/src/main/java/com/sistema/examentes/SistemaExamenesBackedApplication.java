package com.sistema.examentes;

import com.sistema.examentes.entidades.Rol;
import com.sistema.examentes.entidades.Usuario;
import com.sistema.examentes.entidades.UsuarioRol;
import com.sistema.examentes.servicios.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class SistemaExamenesBackedApplication implements CommandLineRunner {

	@Autowired
	private UsuarioService usuarioService;

	public static void main(String[] args) {

		SpringApplication.run(SistemaExamenesBackedApplication.class, args);
		//minuto 1:11:51
	}

	@Override
	public void run(String... args) throws Exception {

		Usuario usuario = new Usuario();
		usuario.setNombre("Alan");
		usuario.setApellido("Mengassini");
		usuario.setUsername("AlanMng");
		usuario.setPassword("12345");
		usuario.setEmail("c1@gmail.com");
		usuario.setTelefono("1140442112");
		usuario.setPerfil("foto.png");

		Rol rol = new Rol();
		rol.setRolId(1l);
		rol.setNombre("ADMIN");

		Set<UsuarioRol> usuarioRoles = new HashSet<>();
		UsuarioRol usuarioRol = new UsuarioRol();
		usuarioRol.setRol(rol);
		usuarioRol.setUsuario(usuario);
		usuarioRoles.add(usuarioRol);

		Usuario usuarioGuardado = usuarioService.guardarUsuario(usuario, usuarioRoles);
		System.out.println(usuarioGuardado.getUsername());
	}
}
