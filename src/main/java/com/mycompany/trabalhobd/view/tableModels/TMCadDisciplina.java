/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalhobd.view.tableModels;

import com.mycompany.trabalhobd.model.entidades.Disciplina;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author USUARIO
 */
public class TMCadDisciplina extends AbstractTableModel{
    private List<Disciplina> disciplinas;
    private final int COL_NOME = 0;
    private final int COL_COD = 1;
    private final int COL_PROFM = 2;
    
    public TMCadDisciplina(List<Disciplina> disciplina){
        this.disciplinas = disciplina;
    }
    @Override
    public int getRowCount() {
       return this.disciplinas.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }
    public Disciplina getObjetoDisciplina(int row){
       return this.disciplinas.get(row);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Disciplina disciplina = this.disciplinas.get(rowIndex);
        switch(columnIndex){
            case COL_NOME:
                return disciplina.getNome();
            case COL_COD:
                return disciplina.getCodigo();
            case COL_PROFM:
                return disciplina.getProfMinistrante();
            default:
                break;
        }
        return"-";
    }
    
    @Override
    public String getColumnName(int columnIndex){
        if(columnIndex ==COL_COD)
            return "COD";
        if(columnIndex ==COL_NOME)
            return "NOME";
        if(columnIndex ==COL_PROFM)
            return "PROFESSOR MINISTRANTE";
            
        return "";
    }
}
