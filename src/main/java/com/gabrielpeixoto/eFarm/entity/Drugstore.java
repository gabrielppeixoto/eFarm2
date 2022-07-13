/**
 * Classe que modela a entidade 'farmácia', com seus atributos
 * @author Gabriel Porto Santos Peixoto
 */

package com.gabrielpeixoto.eFarm.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Drugstore {
    /**
     * Identificador único de cada Drugstore (chave primária)
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nome da farmácia
     */
    @Column(name = "drugstore_name", nullable = false)
    private String name;

    /**
     * CNPJ da farmácia
     */
    @Column(name = "drugstore_cnpj", nullable = false)
    private String cnpj;

    /**
     * Endereço da farmácia
     */
    @Column(name = "drugstore_address", nullable = false)
    private String address;

    /**
     * Chave estrangeira para o dono da farmácia
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    /**
     *
     */
    @OneToMany(mappedBy = "drugstore", cascade = CascadeType.ALL)
    private List<Product> store;
}
