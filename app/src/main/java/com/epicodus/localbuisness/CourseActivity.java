package com.epicodus.localbuisness;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

import butterknife.Bind;
import butterknife.ButterKnife;

public class CourseActivity extends AppCompatActivity {


    @Bind(R.id.courseView) TextView mCourseview;
    @Bind(R.id.courseHeader) TextView mCourseHeader;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);
        Intent mIntent = getIntent();
        String courseTitle = mIntent.getStringExtra("title");
        String courseInformation = mIntent.getStringExtra("courses");
        ButterKnife.bind(this);
        mCourseview.setText(courseInformation);
        mCourseHeader.setText(courseTitle);
    }
}
