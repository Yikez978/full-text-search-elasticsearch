package br.com.sabino.lab.elk.domain;

public enum StatusPedido {

    ABERTO("ABERTO"), CONCLUIDO("CONCLUIDO"), CANCELADO("CANCELADO");

    private final String status;

    private StatusPedido(String statusPedido) {
        status = statusPedido;
    }

    public String toString() {
        return this.status;
    }
}