/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalhobd.model.entidades;

/**
 *
 * @author 14626232639
 */
public class Pessoa {
    protected String nome;
    protected  String cpf;
    protected String idade;

    public Pessoa(String nome, String cpf, String idade) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
    }

    public Pessoa() {
    }
    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "nome=" + nome + ", cpf=" + cpf + ", idade=" + idade + '}';
    }
    
    
}
