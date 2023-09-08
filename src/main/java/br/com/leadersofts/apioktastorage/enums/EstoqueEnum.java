package br.com.leadersofts.apioktastorage.enums;

public enum EstoqueEnum {

    ITAJUBA("Itajubá"),
    SAO_LOURENCO("São Lourenço"),
    CLIENT("Cliente");

    private String value;

    EstoqueEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
