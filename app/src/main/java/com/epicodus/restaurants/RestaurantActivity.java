package com.epicodus.restaurants;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class RestaurantActivity extends AppCompatActivity {
    public TextView mRestaurantDisplayText;
    public String mDisplayText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);

        mRestaurantDisplayText = (TextView) findViewById(R.id.restaurantDisplayText);
        mDisplayText = getString(R.string.restaurant_display_text);

        Intent intent = getIntent();
        String location = intent.getStringExtra("location");
        mRestaurantDisplayText.setText(mDisplayText + " " + location);
    }
}
