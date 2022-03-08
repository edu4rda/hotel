package ifrn.pi.hotel.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ifrn.pi.hotel.models.Usuario;
import ifrn.pi.hotel.repositories.UserRepository;


@Controller
public class UsuarioController {

	@Autowired
	private UserRepository ur;
	
	@RequestMapping("/hotel/formUsuario")
	public String form() {
		return "usuario/formUsuario";
	}
	@PostMapping("/hotel/user")
	public String adicionar(Usuario usuario) {
		
		System.out.println(usuario);
		ur.save(usuario);
		return "usuario/usuario-cadastrado";
	}
	@GetMapping("/hotel/user")
	public ModelAndView listar() {
		
		List<Usuario> users = ur.findAll();
		ModelAndView mv = new ModelAndView("usuario/listaUsuario");
		mv.addObject("users", users);
		return mv;
	}
	
	
}

