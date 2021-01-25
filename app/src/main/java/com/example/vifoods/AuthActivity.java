package com.example.vifoods;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Главное окно приложения. Авторизация и создание аккаунта.
 * @author Vitaly Melnichenko
 * @version 1.0
 */

public class AuthActivity extends AppCompatActivity {

    private EditText mLogin;
    private EditText mPassword;
    private Button mEnter;
    private Button mRegistration;

    private View.OnClickListener mOnEnterClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // TODO: 21.01.21 Переход в окно профиля
            if (isEmailValid() && isPasswordValid()) {
                Intent startProfileIntent = new Intent(AuthActivity.this, ProfileActivity.class);
                startProfileIntent.putExtra(ProfileActivity.USER_KEY,
                        new User(mLogin.getText().toString(), mPassword.getText().toString()));
                startActivity(startProfileIntent);
            } else {
                showMessage(R.string.login_error_input);
            }
        }
    };

    private void showMessage(@StringRes int str) {
        Toast.makeText(this, str, Toast.LENGTH_LONG).show();
    }

    private View.OnClickListener mOnRegistrationClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // TODO: 25.01.21 Переход в окно регистрации пользователя
        }
    };

    private boolean isEmailValid() {
        return !TextUtils.isEmpty(mLogin.getText())
                && Patterns.EMAIL_ADDRESS.matcher(mLogin.getText()).matches();
    }

    private boolean isPasswordValid() {
        return !TextUtils.isEmpty(mPassword.getText());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_auth);

        mLogin = findViewById(R.id.etLogin);
        mPassword = findViewById(R.id.etPassword);
        mEnter = findViewById(R.id.btnEnter);
        mRegistration = findViewById(R.id.btnRegistration);

        mEnter.setOnClickListener(mOnEnterClickListener);
        mRegistration.setOnClickListener(mOnRegistrationClickListener);
    }
}