package com.brunodias.bdc.application.services.mappers;

import com.brunodias.bdc.domain.dtos.CategoryDTO;
import com.brunodias.bdc.domain.dtos.ProductDTO;
import com.brunodias.bdc.domain.entities.Category;
import com.brunodias.bdc.domain.entities.Product;
import org.springframework.stereotype.Service;

public class ProductMapper {

    public static void copyDtoToEntity(ProductDTO dto, Product entity) {
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
