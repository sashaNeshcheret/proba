package Task4.MyApp;

/**
 * Created by Нещерет on 21.11.2017.
 */
public class WeatherSimulationThread implements Runnable{

    @Override
    public void run() {
        WeatherData weatherData = new WeatherData();
        float temperature = 25;
        float humidity = 70;
        float pressure = 756;
        //double r = ;
        while(true){
            temperature+= (Math.random()*2+20);
            humidity+= (Math.random()*10-20);
            pressure+= (Math.random()*20-40);

            try{
                Thread.sleep(5000);
            }catch (Exception e){
                System.out.println(e);
            }
        }
    }
}
