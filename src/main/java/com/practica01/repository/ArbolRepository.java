/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.practica01.repository;

import com.practica01.domain.Arbol;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ArbolRepository
        extends JpaRepository<Arbol, Long> 

{

}
