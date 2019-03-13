package com.example.schedule;

import android.app.TimePickerDialog;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.support.v7.widget.Toolbar;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class RegisterActivity extends AppCompatActivity {

    Button btn_initial_hour,btn_final_hour,btnregistrar;
    EditText et_subject,et_teacher,et_classroom,et_code;
    String indicatorAMPM_END;
    int day,hourStart,hourEnd,Code;
    int cod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //References
        btn_initial_hour = findViewById(R.id.btn_initial_hour);
        btn_final_hour = findViewById(R.id.btn_final_hour);
        et_subject = findViewById(R.id.et_subject);
        et_teacher = findViewById(R.id.et_teacher);
        et_classroom = findViewById(R.id.et_classroom);
        btnregistrar=findViewById(R.id.btnregistrsr);
        et_code = findViewById(R.id.et_code);
        //Sending toolbar
        Toolbar toolbar = findViewById(R.id.register_toolbar);
        setSupportActionBar(toolbar);

        arrayDays();

        btn_initial_hour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTime(btn_initial_hour);
            }
        });
        btn_final_hour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              showTime(btn_final_hour);

            }
        });
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        }

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

       btnregistrar.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               registerSubjects();
           }
       });
    }

    public void arrayDays(){
        Spinner spinner = findViewById(R.id.sp_days);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.day_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

       spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {
               switch(pos) {
                   case 0:

                       break;
                   case 1:
                       day = 1;
                       break;
                   case 2:
                       day = 2;
                       break;
                   case 3:
                       day = 3;
                       break;
                   case 4:
                       day = 4;
                       break;
                   case 5:
                       day = 5;
                       break;

                   default:}


           }

           @Override
           public void onNothingSelected(AdapterView<?> adapterView) {

           }
       });
    }
    private void showTime(final Button button) {
        Calendar c = Calendar.getInstance();
        final int mHour = c.get(Calendar.HOUR_OF_DAY);
        int mMinute = c.get(Calendar.MINUTE);

        TimePickerDialog dialog =
                new TimePickerDialog(RegisterActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override public void onTimeSet(TimePicker view,  int hourOfDay, int minute) {

                        String AM_PM ;
                        if(hourOfDay < 12) {
                            AM_PM = "AM";

                        } else {
                            AM_PM = "PM";

                        }

                        button.setText(hourOfDay + ":" + minute +" "+ AM_PM);

                        if (button == btn_initial_hour){
                            hourStart=hourOfDay;
                            Toast.makeText(RegisterActivity.this,"Ahora es: "+hourStart,Toast.LENGTH_LONG).show();

                        }else if (button == btn_final_hour){
                            hourEnd=hourOfDay;
                            Toast.makeText(RegisterActivity.this,"Ahora es: "+hourEnd,Toast.LENGTH_LONG).show();
                            indicatorAMPM_END = AM_PM;
                        }

                    }
                }, mHour, mMinute, true);
        dialog.show();


    }

    public void registerSubjects(){
       SubjectDBHelper subjectDBHelper = new SubjectDBHelper(getApplicationContext());
        SQLiteDatabase database  = subjectDBHelper.getWritableDatabase();

            String et_cod = et_code.getText().toString();
            cod = Integer.parseInt(et_cod);


            ContentValues values = new ContentValues();

            values.put(SubjectContract.subjectColumns.DAY,day);
            values.put(SubjectContract.subjectColumns.SUBJECT_NAME,et_subject.getText().toString());
            values.put(SubjectContract.subjectColumns.TEACHER,et_teacher.getText().toString());
            values.put(SubjectContract.subjectColumns.CLASSROOM,et_classroom.getText().toString());
            values.put(SubjectContract.subjectColumns.HOUR_START_CLASS,hourStart);
            values.put(SubjectContract.subjectColumns.HOUR_END_CLASS,hourEnd);
            values.put(SubjectContract.subjectColumns.INDICATOR,indicatorAMPM_END);
            values.put(SubjectContract.subjectColumns.KEY,cod);

            database.insert(SubjectContract.subjectColumns.TABLE_NAME,null,values);

            Toast.makeText(RegisterActivity.this,"Seleccionaste dias : "+ day,Toast.LENGTH_LONG).show();
    }




}





