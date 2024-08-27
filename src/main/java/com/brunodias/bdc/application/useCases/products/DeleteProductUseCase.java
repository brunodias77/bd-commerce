package com.brunodias.bdc.application.useCases.products;

import com.brunodias.bdc.application.exceptions.DatabaseException;
import com.brunodias.bdc.application.exceptions.ResourceNotFoundException;
import com.brunodias.bdc.infrastructure.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class DeleteProductUseCase {

    @Autowired
    private ProductRepository _productRepository;

    @Transactional(propagation = Propagation.SUPPORTS)
    public void execute(UUID productId){
        if(!_productRepository.existsById(productId)){
            throw new ResourceNotFoundException("Recurso nao encontrado !");
        }
        try {
            _productRepository.deleteById(productId);
        }catch (EmptyResultDataAccessException err){
            throw new ResourceNotFoundException("Recurso nao encontrado !");
        }catch (DataIntegrityViolationException err){
            throw new DatabaseException("Falha de integridade referencial !");
        }
    }
}
