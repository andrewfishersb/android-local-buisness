package com.epicodus.localbuisness;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

import butterknife.Bind;
import butterknife.ButterKnife;

public class CourseActivity extends AppCompatActivity {

    public ArrayList<String> mMajor = new ArrayList<String>();
    public ArrayList<String> mCourses = new ArrayList<String>();

    @Bind(R.id.courseView) TextView mCourseview;
    @Bind(R.id.courseHeader) TextView mCourseHeader;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);
        Intent mIntent = getIntent();
        mMajor = mIntent.getStringArrayListExtra("majorList");
        mCourses = mIntent.getStringArrayListExtra("coursesList");
        String courseTitle = mIntent.getStringExtra("title");
        String courseInformation = mIntent.getStringExtra("courses");
        ButterKnife.bind(this);
        mCourseview.setText(courseInformation);
        mCourseHeader.setText(courseTitle);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.itemHome:
                Intent myIntent = new Intent(CourseActivity.this, MainActivity.class);
                myIntent.putExtra("major", mMajor);
                myIntent.putExtra("courses", mCourses);
                startActivity(myIntent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
