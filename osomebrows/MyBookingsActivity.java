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
import android.widget.Toast;
import java.util.Map;


public class MyBookingsActivity extends AppCompatActivity {

    //DB handler
    DBBookingsHandler dbBookingsHandler;
    String userName = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_bookings);

        //get the user name
        userName = SaveUserLoggedInSharedPreference.getPrefUserName(MyBookingsActivity.this);

        //Database to read day's select bookings
        dbBookingsHandler = new DBBookingsHandler(this, null, null, 1);

        String myBookings[];

        myBookings = dbBookingsHandler.getMyBookingsFromDB(userName);

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
        final ListView abcListView = (ListView) findViewById(R.id.lViewMyBookings);
        //Convert the array of strings and add it to the list view
        abcListView.setAdapter(abcAdapter);

        //create a listener for each item on the list view to respond to touch
        abcListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String bookingDetails = String.valueOf(parent.getItemAtPosition(position));
                        Toast.makeText(MyBookingsActivity.this, bookingDetails, Toast.LENGTH_LONG).show();
                    }
                }
        );//ends setOnItemClickListener
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_my_bookings, menu);
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
