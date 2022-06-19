package com.osomebrows.freddy.osomebrows;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.osomebrows.freddy.osomebrows.shopping.ShoppingActivity;

public class AdminProduct extends AppCompatActivity {

    EditText price1;
    EditText price2;
    EditText price3;
    Button confirmPrice;

    //initialize the price of the products
    public static String product1 = "199";
    public static String product2 = "130.99";
    public static String product3 = "99.99";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_product);

        price1 = (EditText)findViewById(R.id.price1);
        price2 = (EditText)findViewById(R.id.price2);
        price3 = (EditText)findViewById(R.id.price3);
        confirmPrice = (Button)findViewById(R.id.confirmPrice);

        //admin edits the price of products
        confirmPrice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                product1 = price1.getText().toString();
                product2 = price2.getText().toString();
                product3 = price3.getText().toString();
                Intent intent = new Intent(AdminProduct.this,AdminHomepage.class);
                startActivity(intent);
                Toast.makeText(AdminProduct.this,"Price has been changed.",Toast.LENGTH_LONG).show();
            }
        });

    }

    //admin can return to the homepage
    public void productReturnHome(View view){
        Intent intent = new Intent(this,AdminHomepage.class);
        startActivity(intent);
    }

}
