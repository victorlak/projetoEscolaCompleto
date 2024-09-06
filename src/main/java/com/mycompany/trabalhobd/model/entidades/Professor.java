/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalhobd.model.entidades;

/**
 *
 * @author 14626232639
 */
public class Professor extends Pessoa{
    private String materia;

    public Professor(String nome, String cpf, String idade, String materia) {
        super(nome, cpf, idade);
        this.materia = materia;
    }

    public Professor() {
    }
    
    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    @Override
    public String toString() {
        return "Professor{" +super.toString()+ "materia=" + materia + '}';
    }
    
    
}
