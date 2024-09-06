/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalhobd.model.entidades;

/**
 *
 * @author 14626232639
 */
public class Aluno extends Pessoa{
    private String matricula;
    public Aluno(String nome, String cpf, String idade, String matricula) {
        super(nome, cpf, idade);
        this.matricula = matricula;
    }

    public Aluno() {
        super();
    }
    

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return "Aluno{" + super.toString() + "matricula=" + matricula + '}';
    }

    
    
}
