package com.brunodias.bdc.application.useCases.products;

import com.brunodias.bdc.domain.dtos.ProductDTO;
import com.brunodias.bdc.domain.entities.Product;
import com.brunodias.bdc.infrastructure.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GetAllProductsUseCase {

    @Autowired
    private ProductRepository _productRepository;

    @Transactional(readOnly = true)
    public Page<ProductDTO> execute(Pageable pageable){
        Page <Product> result = _productRepository.findAll(pageable);
        return result.map(product -> new ProductDTO(product));
    }
}
