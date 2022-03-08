package ifrn.pi.hotel.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ifrn.pi.hotel.models.Reserva;
import ifrn.pi.hotel.repositories.ReservaRepository;

@Controller
public class ReservaController {

	@Autowired
	private ReservaRepository rr;

	@RequestMapping("/hotel/formHotel")
	public String form() {
		return "formHotel";
	}

	@PostMapping("/hotel")
	public String adicionar(Reserva reserva) {

		System.out.println(reserva);
		rr.save(reserva);
		return "reserva-adicionada";
	}

	@GetMapping("/hotel")
	public ModelAndView listar() {

		List<Reserva> reservas = rr.findAll();
		ModelAndView mv = new ModelAndView("listaReserva");
		mv.addObject("reservas", reservas);
		return mv;
	}

	@GetMapping("/hotel/{id}")
	public ModelAndView detalhar(@PathVariable Long id) {
		ModelAndView md = new ModelAndView();
		Optional<Reserva> opt = rr.findById(id);
		if (opt.isEmpty()) {
			md.setViewName("redirect:/listaReserva");
			return md;
		}
		
		md.setViewName("quarto/detalhesReserva");
		Reserva reserva = opt.get();
		md.addObject("reserva", reserva);

		return md;
	}
}
