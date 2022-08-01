/**
 * Classe que representa a exceção a ser lançada ao se inserir uma senha incorreta no login
 * @author Gabriel Porto Santos Peixoto
 */

package com.gabrielpeixoto.eFarm.exceptions;

public class IncorrectPasswordException extends RuntimeException{
    /**
     * Construtor; chama a sua versão da classe pai para imprimir a mensagem adequada
     */
    public IncorrectPasswordException()
    {
        super("Senha incorreta!");
    }
}
