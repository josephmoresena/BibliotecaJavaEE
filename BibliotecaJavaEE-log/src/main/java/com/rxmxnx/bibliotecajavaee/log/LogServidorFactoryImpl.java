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
//@EJB(beanName="com.rxmxnx.bibliotecajavaee.log.LogServidorFactory")
@Stateless
public class LogServidorFactoryImpl implements LogServidorFactory {

    static {
        System.out.println("Loaded LogServidorFactoryImp class.");
    }
    
    @Override
    public LogServidor createLog(Class<?> clase) {
        return new LogServidorImpl().init(clase);
    }
}
