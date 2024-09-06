/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalhobd.model.dao;

import com.mycompany.trabalhobd.model.entidades.Aluno;
import com.mycompany.trabalhobd.model.file.FilePersistence;
import com.mycompany.trabalhobd.model.file.SerializadorJSONAluno;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class IDaoAlunoFile implements IDao {
    private SerializadorJSONAluno serializador = new SerializadorJSONAluno();
    
    private FilePersistence filePersistence = new FilePersistence();
    private String caminhoArquivo;

    public IDaoAlunoFile(String caminhoArquivo) {
        this.caminhoArquivo = caminhoArquivo;
    }


    @Override
    public void delete(String cpf) {
       
            List<Aluno> alunos = this.findAll();
            System.out.println("");
            alunos.removeIf(aluno -> aluno.getCpf().equals(cpf));
            
            //mesma rotina para que aprendemos nas aulas de persistencia
            String jsonData = serializador.toFile(alunos);
            filePersistence.saveToFile(jsonData, caminhoArquivo);
            System.out.println("Aluno removido com sucesso do arquivo.");
        
    }

    @Override
    public Aluno find(String cpf) {
        List<Aluno> alunos = this.findAll();
        
        for (Aluno aluno : alunos) {
            String a = aluno.getCpf();
            if (aluno.getCpf().equals(cpf)){
                
                return aluno;
            }      
        }
        return null;
    }
    
    @Override
    public List<Aluno> findAll() {
        String jsonData = filePersistence.loadFromFile(caminhoArquivo);
        return serializador.fromFile(jsonData);
    }

    @Override
    public void update(String cpf, Object newAluno ) {
        Aluno alunoAtualizado = (Aluno) newAluno;
    
        Aluno alunoExistente = this.find(cpf);
    
        if (alunoExistente != null) {
        List<Aluno> alunos = this.findAll();
        
        alunos.removeIf(aluno -> aluno.getCpf().equals(cpf));
        
        // Adiciona o novo aluno atualizado
        alunos.add(alunoAtualizado);
        
        // Atualiza o arquivo com a lista modificada
        String jsonData = serializador.toFile(alunos);
        filePersistence.saveToFile(jsonData, caminhoArquivo);
        System.out.println("Aluno atualizado com sucesso no arquivo.");
        }
    }

    @Override
    public void save(Object newAluno) {
        Aluno a = (Aluno) newAluno;
        List<Aluno> alunos = findAll();
        alunos.add(a);
        
        //mesma rotina para que aprendemos nas aulas de persistencia
        String jsonData = serializador.toFile(alunos);
        filePersistence.saveToFile(jsonData, caminhoArquivo);
        System.out.println("Aluno salvo com sucesso no arquivo.");
    }
}
