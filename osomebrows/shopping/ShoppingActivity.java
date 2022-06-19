package com.osomebrows.freddy.osomebrows.shopping;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;

import com.osomebrows.freddy.osomebrows.AdminProduct;
import com.osomebrows.freddy.osomebrows.R;

public class ShoppingActivity extends AppCompatActivity {

    ImageButton btnPay;
    CheckBox cBoxPOne;
    CheckBox cBoxPTwo;
    CheckBox cBoxPThree;
    TextView getPrice;
    TextView yellowPrice;
    TextView specialPrice;

    public static String productPrice1;
    public static String productPrice2;
    public static String productPrice3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping);

        //declare the interface
        btnPay = (ImageButton)findViewById(R.id.btnPay);
        cBoxPOne = (CheckBox)findViewById(R.id.cBoxPOne);
        cBoxPTwo = (CheckBox)findViewById(R.id.cBoxPTwo);
        cBoxPThree = (CheckBox)findViewById(R.id.cBoxPThree);
        getPrice = (TextView)findViewById(R.id.getPrice);
        yellowPrice = (TextView)findViewById(R.id.yellowPrice);
        specialPrice = (TextView)findViewById(R.id.specialPrice);

        productPrice1 = AdminProduct.product1;
        productPrice2 = AdminProduct.product2;
        productPrice3 = AdminProduct.product3;
        getPrice.setText(productPrice1);
        yellowPrice.setText(productPrice2);
        specialPrice.setText(productPrice3);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_shopping, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //*********************** BTN Pay Clicked *******************
    public void btnPayClicked(View view){

        String pOne = "No";
        String pTwo = "No";
        String pThree = "No";

        //get the values from check box
        if(cBoxPOne.isChecked()){
            //save product one into the user's cart
            pOne = "Selected";
        }
        if(cBoxPTwo.isChecked()){
            pTwo = "Selected";
        }
        if(cBoxPThree.isChecked()){
            pThree = "Selected";
        }

        //Call Pay activity and pass the values to add to the cart
        Intent payIntent = new Intent(this, PayActivity.class);
        payIntent.putExtra("pOne", pOne);
        payIntent.putExtra("pTwo", pTwo);
        payIntent.putExtra("pThree", pThree);
        startActivity(payIntent);
    }
}
