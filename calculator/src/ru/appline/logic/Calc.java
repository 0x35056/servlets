package ru.appline.logic;

public class Calc {

    private int a;
    private int b;
    private String math;

    public Calc(int a, int b, String math) {
        this.a = a;
        this.b = b;
        this.math = math;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public String getMath() {
        return math;
    }

    public void setMath(String math) {
        this.math = math;
    }
}
