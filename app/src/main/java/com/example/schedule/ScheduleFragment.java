package com.example.schedule;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class ScheduleFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    TextView tv_day;
    String today;
    String day;
    RecyclerView subject_list_view;

    ArrayList<Subject> subjectList = new ArrayList<>();
    ArrayList<Subject>temp_subjectList = new ArrayList<>();

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public ScheduleFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ScheduleFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ScheduleFragment newInstance(String param1, String param2) {
        ScheduleFragment fragment = new ScheduleFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View  view = inflater.inflate(R.layout.fragment_schedule, container, false);
        subject_list_view = view.findViewById(R.id.subject_list_view);

        tv_day = view.findViewById(R.id.tv_day);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
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

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**Interface for interaction with Activity*/
    public interface OnFragmentInteractionListener {
        void onSubjectSelected(Subject subject,ArrayList<Subject> subjects);
    }


    /**Main functions*/
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
            Toast.makeText(getActivity(),"Hoy no tienes clase disfruta tu dia!!",Toast.LENGTH_LONG).show();
        }
        for (int i = 0; i < subjectList.size(); i++) {
            if (currentlyDay == subjectList.get(i).getDay()) {
                temp_subjectList.add(subjectList.get(i));
                changeStatusClass();

                final SchuduleAdapter schuduleAdapter = new SchuduleAdapter(getActivity(),temp_subjectList);
                subject_list_view.setAdapter(schuduleAdapter);

                //Method Onclick
                schuduleAdapter.setOnSubjectClickListener(new SchuduleAdapter.OnSubjectClickListener() {
                    @Override
                    public void onSubjectClick(Subject subject) {
                        mListener.onSubjectSelected(subject,subjectList);
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
