package org.bitpipeline.lib.owm;

import org.bitpipeline.lib.owm.WeatherData.Main;
import org.json.JSONObject;

public class Forecast16WeatherData extends LocalizedWeatherData {

    public static final String JSON_F16_WIND = "speed";

    private Temperature temp;
    private float pressure;
    private float humidity;
    private float windSpeed;

    public Forecast16WeatherData(JSONObject json) {
        super(json);

        this.pressure = (float) json.optDouble(Main.JSON_PRESSURE);
        this.humidity = (float) json.optDouble(Main.JSON_HUMIDITY);
        this.windSpeed = (float) json
                .optDouble(Forecast16WeatherData.JSON_F16_WIND);

        JSONObject jsonTemp = json.optJSONObject("temp");
        if (jsonTemp != null) {
            this.temp = new Temperature(jsonTemp);
        }
    }

    public static class Temperature {

        public static final String JSON_F16_TEMP = "temp";
        public static final String JSON_F16_TEMP_DAY = "day";
        public static final String JSON_F16_TEMP_MIN = "min";
        public static final String JSON_F16_TEMP_MAX = "max";

        private final float day;
        private final float min;
        private final float max;

        public Temperature(JSONObject json) {
            this.day = (float) json.optDouble(Temperature.JSON_F16_TEMP_DAY);
            this.min = (float) json.optDouble(Temperature.JSON_F16_TEMP_MIN);
            this.max = (float) json.optDouble(Temperature.JSON_F16_TEMP_MAX);
        }

        public float getDay() {
            return day;
        }

        public float getMin() {
            return min;
        }

        public float getMax() {
            return max;
        }
    }

    public boolean hasTemp() {
        return this.temp != null;
    }

    public Temperature getTemperature() {
        return this.temp;
    }

    public float getTempDay() {
        return this.temp.getDay();
    }

    public float getTempMax() {
        return this.temp.getMax();
    }

    public float getTempMin() {
        return this.temp.getMin();
    }

}
