/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rxmxnx.bibliotecajavaee.web;

/**
 *
 * @author atem94
 * @param <T>
 */
public final class AtributoPagina<T> {
    private final T objeto;
    private final Exception ex;
    
    public AtributoPagina() {
        this.objeto = null;
        this.ex = null;
    }
    public AtributoPagina(T objeto) {
        this.objeto = objeto;
        this.ex = null;
    }
    public AtributoPagina(Exception ex) {
        this.objeto = null;
        this.ex = ex;
    }
    
    public T getObjeto() throws Exception {
        if (ex != null)
            throw ex;
        return (T)objeto;
    }
}
