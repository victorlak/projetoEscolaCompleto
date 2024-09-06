/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalhobd.model.dao;

import com.mycompany.trabalhobd.model.entidades.Professor;
import com.mycompany.trabalhobd.model.file.FilePersistence;
import com.mycompany.trabalhobd.model.file.SerializadorJSONProfessor;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class IDaoProfessorFile implements IDao{
    private SerializadorJSONProfessor serializador = new SerializadorJSONProfessor();//Inversao dependencia
    
    private FilePersistence filePersistence = new FilePersistence();
    private String caminhoArquivo;

    public IDaoProfessorFile(String caminhoArquivo) {
        this.caminhoArquivo = caminhoArquivo;
    }


    @Override
    public void delete(String cpf) {
       
        Professor professorExcluir = this.find(cpf);
        
        if(professorExcluir != null){
            List<Professor> professores = this.findAll();
            professores.removeIf(professor->professor.getCpf().equals(cpf));
            
            //mesma rotina para que aprendemos nas aulas de persistencia
            String jsonData = serializador.toFile(professores);
            filePersistence.saveToFile(jsonData, caminhoArquivo);
            System.out.println("Professor removido com sucesso do arquivo.");
        }
    }

    @Override
    public Professor find(String cpf) {
        List<Professor> professores = this.findAll();
        
        for (Professor professor : professores) {
            if (professor.getCpf().equals(cpf)){
                return professor;
            }      
        }
        return null;
    }
    
    @Override
    public List<Professor> findAll() {
        String jsonData = filePersistence.loadFromFile(caminhoArquivo);
        return serializador.fromFile(jsonData);
    }

    @Override
    public void update(String cpf, Object newProfessor ) {
        Professor alunoAtualizado = (Professor) newProfessor;
    
       
        Professor professorExistente = this.find(cpf);
    
        if (professorExistente != null) {
        
        List<Professor> professores = this.findAll();
        
        
        professores.removeIf(professor->professor.getCpf().equals(cpf));
        
        
        professores.add(alunoAtualizado);
        
        
        String jsonData = serializador.toFile(professores);
        filePersistence.saveToFile(jsonData, caminhoArquivo);
        System.out.println("Professor atualizado com sucesso no arquivo.");
        }
    }

    @Override
    public void save(Object newAluno) {
        Professor a = (Professor) newAluno;
        List<Professor> alunos = findAll();
        alunos.add(a);
        
        //mesma rotina para que aprendemos nas aulas de persistencia
        String jsonData = serializador.toFile(alunos);
        filePersistence.saveToFile(jsonData, caminhoArquivo);
        System.out.println("Professor salvo com sucesso no arquivo.");
    }
}
