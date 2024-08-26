package com.brunodias.bdc.api.controllers;

import com.brunodias.bdc.application.useCases.products.GetAllProductsUseCase;
import com.brunodias.bdc.application.useCases.products.GetProductByIdUseCase;
import com.brunodias.bdc.domain.dtos.ProductDTO;
import com.brunodias.bdc.domain.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private GetProductByIdUseCase _getProductByIdUseCase;
    @Autowired
    private GetAllProductsUseCase _getAllProductsUseCase;

    @GetMapping("{id}")
    public ProductDTO getProductById(@PathVariable UUID id){
        var result = _getProductByIdUseCase.execute(id);
        return result;
    }

    @GetMapping
    public ResponseEntity<Page<ProductDTO>> getAllProdcuts(Pageable pageable){
        var result = _getAllProductsUseCase.execute(pageable);
        return ResponseEntity.ok().body(result);
    }

}

