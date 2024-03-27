package com.purplegym.purplegymweb.domain.usuarios;

public enum Origem {

    INTERNO(0),
    EXTERNO(1);

    private Integer enumValue;

    Origem(Integer enumValue) {
        this.enumValue = enumValue;
    }

    public Integer getEnumValue() {
        return enumValue;
    }
}
