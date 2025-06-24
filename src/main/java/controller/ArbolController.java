/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import domain.Arbol;
import service.ArbolService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/categoria")
public class ArbolController {

    @Autowired
    private ArbolService categoriaService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var lista = categoriaService.getArbols(false);
        model.addAttribute("categorias", lista);
        model.addAttribute("totalArbols", lista.size());
        return "/categoria/listado";
    }

    @PostMapping("/guardar")
    public String guardar(Arbol categoria, @RequestParam("imagenFile") MultipartFile imagenFile) {
        categoriaService.save(categoria);
        return "redirect:/categoria/listado";
    }

    @GetMapping("/eliminar/{idArbol}")
    public String eliminar(Arbol categoria) {
        categoriaService.delete(categoria);
        return "redirect:/categoria/listado";
    }
    
    @GetMapping("/modificar/{idArbol}")
    public String modificar(Arbol categoria, Model model) {
        categoria=categoriaService.getArbol(categoria);
        model.addAttribute("categoria", categoria);
        return "/categoria/modifica";
    }
}
