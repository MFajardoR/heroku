/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.mongodb.controller;

import com.example.mongodb.model.Persona;
import com.example.mongodb.service.PersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author marco
 */

@RestController
@RequestMapping("/api/personas")
public class PersonaController {
    
    @Autowired
    PersonaService personaService;
    
    @PostMapping("/crear")
    public ResponseEntity<Persona> Crear(@RequestBody Persona p) {

        return new ResponseEntity<>(personaService.save(p), HttpStatus.OK);
    }
    
    @GetMapping("/lista")
    public ResponseEntity<List<Persona>> Listar() {

        return new ResponseEntity<>(personaService.findByAll(), HttpStatus.OK);
    }
    
    @GetMapping("/buscarId/{id}")
    public ResponseEntity<Persona> BuscarId(@PathVariable Long id){
         List<Persona> lista = personaService.findByAll();
        
        return new ResponseEntity<>(personaService.findById(id), HttpStatus.OK);
    }
    
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Persona> Actualizar(@PathVariable Long id, @RequestBody Persona p) {
        Persona per = personaService.findById(id);
            per.setCedula(p.getCedula());
            per.setNombre(p.getNombre());
            per.setContacto(p.getContacto());
            per.setEdad(p.getEdad());
           return new ResponseEntity<>(personaService.save(p), HttpStatus.NO_CONTENT);
       
    }
    
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Persona> Eliminar(@PathVariable Long id) {
        Persona per = personaService.findById(id);

        
        personaService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        
    
    
    
}