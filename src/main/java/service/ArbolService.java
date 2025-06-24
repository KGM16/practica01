/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;


import domain.Arbol;
import repository.ArbolRepository;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ArbolService {

    //Se define un único objeto para todos los ususarios y se crea automáticamente
    @Autowired
    private ArbolRepository arbolRepository;

    @Transactional(readOnly = true)
    public List<Arbol> getArbols(boolean activo) {
        var lista = arbolRepository.findAll();

        //Se hace el filtro si sólo se desean las categorías activas...
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
    public void save(Arbol arbol) {
        arbolRepository.save(arbol);
    }
    
    @Transactional
    public void delete(Arbol arbol) {
        arbolRepository.delete(arbol);
    }
}
