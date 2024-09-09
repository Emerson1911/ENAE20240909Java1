package com.example.ENAE20240909.servicios.implementaciones;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.ENAE20240909.dtos.ProductGuardar;
import com.example.ENAE20240909.dtos.ProductModificar;
import com.example.ENAE20240909.dtos.ProductSalida;
import com.example.ENAE20240909.modelos.ProductENAE;
import com.example.ENAE20240909.repositorios.IProductRepository;
import com.example.ENAE20240909.servicios.interfaces.IProductServices;

@Service
public class ProductServices implements IProductServices {

    @Autowired
    private IProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ProductSalida> obtenerTodos() {
        List<ProductENAE> productos = productRepository.findAll();

        return productos.stream()
                .map(producto -> modelMapper.map(producto, ProductSalida.class)) // Mapea cada producto individualmente.
                .collect(Collectors.toList());

    }

    @Override
    public Page<ProductSalida> obtenerTodosPaginados(Pageable pageable) {
        Page<ProductENAE> page = productRepository.findAll(pageable);

        List<ProductSalida> productosDto = page.stream()
                .map(ProductENAE -> modelMapper.map(ProductENAE, ProductSalida.class))
                .collect(Collectors.toList());

        return new PageImpl<>(productosDto, page.getPageable(), page.getTotalElements());
    }

    @Override
    public ProductSalida obtenerPorId(Integer id) {
        return modelMapper.map(productRepository.findById(id).get(), ProductSalida.class);
    }

    @Override
    public ProductSalida crear(ProductGuardar productoGuardar) {
        ProductENAE producto = productRepository.save(modelMapper.map(productoGuardar, ProductENAE.class));
        return modelMapper.map(producto, ProductSalida.class);
    }

    @Override
    public ProductSalida editar(ProductModificar productModificar) {
        ProductENAE producto = productRepository.save(modelMapper.map(productModificar, ProductENAE.class));
        return modelMapper.map(producto, ProductSalida.class);
    }

    @Override
    public void eliminarPorId(Integer id) {
        productRepository.deleteById(id);
    }

}
