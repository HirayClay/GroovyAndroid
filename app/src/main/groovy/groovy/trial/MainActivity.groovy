package groovy.trial

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.util.Log
import com.amap.api.location.AMapLocation
import com.amap.api.location.AMapLocationClient
import com.amap.api.location.AMapLocationClientOption
import com.amap.api.location.AMapLocationListener
import groovy.transform.CompileStatic
import groovy.trial.adapter.WeatherItemAdapter
import groovy.trial.model.WeatherWrapper
import groovy.trial.network.RestApiHelper
import retrofit.Callback
import retrofit.Response
import retrofit.Retrofit

@CompileStatic
public class MainActivity extends AppCompatActivity {

    def static final TAG = "MainActivity"
    RecyclerView recyclerView
    Toolbar toolbar
    AMapLocationClient locationClient
    AMapLocationClientOption locationClientOption = new AMapLocationClientOption()
    WeatherItemAdapter weatherItemAdapter
    String cityName
    String cityCode
    AMapLocationListener listener = new AMapLocationListener() {
        @Override
        void onLocationChanged(AMapLocation location) {
            if (cityName) {
                Log.i(TAG.toString(), "You are now in $cityName  cityCode is:$cityCode")
                locationClient.unRegisterLocationListener(this)
                cityName = location.city
                cityCode = location.cityCode
                fetchWeatherInfo(cityName)
            }
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toolbar = (Toolbar) findViewById(R.id.toolbar)
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view)
        recyclerView.layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = (weatherItemAdapter = new WeatherItemAdapter())
        setSupportActionBar(toolbar)
        getSupportActionBar().setDisplayShowTitleEnabled(false)
        locationClient = new AMapLocationClient(this)
        locationClient.locationListener = listener
        locationClientOption.locationCacheEnable = true
        locationClientOption.locationMode = AMapLocationClientOption.AMapLocationMode.Hight_Accuracy
        locationClient.locationOption = locationClientOption
        locationClient.startLocation()
    }


    def static fetchWeatherInfo(String cityName) {
        RestApiHelper restApiHelper = RestApiHelper.get();
        restApiHelper.getWeatherInfo(cityName, new Callback<WeatherWrapper>() {
            @Override
            void onResponse(Response<WeatherWrapper> response, Retrofit retrofit) {
                Log.i("AAA", "You are now in $cityName  statusCode:" + response.body().status + "" +
                        "thread:${Thread.currentThread().name}")

            }

            @Override
            void onFailure(Throwable t) {

            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy()
        locationClient.onDestroy()
    }
}
