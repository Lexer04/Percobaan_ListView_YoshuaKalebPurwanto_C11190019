package com.example.myapplication1;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity{

    Button b3;
    DatabaseHelper myDB;

    private View.OnClickListener myClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.button3:
                    goToActivity();
                    break;
            }
        }
    };

    private void goToActivity() {
        setContentView(R.layout.activity_main);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        b3 = findViewById(R.id.button3);
        b3.setOnClickListener(myClickListener);

        ListView listView = (ListView) findViewById(R.id.lv1);
        myDB = new DatabaseHelper(this);

        ArrayList<String> thelist = new ArrayList<>();
        Cursor data = myDB.getListContents();
        if(data.getCount() == 0){
            Toast.makeText(MainActivity2.this, "Do Not Leave This Empty!", Toast.LENGTH_SHORT).show();
        }else{
            while (data.moveToNext()){
                thelist.add(data.getString(1));
                ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,thelist);
                listView.setAdapter(listAdapter);
            }
        }
        //Intent i = getIntent();
    }
}
