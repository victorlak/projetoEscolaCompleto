/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalhobd.controller;

import com.mycompany.trabalhobd.model.dao.IDao;
import com.mycompany.trabalhobd.model.entidades.Professor;
import com.mycompany.trabalhobd.model.valid.ValidacaoProfessor;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class ProfessorController {
    private IDao repositorio;

    public ProfessorController(IDao repositorio) {
        this.repositorio = repositorio;
    }
    
    public void adicionarProfessor(String nome, String cpf, String idade, String materia){
        ValidacaoProfessor valid = new ValidacaoProfessor();
        Professor Professor = valid.validar( nome, cpf, idade,  materia);
        repositorio.save(Professor);
    }
    public void atualizarProfessor(String cpfAntigo,String nome, String cpf, String idade, String materia){
        ValidacaoProfessor valid = new ValidacaoProfessor();
        Professor Professor = valid.validar( nome, cpf, idade,  materia);
        repositorio.update(cpfAntigo, Professor);
    }
    public void deleteProfessor(String cpf){
        repositorio.delete(cpf);
    }
    public  Professor findProfessor(String cpf){
        Professor professor = (Professor) repositorio.find(cpf);
        return professor;
    }
    public List<Professor> findAllProfessor(){
        return repositorio.findAll();
    }
}
