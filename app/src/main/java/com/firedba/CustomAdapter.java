package com.firedba;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<Student> {

private Activity context;
//for put data list
    private List<Student> studentList;
    //create conductor


    public CustomAdapter(Activity  context, List<Student> studentList) {//Give activity for context do the show
        super(context,R.layout.sample_layout, studentList);
        this.context = context;
        this.studentList = studentList;
    }

    //layoutView to convert so, create to getView

    @NonNull
    @Override
    public View getView(int position,  View convertView,  ViewGroup parent)
    {

        LayoutInflater layoutInflater = context.getLayoutInflater();//sample viewLoyout convert
        View view = layoutInflater.inflate(R.layout.sample_layout,null,true);//inflate for sample layout and done viewGroup return
        //take the data
        Student student = studentList.get(position);//have a student in the data
        //do the textView find for listView
        TextView t1 = view.findViewById(R.id.nameTextViewId);
        TextView t2 = view.findViewById(R.id.ageTextViewId);
        t1.setText("Name :"+student.getName());
        t2.setText("Age :"+student.getAge());
        //TextView t3 = view.findViewById(R.id.AddressTextViewId);

        return view;
    }
}
