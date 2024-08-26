package com.brunodias.bdc.application.services;

import com.brunodias.bdc.domain.dtos.ProductDTO;
import com.brunodias.bdc.infrastructure.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProductService {
    @Autowired
    private ProductRepository _productRepository;

//    public ProductDTO findById(UUID productId){
//
//    }
}
