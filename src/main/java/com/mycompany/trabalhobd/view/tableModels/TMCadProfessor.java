/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalhobd.view.tableModels;

import com.mycompany.trabalhobd.model.entidades.Professor;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author USUARIO
 */
public class TMCadProfessor extends AbstractTableModel{
     private List<Professor> professores;
    private final int COL_CPF = 0;
    private final int COL_NOME = 1;
    private final int COL_IDADE = 2;
    private final int COL_MATERIA = 3;
    
    public TMCadProfessor(List<Professor> professores){
        this.professores = professores;
    }
    @Override
    public int getRowCount() {
       return this.professores.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }
    public Professor getObjetoAluno(int row){
       return this.professores.get(row);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Professor professor = this.professores.get(rowIndex);
        switch(columnIndex){
            case COL_CPF:
                return professor.getCpf();
            case COL_NOME:
                return professor.getNome();
            case COL_IDADE:
                return professor.getIdade();
            case COL_MATERIA:
                return professor.getMateria();
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
        if(columnIndex ==COL_MATERIA)
            return "MATERIA";
            
        return "";
    }
}
