package com.epicodus.restaurants;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.zipSubmit) Button mZipSubmit;
    @Bind(R.id.zipInput) EditText mZipInput;
    @Bind(R.id.appHeader) TextView mAppHeader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mZipSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String location = mZipInput.getText().toString();
                Intent intent = new Intent(MainActivity.this, RestaurantActivity.class);
                intent.putExtra("location", location);
                startActivity(intent);
            }
        });
    }
}
