/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalhobd.model.entidades;

/**
 *
 * @author 14626232639
 */
public class Disciplina {
    private String codigo;
    private String profMinistrante;
    private String nome;

    public Disciplina() {
        this.codigo = "";
        this.nome = "";
        this.profMinistrante = "";
    }
    
    
    public Disciplina(String codigo, String profMinistrante, String nome) {
        this.codigo = codigo;
        this.profMinistrante = profMinistrante;
        this.nome = nome;
    }

    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getProfMinistrante() {
        return profMinistrante;
    }

    public void setProfMinistrante(String profMinistrante) {
        this.profMinistrante = profMinistrante;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Disciplina{" + "codigo=" + codigo + ", profMinistrante=" + profMinistrante + ", nome=" + nome + '}';
    }
    
    
}
