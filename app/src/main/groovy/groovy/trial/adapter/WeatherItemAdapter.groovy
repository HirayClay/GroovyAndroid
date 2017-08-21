package groovy.trial.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import groovy.trial.model.WeatherInfo

class WeatherItemAdapter extends RecyclerView.Adapter<ItemViewHolder> {

    def List<WeatherInfo> datas = new ArrayList<>()

    void setDatas(List<WeatherInfo> datas) {
        this.datas.clear()
        this.datas.addAll(datas)
        notifyDataSetChanged()
    }

    @Override
    ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null
    }

    @Override
    void onBindViewHolder(ItemViewHolder holder, int position) {

    }

    @Override
    int getItemCount() {
        return datas.size()
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {

        ItemViewHolder(View itemView) {
            super(itemView)
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ViewHolder(View itemView) {
            super(itemView)
        }
    }
}
