/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.practica01.controller;

import com.practica01.domain.Arbol;
import com.practica01.service.ArbolService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/arbol")
public class ArbolController {

    @Autowired
    private ArbolService arbolService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var lista = arbolService.getArbols(false);
        model.addAttribute("arbols", lista);
        model.addAttribute("totalArbols", lista.size());
        return "/arbol/listado";
    }

    @PostMapping("/guardar")
    public String guardar(Arbol arbol, @RequestParam("imagenFile") MultipartFile imagenFile) {
        arbolService.save(arbol, imagenFile);
        return "redirect:/arbol/listado";
    }

    @GetMapping("/eliminar/{idArbol}")
    public String eliminar(Arbol arbol) {
        arbolService.delete(arbol);
        return "redirect:/arbol/listado";
    }
    
    @GetMapping("/modificar/{idArbol}")
    public String modificar(Arbol arbol, Model model) {
        arbol=arbolService.getArbol(arbol);
        model.addAttribute("arbol", arbol);
        return "/arbol/modifica";
    }
}
