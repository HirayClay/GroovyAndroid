package groovy.trial.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup

class WeatherItemAdapter extends RecyclerView.Adapter<ItemViewHolder>{

    def datas

    @Override
    ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null
    }

    @Override
    void onBindViewHolder(ItemViewHolder holder, int position) {

    }

    @Override
    int getItemCount() {
        return 0
    }

    class ItemViewHolder extends RecyclerView.ViewHolder{

        ItemViewHolder(View itemView) {
            super(itemView)
        }
    }
}
