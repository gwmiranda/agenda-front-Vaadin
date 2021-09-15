package com.example.application.data.entity;

public class Contato{

    private Integer contato;

    public Contato(){}

    public Contato(Integer contato) {
        this.contato = contato;
    }

    public java.lang.Integer getContato() {
        return contato;
    }

    public void setContato(java.lang.Integer contato) {
        this.contato = contato;
    }

    @Override
    public String toString() {
        return "Contato{" +
                "contato=" + contato +
                '}';
    }
}
