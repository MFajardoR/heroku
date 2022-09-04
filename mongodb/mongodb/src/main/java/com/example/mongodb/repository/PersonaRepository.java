/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.mongodb.repository;

import com.example.mongodb.model.Persona;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author marco
 */
public interface PersonaRepository extends MongoRepository<Persona, Long>{
    
}
