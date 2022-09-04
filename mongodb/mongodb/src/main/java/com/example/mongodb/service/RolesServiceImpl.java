/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.mongodb.service;

import com.example.mongodb.model.Roles;
import com.example.mongodb.repository.RolesRepository;
import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author marco
 */

@Service
public class RolesServiceImpl extends GenericServiceImpl<Roles, Long> implements RolesService {
    
    
    @Autowired
    RolesRepository rolesRepository;
    
    
    @Override
    public CrudRepository<Roles, Long> getDao() {
        return rolesRepository;
    }
    
}
