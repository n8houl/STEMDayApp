package edu.acmatucf.stemdayapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.ViewHolder> {

    private String[] data;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView myTextView;

        public ViewHolder(View v) {
            super(v);
            myTextView = (TextView) v.findViewById(R.id.scheduleTextView);

        }
    }


    public void SetData(String[] myData){
        data = new String[myData.length];

        System.arraycopy(myData, 0, data, 0, myData.length);

        notifyDataSetChanged();

    }

    @Override
    public ScheduleAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.schedule_item, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position){
        holder.myTextView.setText(data[position]);
    }

    @Override
    public int getItemCount(){
        return data.length;
    }


}
