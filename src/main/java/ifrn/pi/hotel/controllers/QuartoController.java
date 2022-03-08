package ifrn.pi.hotel.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ifrn.pi.hotel.models.Quarto;
import ifrn.pi.hotel.repositories.QuartoRepository;

@Controller
public class QuartoController {

	@Autowired
	private QuartoRepository qr;

	@GetMapping("/quarto/formQuarto")
	public String form() {
		return "quarto/formQuarto";
	}

	@PostMapping("/quarto/room")
	public String reservar(Quarto quarto) {
		System.out.println(quarto);
		qr.save(quarto);
		return "quarto/quarto-reservado";
	}

	@GetMapping("/quarto/room")
	public ModelAndView listar() {
		List<Quarto> quartos = qr.findAll();
		ModelAndView mv = new ModelAndView("quarto/lista");
		mv.addObject("quartos", quartos);
		return mv;
	}

	@GetMapping("/quarto/{id}")
	public ModelAndView detalhar(@PathVariable Long id) {
		ModelAndView md = new ModelAndView();
		Optional<Quarto> opt = qr.findById(id);
		if (opt.isEmpty()) {
			md.setViewName("redirect:/lista");
			return md;
		}

		md.setViewName("quarto/detalhesQuarto");
		Quarto quarto = opt.get();
		md.addObject("quarto", quarto);

		return md;

	}

}
