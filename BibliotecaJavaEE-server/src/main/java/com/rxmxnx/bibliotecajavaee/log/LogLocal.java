/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rxmxnx.bibliotecajavaee.log;

import javax.ejb.*;
import javax.enterprise.context.*;

/**
 *
 * @author atem94
 */
@Dependent
public class LogLocal {
    @EJB
    private LogServidor log;
    @EJB
    private EJBContext ejbContext;
    
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
        return this.ejbContext.getCallerPrincipal().getName();
    }
}
