package com.example.agrotwin.model.domain;

/**
 * Clase Singleton para gestionar el tamaño de la fuente en toda la aplicación.
 * Esta clase asegura que solo exista una instancia de sí misma y proporciona
 * métodos para obtener y establecer el tamaño del texto.
 * @author Adolfo Pérez-Gascón Valls
 */
public class FontSizeManager {
    private static FontSizeManager instance;
    private int textSize = 18;

    private FontSizeManager() {}

    /**
     * Obtiene la instancia única de FontSizeManager. Si no existe, se crea una nueva.
     *
     * @return La instancia única de FontSizeManager.
     */
    public static FontSizeManager getInstance() {
        return instance == null ?
                instance = new FontSizeManager() : instance;
    }

    /**
     * Obtiene el tamaño del texto actual.
     *
     * @return El tamaño del texto.
     */
    public int getTextSize() {
        return textSize;
    }

    /**
     * Establece un nuevo tamaño para el texto.
     *
     * @param textSize El nuevo tamaño del texto a establecer.
     */
    public void setTextSize(int textSize) {
        this.textSize = textSize;
    }
}

