/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalhobd.model.file;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.trabalhobd.model.entidades.Aluno;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class SerializadorJSONAluno {
    public String toFile(List<Aluno> alunos) {
        try {
            // Convertendo objeto filme para JSON 
            ObjectMapper mapper = new ObjectMapper();
            String jsonString = mapper.writeValueAsString(alunos);

            return jsonString;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Desserializa JSON em formato String para um objeto Filme
    public List<Aluno> fromFile(String jsonString) {
        try {
            ObjectMapper mapper = new ObjectMapper();
             
            List<Aluno> alunos = mapper.readValue(jsonString, new TypeReference<List<Aluno>>() {});
           // GerenciadorProduto produtos = mapper.readValue(jsonString, GerenciadorProduto.class);
            
            return alunos;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
