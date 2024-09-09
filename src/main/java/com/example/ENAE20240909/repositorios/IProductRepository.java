package com.example.ENAE20240909.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ENAE20240909.modelos.ProductENAE;

public interface IProductRepository extends JpaRepository<ProductENAE, Integer> {

}
