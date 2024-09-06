/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalhobd.controller;

import com.mycompany.trabalhobd.model.dao.IDao;
import com.mycompany.trabalhobd.model.entidades.Aluno;
import com.mycompany.trabalhobd.model.valid.ValidacaoAluno;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class AlunoController {
    private IDao repositorio;

    public AlunoController(IDao repositorio) {
        this.repositorio = repositorio;
    }
    
    public void adicionarAluno(String nome, String cpf, String idade, String matricula){
        ValidacaoAluno valid = new ValidacaoAluno();
        Aluno novoAluno = valid.validar( nome, cpf, idade,  matricula);
        System.out.println(novoAluno.getNome());
        repositorio.save(novoAluno);
    }
    public void atualizarAluno(String cpfAntigo,String nome, String cpf, String idade, String matricula){
        ValidacaoAluno valid = new ValidacaoAluno();
        Aluno novoAluno = valid.validar( nome, cpf, idade,  matricula);
        repositorio.update(cpfAntigo, novoAluno);
        
    }
    public void deleteAluno(String cpf){
        repositorio.delete(cpf);
    }
    public  Aluno findAluno(String cpf){
        Aluno aluno = (Aluno) repositorio.find(cpf);
        return aluno;
    }
    public List<Aluno> findAllAluno(){
        return repositorio.findAll();
    }
}
