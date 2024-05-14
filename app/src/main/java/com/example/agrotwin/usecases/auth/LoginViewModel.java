package com.example.agrotwin.usecases.auth;

import com.example.agrotwin.R;

public class LoginViewModel {

    // Strings
    private final String LOGGED_IN = String.valueOf(R.string.sesionIniciada);
    private final String PROVIDE_USER_PASS = String.valueOf(R.string.enterUserPass);
    private final String INVALID_USER_PASS = String.valueOf(R.string.invalidUserPass);

    public String getLoggedIn() {
        return LOGGED_IN;
    }

    public String getProvideUserPass() {
        return PROVIDE_USER_PASS;
    }

    public String getInvalidUserPass() {
        return INVALID_USER_PASS;
    }
}
