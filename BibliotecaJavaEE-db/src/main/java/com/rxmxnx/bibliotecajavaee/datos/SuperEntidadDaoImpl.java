/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rxmxnx.bibliotecajavaee.datos;

import com.rxmxnx.bibliotecajavaee.dominio.*;
import com.rxmxnx.bibliotecajavaee.log.LogServidorFactory;
import com.speedment.jpastreamer.application.*;
import javax.persistence.*;
import com.rxmxnx.bibliotecajavaee.log.LogServidor;

/**
 *
 * @author atem94
 * @param <U>
 * @param <TEntidad>
 */
abstract class SuperEntidadDaoImpl<U extends Number & Comparable<U>, TEntidad extends SuperEntidad<U>> {
    private static final String UNIDAD_BASE_DATOS = "BibliotecaJavaEE_PU";
    
    private LogServidor log;
    
    @PersistenceUnit
    private final EntityManagerFactory emf;

    private final EntityManager em;
    private final JPAStreamer jpaStreamer;
    
    protected SuperEntidadDaoImpl() {
        this.emf = Persistence.createEntityManagerFactory(UNIDAD_BASE_DATOS);
        this.em = emf.createEntityManager();
        this.jpaStreamer = JPAStreamer.of(emf);
    }
    
    protected abstract Class<? extends TEntidad> claseEntidad();
    protected abstract LogServidorFactory logFactory();
    protected final EntityManager entityManager() {
        return this.em;
    }
    protected final LogServidor log() {
        if (this.log == null) {
            this.log = this.logFactory().createLog(this.getClass());
        }
        return this.log;
    }
    protected final JPAStreamer streamer() {
        return this.jpaStreamer;
    }
    
    protected final void initialize() {
        this.initialize(true);
    }
    @SuppressWarnings("UseSpecificCatch")
    protected final void initialize(boolean readOnly) {
        try 
        {
            this.em.clear();
            this.jpaStreamer.resetStreamer(this.claseEntidad());
            if (readOnly)
                this.log().info("Transaccion de solo lectura.");
            else {
                this.em.joinTransaction();
                this.log().info("Transaccion iniciada.");
            }
        }
        catch(Exception ex) {
            this.log().error("Error iniciando transacción.", ex);
        }
    }
}
