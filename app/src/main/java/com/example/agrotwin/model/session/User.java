package com.example.agrotwin.model.session;

/**
 * Clase que representa un usuario en la sesión de la aplicación.
 * Contiene el nombre de usuario y la contraseña del usuario.
 * @author Adolfo Pérez-Gascón Valls
 */
public class User {
    private String username;
    private String password;

    public User() {
        username = "admin";
        password = "admin";
    }

    /**
     * Obtiene el nombre de usuario.
     *
     * @return El nombre de usuario.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Establece el nombre de usuario.
     *
     * @param username El nuevo nombre de usuario a establecer.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Obtiene la contraseña.
     *
     * @return La contraseña.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Establece la contraseña.
     *
     * @param password La nueva contraseña a establecer.
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
