package com.osomebrows.freddy.osomebrows;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class staffHomepage extends AppCompatActivity {

    TextView staffUsername;
    String username1 = "";
    String username2 = "";
    String username3 = "";

    //DB handler
    DBBookingsHandler dbBookingsHandler;
    String staffName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_homepage);

        staffUsername = (TextView)findViewById(R.id.staffUsername);

        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();
        if(bundle!=null){
            username1 = bundle.getString("staff1");
            username2 = bundle.getString("staff2");
            username3 = bundle.getString("staff3");
        }
        if(username1!=null){
            staffUsername.setText(username1);
            //Database to read day's select bookings
            dbBookingsHandler = new DBBookingsHandler(this, null, null, 1);

            String myBookings[];

            myBookings = dbBookingsHandler.getStaffFromDB("staff1");

            //create an array of strings of the size of how many rows have returned
            String myCurrentBookings[] = new String[myBookings.length];

            //check for null values
            for(int i =0; i<myBookings.length;i++){
                if(myBookings[i] != null){
                    myCurrentBookings[i] = myBookings[i];
                }
            }





            //create the adapter to convert Array of strings into list items
            ListAdapter abcAdapter = new BookingsMyListViewAdapter(this, myBookings);

            //declare your list view
            final ListView abcListView = (ListView) findViewById(R.id.staffBooking);
            //Convert the array of strings and add it to the list view
            abcListView.setAdapter(abcAdapter);

            //create a listener for each item on the list view to respond to touch
            abcListView.setOnItemClickListener(
                    new AdapterView.OnItemClickListener(){
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            String bookingDetails = String.valueOf(parent.getItemAtPosition(position));
                            Toast.makeText(staffHomepage.this, bookingDetails, Toast.LENGTH_LONG).show();
                        }
                    }
            );//ends setOnItemClickListener
        }
        if(username2!=null){
            staffUsername.setText(username2);
            //Database to read day's select bookings
            dbBookingsHandler = new DBBookingsHandler(this, null, null, 1);

            String myBookings[];

            myBookings = dbBookingsHandler.getStaffFromDB("staff2");

            //create an array of strings of the size of how many rows have returned
            String myCurrentBookings[] = new String[myBookings.length];

            //check for null values
            for(int i =0; i<myBookings.length;i++){
                if(myBookings[i] != null){
                    myCurrentBookings[i] = myBookings[i];
                }
            }





            //create the adapter to convert Array of strings into list items
            ListAdapter abcAdapter = new BookingsMyListViewAdapter(this, myBookings);

            //declare your list view
            final ListView abcListView = (ListView) findViewById(R.id.staffBooking);
            //Convert the array of strings and add it to the list view
            abcListView.setAdapter(abcAdapter);

            //create a listener for each item on the list view to respond to touch
            abcListView.setOnItemClickListener(
                    new AdapterView.OnItemClickListener(){
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            String bookingDetails = String.valueOf(parent.getItemAtPosition(position));
                            Toast.makeText(staffHomepage.this, bookingDetails, Toast.LENGTH_LONG).show();
                        }
                    }
            );//ends setOnItemClickListener
        }
        if(username3!=null){
            staffUsername.setText(username3);
            //Database to read day's select bookings
            dbBookingsHandler = new DBBookingsHandler(this, null, null, 1);

            String myBookings[];

            myBookings = dbBookingsHandler.getStaffFromDB("staff3");

            //create an array of strings of the size of how many rows have returned
            String myCurrentBookings[] = new String[myBookings.length];

            //check for null values
            for(int i =0; i<myBookings.length;i++){
                if(myBookings[i] != null){
                    myCurrentBookings[i] = myBookings[i];
                }
            }





            //create the adapter to convert Array of strings into list items
            ListAdapter abcAdapter = new BookingsMyListViewAdapter(this, myBookings);

            //declare your list view
            final ListView abcListView = (ListView) findViewById(R.id.staffBooking);
            //Convert the array of strings and add it to the list view
            abcListView.setAdapter(abcAdapter);

            //create a listener for each item on the list view to respond to touch
            abcListView.setOnItemClickListener(
                    new AdapterView.OnItemClickListener(){
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            String bookingDetails = String.valueOf(parent.getItemAtPosition(position));
                            Toast.makeText(staffHomepage.this, bookingDetails, Toast.LENGTH_LONG).show();
                        }
                    }
            );//ends setOnItemClickListener
        }


    }

    public void staffReturnMain(View view){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

}
