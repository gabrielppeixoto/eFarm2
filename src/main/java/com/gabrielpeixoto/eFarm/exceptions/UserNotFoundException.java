/**
 * Classe que representa a exceção a ser lançada ao se tentar logar com um usuário inexistente
 * @author Gabriel Porto Santos Peixoto
 */

package com.gabrielpeixoto.eFarm.exceptions;

public class UserNotFoundException extends RuntimeException{
    /**
     * Construtor; chama a sua versão da classe pai para imprimir a mensagem adequada
     */
    public UserNotFoundException() {
        super("Usuário não encontrado!");
    }
}
