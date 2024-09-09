package com.example.ENAE20240909.dtos;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductGuardar implements Serializable {
    
    private String nombreENAE;
    private String descripcionENAE;
    private Double precioENAE;
}
