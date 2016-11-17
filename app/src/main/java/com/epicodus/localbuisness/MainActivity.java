package com.epicodus.localbuisness;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    private ArrayList<String> mCourses = new ArrayList<String>(Arrays.asList(
            "Our department is home to 26 regular faculty members who specialize in a variety of research areas such as computer graphics and vision, computer security, databases, intelligent systems, programming languages, software engineering, open source software, sensor networks, and high performance computing.\n\n-CS 162 Introduction to Computer Science\n\n-CS 163 Data Structures\n\n-CS 350 Algorithms and Complexity", "The critical analysis track is especially suited to preparation for a career that involves research and writing, such as museum work, art criticism, or teaching art history, and is focused on cultivating the ability to think critically and creatively about visual as well as textual resources. This option requires two seminars (small research and writing focused classes) instead of the one needed for other two art history degree tracks.\n\n-ARH 110 Visual Literacy\n\n-ARH 204 History of Western Art\n\n-ART 111 Design Thinking","We educate both undergraduates and graduates about human behavior, about the theories in which research is rooted, and about how to actively critique the assumptions, methods, and ethics that are a part of generating and using psychological knowledge. Along with our research, our work with students reflects our commitment to realizing human and organizational possibilities to their fullest.\n\n-PSY361: Introduction to Industrial Psychology\n\n-PSY362: Introduction to Organizational Psychology\n\n-PSY410: Positive Psychology in the Workplace","The Biology Department has 21 faculty, over 1,200 undergraduate majors, and over 65 graduate students and post-docs. Our faculty take an integrative approach to biology, encompassing all levels of biological organization from molecules to ecosystems. Our Department is committed to excellence in both research and teaching, and we strive to provide a rigorous, balanced education in Biology for all our students.\n\n-BI301 HUMAN ANATOMY & PHY\n\n-BI235 MICROBIOLOGY LAB\n\n-BI360 INTRO TO MARINE BIOLOGY","The Child and Family Studies major represents an integration of theory, research, and practice from multiple disciplines, and it is a unique blend of liberal arts and professional education. CFS graduates may begin careers as early childhood educators, social service agency administrators, parent educators, family advocates, youth workers, social services caseworkers, early intervention/special education assistants, and services providers for community agencies serving children, youth, and families.  The major also provides a foundation of course work for students who intend to pursue graduate work in education, counseling, social work, public  administration, juvenile justice, conflict resolution, or other related disciplines.\n\n-ED 420 Intro to Education\n\n-HIST 343 History of American Families\n\n-CFS 312U Human Development in the Family Setting","Undergraduates in theater arts are expected to acquire basic skills in performance, design and production, practice, and dramatic literature and theater history. These basic skills are developed in the core requirements. The remaining credits are met through a selected option, performance, design/production, or theater studies including criticism, literature and dramatic writing, which provides for flexibility and allows a student to specialize in an area of interest. Students choose from electives in Theater + Film, and World Languages and Literatures (Kabuki).\n\n-TA 111 Stagecraft\n\n-TA 151 Introduction to Theater Arts & Practice\n\n-TA 322 History of Dress","The 28 credit Business Minor offered through the School of Business Administration (SBA) provides students with fundamental business skills that are essential in any career field. The recently revamped program includes personal and organizational planning skills that build a solid foundation for later career success. Whatever your chosen field, chances are that you'll be working in some type of business, agency, or practice. If your career goals involve running your own show, it's important that you leave school with a set of skills that help you to translate your passion into a sustainable career that offers you financial as well as professional success.\n\n-BA101  - Introduction to Business and World Affairs\n\n-BA306U - Essentials of Finance\n\n-BA316U - Essentials of Marketing"
    ));
    private ArrayList<String> mMajor = new ArrayList<String>(Arrays.asList(
            "Computer Science",
            "Art History: Critical Analysis",
            "Psychology",
            "Biology",
            "Child and Family Studies",
            "Theater Arts",
            "Business Administration"
    ));

    @Bind(R.id.majorListView) ListView mMajorListView;
    @Bind(R.id.addMajorButton) Button mAddMajorButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Intent mIntent = getIntent();

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, mMajor);
        mMajorListView.setAdapter(adapter);
        mMajorListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Intent myIntent = new Intent(MainActivity.this, CourseActivity.class);
                myIntent.putExtra("courses", mCourses.get(position));
                myIntent.putExtra("title", mMajor.get(position));
                myIntent.putExtra("majorList", mMajor);
                myIntent.putExtra("coursesList", mCourses);
                startActivity(myIntent);
            }
        });

        mAddMajorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, AddActivity.class);
                myIntent.putExtra("major", mMajor);
                myIntent.putExtra("courses", mCourses);
                startActivity(myIntent);
            }
        });
    }
}
