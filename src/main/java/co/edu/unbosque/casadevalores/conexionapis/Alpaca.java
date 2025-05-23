package co.edu.unbosque.casadevalores.conexionapis;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Alpaca {
	private static final String API_KEY = "PK2OTF007CEOXJSAOEO2";
	private static final String API_SECRET = "RRYTWf9JZtXe55B5RKSLuoJkQ1TC3joPUGfRZYMN";
	private static final String BASE_URL = "https://paper-api.alpaca.markets";

//	public void cnosultaMercados() {
	public static void main(String[] args) {

		String symbol = "AAPL";
		OkHttpClient client = new OkHttpClient();

		Request request = new Request.Builder().url("https://data.alpaca.markets/v2/stocks/" + symbol + "/trades/latest").addHeader("APCA-API-KEY-ID", API_KEY).addHeader("APCA-API-SECRET-KEY", API_SECRET).build();

		try (Response response = client.newCall(request).execute()) {
			if (response.isSuccessful() && response.body() != null) {
				String responseData = response.body().string();
				System.out.println("Respuesta de Alpaca: " + responseData);
			} else {
				System.out.println("Error: " + response.code() + " - " + response.message());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
//	}

	public void perfil() {
		try {
			URL url = new URL(BASE_URL + "/v2/account");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();

			conn.setRequestMethod("GET");
			conn.setRequestProperty("APCA-API-KEY-ID", API_KEY);
			conn.setRequestProperty("APCA-API-SECRET-KEY", API_SECRET);

			int responseCode = conn.getResponseCode();
			System.out.println("Response Code: " + responseCode);

			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String inputLine;
			StringBuilder response = new StringBuilder();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			System.out.println("Cuenta Alpaca Info:");
			System.out.println(response.toString() + "\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
