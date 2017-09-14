package com.example.lz.exercise1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by L&Z on 2017/9/14.
 */

public class SecondActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.second);
            Button button = (Button)findViewById(R.id.buttonReturn);
            TextView textViewName = (TextView)findViewById(R.id.TextViewName);
            TextView textViewAge = (TextView)findViewById(R.id.TextViewAge);
            final EditText editTextId = (EditText)findViewById(R.id.editTextId);

            final Intent intent = getIntent();
            final String name = intent.getStringExtra("name");
            final String age = intent.getStringExtra("age");
            textViewName.setText(name);
            textViewAge.setText(age);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String S = editTextId.getText().toString();
                    Intent intent1 = new Intent(SecondActivity.this,MainActivity.class);
                    intent1.putExtra("result","姓名："+name+"   年龄："+age);
                    intent1.putExtra("Id",S);
                    setResult(0,intent1);
                    finish();
                }
            });

        }


}

