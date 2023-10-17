/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.datos.datosPersonas.service;

import com.datos.datosPersonas.entity.Person;
import com.datos.datosPersonas.repository.PersonRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PersonService {
    @Autowired
    private PersonRepository repo;
    
    public List<Person> listAll(){
        return repo.findAll();
    }
    
    public void save(Person person){
        repo.save(person);
    }
    
    public Person get(long id){
        return repo.findById(id).get();
    }
    
    public void delete(long id){
        repo.deleteById(id);
    }
}
