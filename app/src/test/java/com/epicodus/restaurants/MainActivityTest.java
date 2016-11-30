package com.epicodus.restaurants;

import android.content.Intent;
import android.os.Build;
import android.widget.TextView;

import com.epicodus.restaurants.ui.MainActivity;
import com.epicodus.restaurants.ui.RestaurantActivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowActivity;

import static junit.framework.Assert.assertTrue;

@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP)
@RunWith(RobolectricGradleTestRunner.class)

/**
 * Created by CGrahamS on 11/14/16.
 */
public class MainActivityTest {
    private MainActivity activity;

    @Before
    public void setup() {
        activity = Robolectric.setupActivity(MainActivity.class);
    }

    @Test
    public void validateTextViewContent() {
        TextView appHeader = (TextView) activity.findViewById(R.id.appHeader);
        assertTrue("¡Restaurants!".equals(appHeader.getText().toString()));
    }

    @Test
    public void secondActivityStarted() {
        activity.findViewById(R.id.zipSubmit).performClick();
        Intent expectedIntent = new Intent(activity, RestaurantActivity.class);
        ShadowActivity shadowActivity = org.robolectric.Shadows.shadowOf(activity);
        Intent actualIntent = shadowActivity.getNextStartedActivity();
        assertTrue(actualIntent.filterEquals(expectedIntent));
    }
}
