package ni.edu.unan.aventura_pirata.datos;

import android.content.res.AssetManager;

import org.json.JSONObject;

import java.io.InputStream;

/**
 * Created by SARA on 2/11/2017.
 */

public class JsonReader {
    public static JSONObject readFromFile(String file, AssetManager asset){
        try
        {
            InputStream stream = asset.open(file);

            int size = stream.available();

            byte[] buffer = new byte[size];

            stream.read(buffer);

            stream.close();

            String jsonString = new String(buffer, "UTF-8");

            return new JSONObject(jsonString);
        } catch (Exception e) {
            e.printStackTrace();
            return  null;
        }
    }
}
