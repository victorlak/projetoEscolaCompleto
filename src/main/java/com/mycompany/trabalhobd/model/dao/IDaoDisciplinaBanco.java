/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalhobd.model.dao;

import com.mycompany.trabalhobd.model.entidades.Disciplina;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * 
 * @author USUARIO
 */
public class IDaoDisciplinaBanco implements IDao{
    private Connection connection;
    
    public IDaoDisciplinaBanco(Connection connection) {
        this.connection = connection;
    }
  /*  private Boolean conferirCadastroProfessor(String cpf) {
        String query = "SELECT * FROM professores WHERE cpf = ?";
        try(PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setString(1, cpf);
            ResultSet retorno = stmt.executeQuery();
            if(retorno.next()){
                return true;
            }else{
                return false;
            }
        }catch (SQLException e) {
            System.out.println("Erro ao cadastrar disciplina: " + e.getMessage());
            
        }
        return false;
    }*/
    @Override
    public void save(Object objT) {
        Disciplina disciplina = (Disciplina) objT;
        String query  = "INSERT INTO disciplina(cod, nome, profM) VALUES(?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, disciplina.getCodigo());
            stmt.setString(2, disciplina.getNome());
            stmt.setString(3, disciplina.getProfMinistrante());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar disciplina: " + e.getMessage());
        }
        
    }

    @Override
    public void update(String codObgT, Object objT) {
       Disciplina disciplina = (Disciplina) objT;   
        String query = "UPDATE disciplina SET nome = ?,profM = ? WHERE cod = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, disciplina.getNome());
            stmt.setString(2,disciplina.getProfMinistrante() );
            stmt.setString(3, codObgT);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar a disciplina " + e.getMessage());
        }
    }

    @Override
    public void delete(String codObgT) {
        String query = "DELETE FROM disciplina WHERE cod = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, codObgT);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao deletar a disciplina " + e.getMessage());
        }
    }

    @Override
    public Object find(String codObgT) {
        String query = "SELECT * FROM disciplina WHERE cod = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, codObgT);
            try(ResultSet retorno = stmt.executeQuery()){
                if(retorno.next()){
                    return new Disciplina(
                    retorno.getString("cod"),
                    retorno.getString("profM"),
                    retorno.getString("nome")
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao encontrar disciplina " + e.getMessage());
        }
        return null;
    }

    @Override
    public List findAll() {
        String query = "SELECT * FROM disciplina";
        List<Disciplina> disciplinas = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet retorno = stmt.executeQuery()) {

            while (retorno.next()) {
                disciplinas.add(new Disciplina(
                        retorno.getString("cod"),
                    retorno.getString("profM"),
                    retorno.getString("nome")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar disciplina: " + e.getMessage());
        }
        return disciplinas;
    }
    
}
