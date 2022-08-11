/**
 * Classe que representa um banco de dados de medicamentos
 * @author Gabriel Porto Santos Peixoto
 */

package com.gabrielpeixoto.eFarm.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class AvailableDrugs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nome do produto
     */
    @Column(name = "product_name")
    private String productName;

    /**
     * Categoria do medicamento
     */
    @Column(name = "drug_category")
    private String category;

    /**
     * Número de registro do medicamento
     */
    @Column(name = "drug_registration_number")
    private Long registrationNumber;

    /**
     * Classe terapêutica do medicamento
     */
    @Column(name = "drug_therapeutic_class")
    private String therapeuticClass;
}
