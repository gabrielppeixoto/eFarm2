/**
 * Classe que modela um usuário que está logado no sistema
 * @author Gabriel Porto Santos Peixoto
 */

package com.gabrielpeixoto.eFarm.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoggedUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nome do usuário logado
     */
    @Column(name = "logged_user_name")
    private String loggedUserName;

    /**
     * E-mail do usuário logado
     */
    @Column(name = "logged_user_email")
    private String loggedUserEmail;
}
