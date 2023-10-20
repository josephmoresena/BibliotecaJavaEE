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
@Stateless
@Asynchronous
public class LogServidorImpl implements LogServidor {

    @Override
    public void info(String className, String string, Object... os) {
        Logger log = LogManager.getLogger(className);
        log.info(string, os);
    }
    @Override
    public void error(String className, String string, Object... os) {
        Logger log = LogManager.getLogger(className);
        log.error(string, os);
    }
    @Override
    public void error(String className, String string, Throwable thrwbl) {
        Logger log = LogManager.getLogger(className);
        log.error(string, thrwbl);
    }
}
