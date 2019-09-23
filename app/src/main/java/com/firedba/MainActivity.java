package com.firedba;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private EditText NameEditText,AgeEditText;
    private Button SaveButton,LoadDataButton;
    //for data store
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseReference = FirebaseDatabase.getInstance().getReference("Student");

        NameEditText = findViewById(R.id.Name_EditText);
        AgeEditText = findViewById(R.id.Age_EditText);
        SaveButton = findViewById(R.id.Button);
        LoadDataButton = findViewById(R.id.Load_Button);

        LoadDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //new activity create for details show
                Intent intent = new Intent(getApplicationContext(),DetailsActivity.class);
                startActivity(intent);

            }
        });


        SaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                StoreData();//method create
            }
        });

    }
    private void StoreData()//method implement
    {
        String name = NameEditText.getText().toString().trim();
        String age = AgeEditText.getText().toString().trim();//then do the work implementation in the build.gradle form fireBase link
        //then->tools-> fireBase->realTime dataBase
        String key = databaseReference.push().getKey();
        //object create  student class for data store
        Student student = new Student(name,age);
        databaseReference.child(key).setValue(student);
        Toast.makeText(getApplicationContext(),"Successful",Toast.LENGTH_LONG).show();

        //editText clear
        NameEditText.setText("");
        AgeEditText.setText("");





    }
}
