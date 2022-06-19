package com.osomebrows.freddy.osomebrows;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.paypal.android.sdk.payments.PayPalConfiguration;
import com.paypal.android.sdk.payments.PayPalPayment;
import com.paypal.android.sdk.payments.PayPalService;
import com.paypal.android.sdk.payments.PaymentActivity;
import com.paypal.android.sdk.payments.PaymentConfirmation;

import org.json.JSONException;

import java.math.BigDecimal;

public class PayBooking extends AppCompatActivity {

    public static final int PAYPAL_REQUEST_CODE = 666; // or any number you want

    private static PayPalConfiguration config = new PayPalConfiguration()
            .environment(PayPalConfiguration.ENVIRONMENT_SANDBOX)
            .clientId(Config.PAYPAL_Client_ID);

    Button bookingPay;
    TextView bookingAmount;
    String amount ="";

    protected void onDestroy(){
        stopService(new Intent(this,PayPalService.class));
        super.onDestroy();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_booking);

        // Start Paypal Service
        Intent intent = new Intent(this,PayPalService.class);
        intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, config);
        startService(intent);

        bookingPay = (Button)findViewById(R.id.bookingPay);
        bookingAmount = (TextView)findViewById(R.id.bookingAmount);

        bookingAmount.setText(AppointmentsActivity.servicePrice);

        bookingPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processPayment();
            }
        });
    }

    //make a payment
    private void processPayment() {
        amount = bookingAmount.getText().toString();
        PayPalPayment payPalPayment = new PayPalPayment(new BigDecimal(String.valueOf(amount)),"AUD",
                "Donate for OsomeBrows",PayPalPayment.PAYMENT_INTENT_SALE);
        Intent intent = new Intent(this, PaymentActivity.class);
        intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION,config);
        intent.putExtra(PaymentActivity.EXTRA_PAYMENT,payPalPayment);
        startActivityForResult(intent,PAYPAL_REQUEST_CODE);
    }

    //send and receive command
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode == PAYPAL_REQUEST_CODE)
        {
            if(resultCode == RESULT_OK)
            {
                PaymentConfirmation confirmation = data.getParcelableExtra(PaymentActivity.EXTRA_RESULT_CONFIRMATION);
                if(confirmation != null)
                {
                    try{
                        String paymentDetails = confirmation.toJSONObject().toString(4);

                        startActivity(new Intent(this,PaymentDetails.class)
                                .putExtra("PaymentDetails",paymentDetails)
                                .putExtra("PaymentAmount",amount)
                        );
                    }catch (JSONException e){
                        e.printStackTrace();
                    }
                }
            }
            else if(resultCode == Activity.RESULT_CANCELED)
                Toast.makeText(this,"Cancel",Toast.LENGTH_SHORT).show();

        }else if (resultCode == PaymentActivity.RESULT_EXTRAS_INVALID)
            Toast.makeText(this,"Invalid",Toast.LENGTH_SHORT).show();
    }

    public void cancelPayBooking(View view){
        Intent intent = new Intent(this,MainMenuActivity.class);
        startActivity(intent);
    }
}
