/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rxmxnx.bibliotecajavaee.log;

import javax.enterprise.context.*;
import javax.enterprise.inject.spi.*;
import javax.inject.Inject;

/**
 *
 * @author atem94
 */
@Dependent
public class LogLocal {
    private final Class<?> clase;
    private LogServidor log;
    
    @Inject
    public LogLocal(InjectionPoint inyeccion) {
        this.clase = inyeccion.getMember().getDeclaringClass();
    }
    
    public LogLocal utilizando(LogServidor log) {
        this.log = log;
        return this;
    }
    
    public void info(String string) {
        this.log.info(this.nombreClase(), string);
    }
    public void info(String string, Object... os) {
        this.log.info(this.nombreClase(), string, os);
    }
    public void error(String string) {
        this.log.error(this.nombreClase(), string);
    }
    public void error(String string, Object... os) {
        this.log.error(this.nombreClase(), string, os);
    }
    public void error(String string, Throwable thrwbl){
        this.log.error(this.nombreClase(), string, thrwbl);
    }
    
    private String nombreClase() {
        return this.clase.getName();
    }
}
