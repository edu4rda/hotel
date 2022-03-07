package ifrn.pi.hotel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ifrn.pi.hotel.models.Usuario;

public interface UserRepository extends JpaRepository<Usuario, Long> {

}
