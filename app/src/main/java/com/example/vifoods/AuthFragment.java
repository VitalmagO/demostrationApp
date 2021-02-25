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
    private SharedPreferencesHelper mSharedPreferencesHelper;

    public static AuthFragment newInstance() {
        
        Bundle args = new Bundle();
        
        AuthFragment fragment = new AuthFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private View.OnClickListener mOnEnterClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            boolean isLoginSuccess = false;
            for (User user : mSharedPreferencesHelper.getUsers()
                 ) {
                if (user.getLogin().equalsIgnoreCase(mLogin.getText().toString())
                        && user.getPassword().equals(mPassword.getText().toString())) {
                    isLoginSuccess = true;
                    if (isEmailValid() && isPasswordValid()) {
                        Intent startProfileIntent = new Intent(getActivity(), ProfileActivity.class);
                        startProfileIntent.putExtra(ProfileActivity.USER_KEY,
                                new User(mLogin.getText().toString(), mPassword.getText().toString()));
                        startActivity(startProfileIntent);
                    } else {
                        showMessage(R.string.login_error_input);
                    }
                    break;
                }
            }
            if (!isLoginSuccess) {
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
            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, RegistrationFragment.newInstance())
                    .addToBackStack(RegistrationFragment.class.getName())
                    .commit();
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

        mSharedPreferencesHelper = new SharedPreferencesHelper(getActivity());

        mLogin = v.findViewById(R.id.etLogin);
        mPassword = v.findViewById(R.id.etPassword);
        mEnter = v.findViewById(R.id.btnEnter);
        mRegistration = v.findViewById(R.id.btnRegistration);

        mEnter.setOnClickListener(mOnEnterClickListener);
        mRegistration.setOnClickListener(mOnRegistrationClickListener);
        return v;
    }
}