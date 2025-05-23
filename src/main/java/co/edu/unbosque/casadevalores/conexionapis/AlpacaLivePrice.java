package co.edu.unbosque.casadevalores.conexionapis;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import com.google.gson.*;

public class AlpacaLivePrice {

	private static final String API_KEY = "PK2OTF007CEOXJSAOEO2";
	private static final String API_SECRET = "RRYTWf9JZtXe55B5RKSLuoJkQ1TC3joPUGfRZYMN";
	private static final String SYMBOL = "AAPL";

	public static void iniciarConexion() throws Exception {
		URI uri = new URI("wss://stream.data.alpaca.markets/v2/iex");

		WebSocketClient client = new WebSocketClient(uri) {
			@Override
			public void onOpen(ServerHandshake handshake) {
				System.out.println("Conectado");
				// Autenticarse
				send("{\"action\":\"auth\",\"key\":\"" + API_KEY + "\",\"secret\":\"" + API_SECRET + "\"}");
			}

			@Override
			public void onMessage(String message) {
				JsonElement jsonElement = JsonParser.parseString(message);
				if (jsonElement.isJsonArray()) {
					JsonArray arr = jsonElement.getAsJsonArray();
					for (JsonElement el : arr) {
						JsonObject obj = el.getAsJsonObject();
						if (obj.has("T") && obj.get("T").getAsString().equals("t")) {
							double price = obj.get("p").getAsDouble();
							String utcTime = obj.get("t").getAsString();

							// Convertir a hora local (Colombia) y extraer solo hora:minuto:segundo
							ZonedDateTime localTime = ZonedDateTime.parse(utcTime)
									.withZoneSameInstant(ZoneId.of("America/Bogota"));
							String hora = localTime.toLocalTime().format(DateTimeFormatter.ofPattern("HH:mm:ss.SSS"));

							System.out.println("Hora: " + hora + " | Precio: $" + price);
						}
					}
				} else {
					System.out.println("Mensaje recibido: " + message);
				}

				// Autenticación (si es necesario)
				if (message.contains("\"T\":\"success\"")) {
					send("{\"action\":\"subscribe\",\"trades\":[\"" + SYMBOL + "\"]}");
				}
			}

			@Override
			public void onClose(int code, String reason, boolean remote) {
				System.out.println("Desconectado: " + reason);
			}

			@Override
			public void onError(Exception ex) {
				ex.printStackTrace();
			}
		};

		client.connect();

		// Espera para mantener el cliente activo (simulación simple)
		TimeUnit.MINUTES.sleep(5);
	}
}
