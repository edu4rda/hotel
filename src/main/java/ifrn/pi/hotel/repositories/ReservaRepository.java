package ifrn.pi.hotel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ifrn.pi.hotel.models.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {

}
