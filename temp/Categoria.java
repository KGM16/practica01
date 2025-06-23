package com.tienda.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name="arbol")
public class Categoria implements Serializable {
    private static final long serialVersionUID = 1L;
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategoria;
    
    private Long id;
    private String nombre_comun;
    private String tipo_flor;
    private double dureza_madera;
    private double altura_promedio;
    private String ruta_img;
}
