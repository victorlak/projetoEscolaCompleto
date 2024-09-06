/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalhobd.model.dao;

import com.mycompany.trabalhobd.model.entidades.Disciplina;
import com.mycompany.trabalhobd.model.file.FilePersistence;
import com.mycompany.trabalhobd.model.file.SerializadorJSONDisciplina;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class IDaoDisciplinaFile implements IDao{
    private SerializadorJSONDisciplina serializador = new SerializadorJSONDisciplina();//Inversao dependencia
    
    private FilePersistence filePersistence = new FilePersistence();
    private String caminhoArquivo;

    public IDaoDisciplinaFile(String caminhoArquivo) {
        this.caminhoArquivo = caminhoArquivo;
    }


    @Override
    public void delete(String cod) {
       String b = cod;
        System.out.println(b); //cod chega
        Disciplina disciplinaExcluir = this.find(cod); // n acha disciplina
        String a = disciplinaExcluir.getNome();
        if(disciplinaExcluir != null){
            List<Disciplina> disciplinas = this.findAll();
            disciplinas.removeIf(professor->professor.getCodigo().equals(cod));
            
            String jsonData = serializador.toFile(disciplinas);
            filePersistence.saveToFile(jsonData, caminhoArquivo);
            System.out.println("Disciplina removida com sucesso do arquivo.");
        }
    }

    @Override
    public Disciplina find(String cod) {
        List<Disciplina> disciplinas = this.findAll();
        disciplinas.toString();
        for (Disciplina disciplina : disciplinas) {
            if (disciplina.getNome().equals(cod)){
                return disciplina;
            }      
        }
        return null;
    }
    
    @Override
    public List<Disciplina> findAll() {
        String jsonData = filePersistence.loadFromFile(caminhoArquivo);
        return serializador.fromFile(jsonData);
    }

    @Override
    public void update(String cod, Object disciplina ) {
        Disciplina disciplinaAtualizada = (Disciplina) disciplina;
    
       
        Disciplina disciplinaExistente = this.find(cod);
    
        if (disciplinaExistente != null) {
        
        List<Disciplina> disciplinas = this.findAll();
        
        
        disciplinas.removeIf(professor->professor.getCodigo().equals(cod));
        
        
        disciplinas.add(disciplinaAtualizada);
        
        
        String jsonData = serializador.toFile(disciplinas);
        filePersistence.saveToFile(jsonData, caminhoArquivo);
        System.out.println("Professor atualizado com sucesso no arquivo.");
    }
}
    @Override
    public void save(Object disciplina) {
        Disciplina a = (Disciplina) disciplina;
        List<Disciplina> disciplinas = findAll();
        disciplinas.add(a);
        
        //mesma rotina para que aprendemos nas aulas de persistencia
        String jsonData = serializador.toFile(disciplinas);
        filePersistence.saveToFile(jsonData, caminhoArquivo);
        System.out.println("Disciplina salva com sucesso no arquivo.");
    }
}
