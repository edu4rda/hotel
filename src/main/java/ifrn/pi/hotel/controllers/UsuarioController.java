package ifrn.pi.hotel.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ifrn.pi.hotel.models.Papel;
import ifrn.pi.hotel.models.Usuario;
import ifrn.pi.hotel.repositories.PapelRepository;
import ifrn.pi.hotel.repositories.UsuarioRepository;

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioRepository ur;
	@Autowired
	private PapelRepository pr;

	@RequestMapping("/user/formUsuario")
	public String form() {
		return "usuario/formUsuario";
	}

	@PostMapping("/user/us")
	public String adicionar(Usuario usuario) {
		
		
		System.out.println(usuario);
		System.out.println((new BCryptPasswordEncoder()).encode(usuario.getSenha()));
		usuario.setSenha((new BCryptPasswordEncoder()).encode(usuario.getSenha()));
		
		Papel papel = pr.findByNome("ROLE_USUARIO");
		List<Papel> papeis = new ArrayList<Papel>();
		papeis.add(papel);
		usuario.setPapeis(papeis);
		
		ur.save(usuario);
		return "usuario/usuario-cadastrado";
	}

	@GetMapping("/user/us")
	public ModelAndView listar() {

		List<Usuario> users = ur.findAll();
		ModelAndView mv = new ModelAndView("usuario/listaUsuario");
		mv.addObject("users", users);
		return mv;
	}

	@GetMapping("/user/{id}")
	public ModelAndView detalhar(@PathVariable Long id) {
		ModelAndView md = new ModelAndView();
		Optional<Usuario> opt = ur.findById(id);
		if (opt.isEmpty()) {
			md.setViewName("redirect:/listaUsuario");
			return md;

		}
		md.setViewName("usuario/detalhesUsuario");
		Usuario usuario = opt.get();
		md.addObject("usuario", usuario);

		return md;
	}
	@PostMapping("/user/{id}")
	public String salvarReserva(@PathVariable Long id, Usuario usuario) {
		
		System.out.println("Id da reserva: " + id);
		System.out.println(usuario);
		
		return"redirect:/user/{id}";
		
	}
}
