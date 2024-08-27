package com.brunodias.bdc.application.services;

import com.brunodias.bdc.domain.dtos.CategoryDTO;
import com.brunodias.bdc.domain.dtos.ProductDTO;
import com.brunodias.bdc.domain.entities.Category;
import com.brunodias.bdc.domain.entities.Product;
import com.brunodias.bdc.infrastructure.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProductService {

    public void copyDtoToEntity(ProductDTO dto, Product entity) {
        entity.setName(dto.name());
        entity.setDescription(dto.description());
        entity.setPrice(dto.price());
        entity.setImgUrl(dto.imgUrl());
        entity.getCategories().clear();
        for (CategoryDTO catDto : dto.categories()) {
            Category cat = new Category();
            cat.setId(catDto.id());
            entity.getCategories().add(cat);
        }
    }

}
