package com.brunodias.bdc.application.useCases.products;

import com.brunodias.bdc.application.exceptions.ResourceNotFoundException;
import com.brunodias.bdc.domain.dtos.ProductDTO;
import com.brunodias.bdc.domain.entities.Product;
import com.brunodias.bdc.infrastructure.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
public class GetProductByIdUseCase {
    @Autowired
    private ProductRepository _productRepository;

    @Transactional(readOnly = true)
    public ProductDTO execute(UUID productId){
        var product = _productRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Recurso nao encontrado"));;
        return new ProductDTO(product);
    }
}
