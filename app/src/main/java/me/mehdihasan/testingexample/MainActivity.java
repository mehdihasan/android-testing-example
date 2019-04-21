package me.mehdihasan.testingexample;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private LoginUtils loginUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginUtils = new LoginUtils();

        Button loginButton = findViewById(R.id.button);
        EditText emailEditText = findViewById(R.id.emailEditText);
        EditText passwordEditText = findViewById(R.id.passwordEditText);
        TextView errorText = findViewById(R.id.errorText);

        loginButton.setOnClickListener(v -> {

            // case 02
            if (TextUtils.isEmpty(passwordEditText.getEditableText().toString().trim())) {
                errorText.setText("The provided password is invalid");
                return;
            }

            // case 01
            if (!loginUtils.isValidPassword(passwordEditText.getEditableText().toString())) {
                errorText.setText("The provided password is too short");
                return;
            }

            if (!loginUtils.isValidEmailAddress(emailEditText.getEditableText().toString())) {
                errorText.setText("Invalid email address");
                return;
            }

            errorText.setText("Login success");
        });
    }
}
