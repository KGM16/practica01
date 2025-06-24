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
@RequestMapping("/arbol")
public class ArbolController {

    @Autowired
    private ArbolService arbolService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var lista = arbolService.getArbols(false);
        model.addAttribute("arboles", lista);
        model.addAttribute("totalArboles", lista.size());
        return "/arbol/listado";
    }

    @GetMapping("/nuevo")
    public String arbolNuevo(Arbol arbol) {
        return "/arbol/crear";
    }

    @PostMapping("/guardar")
    public String arbolGuardar(Arbol arbol, @RequestParam("imagenFile") MultipartFile imagenFile) {
        // Lógica para guardar la imagen si es necesario
        arbolService.save(arbol);
        return "redirect:/arbol/listado";
    }

    @GetMapping("/eliminar/{idArbol}")
    public String arbolEliminar(Arbol arbol, Model model) {
        arbol = arbolService.getArbol(arbol);
        model.addAttribute("arbol", arbol);
        return "/arbol/eliminar";
    }
    
    @PostMapping("/eliminar")
    public String arbolEliminar(Arbol arbol) {
        arbolService.delete(arbol);
        return "redirect:/arbol/listado";
    }

    @GetMapping("/modificar/{idArbol}")
    public String arbolModificar(Arbol arbol, Model model) {
        arbol = arbolService.getArbol(arbol);
        model.addAttribute("arbol", arbol);
        return "/arbol/actualizar";
    }
}
