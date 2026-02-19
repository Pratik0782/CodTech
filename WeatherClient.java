import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

public class WeatherClient {

    public static void main(String[] args) {
        try {
            String apiUrl = "https://api.open-meteo.com/v1/forecast?latitude=18.5204&longitude=73.8567&current_weather=true";

            URL url = new URL(apiUrl);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            int responseCode = con.getResponseCode();
            System.out.println("HTTP Response Code: " + responseCode);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream())
            );

            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            JSONObject json = new JSONObject(response.toString());
            JSONObject currentWeather = json.getJSONObject("current_weather");

            double temperature = currentWeather.getDouble("temperature");
            double windspeed = currentWeather.getDouble("windspeed");
            String time = currentWeather.getString("time");

            System.out.println("\n------ Weather Report ------");
            System.out.println("Temperature: " + temperature + " °C");
            System.out.println("Wind Speed: " + windspeed + " km/h");
            System.out.println("Time: " + time);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
