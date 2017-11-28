package ni.edu.unan.aventura_pirata.datos;

import android.content.res.AssetManager;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import ni.edu.unan.aventura_pirata.modelo.RepresentamosPregunta;

/**
 * Created by SARA on 2/11/2017.
 */

public class FraccionDatos {
    public static List<RepresentamosPregunta> getDatos(AssetManager manager){
        List<RepresentamosPregunta> datos = new ArrayList<>();

        JSONObject json = JsonReader.readFromFile("representamos.json", manager);

        try {
            JSONArray data = json.getJSONArray("data");

            for (int i=0;i<data.length();i++){
                JSONObject jObj = data.getJSONObject(i);

                RepresentamosPregunta fraccion = new RepresentamosPregunta(jObj.getInt("id"), jObj.getInt("respuesta"), jObj.getInt("denominador"));

                datos.add(fraccion);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return datos;
    }
}
