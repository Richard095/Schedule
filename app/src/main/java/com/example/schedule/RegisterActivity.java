package com.example.schedule;

import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TimePicker;
import java.util.Calendar;

public class RegisterActivity extends AppCompatActivity {

    Button btn_initial_hour,btn_final_hour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        btn_initial_hour = findViewById(R.id.btn_initial_hour);
        btn_final_hour = findViewById(R.id.btn_final_hour);
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


    }

    public void arrayDays(){
        Spinner spinner = (Spinner) findViewById(R.id.sp_days);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.day_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }
    private void showTime(final Button button) {
        Calendar c = Calendar.getInstance();
        final int mHour = c.get(Calendar.HOUR_OF_DAY);
        int mMinute = c.get(Calendar.MINUTE);
        TimePickerDialog dialog =
                new TimePickerDialog(RegisterActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                        String AM_PM ;
                        if(hourOfDay < 12) {
                            AM_PM = "AM";
                        } else {
                            AM_PM = "PM";
                        }

                        button.setText(hourOfDay + ":" + minute +" "+ AM_PM);
                    }
                }, mHour, mMinute, true);
        dialog.show();
    }

}




