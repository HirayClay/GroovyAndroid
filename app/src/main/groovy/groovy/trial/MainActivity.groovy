package groovy.trial

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.util.Log
import com.amap.api.location.AMapLocation
import com.amap.api.location.AMapLocationClient
import com.amap.api.location.AMapLocationClientOption
import com.amap.api.location.AMapLocationListener
import groovy.transform.CompileStatic

@CompileStatic
public class MainActivity extends AppCompatActivity {

    def static final TAG = "MainActivity"
    RecyclerView recyclerView
    Toolbar toolbar
    AMapLocationClient locationClient
    AMapLocationClientOption locationClientOption = new AMapLocationClientOption()
    String cityName
    String cityCode
    AMapLocationListener listener = new AMapLocationListener() {
        @Override
        void onLocationChanged(AMapLocation location) {
            if (cityName) {
                Log.i("AAA", "cityNam : $cityName");
                locationClient.unRegisterLocationListener(this)
                fetchWeatherInfo(cityName)
            }
            cityName = location.city
            cityCode = location.cityCode
            Log.i("AAA", "You are now in $cityName  $cityCode")
//            Toast.makeText(MainActivity.this.getApplicationContext(),"You are now in $cityName")
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toolbar = (Toolbar) findViewById(R.id.toolbar)
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view)

        setSupportActionBar(toolbar)
        getSupportActionBar().setDisplayShowTitleEnabled(false)
        locationClient = new AMapLocationClient(this)
        locationClient.locationListener = listener
        locationClientOption.locationCacheEnable = true
        locationClientOption.locationMode = AMapLocationClientOption.AMapLocationMode.Hight_Accuracy
        locationClient.locationOption = locationClientOption
        locationClient.startLocation()
    }


    def fetchWeatherInfo(cityName) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy()
        locationClient.onDestroy()
    }
}
