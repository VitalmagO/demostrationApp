package com.example.vifoods;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

public class AuthActivity extends AppCompatActivity {

    private EditText mLogin;
    private EditText mPassword;
    private Button mEnter;
    private Button mRegistration;

    private View.OnClickListener mOnEnterClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (isEmailValid() && isPasswordValid()) {
                // TODO: 20.01.21 Переход на главное окно  
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
            //todo
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