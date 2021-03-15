package ru.appline.logic;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Model implements Serializable {

    private static final Model instance = new Model();

    private final Map<String, Float> model;

    public static Model getInstance() {
        return instance;
    }

    private Model() {
        model = new HashMap<>();
    }

    public void sum(String result, float a, float b) {
        model.put(result, a + b);
    }

    public void sub(String result, float a, float b) {
        model.put(result, a - b);
    }

    public void mul(String result, float a, float b) {
        model.put(result, a * b);
    }

    public void div(String result, float af, float bf) {
        model.put(result, af / bf);
    }

    public Map<String, Float> getFromList() {
        return model;
    }
}
