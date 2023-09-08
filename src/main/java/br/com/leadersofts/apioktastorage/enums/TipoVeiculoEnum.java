package br.com.leadersofts.apioktastorage.enums;

public enum TipoVeiculoEnum {

    MOTORCYCLE("Moto"),
    AUTOMOBIL("Carro"),
    TRUCK("Caminhao");

    private String value;

    TipoVeiculoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
