package com.example.application.data.entity;

import java.time.LocalDate;
import java.util.List;

public class Pessoa {

    private Integer id;
    private String nome;
    private String sobrenome;
    private String parentesco;
    private LocalDate nascimento;
    private List<Contato> contatos;

    public Pessoa(){}

    public Pessoa(java.lang.Integer id, String nome, String sobrenome, String parentesco, LocalDate nascimento, List<Contato> contatos) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.parentesco = parentesco;
        this.nascimento = nascimento;
        this.contatos = contatos;
    }

    public java.lang.Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate dataNascimento) {
        this.nascimento = dataNascimento;
    }

    public List<Contato> getContato() {
        return contatos;
    }

    public void setContato(List<Contato> contatos) {
        this.contatos = contatos;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", parentesco='" + parentesco + '\'' +
                ", nascimento=" + nascimento +
                ", contatos=" + contatos +
                '}';
    }
}
