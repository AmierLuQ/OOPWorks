public class Main{
    public static void main (String args[]){
        
        WeatherList wl = new WeatherList();

		System.out.println("Create WeatherList object : " + wl);
        
        wl.readWeather();
        wl.calcWeather();
        wl.display();
		
    }
}