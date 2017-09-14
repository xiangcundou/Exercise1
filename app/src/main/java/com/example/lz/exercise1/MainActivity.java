package com.example.lz.exercise1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final MainActivity context = this;
        Button button = (Button)  findViewById(R.id.buttonText);
        final EditText editTextName = (EditText)findViewById(R.id.editTextName);
        final EditText editTextAge = (EditText)findViewById(R.id.editTextAge);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context,SecondActivity.class);
                intent.putExtra("name",editTextName.getText().toString());
                intent.putExtra("age",editTextAge.getText().toString());
                startActivityForResult(intent,0);
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        TextView textViewId = (TextView)findViewById(R.id.textViewId);
        TextView textView = (TextView)findViewById(R.id.textViewR);
        if(requestCode == 0 && resultCode == 0)
        {
            String str = data.getStringExtra("result");
            String Sid = data.getStringExtra("Id");
            textView.setText(str);
            textViewId.setText("学号："+Sid);
        }
    }

    }

