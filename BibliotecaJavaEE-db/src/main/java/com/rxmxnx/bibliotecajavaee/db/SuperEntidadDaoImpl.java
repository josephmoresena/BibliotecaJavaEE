/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rxmxnx.bibliotecajavaee.db;

import com.rxmxnx.bibliotecajavaee.dominio.*;
import com.rxmxnx.bibliotecajavaee.log.*;
import com.speedment.jpastreamer.application.*;
import javax.persistence.*;
import com.speedment.jpastreamer.field.predicate.*;
import com.speedment.jpastreamer.field.trait.*;
import java.util.stream.*;

/**
 *
 * @author atem94
 * @param <U>
 * @param <T>
 */
abstract class SuperEntidadDaoImpl<U extends Number & Comparable<U>, T extends SuperEntidad<U>, TDetallado extends T, TEntidad extends TDetallado> {
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
    
    protected abstract Class<TEntidad> claseEntidad();
    protected abstract HasComparableOperators<TEntidad, U> campoId();
    protected abstract LogLocal log();
    
    protected final EntityManager entityManager() {
        return this.em;
    }
    protected final JPAStreamer streamer() {
        return this.jpaStreamer;
    }
    protected final boolean esActualizacion(T entidad) {
        return SuperEntidad.getId(entidad) != null;
    }
    protected final Stream<TEntidad> streamListado() {
        return this.streamListado(null);
    }
    protected final Stream<TEntidad> streamListado(SpeedmentPredicate<TEntidad> predicado) {
        this.initialize();
        Stream<TEntidad> resultado = this.streamer().stream(this.claseEntidad());
        return predicado != null ? resultado.filter(predicado) : resultado;
    }
    protected final Stream<TEntidad> streamEncontrar(U id) {
        this.initialize();
        return this.streamer()
                .stream(this.claseEntidad())
                .filter(this.campoId().equal(id));
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
