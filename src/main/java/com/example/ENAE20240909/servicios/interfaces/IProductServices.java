package com.example.ENAE20240909.servicios.interfaces;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import com.example.ENAE20240909.dtos.ProductGuardar;
import com.example.ENAE20240909.dtos.ProductModificar;
import com.example.ENAE20240909.dtos.ProductSalida;

public interface IProductServices {

    List<ProductSalida> obtenerTodos();

    Page<ProductSalida> obtenerTodosPaginados(Pageable pageable);

    ProductSalida obtenerPorId(Integer id);

    ProductSalida crear(ProductGuardar productGuardar);

    ProductSalida editar(ProductModificar productModificar);

    void eliminarPorId(Integer id);
}
