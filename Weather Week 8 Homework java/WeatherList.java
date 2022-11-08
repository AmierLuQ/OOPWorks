public class WeatherList {
    
    //data
    int NUMDATA = 60;
    float TempRange[]={20,45};
	float WindRange[]={0,50};
	float HumidityRange[]={0,50};
	float PrecipitationRange[]={0,100};
	
	float minTemp, minWind, minHumidity, minPrecipitation;
	float maxTemp, maxWind, maxHumidity, maxPrecipitation;
	float avgTemp, avgWind, avgHumidity, avgPrecipitation;
	float stdDevTemp, stdDevWind, stdDevHumidity, stdDevPrecipitation;
	
	Weather[] readings = new Weather[NUMDATA];
    
    //operations
    
    public void readWeather() {
        
        for (int i=0; i<readings.length; i++) {

            readings[i] = new Weather();  

            readings[i].generate(TempRange, WindRange, HumidityRange, PrecipitationRange);
            

        }
    }
    
    public void calcWeather() {
        
        minTemp = minTemp();
        minWind = minWind();
        minHumidity = minHumidity();
        minPrecipitation = minPrecipitation();
        
        maxTemp = maxTemp();
        maxWind = maxWind();
        maxHumidity = maxHumidity();
        maxPrecipitation = maxPrecipitation();
        
        avgTemp = avgTemp();
        avgWind = avgWind();
        avgHumidity = avgHumidity();
        avgPrecipitation = avgPrecipitation();
        
        stdDevTemp = stdDevTemp(avgTemp);
        stdDevWind = stdDevWind(avgWind);
        stdDevHumidity = stdDevHumidity(avgHumidity);
        stdDevPrecipitation = stdDevPrecipitation(avgPrecipitation);
        
    }
    
    public void display() {
        
        for (int i=0; i<readings.length; i++) {
            
            System.out.println("\nWeather generated at index #" + (i+1) + ":");
            
            readings[i].display();
    		
        }
        
        System.out.println("\nOverall Calculated Data: ");
        
        System.out.println("\nMinimum Temperature: " + minTemp + "\nMinimum Wind: " + minWind
        + "\nMinimum Humidity: " + minHumidity + "\nMinimum Precipitation: " + minPrecipitation);
        System.out.println("\nMaximum Temperature: " + maxTemp + "\nMaximum Wind: " + maxWind
        + "\nMaximum Humidity: " + maxHumidity + "\nMaximum Precipitation: " + maxPrecipitation);
        System.out.println("\nAverage Temperature: " + avgTemp + "\nAverage Wind: " + avgWind
        + "\nAverage Humidity: " + avgHumidity + "\nAverage Precipitation: " + avgPrecipitation);
        System.out.println("\nStandard Deviation Temperature: " + stdDevTemp + "\nStandard Deviation Wind: " + stdDevWind
        + "\nStandard Deviation Humidity: " + stdDevHumidity + "\nStandard Deviation Precipitation: " + stdDevPrecipitation);
    }
    
    public float minTemp() {
        float min = readings[0].temperature;
        for (int i=1; i<NUMDATA; i++) {
            if (min > readings[i].temperature) {
                min = readings[i].temperature;
            }
        }
        
        return min;
    }
    
    public float minWind() {
        float min = readings[0].wind;
        for (int i=1; i<NUMDATA; i++) {
            if (min > readings[i].wind) {
                min = readings[i].wind;
            }
        }
        
        return min;
    }
    
    public float minHumidity() {
        float min = readings[0].humidity;
        for (int i=1; i<NUMDATA; i++) {
            if (min > readings[i].humidity) {
                min = readings[i].humidity;
            }
        }
        
        return min;
    }
    
    public float minPrecipitation() {
        float min = readings[0].precipitation;
        for (int i=1; i<NUMDATA; i++) {
            if (min > readings[i].precipitation) {
                min = readings[i].precipitation;
            }
        }
        
        return min;
    }
    
    public float maxTemp() {
        float max = readings[0].temperature;
        for (int i=1; i<NUMDATA; i++) {
            if (max < readings[i].temperature) {
                max = readings[i].temperature;
            }
        }
        
        return max;
    }
    
    public float maxWind() {
        float max = readings[0].wind;
        for (int i=1; i<NUMDATA; i++) {
            if (max < readings[i].wind) {
                max = readings[i].wind;
            }
        }
        
        return max;
    }
    
    public float maxHumidity() {
        float max = readings[0].humidity;
        for (int i=1; i<NUMDATA; i++) {
            if (max < readings[i].humidity) {
                max = readings[i].humidity;
            }
        }
        
        return max;
    }
    
    public float maxPrecipitation() {
        float max = readings[0].precipitation;
        for (int i=1; i<NUMDATA; i++) {
            if (max < readings[i].precipitation) {
                max = readings[i].precipitation;
            }
        }
        
        return max;
    }
    
    public float avgTemp() {
        float sum = 0;
        for (int i=0; i<NUMDATA; i++) sum += readings[i].temperature;
        float avg = sum / NUMDATA;
        return avg;
    }
    
    public float avgWind() {
        float sum = 0;
        for (int i=0; i<NUMDATA; i++) sum += readings[i].wind;
        float avg = sum / NUMDATA;
        return avg;
    }
    
    public float avgHumidity() {
        float sum = 0;
        for (int i=0; i<NUMDATA; i++) sum += readings[i].humidity;
        float avg = sum / NUMDATA;
        return avg;
    }
    
    public float avgPrecipitation() {
        float sum = 0;
        for (int i=0; i<NUMDATA; i++) sum += readings[i].precipitation;
        float avg = sum / NUMDATA;
        return avg;
    }
    
    public float stdDevTemp(float avg) {
        float numerator=0;
        for (int i = 0;i<NUMDATA;i++){
            numerator += Math.pow((readings[i].temperature - avg),2);
        }
        float std = (float) Math.sqrt(numerator/NUMDATA);
    
        return std;
    }
    
        
    public float stdDevWind(float avg) {
        float numerator=0;
        for (int i = 0;i<NUMDATA;i++){
            numerator += Math.pow((readings[i].wind - avg),2);
        }
        float std = (float) Math.sqrt(numerator/NUMDATA);
    
        return std;
    }
    
    public float stdDevHumidity(float avg) {
        float numerator=0;
        for (int i = 0;i<NUMDATA;i++){
            numerator += Math.pow((readings[i].humidity - avg),2);
        }
        float std = (float) Math.sqrt(numerator/NUMDATA);
    
        return std;
    }

    
    public float stdDevPrecipitation(float avg) {
        float numerator=0;
        for (int i = 0;i<NUMDATA;i++){
            numerator += Math.pow((readings[i].precipitation - avg),2);
        }
        float std = (float) Math.sqrt(numerator/NUMDATA);
    
        return std;
    }
    
}