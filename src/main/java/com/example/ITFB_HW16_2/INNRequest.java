package com.example.ITFB_HW16_2;

public class INNRequest {
    private String inn;

    // конструктор по умолчанию
    public INNRequest() {}

    // конструктор с параметрами
    public INNRequest(String inn) {
        this.inn = inn;
    }

    // геттеры и сеттеры
    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }
}