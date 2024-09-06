package com.brunodias.bdc.dto;


import com.brunodias.bdc.entities.Product;

import java.util.UUID;

public class ProductDTO {

    private UUID id;
    private String name;

    public ProductDTO() {
    }

    public ProductDTO(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public ProductDTO(Product entity) {
        id = entity.getId();
        name = entity.getName();
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
