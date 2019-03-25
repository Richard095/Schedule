package com.example.schedule;

import android.app.ActivityOptions;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ScheduleFragment.OnFragmentInteractionListener,
        DetailFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar =  findViewById(R.id.main_activity_toolbar);
        setSupportActionBar(toolbar);

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onSubjectSelected(Subject subject,ArrayList<Subject> subjects) {
        //Toast.makeText(this,subject.getSubject_name(),Toast.LENGTH_LONG).show();

        final DetailFragment detailFragment =
                (DetailFragment) getSupportFragmentManager().findFragmentById(R.id.DetailFragmentId);

        detailFragment.KeySubject(subject.getKeySubject());

        detailFragment.getArrayList(subjects);


        Toast.makeText(this,"recibi------------------------__>"+subjects.get(3).getSubject_name(),Toast.LENGTH_LONG).show();

    }

    //Menu Options

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.item_new_schedule) {
            Toast.makeText(MainActivity.this, "Action clicked", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
            Bundle bundle = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this).toBundle();
            startActivity(intent,bundle);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
