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
public interface LogServidor {
    void info(String className, String string, Object... os);
    void error(String className, String string, Object... os);
    void error(String className, String string, Throwable thrwbl);
}