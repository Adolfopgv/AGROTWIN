package com.example.agrotwin.usecases.auth;

import com.example.agrotwin.R;

public class LoginViewModel {

    // Strings
    private final int LOGGED_IN = R.string.sesionIniciada;
    private final int PROVIDE_USER_PASS = R.string.enterUserPass;
    private final int INVALID_USER_PASS = R.string.invalidUserPass;

    public int getLoggedIn() {
        return LOGGED_IN;
    }

    public int getProvideUserPass() {
        return PROVIDE_USER_PASS;
    }

    public int getInvalidUserPass() {
        return INVALID_USER_PASS;
    }
}
