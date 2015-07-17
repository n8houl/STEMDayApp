package edu.acmatucf.stemdayapp;

import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class JSONHelper {

    /**
    * Retrieves the List of Events From the URL Passed to it
    **/
    public static String readURL(String site) throws Exception {
        URL url = new URL(site);
        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

        String inputLine;
        StringBuilder str = new StringBuilder(in.readLine());
        while ((inputLine = in.readLine()) != null)
            str.append(inputLine);
        in.close();
        str.trimToSize();
        return str.toString();
    }

    /*
    * Static Method, Returns ArrayList of Schedule Objects
    *
    * Used to Split up JSON String from network into Several different Schedule Objects
    * */
    public static ArrayList<JSONObject> split(String JSONString) {
        ArrayList<JSONObject> objectList = new ArrayList<JSONObject>();

        for(int i=0;i<JSONString.length();i++) {
            if(JSONString.charAt(i) == '{') {
                StringBuilder objString = new StringBuilder();
                while(JSONString.charAt(i) != '}') {
                    objString.append(JSONString.charAt(i));
                    i++;
                }
                objString.append(JSONString.charAt(i));
                objectList.add(new JSONObject(objString.toString()));
            }
        }

        return objectList;
    }
}
