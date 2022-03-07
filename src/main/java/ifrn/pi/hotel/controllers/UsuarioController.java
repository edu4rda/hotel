package ifrn.pi.hotel.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ifrn.pi.hotel.models.Usuario;
import ifrn.pi.hotel.repositories.UserRepository;


@Controller
public class UsuarioController {

	@Autowired
	private UserRepository ur;
	
	@RequestMapping("/hotel/formUsuario")
	public String form() {
		return "formUsuario";
	}
	@PostMapping("/hotel/user")
	public String adicionar(Usuario usuario) {
		
		System.out.println(usuario);
		ur.save(usuario);
		return "usuario-cadastrado";
	}
}

