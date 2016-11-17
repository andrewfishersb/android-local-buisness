package com.epicodus.localbuisness;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AddActivity extends AppCompatActivity {
    @Bind(R.id.submitMajor) Button mAddMajorButton;
    @Bind(R.id.courseInformation) EditText mCourseInformation;
    @Bind(R.id.addMajor) EditText mAddMajor;
    private ArrayList<String> mMajor = new ArrayList<String>();
    private ArrayList<String> mCourses = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        ButterKnife.bind(this);

        Intent myIntent = getIntent();

        mMajor = myIntent.getStringArrayListExtra("major");
        mCourses = myIntent.getStringArrayListExtra("courses");

        mAddMajorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String output = "";
                if (mAddMajor.getText().toString().equals("")) {
                    output += "Need to add title\n";
                }

                if (mCourseInformation.getText().toString().equals("")) {
                    output += "Need to add information for major";
                }

                if (output.equals("")) {
                    mMajor.add(mAddMajor.getText().toString());
                    mCourses.add(mCourseInformation.getText().toString());
                    Intent myIntent = new Intent(AddActivity.this, MainActivity.class);
                    myIntent.putExtra("major", mMajor);
                    myIntent.putExtra("courses", mCourses);
                    startActivity(myIntent);
                } else {
                    Toast.makeText(AddActivity.this, output, Toast.LENGTH_SHORT).show();
                }
            }
        });

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
                Intent myIntent = new Intent(AddActivity.this, MainActivity.class);
                myIntent.putExtra("major", mMajor);
                myIntent.putExtra("courses", mCourses);
                startActivity(myIntent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
