/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.datos.datosPersonas.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author anthony
 */
@Entity
public class Person {
    private Long id;
    private String heroName;
    private String realName;
    private String additional;
    
    public Person(){
    }
    
    protected Person(Long id, String heroName, String realName, String additional){
        super();
        this.id = id;
        this.heroName = heroName;
        this.realName = realName;
        this.additional = additional;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId(){
        return id;
    }
    
    public void setId(Long id){
        this.id = id;
    }
    
    public String getHeroName(){
        return heroName;
    }
    
    public void setHeroName(String heroName){
        this.heroName = heroName;
    }
    
    public String getRealName(){
        return realName;
    }
    
    public void setRealName(String realName){
        this.realName = realName;
    }
    
    public String getAdditional(){
        return additional;
    }
    
    public void setAdditional(String additional){
        this.additional = additional;
    }
    
    }
    