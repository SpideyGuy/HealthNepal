package org.samriddhi.healthnepal;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    Button login;
    EditText email, password;

    TextView register;

    SharedPreferences sharedPreferences;

    SharedPreferences.Editor editor;

    final String PREFERENCES_NAME = "user_data";
    final String USER_EMAIL = "user_email";
    final String USER_PASSWORD = "user_password";

    final String IS_LOGGED_IN = "logged_in";

    String stringEmail, stringPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = (Button) findViewById(R.id.btn_login);
        email = (EditText) findViewById(R.id.et_email);
        password = (EditText) findViewById(R.id.et_pwd);

        register = (TextView) findViewById(R.id.tv_register);

        sharedPreferences = getSharedPreferences(PREFERENCES_NAME, MODE_PRIVATE);

        editor = sharedPreferences.edit();

        stringEmail = sharedPreferences.getString(USER_EMAIL, "");
        stringPassword = sharedPreferences.getString(USER_PASSWORD, "");

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(email.getText().toString()
                        .equalsIgnoreCase(stringEmail) &&
                        password.getText().toString().equals(stringPassword)){
                    editor.putBoolean(IS_LOGGED_IN, true);
                    editor.commit();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

    }
}
