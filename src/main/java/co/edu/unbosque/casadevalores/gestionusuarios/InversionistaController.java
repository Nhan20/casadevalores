package co.edu.unbosque.casadevalores.gestionusuarios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/inversionista")
@CrossOrigin(origins = "http://localhost:3000")
public class InversionistaController {

    @Autowired
    private InversionistaService invServ;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Inversionista loginRequest) {
    	System.out.println(loginRequest.getPassword());
        Optional<Inversionista> inversionistaOpt = invServ.getInversionistaByNickname(loginRequest.getNickname());

        if (inversionistaOpt.isPresent()) {
            Inversionista inversionista = inversionistaOpt.get();
            if (inversionista.getPassword().equals(loginRequest.getPassword())) {
                return ResponseEntity.ok("Inicio de sesión exitoso");
            } else {
                return ResponseEntity.status(401).body("Contraseña incorrecta");
            }
        } else {
            return ResponseEntity.status(404).body("Usuario no encontrado");
        }
    }
    
    @GetMapping("/perfil")
    public ResponseEntity<Inversionista> getPerfil(@RequestParam String nickname) {
    	Optional<Inversionista> inversionista = invServ.getInversionistaByNickname(nickname);
        if (inversionista == null) {
            return ResponseEntity.notFound().build();
        }
        Inversionista dto = new Inversionista();
        dto.setName(inversionista.get().getName());
        dto.setCorreo(inversionista.get().getCorreo());
        dto.setNickname(inversionista.get().getNickname());
        return ResponseEntity.ok(dto);
    }
    

    // Crear un nuevo inversionista
    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody Inversionista inversionista) {
    	System.out.println("Todo en orden");
    	System.out.println(inversionista.getPassword());
    	invServ.saveInversionista(inversionista);
        return new ResponseEntity<String>("Listo", HttpStatus.OK);
    }

    // Actualizar un inversionista
    @PutMapping("/update/{nickname}")
    public ResponseEntity<Inversionista> update(@PathVariable String nickname, @RequestBody Inversionista updatedInversionista) {
        if (!invServ.existsByNickname(nickname)) {
            return ResponseEntity.notFound().build();
        }
        updatedInversionista.setNickname(nickname);
        Inversionista saved = invServ.saveInversionista(updatedInversionista);
        return ResponseEntity.ok(saved);
    }

    // Eliminar un inversionista
    @DeleteMapping("/delete/{nickname}")
    public ResponseEntity<Void> delete(@PathVariable String nickname) {
        if (!invServ.existsByNickname(nickname)) {
            return ResponseEntity.notFound().build();
        }
        invServ.deleteInversionista(nickname);
        return ResponseEntity.noContent().build();
    }
}
