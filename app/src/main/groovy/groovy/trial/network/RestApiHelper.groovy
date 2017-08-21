package groovy.trial.network

import com.squareup.okhttp.OkHttpClient
import groovy.transform.CompileStatic
import groovy.trial.BuildConfig
import groovy.trial.model.WeatherWrapper
import retrofit.Call
import retrofit.Callback
import retrofit.GsonConverterFactory
import retrofit.Retrofit

@CompileStatic
class RestApiHelper {


    def static RestApiHelper intance = new RestApiHelper()
    def static RestApi restApi

    static def RestApiHelper get(){
        intance
    }

    private RestApiHelper() {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BuildConfig.BASE_URL)
                .client(new OkHttpClient())
                .build()
        restApi = retrofit.create(RestApi.class)
    }

    public static void getWeatherInfo(String cityName, Callback<WeatherWrapper> callback) {
        Call<WeatherWrapper> call = restApi.getWeatherInfo(cityName)
        call.enqueue(callback)
    }
}