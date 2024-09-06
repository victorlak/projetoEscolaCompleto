/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalhobd.model.valid;

import com.mycompany.trabalhobd.model.entidades.Disciplina;
import com.mycompany.trabalhobd.model.exceptions.DisciplinaException;

/**
 *
 * @author USUARIO
 */
public class ValidacaoDisciplina {


    public Disciplina validar(String codigo, String nome, String professorMinistrante){
        Disciplina novaDisciplina = new Disciplina();
        
        if(codigo.isEmpty()){
            throw new DisciplinaException("ERROR-campo vazio");
        }
        novaDisciplina.setCodigo(codigo);
        
        if(nome.isEmpty()){
            throw new DisciplinaException("ERROR-campo vazio");
        }
        novaDisciplina.setNome(nome);
        if(professorMinistrante.isEmpty()){
            throw new DisciplinaException("ERROR-campo vazio");
        }
        novaDisciplina.setProfMinistrante(professorMinistrante);
        
        return novaDisciplina;
    }
}
