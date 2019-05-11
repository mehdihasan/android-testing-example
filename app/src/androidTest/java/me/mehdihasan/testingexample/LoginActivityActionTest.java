package me.mehdihasan.testingexample;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.rule.ActivityTestRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class LoginActivityActionTest {

    @Rule
    public ActivityTestRule<LoginActivity> activityRule
            = new ActivityTestRule<>(LoginActivity.class);

    @Before
    public void setUp() {
        activityRule.getActivity();
    }

    @Test
    public void loginTestSuccess() throws Exception {
        // Type text
        onView(withId(R.id.emailEditText))
                .perform(typeText("oroni@gmail.com"));
        onView(withId(R.id.passwordEditText))
                .perform(typeText("123456789"))
                .perform(closeSoftKeyboard());

        //Thread.sleep(250);

        // press the button
        onView(withId(R.id.button)).perform(click());

        // Check that the result has changed
        onView(withId(R.id.errorText))
                .check(matches(withText("Login success")));
    }

    @Test
    public void loginTestFailForEmail() throws Exception {
        // Type text
        onView(withId(R.id.emailEditText))
                .perform(typeText("dfgdgfg"));
        onView(withId(R.id.passwordEditText))
                .perform(typeText("123456789"))
                .perform(closeSoftKeyboard());

        //Thread.sleep(250);

        // press the button
        onView(withId(R.id.button)).perform(click());

        // Check that the result has changed
        onView(withId(R.id.errorText))
                .check(matches(isDisplayed()))
                .check(matches(withText("Invalid email address")));
    }

    @Test
    public void loginTestFailForTooShortPassword() throws Exception {
        // Type text
        onView(withId(R.id.emailEditText))
                .perform(typeText("oroni@gmail.com"));
        onView(withId(R.id.passwordEditText))
                .perform(typeText("12345"))
                .perform(closeSoftKeyboard());

        //Thread.sleep(250);

        // press the button
        onView(withId(R.id.button)).perform(click());

        // Check that the result has changed
        onView(withId(R.id.errorText))
                .check(matches(withText("The provided password is too short")));
    }

    @Test
    public void loginTestFailForEmptyPassword() throws Exception {
        // Type text
        onView(withId(R.id.emailEditText))
                .perform(typeText("oroni@gmail.com"));
        onView(withId(R.id.passwordEditText))
                .perform(typeText(""))
                .perform(closeSoftKeyboard());

        //Thread.sleep(250);

        // press the button
        onView(withId(R.id.button)).perform(click());

        // Check that the result has changed
        onView(withId(R.id.errorText))
                .check(matches(withText("The provided password is invalid")));
    }
}
