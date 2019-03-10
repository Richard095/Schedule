package com.example.schedule;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class DetailAdapter extends RecyclerView.Adapter<DetailAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Subject> subjectList;

    public DetailAdapter (Context context, ArrayList<Subject> subjectList){
        this.context = context;
        this.subjectList = subjectList;
    }

    @Override
    public DetailAdapter.ViewHolder onCreateViewHolder( ViewGroup parent, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.detail_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder( DetailAdapter.ViewHolder viewHolder, int position) {
        final Subject subject = subjectList.get(position);



        int CheckDay = subjectList.get(position).getDay();
        switch (CheckDay) {
            case 1:
                viewHolder.tvday.setText("Lunes");
                break;
            case 2:
                viewHolder.tvday.setText("Martes");
                break;
            case 3:
                viewHolder.tvday.setText("Miercoles");
                break;
            case 4:
                viewHolder.tvday.setText("Jueves");
                break;
            case 5:
                viewHolder.tvday.setText("Viernes");
                break;

            default:
                break;
        }

        //viewHolder.tvday.setText(Integer.toString(subject.getDay()));
        viewHolder.hour_start.setText(Integer.toString(subject.getHour_start_class())+":00");
        viewHolder.hour_end.setText(Integer.toString(subject.getHour_end_class())+":00");
        viewHolder.classroom.setText(subject.getClassroom());


    }

    @Override
    public int getItemCount() {
        return subjectList.size();
    }

    class ViewHolder extends  RecyclerView.ViewHolder{

        public TextView tvday;
        public TextView hour_start;
        public TextView hour_end;
        public TextView classroom;

        public ViewHolder( View itemView) {
            super(itemView);
            tvday = itemView.findViewById(R.id.tvday);
            hour_start = itemView.findViewById(R.id.hour_start);
            hour_end = itemView.findViewById(R.id.hour_end);
            classroom = itemView.findViewById(R.id.classroom);


        }
    }
}
