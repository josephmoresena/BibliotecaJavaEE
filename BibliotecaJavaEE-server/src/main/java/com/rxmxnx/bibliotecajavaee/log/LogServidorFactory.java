/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rxmxnx.bibliotecajavaee.log;

import javax.ejb.Remote;

/**
 *
 * @author atem94
 */
@Remote
public interface LogServidorFactory {
    <T> LogServidor createLog(Class<T> clase);
}
