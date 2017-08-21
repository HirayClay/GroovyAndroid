package groovy.trial.model

import com.google.gson.annotations.SerializedName

class WeatherInfo {
    @SerializedName("date")
    String date
    @SerializedName("high")
    String tempDesc
    @SerializedName("fengli")
    String windStrength
    @SerializedName("fengxiang")
    String windFlow
    @SerializedName("type")
    String weatherType
}