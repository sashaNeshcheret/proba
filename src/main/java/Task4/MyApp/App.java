package Task4.MyApp;

import main.java.com.sasha.Tasks.Task4.net.webservicex.*;

/**
 * Created by Нещерет on 19.11.2017.
 */
public class App {
    public static void main(String[] args) {
        GetWeather weather = new GetWeather();
        System.out.println(weather.getCountryName());
        System.out.println(weather.getCityName());

        weather.setCountryName("London");
        weather.setCityName("Great Britain");

        String city = weather.getCityName();
        String country = weather.getCountryName();

        System.out.println(city);
        System.out.println(country);


        GlobalWeather globalWeather = new GlobalWeather();
        GlobalWeatherSoap globalWeatherSoap = globalWeather.getGlobalWeatherSoap();

        System.out.println(globalWeatherSoap.getWeather(city, country));

    }
}