package com.brunodias.bdc.api.controllers;

import com.brunodias.bdc.application.useCases.products.*;
import com.brunodias.bdc.domain.dtos.ProductDTO;
import com.brunodias.bdc.domain.entities.Product;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private GetProductByIdUseCase _getProductByIdUseCase;
    @Autowired
    private GetAllProductsUseCase _getAllProductsUseCase;

    @Autowired
    private AddNewProductUseCase _addNewProductUseCase;

    @Autowired
    private UpdateProductUseCase _updateProductUseCase;

    @Autowired
    private DeleteProductUseCase _deleteProductUseCase;
    @GetMapping("/{id}")
    public ProductDTO getProductById(@PathVariable UUID id){
        var result = _getProductByIdUseCase.execute(id);
        return result;
    }

    @GetMapping
    public ResponseEntity<Page<ProductDTO>> getAllProdcuts(Pageable pageable){
        var result = _getAllProductsUseCase.execute(pageable);
        return ResponseEntity.ok().body(result);
    }

    @PostMapping
    public ResponseEntity<ProductDTO> insert(@RequestBody @Valid ProductDTO request){
        var result = _addNewProductUseCase.execute(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> update(@PathVariable UUID id, @Valid @RequestBody ProductDTO productDTO){
        var result = _updateProductUseCase.execute(id, productDTO);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id){
        _deleteProductUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }

}

