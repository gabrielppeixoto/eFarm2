/**
 * Classe que representa a entidade Usuário, responsável por modelar um usuário do site
 * @author Gabriel Porto Santos Peixoto
 */

package com.gabrielpeixoto.eFarm.entity;
import com.gabrielpeixoto.eFarm.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "usuario")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    /**
     * Identificador
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nome completo
     */
    @Column(name = "name", nullable = false)
    private String completeName;

    /**
     * Idade
     */
    @Column(name = "age")
    private Integer age;

    /**
     * Endereço
     */
    @Column(name = "address", nullable = false)
    private String address;

    /**
     * CPF ou CNPJ
     */
    @Column(name = "identity", nullable = false)
    private String identityNumber;

    /**
     * Lista de estabelecimentos que ele possui
     */
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Drugstore> drugstores;

    /**
     * E-mail para acesso
     */
    @Column(name = "user_email", unique = true)
    private String email;

    /**
     * Senha
     */
    @Column(name = "user_password", unique = true)
    private String password;

    /**
     * Tipo de usuário (pessoa física ou jurídica)
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "user_type")
    private UserType userType;

    public User(String completeName, Integer age, String address, String identityNumber) {
        this.completeName = completeName;
        this.age = age;
        this.address = address;
        this.identityNumber = identityNumber;
    }
}
