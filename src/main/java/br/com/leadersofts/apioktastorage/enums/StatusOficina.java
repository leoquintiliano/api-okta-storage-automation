package br.com.leadersofts.apioktastorage.enums;

import lombok.Data;
import lombok.Getter;

@Getter
public enum StatusOficina {

    AGUARDANDO("A"),
    FINALIZADO("S"),
    EM_PROCESSO("P");

    private String value;

    StatusOficina(String value) {
        this.value = value;
    }
}
