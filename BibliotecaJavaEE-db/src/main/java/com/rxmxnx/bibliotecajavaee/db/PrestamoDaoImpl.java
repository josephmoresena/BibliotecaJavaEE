/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rxmxnx.bibliotecajavaee.db;

import com.rxmxnx.bibliotecajavaee.db.entidad.*;
import com.rxmxnx.bibliotecajavaee.db.definicion.*;
import com.rxmxnx.bibliotecajavaee.dominio.detalle.*;
import com.rxmxnx.bibliotecajavaee.dominio.*;
import com.rxmxnx.bibliotecajavaee.log.*;
import com.speedment.jpastreamer.field.*;
import com.speedment.jpastreamer.field.predicate.*;
import com.speedment.jpastreamer.field.trait.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;
import javax.ejb.*;
import javax.transaction.*;
import javax.transaction.Transactional.*;

/**
 *
 * @author atem94
 */
@Stateless
public class PrestamoDaoImpl extends SuperEntidadDaoImpl<Long, Prestamo, PrestamoDetalle, PrestamoEntidad> implements PrestamoDao  {
    @EJB
    private LogServidorFactory logFactory;
    
    public PrestamoDaoImpl() {
    }
    
    @Override
    protected Class<PrestamoEntidad> claseEntidad() {
        return Definicion.INSTANCIA.clase();
    }
    @Override
    protected HasComparableOperators<PrestamoEntidad, Long> campoId() {
        return Definicion.INSTANCIA.id();
    }
    @Override
    protected LogServidorFactory logFactory() {
        return this.logFactory;
    }
    
    @Override
    @Transactional(TxType.SUPPORTS)
    public List<Prestamo> listar() {
        return this.streamListado()
                .map(p -> new Prestamo(p))
                .collect(Collectors.toList());
    }
    @Override
    @Transactional(TxType.SUPPORTS)
    public List<Prestamo> listarPrestamo(Function<? extends PrestamoDefinicion, SpeedmentPredicate<? extends Prestamo>> funcionPredicado) {
        return this.streamListado(PrestamoDaoImpl.predicado(funcionPredicado))
                .map(p -> new Prestamo(p))
                .collect(Collectors.toList());
    }
    @Override
    @Transactional(TxType.SUPPORTS)
    public Optional<Prestamo> encontrar(Long id) {
        return this.streamEncontrar(id)
                .map(p -> new Prestamo(p))
                .findAny();
    }
    @Override
    @Transactional(TxType.REQUIRES_NEW)
    public Prestamo guardar(Prestamo entidad) {
        this.initialize(false);
        PrestamoEntidad resultado = PrestamoEntidad.crearEntidad(entidad);
        if (this.esActualizacion(entidad)) {
            return this.entityManager().merge(resultado);
        }
        this.entityManager().persist(resultado);
        return resultado;
    }
    @Override
    @Transactional(TxType.REQUIRES_NEW)
    public boolean eliminar(Long id) {
        Optional<PrestamoEntidad> Prestamo = this.streamer()
                .stream(Definicion.INSTANCIA.clase())
                .filter(Definicion.INSTANCIA.id().equal(id))
                .findAny();
        if (Prestamo.isPresent()) {
            this.entityManager().joinTransaction();
            this.entityManager().remove(this.entityManager().merge(Prestamo.get()));
            return true;
        }
        return false;
    }

    @Override
    public List<PrestamoDetalle> listarDetallado() {
        return this.streamListado()
                .map(p -> new PrestamoDetalle(p))
                .collect(Collectors.toList());
    }
    @Override
    public List<PrestamoDetalle> listarPrestamoDetallado(Function<? extends PrestamoDefinicion, SpeedmentPredicate<? extends Prestamo>> funcionPredicado) {
        return this.streamListado(PrestamoDaoImpl.predicado(funcionPredicado))
                .map(p -> new PrestamoDetalle(p))
                .collect(Collectors.toList());
    }
    @Override
    public Optional<PrestamoDetalle> encontrarDetallado(Long id) {
        return this.streamEncontrar(id)
                .map(p -> new PrestamoDetalle(p))
                .findAny();
    }
    
    private static SpeedmentPredicate<PrestamoEntidad> predicado(Function<? extends PrestamoDefinicion, SpeedmentPredicate<? extends Prestamo>> funcionPredicado) {
        Function<Definicion, SpeedmentPredicate<PrestamoEntidad>> predicado = (Function)funcionPredicado;
        return predicado.apply(Definicion.INSTANCIA);
    }

    private static final class Definicion implements PrestamoDefinicion<PrestamoEntidad, LibroEntidad, UsuarioEntidad> {
        private static final Definicion INSTANCIA = new Definicion();
        
        private static final LongField<PrestamoEntidad> ID = LongField.create(PrestamoEntidad.class, "id", PrestamoEntidad::getPrestamoId, true);
        private static final ComparableField<PrestamoEntidad, Date> FECHA_PRESTAMO = ComparableField.create(PrestamoEntidad.class, "fecha_prestamo", PrestamoEntidad::getFechaPrestamo, false);
        private static final ComparableField<PrestamoEntidad, Date> FECHA_DEVOLCUION = ComparableField.create(PrestamoEntidad.class, "fecha_devolucion", PrestamoEntidad::getFechaPrestamo, false);
        private static final BooleanField<PrestamoEntidad> DEVUELTO = BooleanField.create(PrestamoEntidad.class, "devuelto", PrestamoEntidad::getDevuelto, false);
        private static final IntField<PrestamoEntidad> LIBRO_ID = IntField.create(PrestamoEntidad.class, "id_libro", PrestamoEntidad::getLibroId, false);
        private static final IntField<PrestamoEntidad> USUARIO_ID = IntField.create(PrestamoEntidad.class, "id_usuario", PrestamoEntidad::getUsuarioId, false);
        
        private static final ReferenceField<PrestamoEntidad, LibroEntidad> LIBRO = ReferenceField.create(PrestamoEntidad.class, "id_libro", PrestamoEntidad::getLibro, false);
        private static final ReferenceField<PrestamoEntidad, UsuarioEntidad> USUARIO = ReferenceField.create(PrestamoEntidad.class, "id_usuario", PrestamoEntidad::getUsuario, false);
        
        private Definicion() {}
        @Override
        public Class<PrestamoEntidad> clase() {
            return PrestamoEntidad.class;
        }
        @Override
        public LongField<PrestamoEntidad> id() {
            return ID;
        }
        @Override
        public ComparableField<PrestamoEntidad, Date> fechaPrestamo() {
            return FECHA_PRESTAMO;
        }
        @Override
        public ComparableField<PrestamoEntidad, Date> fechaDevolucion() {
            return FECHA_DEVOLCUION;
        }
        @Override
        public BooleanField<PrestamoEntidad> devuelto() {
            return DEVUELTO;
        }
        @Override
        public IntField<PrestamoEntidad> libroId() {
            return LIBRO_ID;
        }
        @Override
        public IntField<PrestamoEntidad> usuarioId() {
            return USUARIO_ID;
        }
        @Override
        public ReferenceField<PrestamoEntidad, LibroEntidad> libro() {
            return LIBRO;
        }
        @Override
        public ReferenceField<PrestamoEntidad, UsuarioEntidad> usuario() {
            return USUARIO;
        }
    }
}