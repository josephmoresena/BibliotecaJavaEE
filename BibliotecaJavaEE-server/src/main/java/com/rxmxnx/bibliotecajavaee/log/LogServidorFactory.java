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
@Remote
public interface LogServidorFactory {
    LogServidor createLog(String nombreClase);
    LogServidor createLog(Class<?> clase);
}
