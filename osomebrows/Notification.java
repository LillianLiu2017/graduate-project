package com.osomebrows.freddy.osomebrows;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

//customer can read the notification from this page
public class Notification extends AppCompatActivity {

    public static String acquireNoti;

    TextView userNoti;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        //customer can receive the notification from the admin
        userNoti = (TextView)findViewById(R.id.acquireNoti);
        acquireNoti = adminNotifications.notification;
        userNoti.setText(acquireNoti);
    }

    //customer can return the homepage
    public void notiBackReturn(View view) {
        Intent intent = new Intent(Notification.this,MainMenuActivity.class);
        startActivity(intent);
    }
}
