/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rxmxnx.bibliotecajavaee.log;

import javax.ejb.*;

/**
 *
 * @author atem94
 */
@EJB
@Stateless
public class LogServidorFactoryImpl implements LogServidorFactory {

    @Override
    public <T> LogServidor createLog(Class<T> clase) {
        return new LogServidorImpl().init(clase);
    }
}
