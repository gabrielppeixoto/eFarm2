/**
 * Enumera os tipos de usuário que irão utilizar o site
 * @author Gabriel Porto Santos Peixoto
 */

package com.gabrielpeixoto.eFarm.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public enum UserType {
    PESSOA_FISICA("Pessoa física"), PESSOA_JURIDICA("Pessoa jurídica");

    private String tipo;
}
