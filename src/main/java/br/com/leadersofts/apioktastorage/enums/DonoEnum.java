package br.com.leadersofts.apioktastorage.enums;

public enum DonoEnum {

    FIAT("Fiat"),
    ANDRE("André"),
    AUGUSTO("Augusto");

    private String value;

    DonoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
