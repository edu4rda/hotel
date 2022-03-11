package ifrn.pi.hotel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ifrn.pi.hotel.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	Usuario findByEmail(String email);

}
