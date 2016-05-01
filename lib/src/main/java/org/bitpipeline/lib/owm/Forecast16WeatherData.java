package org.bitpipeline.lib.owm;

import org.json.JSONObject;

public class Forecast16WeatherData {

    public static final String JSON_WIND = "speed";
    public static final String JSON_DATETIME = "dt";
    public static final String JSON_PRESSURE = "pressure";
    public static final String JSON_HUMIDITY = "humidity";

    private Temperature temp;
    private float pressure;
    private float humidity;
    private float windSpeed;
    private long dateTime;

    public Forecast16WeatherData(JSONObject json) {
        this.pressure = (float) json.optDouble(JSON_PRESSURE);
        this.humidity = (float) json.optDouble(JSON_HUMIDITY);
        this.windSpeed = (float) json.optDouble(JSON_WIND);
        this.dateTime = (long) json.optDouble(JSON_DATETIME);
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
        public static final String JSON_F16_TEMP_EVE = "night";
        public static final String JSON_F16_TEMP_NIGHT = "eve";
        public static final String JSON_F16_TEMP_MORNING = "morn";

        private final float day;
        private final float min;
        private final float max;
        private final float night;
        private final float eve;
        private final float morn;

        public Temperature(JSONObject json) {
            this.day = (float) json.optDouble(Temperature.JSON_F16_TEMP_DAY);
            this.min = (float) json.optDouble(Temperature.JSON_F16_TEMP_MIN);
            this.max = (float) json.optDouble(Temperature.JSON_F16_TEMP_MAX);
            this.night = (float) json
                    .optDouble(Temperature.JSON_F16_TEMP_NIGHT);
            this.eve = (float) json.optDouble(Temperature.JSON_F16_TEMP_EVE);
            this.morn = (float) json
                    .optDouble(Temperature.JSON_F16_TEMP_MORNING);
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

        public float getNight() {
            return night;
        }

        public float getEve() {
            return eve;
        }

        public float getMorn() {
            return morn;
        }
    }

    public boolean hasTemp() {
        return this.temp != null;
    }

    public Temperature getTemperature() {
        return this.temp;
    }

    public float getPressure() {
        return pressure;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getWindSpeed() {
        return windSpeed;
    }
    
    public long getDateTime(){
        return dateTime;
    }
}
