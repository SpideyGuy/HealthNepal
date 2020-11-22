package org.samriddhi.healthnepal;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    //FullName - * - ET
    //Contact Number - * - ET
    //Email Address - * - ET
    //Address - * - ET
    //Age - * - ET
    //Blood Group - Opt - Spinner (ET)
    //Gender - * - RadioButton (RadioGroup)
    //Password - * - ET

//    Sqlite

//    SharePreferences - UserDetails, Logged in or not?

    EditText email, password;

    Button register;

    SharedPreferences sharedPreferences;

    SharedPreferences.Editor editor;

    final String PREFERENCES_NAME = "user_data";
    final String USER_EMAIL = "user_email";
    final String USER_PASSWORD = "user_password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        email = (EditText) findViewById(R.id.etEmail);
        password = (EditText) findViewById(R.id.etPassword);

        register = (Button) findViewById(R.id.btnRegister);

        sharedPreferences = getSharedPreferences(PREFERENCES_NAME, MODE_PRIVATE);

        editor = sharedPreferences.edit();

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailString = email.getText().toString();
                String passwordString = password.getText().toString();
                editor.putString(USER_EMAIL, emailString);
                editor.putString(USER_PASSWORD, passwordString);
                editor.commit();
            }
        });
    }
}
