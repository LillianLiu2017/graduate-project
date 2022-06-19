package com.osomebrows.freddy.osomebrows;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

//this class can make admin release Ecoupons
public class AdminCoupons extends AppCompatActivity {

    public static String discount;
    EditText coupons;
    Button sendCoupons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_coupons);

        coupons = (EditText)findViewById(R.id.adminCouponsEdit);
        sendCoupons = (Button)findViewById(R.id.sendCoupon);

        //admin send coupons to the customer interface
        sendCoupons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                discount = coupons.getText().toString();
                Intent intent = new Intent(AdminCoupons.this,AdminHomepage.class);
                startActivity(intent);
                Toast.makeText(AdminCoupons.this,"Ecoupons have been sent.",Toast.LENGTH_LONG).show();
            }
        });

    }

    //admin returns to the homepage
    public void couponReturn(View view){
        Intent intent = new Intent(this,AdminHomepage.class);
        startActivity(intent);
    }
}
