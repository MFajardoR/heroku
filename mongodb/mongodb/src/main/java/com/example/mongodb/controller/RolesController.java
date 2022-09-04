/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.mongodb.controller;

import com.example.mongodb.model.Roles;
import com.example.mongodb.service.RolesService;
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
@RequestMapping("/api/roles")
public class RolesController {
    
    @Autowired
    RolesService rolesService;
    
    @PostMapping("/crear")
    public ResponseEntity<Roles> Crear(@RequestBody Roles r) {

        return new ResponseEntity<>(rolesService.save(r), HttpStatus.OK);
    }
    
    @GetMapping("/lista")
    public ResponseEntity<List<Roles>> Listar() {

        return new ResponseEntity<>(rolesService.findByAll(), HttpStatus.OK);
    }
    
    @GetMapping("/buscarId/{id}")
    public ResponseEntity<Roles> BuscarId(@PathVariable Long id){
         List<Roles> lista = rolesService.findByAll();
        
        return new ResponseEntity<>(rolesService.findById(id), HttpStatus.OK);
    }
    
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Roles> Actualizar(@PathVariable Long id, @RequestBody Roles r) {
        Roles per = rolesService.findById(id);
            per.setNombre(r.getNombre());
            per.setDescripcion(r.getDescripcion());
            per.setEstado(r.getEstado());
            
           return new ResponseEntity<>(rolesService.save(r), HttpStatus.NO_CONTENT);
       
    }
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Roles> Eliminar(@PathVariable Long id) {
        Roles per = rolesService.findById(id);

        
        rolesService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
}
