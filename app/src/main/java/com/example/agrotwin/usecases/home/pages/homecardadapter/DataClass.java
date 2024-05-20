package com.example.agrotwin.usecases.home.pages.homecardadapter;

/**
 * Clase que representa los datos de una tarjeta de invernadero.
 * En versiones futuras se actualizará para mostrar las gráficas con sus respectivos datos
 * de la base de datos.
 * @author Adolfo Pérez-Gascón Valls
 */
public class DataClass {

    private String dataTitle;

    /**
     * Constructor que inicializa el título de los datos de la tarjeta.
     *
     * @param dataTitle El título de los datos.
     */
    public DataClass(String dataTitle) {
        this.dataTitle = dataTitle;
    }

    /**
     * Obtiene el título de los datos de la tarjeta.
     *
     * @return El título de los datos.
     */
    public String getDataTitle() {
        return dataTitle;
    }

}