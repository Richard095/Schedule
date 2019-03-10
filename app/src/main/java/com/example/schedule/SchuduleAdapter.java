package com.example.schedule;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;



public class SchuduleAdapter extends RecyclerView.Adapter<SchuduleAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Subject>subjectList;
    private OnSubjectClickListener onSubjectClickListener;

    public interface OnSubjectClickListener{
        void onSubjectClick(Subject subject);
    }

    public void setOnSubjectClickListener(OnSubjectClickListener onSubjectClickListener) {
        this.onSubjectClickListener = onSubjectClickListener;
    }

    public SchuduleAdapter (Context context, ArrayList<Subject> subjectList){
        this.context = context;
        this.subjectList = subjectList;
    }

    @Override
    public SchuduleAdapter.ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.subject_list_layout,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder( SchuduleAdapter.ViewHolder viewHolder, int position) {

        final Subject subject = subjectList.get(position);

        viewHolder.tv_subject_name.setText(subject.getSubject_name());
        viewHolder.tv_teacher.setText(subject.getTeacher());
        viewHolder.tv_classroom.setText(subject.getClassroom());
        viewHolder.tv_start_class.setText(Integer.toString(subject.getHour_start_class())+":00");
        viewHolder.tv_end_class.setText(Integer.toString(subject.getHour_end_class())+":00");
        viewHolder.tv_indicator.setText(subject.getIndicator());
        viewHolder.iv_On_Classe.setImageResource(subject.getImage_on_off());

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSubjectClickListener.onSubjectClick(subject);
            }
        });


    }

    @Override
    public int getItemCount() {
        return subjectList.size();
    }

     class ViewHolder extends  RecyclerView.ViewHolder{

        public TextView tv_subject_name;
        public TextView tv_teacher;
        public TextView tv_classroom;
        public TextView tv_start_class;
        public TextView tv_end_class;
        public TextView tv_indicator;
        public ImageView iv_On_Classe;

        public ViewHolder( View itemView) {
            super(itemView);
            tv_subject_name = itemView.findViewById(R.id.tv_subject_name);
            tv_teacher = itemView.findViewById(R.id.tv_teacher);
            tv_classroom = itemView.findViewById(R.id.tv_classroom);
            tv_start_class = itemView.findViewById(R.id.tv_start_class);
            tv_end_class = itemView.findViewById(R.id.tv_end_class);
            tv_indicator = itemView.findViewById(R.id.tv_indicator);
            iv_On_Classe =itemView.findViewById(R.id.iv_On_Classe);
        }
    }
}
