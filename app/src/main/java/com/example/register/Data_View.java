package com.example.register;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Data_View extends AppCompatActivity {
    Button btnView;
    Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_view);
        setTitle("User Data Information");
        btnView =findViewById(R.id.btnView);


        btnView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Cursor c=db.getInfo();
                if(c.getCount()==0)
                {
                    Toast.makeText(Data_View.this, "No Data Found", Toast.LENGTH_SHORT).show();
                }
                StringBuffer buffer=new StringBuffer();
                while(c.moveToNext()) {
                    buffer.append("email::"+c.getString(0)+"\n");
                    buffer.append("userName::"+c.getString(1)+"\n");
                    buffer.append("password::"+c.getString(2)+"\n");

                }
                AlertDialog.Builder builder=new AlertDialog.Builder(Data_View.this);
                builder.setCancelable(true);
                builder.setTitle("SignUp Users");
                builder.setMessage(buffer.toString());
                builder.show();
            }
        });
    }
}