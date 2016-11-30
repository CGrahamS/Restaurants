package com.epicodus.restaurants.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.epicodus.restaurants.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.zipSubmit) Button mZipSubmit;
    @Bind(R.id.zipInput) EditText mZipInput;
    @Bind(R.id.appHeader) TextView mAppHeader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mZipSubmit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == mZipSubmit) {
            String location = mZipInput.getText().toString();
            Intent intent = new Intent(MainActivity.this, RestaurantListActivity.class);
            intent.putExtra("location", location);
            startActivity(intent);
        }

    }
}
