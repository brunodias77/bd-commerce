package com.brunodias.bdc.domain.dtos;

import com.brunodias.bdc.domain.entities.Product;
import jakarta.validation.constraints.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public record ProductDTO(
        UUID id,

        @NotBlank(message = "Campo obrigatório")
        @Size(min = 3, max = 80, message = "O nome deve ter entre 3 e 80 caracteres")
        String name,

        @NotBlank(message = "Campo obrigatório")
        @Size(min = 10, message = "A descrição deve ter pelo menos 10 caracteres")
        String description,

        @NotNull(message = "O campo preço deve ser preenchido")
        @Positive(message = "O preço deve ser positivo")
        Double price,

        String imgUrl,

        @NotEmpty(message = "É necessário ter pelo menos uma categoria")
        List<CategoryDTO> categories
) {
    public ProductDTO(Product entity) {
        this(
                entity.getId(),
                entity.getName(),
                entity.getDescription(),
                entity.getPrice(),
                entity.getImgUrl(),
                entity.getCategories().stream().map(CategoryDTO::new).collect(Collectors.toList())
        );
    }
}
