package com.epicodus.restaurants;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;

public class RestaurantActivity extends AppCompatActivity {
    @Bind(R.id.restaurantDisplayText) TextView mRestaurantDisplayText;
    private String mDisplayText;
    @Bind(R.id.restaurantList) ListView mRestaurantList;
    private String[] restaurants = new String[] {
            "Fish Sauce", "Pok Pok", "Los Gorditos", "People's Pig", "Wolf & Bear", "King Burrito", "Tasty & Alder", "Sweet Hereafter", "Pambiche", "808 Hawaiian", "Cafe De La Soul", "Screen Door", "Ken's Artisan Bakery", "Juniors", "Mount Tabor Bakery"
    };
    public static final String TAG = RestaurantActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);
        ButterKnife.bind(this);
        mDisplayText = getString(R.string.restaurant_display_text);


        ArrayAdapter adapter = new ArrayAdapter(RestaurantActivity.this, android.R.layout.simple_list_item_1, restaurants);
        mRestaurantList.setAdapter(adapter);

        mRestaurantList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String restaurant = ((TextView)view).getText().toString();
                Toast.makeText(RestaurantActivity.this, restaurant, Toast.LENGTH_LONG).show();
                Log.v(TAG, restaurant);
            }
        });

        Intent intent = getIntent();
        String location = intent.getStringExtra("location");
        String formattedDisplayText = String.format(mDisplayText, location);
        mRestaurantDisplayText.setText(formattedDisplayText);
        Log.d(TAG, "In the onCreate method!");
    }
}
