package groovy.trial.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import groovy.trial.R
import groovy.trial.model.WeatherInfo

class WeatherItemAdapter extends RecyclerView.Adapter<ItemViewHolder> {

    def List<WeatherInfo> datas = new ArrayList<>()
    LayoutInflater layoutInflater

    void setDatas(List<WeatherInfo> datas) {
        this.datas.clear()
        this.datas.addAll(datas)
        notifyDataSetChanged()
    }

    @Override
    ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (layoutInflater == null)
            layoutInflater = LayoutInflater.from(parent.context)
        return new ItemViewHolder(layoutInflater.inflate(R.layout.item_weather,parent,false))
    }

    @Override
    void onBindViewHolder(ItemViewHolder holder, int position) {
        holder.icon.setImageResource(getWeatherIcon(datas.get(position).weatherType))
        holder.desc.setText(datas.get(position).tempDesc)
    }

    @Override
    int getItemCount() {
        return datas.size()
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {

        ImageView icon
        TextView desc

        ItemViewHolder(View itemView) {
            super(itemView)
            icon = itemView.findViewById(R.id.icon)
            desc = itemView.findViewById(R.id.desc)
        }
    }

    static def int getWeatherIcon(String weatherType) {
        if (weatherType.contains("多云"))
            return R.drawable.cloud
        if (weatherType.contains("雷阵雨"))
            return R.drawable.lightening
        if (weatherType == "晴")
            return R.drawable.sunny
        if (weatherType == "阴")
            return R.drawable.overcast

    }

}
