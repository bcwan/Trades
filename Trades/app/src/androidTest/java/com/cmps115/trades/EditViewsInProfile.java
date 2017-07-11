package com.cmps115.trades;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.core.deps.guava.util.concurrent.Service;
import android.support.test.rule.ActivityTestRule;
import android.support.test.rule.ServiceTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.action.ViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isClickable;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsInstanceOf.any;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.*;

import static android.support.test.espresso.Espresso.onView;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class EditViewsInProfile {

    private static final String STRING_TO_BE_TYPED_FIRST = "Sid";
    private static final String STRING_TO_BE_TYPED_LAST = "Gilela";
    private static final String STRING_TO_BE_TYPED_EMAIL = "myemail";
    private static final String STRING_TO_BE_TYPED_PHONE = "5101234567";

    @Rule
    public ActivityTestRule<ProfileLast> rule = new ActivityTestRule<ProfileLast>(ProfileLast.class);

    @Test
    public void fillInFirstNameData() throws Exception {

        String expectedString = "Sid";
        onView(withId(R.id.firstName)).perform(typeText(STRING_TO_BE_TYPED_FIRST), closeSoftKeyboard()).check(matches(withText(expectedString)));

        String expectedLastName = "Gilela";
        onView(withId(R.id.lastName)).perform(typeText(STRING_TO_BE_TYPED_LAST), closeSoftKeyboard()).check(matches(withText(expectedLastName)));

        String expectedemail = "myemail";
        onView(withId(R.id.email)).perform(typeText(STRING_TO_BE_TYPED_EMAIL), closeSoftKeyboard()).check(matches(withText(expectedemail)));

        String expectedphone = "5101234567";
        onView(withId(R.id.phone)).perform(typeText(STRING_TO_BE_TYPED_PHONE), closeSoftKeyboard()).check(matches(withText(expectedphone)));

    }
}
