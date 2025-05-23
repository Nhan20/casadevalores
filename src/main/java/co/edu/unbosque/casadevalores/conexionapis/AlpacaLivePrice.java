package co.edu.unbosque.casadevalores.conexionapis;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;

import com.google.gson.*;

public class AlpacaLivePrice extends WebSocketClient {

	private static final String API_KEY = "PK2OTF007CEOXJSAOEO2";
	private static final String API_SECRET = "RRYTWf9JZtXe55B5RKSLuoJkQ1TC3joPUGfRZYMN";
	private String SYMBOL = "AAPL";
	private final BiConsumer<String, Double> onPrecio;

	public AlpacaLivePrice(String symbol, BiConsumer<String, Double> onPrecio) throws URISyntaxException {
		super(new URI("wss://stream.data.alpaca.markets/v2/iex"));
		this.SYMBOL = symbol;
		this.onPrecio = onPrecio;
	}

	@Override
	public void onOpen(ServerHandshake handshake) {
		send("{\"action\":\"auth\",\"key\":\"" + API_KEY + "\",\"secret\":\"" + API_SECRET + "\"}");
	}

	@Override
	public void onMessage(String message) {
		JsonElement jsonElement = JsonParser.parseString(message);
		if (jsonElement.isJsonArray()) {
			for (JsonElement el : jsonElement.getAsJsonArray()) {
				JsonObject obj = el.getAsJsonObject();
				if ("t".equals(obj.get("T").getAsString())) {
					double price = obj.get("p").getAsDouble();
					String time = ZonedDateTime.parse(obj.get("t").getAsString())
							.withZoneSameInstant(ZoneId.of("America/Bogota")).toLocalTime()
							.format(DateTimeFormatter.ofPattern("HH:mm:ss.SSS"));
					onPrecio.accept(time, price);
				}
			}
		} else if (message.contains("\"T\":\"success\"")) {
			send("{\"action\":\"subscribe\",\"trades\":[\"" + SYMBOL + "\"]}");
		}
	}

	@Override
	public void onClose(int code, String reason, boolean remote) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onError(Exception ex) {
		// TODO Auto-generated method stub
		
	}

	// onClose y onError como antes...
}
