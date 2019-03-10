package com.example.schedule;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class DetailSubject extends AppCompatActivity {

    TextView tv_name_Subject;
    RecyclerView detail_subject_list;

    String subjectName;
    int key_subject;

    ArrayList<Subject> datail_lista = new ArrayList<>();
    ArrayList<Subject> ListSubject  = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_subject);

        detail_subject_list = findViewById(R.id.detail_subject_list);
        tv_name_Subject = findViewById(R.id.tv_name_Subject);

        //**Getting objects from MainActivity
        Bundle extras = getIntent().getExtras();

        Subject subject = extras.getParcelable(ScheduleFragment.KEY_DATA);
        if (subject != null){
            key_subject=subject.getKeySubject();
            subjectName = subject.getSubject_name();
        }
        tv_name_Subject.setText(subjectName);

       showView();

    }

    public void showView(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        detail_subject_list.setLayoutManager(linearLayoutManager);
        datail_lista = (ArrayList<Subject>) getIntent().getSerializableExtra("miLista");

        for (int i = 0; i < datail_lista.size(); i++) {
            System.out.println("LA CLAVE ESS : ------------->"+key_subject);

            if (key_subject == datail_lista.get(i).getKeySubject()){
                ListSubject.add(datail_lista.get(i));

                DetailAdapter detail = new DetailAdapter(this,ListSubject);
                detail_subject_list.setAdapter(detail);
            }
        }




    }

}
