package co.edu.unbosque.casadevalores.gestionordenes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/orders")
@CrossOrigin(origins = "http://localhost:3000")
public class OrdenController {

    private final OrdenService ordenService;

    @Autowired
    public OrdenController(OrdenService ordenService) {
        this.ordenService = ordenService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> crearOrden(@RequestBody Orden orden) {
    	System.out.println("todo en orden");    	
        ordenService.crearOrden(orden);
    	return new ResponseEntity<String>("Listo", HttpStatus.OK);
    }
    
    
    @DeleteMapping("/{id}")
    public String eliminarOrden(@PathVariable Long id) {
        boolean eliminada = ordenService.eliminarOrden(id);
        if (eliminada) {
            return "Orden eliminada correctamente.";
        } else {
            return "Orden no encontrada.";
        }
    }
}
