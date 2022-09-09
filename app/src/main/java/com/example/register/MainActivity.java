package com.example.register;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView email,userName,password;
    Button registerBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        email=findViewById(R.id.email);
        userName=findViewById(R.id.userName);
        password=findViewById(R.id.password);
        registerBtn=findViewById(R.id.registerBtn);
        Database db=new Database(MainActivity.this);


        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email1=email.getText().toString();
                String user1=userName.getText().toString();
                String password1=password.getText().toString();
                if(email.equals("")||userName.equals("")||password.equals(""))
                {
                    Toast.makeText(MainActivity.this, "Enter all credentials", Toast.LENGTH_SHORT).show();
                }
                else {
                        boolean c=db.insert_data(email1,user1,password1);
                        if(c==true)
                        {
                            Toast.makeText(MainActivity.this, "Register Successful", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(MainActivity.this, "Register failed", Toast.LENGTH_SHORT).show();
                        }

                }
                registerBtn.setText("");
            }
        });
        {

        }



    }
}