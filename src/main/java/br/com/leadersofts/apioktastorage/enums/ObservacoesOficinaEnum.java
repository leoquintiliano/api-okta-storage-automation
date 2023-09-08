package br.com.leadersofts.apioktastorage.enums;

public enum ObservacoesOficinaEnum {

    REVISAO("Revisão"),
    MECANICA("Mecânica"),
    POLIMENTO("Polimento"),

    PINTURA("Pintura"),
    FUNILARIA("Funilaria"),
    HIGIENIZACAO("Higienização"),
    TRANSFERENCIA("Transferência");

    private String value;

    ObservacoesOficinaEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
