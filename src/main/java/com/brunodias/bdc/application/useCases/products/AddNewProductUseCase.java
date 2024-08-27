package com.brunodias.bdc.application.useCases.products;

import com.brunodias.bdc.application.services.ProductService;
import com.brunodias.bdc.domain.dtos.ProductDTO;
import com.brunodias.bdc.domain.entities.Product;
import com.brunodias.bdc.infrastructure.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AddNewProductUseCase {

    @Autowired
    private ProductRepository _productRepository;

    @Autowired
    private ProductService _productService;

    @Transactional
    public ProductDTO execute(ProductDTO productDTO){
        var product = new Product();
        _productService.copyDtoToEntity(productDTO, product);
        product = _productRepository.save(product);
        return new ProductDTO(product);
    }
}
