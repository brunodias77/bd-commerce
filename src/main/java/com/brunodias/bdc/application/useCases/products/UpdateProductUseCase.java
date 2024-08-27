package com.brunodias.bdc.application.useCases.products;

import com.brunodias.bdc.application.exceptions.ResourceNotFoundException;
import com.brunodias.bdc.application.services.mappers.ProductMapper;
import com.brunodias.bdc.domain.dtos.ProductDTO;
import com.brunodias.bdc.infrastructure.repositories.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class UpdateProductUseCase {

    @Autowired
    private ProductRepository _productRepository;

    @Transactional
    public ProductDTO execute(UUID id, ProductDTO productDTO)  {
        try{
            var product = _productRepository.getReferenceById(id);
            ProductMapper.copyDtoToEntity(productDTO, product);
            var productSaved = _productRepository.save(product);
            return new ProductDTO(productSaved);
        }catch (EntityNotFoundException err){
            throw new ResourceNotFoundException("Recurso não encontrado !");
        }
    }
}
