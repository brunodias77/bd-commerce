package com.brunodias.bdc.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name = "products")
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Product extends BaseEntity{

    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    private Double price;

    private String imgUrl;

    @ManyToMany
    @JoinTable(name = "product_category",
                joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private Set<Category> categories = new HashSet<>();

    @OneToMany(mappedBy = "id.product")
    private Set<OrderItem> items = new HashSet<>();

    public List<Order> getOrders() {
        return items.stream().map(x -> x.getOrder()).toList();
    }
}
