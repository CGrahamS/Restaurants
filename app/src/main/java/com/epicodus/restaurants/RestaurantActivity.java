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

import java.io.IOException;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class RestaurantActivity extends AppCompatActivity {
    public static final String TAG = RestaurantActivity.class.getSimpleName();

    @Bind(R.id.restaurantDisplayText) TextView mRestaurantDisplayText;
    @Bind(R.id.restaurantList) ListView mRestaurantList;

    private String mDisplayText;
    public ArrayList<Restaurant> mRestaurants = new ArrayList<>();
    private String[] restaurants = new String[] {
            "Fish Sauce", "Pok Pok", "Los Gorditos", "People's Pig", "Wolf & Bear", "King Burrito", "Tasty & Alder", "Sweet Hereafter", "Pambiche", "808 Hawaiian", "Cafe De La Soul", "Screen Door", "Ken's Artisan Bakery", "Juniors", "Mount Tabor Bakery"
    };

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
            }
        });

        Intent intent = getIntent();
        String location = intent.getStringExtra("location");
        String formattedDisplayText = String.format(mDisplayText, location);
        mRestaurantDisplayText.setText(formattedDisplayText);
        getRestaurants(location);
    }

    private void getRestaurants(String location) {
        final YelpService yelpService = new YelpService();
        yelpService.findRestaurants(location, new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    String jsonData = response.body().string();
                    if (response.isSuccessful()) {
                        Log.v(TAG, jsonData);
                        mRestaurants = yelpService.processResults(response);
                    }
                    Log.v(TAG, jsonData);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
