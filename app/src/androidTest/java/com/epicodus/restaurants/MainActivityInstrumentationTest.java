package com.epicodus.restaurants;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by CGrahamS on 11/14/16.
 */
public class MainActivityInstrumentationTest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void validateEditText() {
        onView(withId(R.id.zipInput)).perform(typeText("Portland"))
                .check(matches(withText("Portland")));
    }

    @Test
    public void locationIstSentToRestaurantActivity() {
        String location = "Portland";
        onView(withId(R.id.zipInput)).perform(typeText(location));
        onView(withId(R.id.zipSubmit)).perform(click());
        onView(withId(R.id.restaurantDisplayText)).check(matches
                (withText("These are the restaurants nearest to " + location)));
    }

}
