package br.com.leadersofts.apioktastorage.enums;

public enum OrigemEnum {

    FIAT("Fiat"),
    BR("BR");

    private String value;

    OrigemEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
