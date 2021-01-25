package com.example.vifoods;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

/**
 * Окно профиля, содержащее основную информацию об аккаунте
 * @author Vitaly Melnichenko
 * @version 1.0
 */

public class ProfileActivity extends AppCompatActivity {

    public static final String USER_KEY = "USER_KEY";

    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };
    private AppCompatImageView mPhoto;
    private TextView mLogin;
    private TextView mPassword;
    private User mUser;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_profile);

        mPhoto = findViewById(R.id.ivPhoto);
        mLogin = findViewById(R.id.tvEmail);
        mPassword = findViewById(R.id.tvPassword);

        Bundle bundle = getIntent().getExtras();
        mUser = (User) bundle.get(USER_KEY);
        mLogin.setText(bundle.getString(mUser.getLogin()));
        mPassword.setText(bundle.getString(mUser.getPassword()));

        mPhoto.setOnClickListener(mOnClickListener);
    }
}
