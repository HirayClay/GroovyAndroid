package groovy.trial.network

import groovy.trial.model.WeatherWrapper
import retrofit.Call
import retrofit.http.GET
import retrofit.http.Query

interface RestApi {

    @GET("/weather_mini")
    Call<WeatherWrapper> getWeatherInfo(@Query("city") String cityName)
}