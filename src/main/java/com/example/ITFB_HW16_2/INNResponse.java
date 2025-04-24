package com.example.ITFB_HW16_2;

public class INNResponse {
    private String message;
    private String organizationName;

    // конструктор по умолчанию
    public INNResponse() {}

    // конструктор с параметрами
    public INNResponse(String message, String organizationName) {
        this.message = message;
        this.organizationName = organizationName;
    }

    // геттеры и сеттеры
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }
}
