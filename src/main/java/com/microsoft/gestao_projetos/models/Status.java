package com.microsoft.gestao_projetos.models;

public enum Status {
    NAO_INICIADO(1),
    EM_ANDAMENTO(2),
    FINALIZADO(3),
    CANCELADO(4);

    private final int value;

    Status(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Status fromValue(int value) {
        for (Status status : Status.values()) {
            if (status.value == value) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid status value: " + value);
    }
}