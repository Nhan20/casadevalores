package co.edu.unbosque.casadevalores.gestionusuarios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InversionistaService {

    @Autowired
    private InversionistaRepository inversionistaRepository;

    public List<Inversionista> getAllInversionistas() {
        return inversionistaRepository.findAll();
    }

    public Optional<Inversionista> getInversionistaByNickname(String nickname) {
        return inversionistaRepository.findById(nickname);
    }

    public Inversionista saveInversionista(Inversionista inversionista) {
        return inversionistaRepository.save(inversionista);
    }

    public void deleteInversionista(String nickname) {
        inversionistaRepository.deleteById(nickname);
    }

    public boolean existsByNickname(String nickname) {
        return inversionistaRepository.existsById(nickname);
    }
}

