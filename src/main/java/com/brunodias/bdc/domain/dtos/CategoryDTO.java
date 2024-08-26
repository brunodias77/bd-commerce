package com.brunodias.bdc.domain.dtos;

import com.brunodias.bdc.domain.entities.Category;
import lombok.Builder;

import java.util.UUID;

@Builder
public record CategoryDTO(
        UUID id,
        String name
) {
    public CategoryDTO(Category entity) {
        this(
                entity.getId(),
                entity.getName()
        );
    }
}

