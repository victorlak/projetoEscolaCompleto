/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalhobd.model.file;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.trabalhobd.model.entidades.Professor;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class SerializadorJSONProfessor {
    public String toFile(List<Professor> professores) {
        try {
            // Convertendo objeto filme para JSON 
            ObjectMapper mapper = new ObjectMapper();
            String jsonString = mapper.writeValueAsString(professores);

            return jsonString;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Desserializa JSON em formato String para um objeto Filme
    public List<Professor> fromFile(String jsonString) {
        try {
            ObjectMapper mapper = new ObjectMapper();
             
            List<Professor> professores = mapper.readValue(jsonString, new TypeReference<List<Professor>>() {});
           // GerenciadorProduto produtos = mapper.readValue(jsonString, GerenciadorProduto.class);
            
            return professores;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
