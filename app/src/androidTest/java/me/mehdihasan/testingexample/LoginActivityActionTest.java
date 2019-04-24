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
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class LoginActivityActionTest {

    private String passEmail = "mail@oroni.com";
    private String passPassword = "123456789";
    private String failEmail = "123456789";
    private String failPassword = "123456";

    @Rule
    public ActivityTestRule<LoginActivity> activityRule
            = new ActivityTestRule<>(LoginActivity.class);

    @Before
    public void setUp() {}

    @Test
    public void loginTestSuccess() {
        // Type text
        onView(withId(R.id.emailEditText))
                .perform(typeText(passEmail));
        onView(withId(R.id.passwordEditText))
                .perform(typeText(passPassword));

        // press the button
        onView(withId(R.id.button)).perform(click());

        // Check that the result has changed
        onView(withId(R.id.errorText)).check(matches(withText("Login success")));
    }

    @Test
    public void loginTestFailForEmail() {
        // Type text
        onView(withId(R.id.emailEditText))
                .perform(typeText(failEmail));
        onView(withId(R.id.passwordEditText))
                .perform(typeText(passPassword));

        // press the button
        onView(withId(R.id.button)).perform(click());

        // Check that the result has changed
        onView(withId(R.id.errorText)).check(matches(withText("Invalid email address")));
    }

    @Test
    public void loginTestFailForTooShortPassword() {
        // Type text
        onView(withId(R.id.emailEditText))
                .perform(typeText(passEmail));
        onView(withId(R.id.passwordEditText))
                .perform(typeText(failPassword));

        // press the button
        onView(withId(R.id.button)).perform(click());

        // Check that the result has changed
        onView(withId(R.id.errorText)).check(matches(withText("The provided password is too short")));
    }

    @Test
    public void loginTestFailForEmptyPassword() {
        // Type text
        onView(withId(R.id.emailEditText))
                .perform(typeText(passEmail));
        onView(withId(R.id.passwordEditText))
                .perform(typeText(""));

        // press the button
        onView(withId(R.id.button)).perform(click());

        // Check that the result has changed
        onView(withId(R.id.errorText)).check(matches(withText("The provided password is invalid")));
    }
}
