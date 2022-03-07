package ifrn.pi.hotel.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
