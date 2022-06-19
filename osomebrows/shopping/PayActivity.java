package com.osomebrows.freddy.osomebrows.shopping;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.osomebrows.freddy.osomebrows.AdminProduct;
import com.osomebrows.freddy.osomebrows.Ecoupons;
import com.osomebrows.freddy.osomebrows.PaymentWay;
import com.osomebrows.freddy.osomebrows.R;

import java.math.BigDecimal;


public class PayActivity extends AppCompatActivity {
    String pOne;
    String pTwo;
    String pThree;
    double total = 0;
    public static double dicountCoupons;
    public static String payNumberWay;

    TextView lblProductToBuy;
    TextView lblPrice;
    TextView lblTotal;
    TextView couponsTotal;
    Button btnBuy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);

        //declare the interface
        lblProductToBuy = (TextView) findViewById(R.id.lblProductTobuy);
        lblPrice = (TextView) findViewById(R.id.lblPrice);
        lblTotal = (TextView) findViewById(R.id.lblTotal);
        couponsTotal = (TextView)findViewById(R.id.couponsTotal);
        btnBuy = (Button) findViewById(R.id.btnBuy);


        //get the date chosen from the intent
        Intent dataIntent = getIntent();
        //get the extras variable put to it
        pOne = dataIntent.getExtras().getString("pOne");
        pTwo = dataIntent.getExtras().getString("pTwo");
        pThree = dataIntent.getExtras().getString("pThree");

        dicountCoupons = Ecoupons.numberCoupons;

        //if the user has selected no products display empty
        if (pOne.equals("No") && pTwo.equals("No") && pThree.equals("No")) {
            lblProductToBuy.setText("Your shpping cart is empty!");
            lblPrice.setText("");
            lblTotal.setText("");
            btnBuy.setEnabled(false);
        }

        if(pOne.equals("Selected")) {
            total = Double.parseDouble(ShoppingActivity.productPrice1);
            lblProductToBuy.setText("GET HOT OUTSIDE");
            lblPrice.setText(AdminProduct.product1);
            BigDecimal b1 = new BigDecimal(total);
            final double t1 = b1.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
            lblTotal.setText("Total $" + String.valueOf(t1));
            double discountTotal1 = dicountCoupons * total;
            BigDecimal bigDecimal1 = new BigDecimal(discountTotal1);
            final double dis1 = bigDecimal1.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
            if(dis1 != 0){
                couponsTotal.setText("Ecoupons Discount Total $" + String.valueOf(dis1));
                btnBuy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        payNumberWay = String.valueOf(dis1);
                        Intent intent = new Intent(PayActivity.this, PaymentWay.class);
                        startActivity(intent);
                    }
                });
            }else{
                btnBuy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        payNumberWay = String.valueOf(t1);
                        Intent intent = new Intent(PayActivity.this, PaymentWay.class);
                        startActivity(intent);
                    }
                });
            }

            if (pTwo.equals("Selected")) {
                total += Double.parseDouble(AdminProduct.product2);
                lblProductToBuy.append("\nYELLOW BREATH");
                lblPrice.append("\n" + AdminProduct.product2);
                BigDecimal b2 = new BigDecimal(total);
                final double t2 = b2.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
                lblTotal.setText("Total $" + String.valueOf(t2));
                double discountTotal2 = dicountCoupons * total;
                BigDecimal bigDecimal2 = new BigDecimal(discountTotal2);
                final double dis2 = bigDecimal2.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
                if(dis2 != 0){
                    couponsTotal.setText("Ecoupons Discount Total $" + String.valueOf(dis2));
                    btnBuy.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            payNumberWay = String.valueOf(dis2);
                            Intent intent = new Intent(PayActivity.this, PaymentWay.class);
                            startActivity(intent);
                        }
                    });
                }else{
                    btnBuy.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            payNumberWay = String.valueOf(t2);
                            Intent intent = new Intent(PayActivity.this, PaymentWay.class);
                            startActivity(intent);
                        }
                    });
                }

            }
            if(pThree.equals("Selected")){
                total += Double.parseDouble(AdminProduct.product3);
                lblProductToBuy.append("\nSPECIAL SUNGLASSES");
                lblPrice.append("\n" + AdminProduct.product3);
                BigDecimal b3 = new BigDecimal(total);
                final double t3 = b3.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
                lblTotal.setText("Total $" + String.valueOf(t3));
                double discountTotal3 = dicountCoupons * total;
                BigDecimal bigDecimal3 = new BigDecimal(discountTotal3);
                final double dis3 = bigDecimal3.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
                if(dis3 != 0){
                    couponsTotal.setText("Ecoupons Discount Total $" + String.valueOf(dis3));
                    btnBuy.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            payNumberWay = String.valueOf(dis3);
                            Intent intent = new Intent(PayActivity.this, PaymentWay.class);
                            startActivity(intent);
                        }
                    });
                }else{
                    btnBuy.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            payNumberWay = String.valueOf(t3);
                            Intent intent = new Intent(PayActivity.this, PaymentWay.class);
                            startActivity(intent);
                        }
                    });
                }

            }
        }
        else if(pTwo.equals("Selected")){
            total = Double.parseDouble(AdminProduct.product2);
            lblProductToBuy.setText(("YELLOW BREATH"));
            lblPrice.setText(AdminProduct.product2);
            BigDecimal b4 = new BigDecimal(total);
            final double t4 = b4.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
            lblTotal.setText("Total $" + String.valueOf(t4));
            double discountTotal4 = dicountCoupons * total;
            BigDecimal bigDecimal4 = new BigDecimal(discountTotal4);
            final double dis4 = bigDecimal4.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
            if(dis4 != 0){
                couponsTotal.setText("Ecoupons Discount Total $" + String.valueOf(dis4));
                btnBuy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        payNumberWay = String.valueOf(dis4);
                        Intent intent = new Intent(PayActivity.this, PaymentWay.class);
                        startActivity(intent);
                    }
                });
            }else{
                btnBuy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        payNumberWay = String.valueOf(t4);
                        Intent intent = new Intent(PayActivity.this, PaymentWay.class);
                        startActivity(intent);
                    }
                });
            }

            if(pThree.equals("Selected")){
                total += Double.parseDouble(AdminProduct.product3);
                lblProductToBuy.append("\nSPECIAL SUNGLASSES");
                lblPrice.append("\n" + AdminProduct.product3);
                BigDecimal b5 = new BigDecimal(total);
                final double t5 = b5.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
                lblTotal.setText("Total $" + String.valueOf(t5));
                double discountTotal5 = dicountCoupons * total;
                BigDecimal bigDecimal5 = new BigDecimal(discountTotal5);
                final double dis5 = bigDecimal5.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
                if(dis5 != 0){
                    couponsTotal.setText("Ecoupons Discount Total $" + String.valueOf(dis5));
                    btnBuy.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            payNumberWay = String.valueOf(dis5);
                            Intent intent = new Intent(PayActivity.this, PaymentWay.class);
                            startActivity(intent);
                        }
                    });
                }else{
                    btnBuy.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            payNumberWay = String.valueOf(t5);
                            Intent intent = new Intent(PayActivity.this, PaymentWay.class);
                            startActivity(intent);
                        }
                    });
                }

            }
        }
        else if(pThree.equals("Selected")){
            total = Double.parseDouble(AdminProduct.product3);
            lblProductToBuy.setText("SPECIAL SUNGLASSES");
            lblPrice.setText(AdminProduct.product3);
            BigDecimal b6 = new BigDecimal(total);
            final double t6 = b6.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
            lblTotal.setText("Total $" + String.valueOf(t6));
            double discountTotal6 = dicountCoupons * total;
            BigDecimal bigDecimal6 = new BigDecimal(discountTotal6);
            final double dis6 = bigDecimal6.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
            if(dis6 != 0){
                couponsTotal.setText("Ecoupons Discount Total $" + String.valueOf(dis6));
                btnBuy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        payNumberWay = String.valueOf(dis6);
                        Intent intent = new Intent(PayActivity.this, PaymentWay.class);
                        startActivity(intent);
                    }
                });
            }else{
                btnBuy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        payNumberWay = String.valueOf(t6);
                        Intent intent = new Intent(PayActivity.this, PaymentWay.class);
                        startActivity(intent);
                    }
                });
            }

        }

    }//ends on create


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_pay, menu);
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

}
