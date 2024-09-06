/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalhobd.model.valid;

import com.mycompany.trabalhobd.model.entidades.Aluno;
import com.mycompany.trabalhobd.model.exceptions.AlunoException;

/**
 *
 * @author USUARIO
 */
public class ValidacaoAluno {
        public Aluno validar(String nome, String cpf, String idade, String matricula){
        Aluno novoAluno = new Aluno();
        
        if(nome.isEmpty()){
            throw new AlunoException("ERROR-campo vazio-nome");
        }
        novoAluno.setNome(nome);
        
        if(cpf.isEmpty()){
            throw new AlunoException("ERROR-campo vazio-CPF");
        }
        novoAluno.setCpf(cpf);
        if(idade.isEmpty()){
            throw new AlunoException("ERROR-campo vazio-idade");
        }
        novoAluno.setIdade(idade);
        if(matricula.isEmpty()){
            throw new AlunoException("ERROR-campo vazio-matricula");
        }
        novoAluno.setMatricula(matricula);
        return novoAluno;
    }
}
