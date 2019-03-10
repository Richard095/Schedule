package com.example.schedule;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class MainActivity extends AppCompatActivity {
    public static final String KEY_DATA = "keyData";

    RecyclerView subject_list_view;
    TextView tv_day;
    String today;
    String day;


    ArrayList<Subject> subjectList = new ArrayList<>();
    ArrayList<Subject>temp_subjectList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        subject_list_view = findViewById(R.id.subject_list_view);
        tv_day = findViewById(R.id.tv_day);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        subject_list_view.setLayoutManager(linearLayoutManager);

        //Lunes
        subjectList.add(new Subject(1,"Desarrollo de App.Moviles","Ing.Hugo Rene Larraga",
                "LC2",8,10,"AM",R.drawable.ic_timer_black_24dp,101));

        subjectList.add(new Subject(1,"Computo Forense","Ing.Juan Mata",
                "LC5",10,12,"PM",R.drawable.ic_timer_black_24dp,102));
        //Martes
        subjectList.add(new Subject(2,"Programacion web","Ing.Jaime",
                "LC2",10,12,"PM",R.drawable.ic_timer_black_24dp,103));

        subjectList.add(new Subject(2,"Computo forense","Ing. Juan Mata",
                "LRED",12,14,"PM",R.drawable.ic_timer_black_24dp,102));

        //MIERCOLES
        subjectList.add(new Subject(3,"Programacion web","Ing.Jaime",
                "LC2",12,13,"PM",R.drawable.ic_timer_black_24dp,103));
        subjectList.add(new Subject(3,"Administracion de redes","Camaleon",
                "CISCO",13,15,"PM",R.drawable.ic_timer_black_24dp,104));
        subjectList.add(new Subject(3,"Taller de investigacion 2","Ing.Segundo",
                "A6",15,17,"PM",R.drawable.ic_timer_black_24dp,105));
        subjectList.add(new Subject(3,"Programacion logica y funcional","Ing.Abundis",
                "LC1",17,19,"PM",R.drawable.ic_timer_black_24dp,106));

        //JUEVES

        subjectList.add(new Subject(4,"Desarrollo de App.Moviles","Ing.HUGO",
                "LC2",8,9,"AM",R.drawable.ic_timer_black_24dp,101));
        subjectList.add(new Subject(4,"Programacion web","Ing.Jaime",
                "LC2",9,11,"AM",R.drawable.ic_timer_black_24dp,103));
        subjectList.add(new Subject(4,"Computo forense","Ing. Juan Mata",
                "LC3",11,12,"PM",R.drawable.ic_timer_black_24dp,102));
        subjectList.add(new Subject(4,"Administracion de redes","Camaleon",
                "CISCO",12,13,"PM",R.drawable.ic_timer_black_24dp,104));
        //Viernes
        subjectList.add(new Subject(5,"Desarrollo de App.Moviles","Ing.HUGO",
                "LC2",13,15,"AM",R.drawable.ic_timer_black_24dp,101));

        subjectList.add(new Subject(5,"Taller de investigacion 2","Ing.Segundo",
                "A6",15,17,"AM",R.drawable.ic_timer_black_24dp,105));

        subjectList.add(new Subject(5,"Programacion logica y funcional","Ing.Abundis",
                "LC1",17,19,"PM",R.drawable.ic_timer_black_24dp,106));

        showSubject();


    }

    public  String[] getDay(){

        Calendar c = Calendar.getInstance();
        int get_specific_day =  c.get(Calendar.DAY_OF_WEEK);

        String date[] = new String[2];
        if(get_specific_day==Calendar.MONDAY){
            day="1";
            today="Lunes";
            date[0]=day;
            date[1]=today;

        }if(get_specific_day==Calendar.TUESDAY){
            day="2";
            today="Martes";
            date[0]=day;
            date[1]=today;
        }
        if(get_specific_day==Calendar.WEDNESDAY){
            day="3";
            today="Miercoles";
            date[0]=day;
            date[1]=today;
        }
        if(get_specific_day==Calendar.THURSDAY){
            day="4";
            today="Jueves";
            date[0]=day;
            date[1]=today;
        }
        if(get_specific_day==Calendar.FRIDAY){
            day="5";
            today="Viernes";
            date[0]=day;
            date[1]=today;
        }
        if(get_specific_day==Calendar.SATURDAY){
            day="6";
            today="Sabado";
            date[0]=day;
            date[1]=today;
        }
        if(get_specific_day==Calendar.SUNDAY){
            day="7";
            today="Domingo";
            date[0]=day;
            date[1]=today;
        }
        return date;
    }

    public  int getHourOfDay(){
        Date date = new Date();
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTime(date);   // assigns calendar to given date
        calendar.get(Calendar.HOUR_OF_DAY); // gets hour in 24h format
        calendar.get(Calendar.HOUR);

        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        return hour;
    }

    public void showSubject(){

        int currentlyDay=0;
        String dayText="";
        String[] dateToday= getDay();
        for(int j=0;j<dateToday.length;j++){
            String day = dateToday[0];
            dayText=dateToday[1];
            currentlyDay = Integer.parseInt(day);
            System.out.println(dateToday[1]);
        }
        tv_day.setText(dayText);
        if(dayText=="Sabado" || dayText=="Domingo"){
            Toast.makeText(MainActivity.this,"Hoy no tienes clase disfruta tu dia!!",Toast.LENGTH_LONG).show();
        }
        for (int i = 0; i < subjectList.size(); i++) {
            if (currentlyDay == subjectList.get(i).getDay()) {
                temp_subjectList.add(subjectList.get(i));
                changeStatusClass();
                SchuduleAdapter schuduleAdapter = new SchuduleAdapter(this,temp_subjectList);
                subject_list_view.setAdapter(schuduleAdapter);

                //Method Onclick
                schuduleAdapter.setOnSubjectClickListener(new SchuduleAdapter.OnSubjectClickListener() {
                    @Override
                    public void onSubjectClick(Subject subject) {

                        final Subject subject1 = new Subject(subject.getDay(),subject.getSubject_name(),subject.getTeacher(),
                                subject.getClassroom(),subject.getHour_start_class(),subject.getHour_end_class(),
                                subject.getIndicator(),subject.getImage_on_off(),subject.getKeySubject());

                        Intent DetailSubjet = new Intent(MainActivity.this,DetailSubject.class);
                        DetailSubjet.putExtra("miLista", subjectList);
                        DetailSubjet.putExtra(KEY_DATA,subject1);
                        startActivity(DetailSubjet);
                    }
                });


            }
        }


    }
    public void changeStatusClass(){
        int HourOfDay = getHourOfDay();
        for (int i=0;i<temp_subjectList.size();i++){
            //[1,2,3,4,5,6,7,8,9,10]
            int classStar = temp_subjectList.get(i).getHour_start_class();
            int classEnd = temp_subjectList.get(i).getHour_end_class(); // 12 -13- 14
            System.out.println("HORA DEL DIA ES "+HourOfDay);
            if ((HourOfDay==classStar && HourOfDay+1 == classEnd) ||
                    ((HourOfDay == classStar+1 || HourOfDay == classStar) && (classStar+2 == classEnd)) ){
                temp_subjectList.get(i).setImage_on_off(R.drawable.ic_timer_black_24dp);
            }else{
                temp_subjectList.get(i).setImage_on_off(R.drawable.ic_timer_off_black_24dp);
            }

        }

    }

}
