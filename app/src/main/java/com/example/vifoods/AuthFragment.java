package com.example.vifoods;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;

/**
 * Главное окно приложения. Авторизация и создание аккаунта.
 * @author Vitaly Melnichenko
 * @version 1.0
 */

public class AuthFragment extends Fragment {

    private EditText mLogin;
    private EditText mPassword;
    private Button mEnter;
    private Button mRegistration;

    public static AuthFragment newInstance() {
        
        Bundle args = new Bundle();
        
        AuthFragment fragment = new AuthFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private View.OnClickListener mOnEnterClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // TODO: 21.01.21 Переход в окно профиля
            if (isEmailValid() && isPasswordValid()) {
                Intent startProfileIntent = new Intent(getActivity(), ProfileActivity.class);
                startProfileIntent.putExtra(ProfileActivity.USER_KEY,
                        new User(mLogin.getText().toString(), mPassword.getText().toString()));
                startActivity(startProfileIntent);
            } else {
                showMessage(R.string.login_error_input);
            }
        }
    };

    private void showMessage(@StringRes int str) {
        Toast.makeText(getActivity(), str, Toast.LENGTH_LONG).show();
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

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fr_auth, container, false);

        mLogin = v.findViewById(R.id.etLogin);
        mPassword = v.findViewById(R.id.etPassword);
        mEnter = v.findViewById(R.id.btnEnter);
        mRegistration = v.findViewById(R.id.btnRegistration);

        mEnter.setOnClickListener(mOnEnterClickListener);
        mRegistration.setOnClickListener(mOnRegistrationClickListener);
        return v;
    }
}