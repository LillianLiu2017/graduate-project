package com.osomebrows.freddy.osomebrows;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

//customer can get the Ecoupons from the admin
public class Ecoupons extends AppCompatActivity {

    public static String acquireCoupons;
    public static double numberCoupons;

    TextView couponsUser;
    Button getCoupons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ecoupons);

        couponsUser = (TextView)findViewById(R.id.couponView);
        getCoupons = (Button)findViewById(R.id.getCoupon);

        acquireCoupons = AdminCoupons.discount;
        couponsUser.setText(acquireCoupons);

        //customer can get this coupon
        getCoupons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberCoupons = Double.parseDouble(acquireCoupons);
                Intent intent = new Intent(Ecoupons.this,MainMenuActivity.class);
                startActivity(intent);
                Toast.makeText(Ecoupons.this,"You have got Ecoupons.",Toast.LENGTH_LONG).show();
            }
        });

    }

    //customer can cancel to get the coupons and return homepage
    public void couBackCancel(View view) {
        Intent intent = new Intent(this,MainMenuActivity.class);
        startActivity(intent);
    }
}
