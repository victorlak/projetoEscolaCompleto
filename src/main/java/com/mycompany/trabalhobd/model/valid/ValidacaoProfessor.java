/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalhobd.model.valid;

import com.mycompany.trabalhobd.model.entidades.Professor;
import com.mycompany.trabalhobd.model.exceptions.ProfessorException;

/**
 *
 * @author USUARIO
 */
public class ValidacaoProfessor {
    public Professor validar(String nome, String cpf, String idade, String materia){
        Professor novoProfessor = new Professor();
        
        if(nome.isEmpty()){
            throw new ProfessorException("ERROR-campo vazio-nome");
        }
        novoProfessor.setNome(nome);
        
        if(cpf.isEmpty()){
            throw new ProfessorException("ERROR-campo vazio-CPF");
        }
        novoProfessor.setCpf(cpf);
        if(idade.isEmpty()){
            throw new ProfessorException("ERROR-campo vazio-idade");
        }
        novoProfessor.setIdade(idade);
        if(materia.isEmpty()){
            throw new ProfessorException("ERROR-campo vazio-materia");
        }
        novoProfessor.setMateria(materia);
        return novoProfessor;
    }
}
