package com.example.agrotwin.usecases.auth;

import com.example.agrotwin.R;

/**
 * ViewModel para la actividad de inicio de sesión.
 * Proporciona las referencias a los recursos de cadena utilizados en la interfaz de inicio de sesión.
 * @author Adolfo Pérez-Gascón Valls
 */
public class LoginViewModel {

    // Strings
    private final int LOGGED_IN = R.string.sesionIniciada;
    private final int PROVIDE_USER_PASS = R.string.enterUserPass;
    private final int INVALID_USER_PASS = R.string.invalidUserPass;

    /**
     * Obtiene el recurso de cadena para el mensaje de sesión iniciada.
     *
     * @return El ID del recurso de cadena para el mensaje de sesión iniciada.
     */
    public int getLoggedIn() {
        return LOGGED_IN;
    }

    /**
     * Obtiene el recurso de cadena para el mensaje de proporcionar usuario y contraseña.
     *
     * @return El ID del recurso de cadena para el mensaje de proporcionar usuario y contraseña.
     */
    public int getProvideUserPass() {
        return PROVIDE_USER_PASS;
    }

    /**
     * Obtiene el recurso de cadena para el mensaje de usuario o contraseña inválidos.
     *
     * @return El ID del recurso de cadena para el mensaje de usuario o contraseña inválidos.
     */
    public int getInvalidUserPass() {
        return INVALID_USER_PASS;
    }
}
