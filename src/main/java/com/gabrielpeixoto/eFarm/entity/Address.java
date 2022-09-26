/**
 * Classe que modela a entidade 'endereço', com seus atributos
 * @author Gabriel Porto Santos Peixoto
 */

package com.gabrielpeixoto.eFarm.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Address {
    /**
     * Identificador único de cada Address (chave primária)
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Logradouro
     */
    @Column(name = "address_name")
    private String addressName;

    /**
     * Número do endereço
     */
    @Column(name = "address_number")
    private String addressNumber;

    /**
     * Complemento
     */
    @Column(name = "address_complement")
    private String addressComplement;

    /**
     * Bairro
     */
    @Column(name = "address_neighborhood")
    private String neighborhood;

    /**
     * Cidade
     */
    @Column(name = "address_city")
    private String city;

    /**
     * Estado
     */
    @Column(name = "address_state")
    private String state;

    /**
     * CEP
     */
    @Column(name = "address_cep", nullable = false)
    private String cep;
}
