package ru.appline.logic;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Model implements Serializable {

    private static final Model instance = new Model();

    private final Map<String, Integer> model;

    public static Model getInstance() {
        return instance;
    }

    private Model() {
        model = new HashMap<>();
    }

    public void sum(String result, int a, int b) {
        model.put(result, a + b);
    }

    public void sub(String result, int a, int b) {
        model.put(result, a - b);
    }

    public void mul(String result, int a, int b) {
        model.put(result, a * b);
    }

    public void div(String result, int a, int b) {
        model.put(result, a / b);
    }

    public Map<String, Integer> getFromList() {
        return model;
    }
}
