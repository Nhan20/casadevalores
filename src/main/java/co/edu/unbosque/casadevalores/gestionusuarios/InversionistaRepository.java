package co.edu.unbosque.casadevalores.gestionusuarios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InversionistaRepository extends JpaRepository<Inversionista, String> {
}
