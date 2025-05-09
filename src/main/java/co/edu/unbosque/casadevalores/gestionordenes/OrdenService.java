package co.edu.unbosque.casadevalores.gestionordenes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrdenService {

    private final OrdenRepository ordenRepository;

    @Autowired
    public OrdenService(OrdenRepository ordenRepository) {
        this.ordenRepository = ordenRepository;
    }

    // Crear una nueva orden
    public Orden crearOrden(Orden orden) {
        return ordenRepository.save(orden);
    }

    // Eliminar una orden por ID
    public boolean eliminarOrden(Long id) {
        Optional<Orden> ordenOptional = ordenRepository.findById(id);
        if (ordenOptional.isPresent()) {
            ordenRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
