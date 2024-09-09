package com.example.ENAE20240909.dtos;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductModificar implements Serializable{
    private Integer id;
    private String nombreENAE;
    private String descripcionENAE;
    private Double precioENAE;
}
