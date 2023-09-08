package br.com.leadersofts.apioktastorage.enums;

public enum StatusEnum {

    FREE("Liberado"),
    BLOCKED("Bloqueado"),
    PREFREE("Pré-Liberado"),
    CLIENT("Cliente");

    private String value;

    StatusEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
