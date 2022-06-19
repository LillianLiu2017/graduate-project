package com.osomebrows.freddy.osomebrows;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class PaymentDetails extends AppCompatActivity {

    TextView txtId, txtAmount, txtStatus;
    Button returnPayment;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_details);

        txtId = (TextView)findViewById(R.id.txtId);
        txtAmount = (TextView)findViewById(R.id.txtAmount);
        txtStatus = (TextView)findViewById(R.id.txtStatus);

        returnPayment = (Button) findViewById(R.id.returnPayment);
        returnPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PaymentDetails.this,MainMenuActivity.class);
                startActivity(intent);
            }
        });

        // Get Intent
        Intent intent = getIntent();

        //send and receive the command
        try{
            JSONObject jsonObject = new JSONObject(intent.getStringExtra("PaymentDetails"));
            showDetails(jsonObject.getJSONObject("response"),intent.getStringExtra("PaymentAmount"));

        }catch (JSONException e){
            e.printStackTrace();
        }
    }

    //define the payment details
    private void showDetails(JSONObject response, String paymentAmount) {
        try{
            txtId.setText(response.getString("id"));
            txtStatus.setText(response.getString("state"));
            txtAmount.setText("$"+paymentAmount);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


}
