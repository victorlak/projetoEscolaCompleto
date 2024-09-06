/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalhobd.controller;

import com.mycompany.trabalhobd.model.dao.IDao;
import com.mycompany.trabalhobd.model.entidades.Disciplina;
import com.mycompany.trabalhobd.model.valid.ValidacaoDisciplina;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class DisciplinaController {
    private IDao repositorio;

    public DisciplinaController(IDao repositorio) {
        this.repositorio = repositorio;
    }
    
    public void adicionarDisciplina(String codigo, String nome, String professorMinistrante){
        ValidacaoDisciplina valid = new ValidacaoDisciplina();
        Disciplina novaDisciplina = valid.validar(codigo, nome, professorMinistrante);
        System.out.println("BBBBBBBBBBB");
        repositorio.save(novaDisciplina);
    }
    public void atualizarDisciplina(String codAntigo,String codigo, String nome, String professorMinistrante){
        ValidacaoDisciplina valid = new ValidacaoDisciplina();
        Disciplina novaDisciplina = valid.validar(codigo, nome, professorMinistrante);
        repositorio.update(codAntigo, novaDisciplina);
    }
    public void deleteDisciplina(String codigo){
        repositorio.delete(codigo);
    }
    public Disciplina findDisciplina(String codigo){
        Disciplina disciplina = (Disciplina) repositorio.find(codigo);
        return disciplina;
    }
    public List<Disciplina> findAllDisciplina(){
        return repositorio.findAll();
    }
}
