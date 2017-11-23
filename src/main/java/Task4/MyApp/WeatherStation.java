package Task4.MyApp;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherStation {
	/*public static String urlAdress = "http://api.openweathermap.org/data/2.5/weather?q=Kiev&appid=" +
            "76f37caefb4a0de9cade877a11f5138e&mode=xml&units=metric";
	public static byte[] content = new byte[256];
	public static void main(String[] args) {
		URL adress = null;
        HttpURLConnection connection = null;
        InputStream inputStream = null;

        try {
            adress = new URL(urlAdress);
            connection = (HttpURLConnection) adress.openConnection();
            connection.connect();
            inputStream = connection.getInputStream();
            while(inputStream.available() != -1){
                inputStream.read(content);
                for(byte b : content){
                    System.out.print(b+" ");
                }
                System.out.println("/n");
            }
            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
*/
		//Weather weather = weatherParser(inputStream);



		/*WeatherData weatherData = new WeatherData();
	
		CurrentConditionsDisplay currentDisplay =
			new CurrentConditionsDisplay(weatherData);
		StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
		ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);

		weatherData.setMeasurements(80, 65, 30.4f);
		weatherData.setMeasurements(82, 70, 29.2f);
		weatherData.setMeasurements(78, 90, 29.2f);
	}*/
}
