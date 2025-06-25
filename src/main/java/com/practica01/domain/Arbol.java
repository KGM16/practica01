package com.practica01.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;


@Data
@Entity
@Table(name="arbol")
public class Arbol implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long idArbol;
    
    private String nombreComun;
    private String tipoFlor;
    private double durezaMadera;
    private double alturaPromedio;
    private String rutaImg;
    private boolean activo;
}
