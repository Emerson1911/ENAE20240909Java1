package com.example.ENAE20240909.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.ENAE20240909.dtos.ProductGuardar;
import com.example.ENAE20240909.dtos.ProductModificar;
import com.example.ENAE20240909.dtos.ProductSalida;
import com.example.ENAE20240909.servicios.interfaces.IProductServices;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/productos")
public class ProductController {

    @Autowired
    private IProductServices productServices;

    @GetMapping
    public ResponseEntity<Page<ProductSalida>> mostrarTodosPaginados(Pageable pageable) {
        Page<ProductSalida> productos = productServices.obtenerTodosPaginados(pageable);
        if (productos.hasContent()) {
            return ResponseEntity.ok(productos);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/lista")
    public ResponseEntity<List<ProductSalida>> mostrarTodos() {
        List<ProductSalida> productos = productServices.obtenerTodos();
        if (!productos.isEmpty()) {
            return ResponseEntity.ok(productos);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductSalida> buscarPorId(@PathVariable Integer id) {
        ProductSalida producto = productServices.obtenerPorId(id);
        if (producto != null) {
            return ResponseEntity.ok(producto);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<ProductSalida> crear(@RequestBody ProductGuardar productGuardar) {
        ProductSalida producto = productServices.crear(productGuardar);
        return ResponseEntity.ok(producto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductSalida> editar(@PathVariable Integer id, @RequestBody ProductModificar productModificar){
        ProductSalida producto = productServices.editar(productModificar);
        return ResponseEntity.ok(producto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminar(@PathVariable Integer id) {
        productServices.eliminarPorId(id);
        return ResponseEntity.ok("Producto eliminado correctamente");
    }
}
