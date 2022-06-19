package com.osomebrows.freddy.osomebrows;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class AdminBooking extends AppCompatActivity {

    DBBookingsHandler dbBookingsHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_booking);


        dbBookingsHandler = new DBBookingsHandler(this, null, null, 1);

        String myBookings[];

        myBookings = dbBookingsHandler.adminBookingsFromDB();

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
        final ListView abcListView = (ListView) findViewById(R.id.viewBookingsInfo);
        //Convert the array of strings and add it to the list view
        abcListView.setAdapter(abcAdapter);

        //create a listener for each item on the list view to respond to touch
        abcListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String bookingDetails = String.valueOf(parent.getItemAtPosition(position));
                        Toast.makeText(AdminBooking.this, bookingDetails, Toast.LENGTH_LONG).show();
                    }
                }
        );//ends setOnItemClickListener


    }
}
