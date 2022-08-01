/**
 * Classe que representa a entidade Produto
 * @author Gabriel Porto Santos Peixoto
 */

package com.gabrielpeixoto.eFarm.entity;

import com.gabrielpeixoto.eFarm.enums.ProductType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Product {
    /**
     * Identificador
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Tipo do produto
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "product_type")
    private ProductType type;

    /**
     * Nome do produto
     */
    @Column(name = "product_name", nullable = false)
    private String name;

    /**
     * Quantidade em estoque
     */
    @Column(name = "quantity", nullable = false)
    private int quantity;

    /**
     * Farmácia a qual está relacionado
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "drugstore_id")
    private Drugstore drugstore;
}
