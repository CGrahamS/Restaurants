package com.epicodus.restaurants;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button mZipSubmit;
    private EditText mZipInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mZipInput = (EditText) findViewById(R.id.zipInput);
        mZipSubmit = (Button) findViewById(R.id.zipSubmit);
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
