package com.osomebrows.freddy.osomebrows;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class ServicesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);

        //Implement the List View
        String[] services = {"Hair cut", "Eyelash Extensions", "Waxing"};
        final String[] servicePrice = {"Hair cut - $50",
                "Eyelash Extensions - $99",
                "Waxing - $99"};
        Integer[] serviceImageID = {R.drawable.haircut,R.drawable.eye,R.drawable.waxing};

        //create the adpter to convert Array of strings into list items
        ListAdapter wilsAdapter = new ServicesAdapter(this, services, serviceImageID);

        //declare your list view
        ListView wilsListView = (ListView) findViewById(R.id.lViewServices);
        //Convert the array of strings and add it to the list view
        wilsListView.setAdapter(wilsAdapter);

        //create a listener for each item on the list view to respond to touch
        wilsListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        //String food = String.valueOf(parent.getItemAtPosition(position));
                        Toast.makeText(ServicesActivity.this, servicePrice[position], Toast.LENGTH_LONG).show();
                    }
                }
        );//ends setOnItemClickListener

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_services, menu);
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
