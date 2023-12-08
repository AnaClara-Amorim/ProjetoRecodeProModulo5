package com.agenciahorizonteaberto.apiagenciahorizonteaberto.models;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
public class UserModel {

    @Id
    private String id;
    private String cpf;
    private String nome;
    private String senha;

    private List<PacoteModel> pacotes = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<PacoteModel> getPacotes() {
        return pacotes;
    }

    public void setPacotes(List<PacoteModel> pacotes) {
        this.pacotes = pacotes;
    }
            
}
