/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.practica01.service;


import com.practica01.domain.Arbol;
import com.practica01.repository.ArbolRepository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class ArbolService {

    @Autowired
    private ArbolRepository arbolRepository;



    @Transactional(readOnly = true)
    public List<Arbol> getArbols(boolean activo) {
        var lista = arbolRepository.findAll();

        if (activo) {
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }
    
    @Transactional(readOnly = true)
    public Arbol getArbol(Arbol arbol) {
        
        return arbolRepository.findById(arbol.getIdArbol())
                .orElse(null);
    }
    

    @Transactional
    public void save(Arbol arbol, MultipartFile imagenFile) {
        if (imagenFile != null && !imagenFile.isEmpty()) {
            try {
                String uniqueFilename = UUID.randomUUID().toString() + "_" + imagenFile.getOriginalFilename();
                Path imagePath = Paths.get("src/main/resources/static/imagenes/").resolve(uniqueFilename).toAbsolutePath();
                Files.createDirectories(imagePath.getParent());
                Files.write(imagePath, imagenFile.getBytes());
                arbol.setRutaImg("/imagenes/" + uniqueFilename);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        arbolRepository.save(arbol);
    }
    
    @Transactional
    public void delete(Arbol arbol) {
        arbolRepository.delete(arbol);
    }
}
