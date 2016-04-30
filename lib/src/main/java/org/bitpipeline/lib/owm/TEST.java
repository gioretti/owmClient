package org.bitpipeline.lib.owm;

import java.io.IOException;
import java.util.List;

import org.json.JSONException;

public class TEST {
    
    public static void main(String[] args) throws JSONException, IOException {
        OwmClient client = new OwmClient(OwmClient.Units.METRIC);
        client.setAPPID("c4cb05905b0c1017d58221beda81460d");
        WeatherForecast16Response r = client.dailyForecastWeatherAtCity("Zurich");
        List<Forecast16WeatherData> data = r.getForecasts();
    }
    

}
