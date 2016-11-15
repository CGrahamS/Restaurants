package com.epicodus.restaurants;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class RestaurantActivity extends AppCompatActivity {
    private TextView mRestaurantDisplayText;
    private String mDisplayText;
    private ListView mRestaurantList;
    private String[] restaurants = new String[] {
            "Fish Sauce", "Pok Pok", "Los Gorditos", "People's Pig", "Wolf & Bear", "King Burrito", "Tasty & Alder", "Sweet Hereafter", "Pambiche", "808 Hawaiian", "Cafe De La Soul", "Screen Door", "Ken's Artisan Bakery", "Juniors", "Mount Tabor Bakery"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);

        mRestaurantList = (ListView) findViewById(R.id.restaurantList);
        mRestaurantDisplayText = (TextView) findViewById(R.id.restaurantDisplayText);
        mDisplayText = getString(R.string.restaurant_display_text);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, restaurants);
        mRestaurantList.setAdapter(adapter);

        mRestaurantList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String restaurant = ((TextView)view).getText().toString();
                Toast.makeText(RestaurantActivity.this, restaurant, Toast.LENGTH_LONG).show();
            }
        });

        Intent intent = getIntent();
        String location = intent.getStringExtra("location");
        mRestaurantDisplayText.setText(mDisplayText + " " + location + ":");
    }
}
