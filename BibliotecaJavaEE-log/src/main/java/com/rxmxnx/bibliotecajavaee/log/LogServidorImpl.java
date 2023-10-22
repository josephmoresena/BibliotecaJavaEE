/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rxmxnx.bibliotecajavaee.log;

import javax.annotation.*;
import javax.ejb.*;
import org.apache.logging.log4j.*;

/**
 *
 * @author atem94
 */
@Stateless
@Asynchronous
public class LogServidorImpl implements LogServidor {
    @Resource
    private SessionContext context;

    @Override
    public void info(String string, Object... os) {
        Logger log = LogManager.getLogger(this.nombreClase());
        log.info(string, os);
    }
    @Override
    public void error(String string, Object... os) {
        Logger log = LogManager.getLogger(this.nombreClase());
        log.error(string, os);
    }
    @Override
    public void error(String string, Throwable thrwbl) {
        Logger log = LogManager.getLogger(this.nombreClase());
        log.error(string, thrwbl);
    }
    
    private String nombreClase() {
        return this.context.getCallerPrincipal().getName();
    }
}
