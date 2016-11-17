package com.epicodus.localbuisness;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.headerTextView) TextView mHeaderTextView;
    @Bind(R.id.majorListView) ListView mMajorListView;
    private String[] mMajor = new String[] {
            "Computer Science",
            "CIT",
            "Art History",
            "Psychology",
            "Software Engineer",
            "Biology",
            "Child and Family Studies",
            "Theater Arts"

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, mMajor);
        mMajorListView.setAdapter(adapter);
        mMajorListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Toast.makeText(MainActivity.this, mMajor[position], Toast.LENGTH_SHORT).show();

            }
        });
    }
}
