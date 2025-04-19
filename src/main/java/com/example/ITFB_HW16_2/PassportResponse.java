package com.example.ITFB_HW16_2;

public class PassportResponse {
    private boolean isValid;

    //конструктор по умолчанию
    public PassportResponse() {}

    public PassportResponse(boolean isValid) {
        this.isValid = isValid;
    }

    //геттер
    public boolean isValid() {
        return isValid;
    }

    //сеттер
    public void setValid(boolean valid) {
        isValid = valid;
    }
}
