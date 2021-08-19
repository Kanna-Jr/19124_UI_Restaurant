package com.example.checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn,btn1,btn2;
    EditText name, phn, add;
    int btn_fl=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.e1);
        phn = findViewById(R.id.e2);
        add = findViewById(R.id.e3);
        btn = findViewById(R.id.vl);
        btn1 = findViewById(R.id.bt);
        btn2 = findViewById(R.id.cl);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int f1=1, f2=1, s=0;
                String user_name = name.getText().toString();
                String mno = phn.getText().toString();
                for (int i = 0; i < user_name.length(); i++) {
                    char ch = user_name.charAt(i);
                    if (!(ch >= 'a' && ch <= 'z')&&!(ch >= 'A' && ch <= 'Z')) {
                        f1=0;
                    }
                }
                for (int i = 0; i < mno.length(); i++) {
                    char ch = mno.charAt(i);
                    if (!(ch >= '0' && ch <= '9')) {

                        f2=0;
                    }
                }

                s = mno.length();
                if(f1==0 || user_name.isEmpty()){
                    Toast.makeText(MainActivity.this, "Please Enter User Name correctly", Toast.LENGTH_LONG).show();
                }
                if(f2==0 || s!=10) {
                    Toast.makeText(MainActivity.this, "Mobile number must contain 10 digits", Toast.LENGTH_LONG).show();
                }
                if(f1==1 && f2==1 && s==10)
                {
                    Toast.makeText(MainActivity.this, "All data validated, proceed to register", Toast.LENGTH_LONG).show();
                    btn_fl=1;
                }
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn_fl==1){
                    Toast.makeText(MainActivity.this, "Registering User", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getApplicationContext(),MainActivity2.class);
                    String user_name = name.getText().toString();
                    intent.putExtra("user",user_name);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(getApplicationContext(), "Validate first before registering", Toast.LENGTH_LONG).show();
                }
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name.setText("");
                phn.setText("");
                add.setText("");
            }
        });


    }
    }
