package br.com.cadastroescolar.model;

import java.util.Date;

public class Car {
    private String id;
    private String name;
    private String cpf;
    private String rg;
    private String nascimento;
    private String email;
    private String telefone;
    private String cep;
    private String logradouro;
    private String complemento;


    public Car(String name) {
        this.name = name;
    }

    public Car(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Car(String id, String name, String cpf, String rg, String nascimento, String email, String telefone, String cep, String logradouro, String complemento) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.rg = rg;
        this.nascimento = nascimento;
        this.email = email;
        this.telefone = telefone;
        this.cep = cep;
        this.logradouro = logradouro;
        this.complemento = complemento;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public String getRg() {
        return rg;
    }

    public String getNascimento() {
        return nascimento;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getComplemento() {
        return complemento;
    }
}

