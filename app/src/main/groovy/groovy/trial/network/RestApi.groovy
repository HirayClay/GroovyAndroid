package groovy.trial.network

import groovy.trial.model.WeatherWrapper
import retrofit.http.GET
import retrofit.http.Query

interface RestApi {

    @GET("http://wthrcdn.etouch.cn/weather_mini")
    WeatherWrapper getWeatherInfo(@Query("city") String cityName)
}