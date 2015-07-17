package edu.acmatucf.stemdayapp;

/**
 * Created by Nathaniel on 7/16/2015.
 */
public class JSONObject {
    private String JSONString;

    public JSONObject(String JSONString) {
        this.JSONString = JSONString;
    }

    /*
    *
    * Returns The Requested Attribute.
    *
    * */
    public String getAttrib(String id) {
        StringBuilder attrib = new StringBuilder();
        boolean flag = false;
        for(int i=JSONString.indexOf("\"" + id + "\"")+("\"" + id + "\":").length();i<JSONString.length();i++) {
            if(JSONString.charAt(i) == '\"') {
                i++;
                while(JSONString.charAt(i) != '\"') {
                    attrib.append(JSONString.charAt(i));
                    i++;
                }
                break;
            }
        }


        return attrib.toString();
    }
}
