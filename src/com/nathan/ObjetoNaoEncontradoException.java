package com.nathan;

public class ObjetoNaoEncontradoException extends Exception{
    public ObjetoNaoEncontradoException(Object data) {
        super("Objeto "+data.toString()+" não encontrado");
    }
}
