package ifrn.pi.hotel.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ifrn.pi.hotel.models.Quarto;
import ifrn.pi.hotel.repositories.QuartoRepository;

@Controller
public class QuartoController {

	@Autowired
	private QuartoRepository qr;

	@RequestMapping("/hotel/formQuarto")
	public String form() {
		return "formQuarto";
	}

	@PostMapping("/hotel/room")
	public String reservar(Quarto quarto) {
		System.out.println(quarto);
		qr.save(quarto);
		return "quarto-reservado";
	}

}
