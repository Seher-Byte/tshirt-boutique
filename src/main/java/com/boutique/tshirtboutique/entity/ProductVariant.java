package com.boutique.tshirtboutique.entity;

import jakarta.persistence.*;

@Entity
@Table(
        name = "product_variants",
        uniqueConstraints = @UniqueConstraint(
                name = "uq_product_size_color",
                columnNames = {"product_id", "size", "color"}
        )
)
public class ProductVariant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    private TshirtSize size;

    @Column(nullable = false, length = 50)
    private String color;

    @Column(nullable = false)
    private Integer stockQuantity = 0;

    @Column(length = 7)
    private String colorHex;

    // --- Constructorlar ---
    public ProductVariant() {
    }

    public ProductVariant(Long id, Product product, TshirtSize size, String color, Integer stockQuantity, String colorHex) {
        this.id = id;
        this.product = product;
        this.size = size;
        this.color = color;
        this.stockQuantity = stockQuantity;
        this.colorHex = colorHex;
    }

    // --- Getters & Setters ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }

    public TshirtSize getSize() { return size; }
    public void setSize(TshirtSize size) { this.size = size; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public Integer getStockQuantity() { return stockQuantity; }
    public void setStockQuantity(Integer stockQuantity) { this.stockQuantity = stockQuantity; }

    public String getColorHex() { return colorHex; }
    public void setColorHex(String colorHex) { this.colorHex = colorHex; }
}