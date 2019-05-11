package me.mehdihasan.testingexample;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * required-for-robolectric (4)
 *
 * Robolectric is a framework that allows you to write unit tests and
 * run them on a desktop JVM while still using Android API.
 *
 * Robolectric provides a JVM compliant version of the android.jar file.
 * Robolectric handles inflation of views, resource loading, and lots of
 * other stuff that’s implemented in native C code on Android devices.
 *
 * This enables you to run your Android tests in your continuous
 * integration environment without any additional setup. Robolectric
 * supports resource handling, e.g., inflation of views. You can also
 * use the findViewById() to search in a view.
 *
 * Robolectric is not an integration test framework, i.e., you cannot
 * not test the interaction of Android components with it.
 *
 * Robolectric does not require additional mocking frameworks, of
 * course it is still possible to use frameworks like Mockito if desired.
 *
 */
@RunWith(RobolectricTestRunner.class)
public class LoginActivityRoboElectricTest {

    private LoginActivity loginActivity;

    private EditText emailEditText;
    private EditText passwordEditText;
    private Button loginButton;
    private TextView resultTextView;

    @Before
    public void setUp() throws Exception {
        loginActivity = Robolectric.buildActivity(LoginActivity.class)
                .create()
                //.resume()
                .get();

        emailEditText = loginActivity.findViewById(R.id.emailEditText);
        passwordEditText = loginActivity.findViewById(R.id.passwordEditText);
        loginButton = loginActivity.findViewById(R.id.button);
        resultTextView = loginActivity.findViewById(R.id.errorText);
        // TextView resultTextView = Shadows.shadowOf(loginActivity).getContentView().findViewById(R.id.errorText);
    }

    /**
     * Robolectric replaced all Android classes by so-called shadow objects.
     * If a method is implemented by Robolectric, it forwards these
     * method calls to the shadow object. Shadow objects behave similar
     * to the Android implementation. If a method is not implemented
     * by the shadow object, it simply returns a default value, e.g., null or 0.
     *
     * To access a shadow object use Shadows.shadowOf.
     *
     * @throws Exception
     */
    @Test
    public void loginTestSuccess() throws Exception {
        emailEditText.setText("oroni@gmail.com");
        passwordEditText.setText("123456789");

        loginButton.performClick();

        assertThat(
                resultTextView.getText().toString(),
                equalTo("Login success"));
        // assertThat(ShadowToast.getTextOfLatestToast(), equalTo("Lala") ); // to test Toast
    }

    @Test
    public void loginTestFailForEmail() throws Exception {
        emailEditText.setText("dfgdgfg");
        passwordEditText.setText("123456789");

        loginButton.performClick();

        assertThat(
                resultTextView.getText().toString(),
                equalTo("Invalid email address"));
    }

    @Test
    public void loginTestFailForTooShortPassword() throws Exception {
        emailEditText.setText("oroni@gmail.com");
        passwordEditText.setText("12345");

        loginButton.performClick();

        assertThat(
                resultTextView.getText().toString(),
                equalTo("The provided password is too short"));
    }

    @Test
    public void loginTestFailForEmptyPassword() throws Exception {
        emailEditText.setText("oroni@gmail.com");
        passwordEditText.setText("");

        loginButton.performClick();

        assertThat(
                resultTextView.getText().toString(),
                equalTo("The provided password is invalid"));
    }
}
