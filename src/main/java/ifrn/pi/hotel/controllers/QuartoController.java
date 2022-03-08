package ifrn.pi.hotel.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ifrn.pi.hotel.models.Quarto;
import ifrn.pi.hotel.repositories.QuartoRepository;

@Controller
public class QuartoController {

	@Autowired
	private QuartoRepository qr;

	@GetMapping("/hotel/formQuarto")
	public String form() {
		return "quarto/formQuarto";
	}

	@PostMapping("/hotel/room")
	public String reservar(Quarto quarto) {
		System.out.println(quarto);
		qr.save(quarto);
		return "quarto/quarto-reservado";
	}
	
	@GetMapping("/hotel/room")
	public ModelAndView listar() {
		
		List<Quarto> quartos = qr.findAll();
		ModelAndView mv = new ModelAndView("quarto/lista");
		mv.addObject("quartos", quartos);
		return mv;
	}

}
