package com.example.vifoods;

import androidx.fragment.app.Fragment;

/**
 * Активити авторизации
 * @author Vitaly Melnichenko
 * @version 1.0
 * // TODO: 26.01.21
 */

public class AuthActivity extends SingleFragmentActivity {

    @Override
    protected Fragment getFragment() {
        return AuthFragment.newInstance();
    }
}
