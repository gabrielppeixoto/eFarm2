package com.gabrielpeixoto.eFarm.entity;

import com.gabrielpeixoto.eFarm.enums.ProductType;

import javax.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "product_type")
    private ProductType type;

    @Column(name = "product_name", nullable = false)
    private String name;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "drugstore_id")
    private Drugstore drugstore;

    public Drugstore getDrugstore() {
        return drugstore;
    }

    public void setDrugstore(Drugstore drugstore) {
        this.drugstore = drugstore;
    }
}
