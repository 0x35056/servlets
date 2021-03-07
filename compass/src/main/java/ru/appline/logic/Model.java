package ru.appline.logic;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Model implements Serializable {

    private static final Model instance = new Model();

    private final Map<String, Compass> modelCompass;

    public Model(){
        modelCompass = new HashMap<String, Compass>();
    }

    public static Model getInstance(){
        return instance;
    }

    public void add(Compass compass) {
        modelCompass.put("compass", compass);
    }

    public Map<String, Compass> getFromList() {
        return modelCompass;
    }

    public Map<String, String> getSide(int degree) {

        Map<String, String> side = new HashMap<String, String>();

            if (degree <= 23){
                side.put("side", "north");
            } else if (degree < 68) {
                side.put("side", "north-east");
            } else if (degree < 113) {
                side.put("side", "east");
            } else if (degree < 158) {
                side.put("side", "south-east");
            } else if (degree < 203) {
                side.put("side", "south");
            } else if (degree < 248) {
                side.put("side", "south-west");
            } else if (degree < 293) {
                side.put("side", "west");
            } else if (degree < 338) {
                side.put("side", "north-west");
            } else if (degree < 359) {
                side.put("side", "north");
            }

        return side;
    }
}