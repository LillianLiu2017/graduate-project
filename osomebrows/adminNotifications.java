package com.osomebrows.freddy.osomebrows;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

//admin can send notification to the customer
public class adminNotifications extends AppCompatActivity {

    Button sendNoti;
    EditText editNoti;

    public static String notification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_notifications);

        sendNoti = (Button)findViewById(R.id.sendNoti);
        editNoti = (EditText)findViewById(R.id.adminNotiEdit);

        //send notification to the customer page
        sendNoti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notification = editNoti.getText().toString();
                Intent intent = new Intent(adminNotifications.this,AdminHomepage.class);
                startActivity(intent);
                Toast.makeText(adminNotifications.this,"Notifications hava been sent.",Toast.LENGTH_LONG).show();
            }
        });

    }

    //admin can return to the homepage
    public void adminReturnHome(View view){
        Intent intent = new Intent(this,AdminHomepage.class);
        startActivity(intent);
    }

}
