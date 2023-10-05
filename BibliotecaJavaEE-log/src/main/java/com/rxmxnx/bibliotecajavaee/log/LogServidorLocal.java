/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rxmxnx.bibliotecajavaee.log;

import javax.ejb.Local;

/**
 *
 * @author atem94
 */
@Local
public interface LogServidorLocal extends LogServidor {
    LogServidorLocal init(String nombreClase);
    LogServidorLocal init(Class<?> clase);
}
