package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper myDB;
    EditText editText;

    Button b1, b2;

    private View.OnClickListener myClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.button:
                    break;
                case R.id.button2:
                    goToActivity2();
                    break;
            }
        }
    };



    private void goToActivity2() {
        Intent i = new Intent(this, MainActivity2.class);

        startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = (Button) findViewById(R.id.button);
        b2 = findViewById(R.id.button2);
        b2.setOnClickListener(myClickListener);
        editText = (EditText) findViewById(R.id.UsernameText);
        myDB = new DatabaseHelper(this);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newEntry = editText.getText().toString();
                if(editText.length() !=0) {
                    AddData(newEntry);
                    editText.setText("");
                }else{
                    Toast.makeText(MainActivity.this, "Do Not Leave This Empty!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    
    public void AddData(String newEntry){
        boolean insertData = myDB.addData(newEntry);
        if(insertData==true){
            Toast.makeText(MainActivity.this, "Data Has Been Successfuly Enter ", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(MainActivity.this, "Something Went Wrong", Toast.LENGTH_SHORT).show();
        }
    }
}