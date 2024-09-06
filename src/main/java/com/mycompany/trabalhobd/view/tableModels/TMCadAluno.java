/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalhobd.view.tableModels;

import com.mycompany.trabalhobd.model.entidades.Aluno;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author USUARIO
 */
public class TMCadAluno extends AbstractTableModel{
    private List<Aluno> alunos;
    private final int COL_CPF = 0;
    private final int COL_NOME = 1;
    private final int COL_IDADE = 2;
    private final int COL_MATRICULA = 3;
    
    public TMCadAluno(List<Aluno> alunos){
        this.alunos = alunos;
    }
    @Override
    public int getRowCount() {
       return this.alunos.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }
    public Aluno getObjetoAluno(int row){
       return this.alunos.get(row);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Aluno aluno = this.alunos.get(rowIndex);
        switch(columnIndex){
            case COL_CPF:
                return aluno.getCpf();
            case COL_NOME:
                return aluno.getNome();
            case COL_IDADE:
                return aluno.getIdade();
            case COL_MATRICULA:
                return aluno.getMatricula();
            default:
                break;
        }
        return"-";
    }
    
    public String getColumnName(int columnIndex){
        if(columnIndex ==COL_CPF)
            return "CPF";
        if(columnIndex ==COL_NOME)
            return "NOME";
        if(columnIndex ==COL_IDADE)
            return "IDADE";
        if(columnIndex ==COL_MATRICULA)
            return "MATRICULA";
            
        return "";
    }
    
}
