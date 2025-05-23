package co.edu.unbosque.casadevalores.conexionapis;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Service
public class AlpacaService {

    private static final String API_KEY = "PK2OTF007CEOXJSAOEO2";
    private static final String API_SECRET = "RRYTWf9JZtXe55B5RKSLuoJkQ1TC3joPUGfRZYMN";

    public double obtenerPrecioActual(String symbol) {
        String url = "https://data.alpaca.markets/v2/stocks/" + symbol + "/quotes/latest";

        HttpHeaders headers = new HttpHeaders();
        headers.set("APCA-API-KEY-ID", API_KEY);
        headers.set("APCA-API-SECRET-KEY", API_SECRET);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            JsonObject json = JsonParser.parseString(response.getBody()).getAsJsonObject();
            double precio = json.getAsJsonObject("quote").get("ap").getAsDouble(); // "ap" = ask price
            return precio;
        } else {
            throw new RuntimeException("No se pudo obtener el precio desde Alpaca");
        }
    }
    
    
    
    
}
