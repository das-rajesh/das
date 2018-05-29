/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.heroku.web.dao;

import java.util.List;

/**
 *
 * @author RAJESH
 */
public interface GenricDAO<T> {
    
    List<T> getAll();
    int insert(T model);
    int update(T model);
    int  delete(int id);
    T getById(int id); 
    
}
