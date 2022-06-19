package com.osomebrows.freddy.osomebrows;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

//create admin homepage
public class AdminHomepage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_homepage);
    }

    //admin return the app homepage
    public void adminReturnMain(View view){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    //admin goes to the Notification page
    public void adminGoNoti(View view){
        Intent intent = new Intent(this,adminNotifications.class);
        startActivity(intent);
    }

    //admin goes to the Booing page
    public void adminBooking(View view){
        Intent intent = new Intent(this,AdminBooking.class);
        startActivity(intent);
    }

    //admin goes to the Ecoupons page
    public void adminGoCoupon(View view){
        Intent intent = new Intent(this,AdminCoupons.class);
        startActivity(intent);
    }

    //admin goes to the product page
    public void adminGoProduct(View view){
        Intent intent = new Intent(this,AdminProduct.class);
        startActivity(intent);
    }

}
