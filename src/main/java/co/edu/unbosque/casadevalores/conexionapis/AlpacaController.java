package co.edu.unbosque.casadevalores.conexionapis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000") // Ajusta según tu frontend
public class AlpacaController {

	@Autowired
	private AlpacaService alpacaService;
	
	
	@GetMapping(value = "/api/live-price/{symbol}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public SseEmitter streamPrecio(@PathVariable String symbol) {
		return null;
	}

	@GetMapping("/precio/{symbol}")
	public PrecioResponse getPrecio(@PathVariable String symbol) {
		double precio = alpacaService.obtenerPrecioActual(symbol);
		return new PrecioResponse(precio);
	}

	public static class PrecioResponse {
		private double currentPrice;

		public PrecioResponse(double currentPrice) {
			this.currentPrice = currentPrice;
		}

		public double getCurrentPrice() {
			return currentPrice;
		}

		public void setCurrentPrice(double currentPrice) {
			this.currentPrice = currentPrice;
		}
	}
}
