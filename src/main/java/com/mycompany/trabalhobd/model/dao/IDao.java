/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.trabalhobd.model.dao;

import java.util.List;

/**
 *
 * @author USUARIO
 */
public interface IDao<T> {
    void save(T objT);
    
    void update(String codObgT, T objT);
    
    void delete(String codObgT);
    
    T find(String codObgT);
    
    List<T> findAll();
}
