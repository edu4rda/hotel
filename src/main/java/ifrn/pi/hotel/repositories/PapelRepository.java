package ifrn.pi.hotel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ifrn.pi.hotel.models.Papel;

public interface PapelRepository extends JpaRepository<Papel, Long> {
	
	Papel findByNome(String nome);

}
