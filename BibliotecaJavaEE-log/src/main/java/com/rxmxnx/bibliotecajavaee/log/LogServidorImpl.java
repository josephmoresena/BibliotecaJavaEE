/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rxmxnx.bibliotecajavaee.log;

import javax.ejb.*;
import org.apache.logging.log4j.*;

/**
 *
 * @author atem94
 */
@Stateful
public class LogServidorImpl implements LogServidor {
    private Logger log;
    
    protected LogServidorImpl init(Class<?> clase) {
        this.log = LogManager.getLogger(clase);
        return this;
    }
    protected LogServidorImpl init(String nombreClase) {
        this.log = LogManager.getLogger(nombreClase);
        return this;
    }

    @Override
    public void info(String string, Object... os) {
        this.log.info(string, os);
    }
    @Override
    public void error(String string, Object... os) {
        this.log.error(string, os);
    }

    @Override
    public void error(String string, Throwable thrwbl) {
        this.log.error(string, thrwbl);
    }
}
