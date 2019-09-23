package com.firedba;

import
        android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.security.Key;
import java.util.ArrayList;
import java.util.List;

public class DetailsActivity extends AppCompatActivity {
    private ListView listView;
    //data load DataBaseReference for adapter class
    DatabaseReference databaseReference;
    private List<Student> studentList;
    private CustomAdapter customAdapter;//object for adapter class


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        databaseReference = FirebaseDatabase.getInstance().getReference("Student");

        studentList = new ArrayList<>();
       customAdapter = new CustomAdapter(DetailsActivity.this,studentList);


        listView = findViewById(R.id.ListViewId);


        listView.setAdapter(customAdapter);


    }

    // Data load for method create


    @Override
    protected void onStart()
    {
        Log.e("start","oyy ");

        listView.setAdapter(customAdapter);//done adapter add
        databaseReference.addValueEventListener(new ValueEventListener()

        {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                studentList.clear();//staring time data clear

                for (DataSnapshot DataSnapshot1 : dataSnapshot.getChildren())
                {
                    Student student = DataSnapshot1.getValue(Student.class); //take data form student class

                    //String name = DataSnapshot.child("Student").getValue(String.class);
                    //String age =DataSnapshot.child("Student").getValue(String.class);
                   //String name = student.getName();
                  // String age = student.getAge();
               Log.e("find",""+student.getAge());
                    studentList.add(student);//from student transfer data in the studentList
                    //studentList.add(name + " / " +  age);
                }

                listView.setAdapter(customAdapter);//done adapter add

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError)
            {

            }
        });
        super.onStart();
    }
}
