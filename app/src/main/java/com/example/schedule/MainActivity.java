package com.example.schedule;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ScheduleFragment.OnFragmentInteractionListener,
        DetailFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onSubjectSelected(Subject subject,ArrayList<Subject> subjects) {
        //Toast.makeText(this,subject.getSubject_name(),Toast.LENGTH_LONG).show();

        DetailFragment detailFragment =
                (DetailFragment) getSupportFragmentManager().findFragmentById(R.id.DetailFragmentId);

        detailFragment.KeySubject(subject.getKeySubject());
        detailFragment.getArrayList(subjects);

        Toast.makeText(this,"recibi------------------------__>"+subjects.get(3).getSubject_name(),Toast.LENGTH_LONG).show();

    }
}
