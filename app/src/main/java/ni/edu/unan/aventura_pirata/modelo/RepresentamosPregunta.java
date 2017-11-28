package ni.edu.unan.aventura_pirata.modelo;

/**
 * Created by Lester Mendoza on 27/11/2017.
 */

public class RepresentamosPregunta {
    private int id;
    private int respuesta;
    private int denominador;
    public RepresentamosPregunta(int id, int respuesta, int denominador) {
        this.id = id;
        this.respuesta = respuesta;
        this.denominador = denominador;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(int respuesta) {
        this.respuesta = respuesta;
    }

    public int getDenominador() {
        return denominador;
    }

    public void setDenominador(int denominador) {
        this.denominador = denominador;
    }
}
