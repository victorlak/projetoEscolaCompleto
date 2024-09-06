package com.mycompany.trabalhobd.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLiteConnector {

    private Connection connection;

    public SQLiteConnector(String dbName) throws SQLException {
        String url = "jdbc:sqlite:" + dbName;
        this.connection = DriverManager.getConnection(url);

        criarTabelaAluno();
        criarTabelaProfessor();
        criarTabelaDisciplina();
        System.out.println("Tabelas criadas com sucesso!");
    }

    public Connection getConnection() {
        return connection;
    }

    private void criarTabelaAluno() {
        String sql = "CREATE TABLE IF NOT EXISTS aluno ("
                + " id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + " cpf TEXT NOT NULL,"
                + " nome TEXT NOT NULL,"
                + " idade TEXT NOT NULL,"
                + " matricula TEXT NOT NULL"
                + ");";
        executarSQL(sql);
    }
    
    private void criarTabelaProfessor() {
        String sql = "CREATE TABLE IF NOT EXISTS professor ("
                + " id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + " cpf TEXT NOT NULL,"
                + " nome TEXT NOT NULL,"
                + " idade INTEGER NOT NULL,"
                + " materia TEXT NOT NULL"
                + ");";
        executarSQL(sql);
    }
    
    private void criarTabelaDisciplina() {
        String sql = "CREATE TABLE IF NOT EXISTS disciplina ("
                + " id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + " cod TEXT NOT NULL,"
                + " nome TEXT NOT NULL,"
                + " profM TEXT NOT NULL"
                + ");";
        executarSQL(sql);
    }

    private void executarSQL(String sql) {
        try (Statement stmt = connection.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println("Erro ao criar a tabela: " + e.getMessage());
        }
    }
}
