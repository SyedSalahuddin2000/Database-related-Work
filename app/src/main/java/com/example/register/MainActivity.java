package com.example.register;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView email,userName,password;
    Button registerBtn,BtnView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        email=findViewById(R.id.email);
        userName=findViewById(R.id.userName);
        password=findViewById(R.id.password);
        registerBtn=findViewById(R.id.registerBtn);
        BtnView=findViewById(R.id.BtnView);
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
                else
                {
                        boolean c=db.insert_data(email1,user1,password1);
                        if(c == true)
                        {
                            Toast.makeText(MainActivity.this, "Register Successful", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            Toast.makeText(MainActivity.this, "Register failed", Toast.LENGTH_SHORT).show();
                        }

                }
//                Intent intent = new Intent(MainActivity.this,Data_View.class);
//                startActivity(intent);
                registerBtn.setText("");
            }
        });

        BtnView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Cursor c=db.getInfo();
                if(c.getCount()==0)
                {
                    Toast.makeText(MainActivity.this, "No Data Found", Toast.LENGTH_SHORT).show();
                }
                StringBuffer buffer=new StringBuffer();
                while(c.moveToNext()) {
                    buffer.append("email:: "+c.getString(0)+"\n");
                    buffer.append("userName:: "+c.getString(1)+"\n");
                    buffer.append("password:: "+c.getString(2)+"\n");
                    buffer.append("----------------------------------------"+"\n\n");

                }
                AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                builder.setCancelable(true);
                builder.setTitle("SignUp Users");
                builder.setMessage(buffer.toString());
                builder.show();
            }
        });




    }
}