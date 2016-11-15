package com.epicodus.restaurants;

import android.os.Build;
import android.widget.ListView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP)
@RunWith(RobolectricGradleTestRunner.class)
/**
 * Created by Guest on 11/15/16.
 */
public class RestaurantActivityTest {
    private RestaurantActivity activity;
    private ListView mRestaurantList;

    @Before
    public void setup() {
        activity = Robolectric.setupActivity(RestaurantActivity.class);
        mRestaurantList = (ListView) activity.findViewById(R.id.restaurantList);
    }

    @Test
    public void restaurantListViewPopulates() {
        assertNotNull(mRestaurantList.getAdapter());
        assertEquals(mRestaurantList.getAdapter().getCount(), 15);
    }
}
