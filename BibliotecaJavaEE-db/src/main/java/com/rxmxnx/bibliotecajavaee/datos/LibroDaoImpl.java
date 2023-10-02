/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rxmxnx.bibliotecajavaee.datos;

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
public class LibroDaoImpl extends SuperEntidadDaoImpl<Integer, Libro, LibroReferencia, LibroEntidad> implements LibroDao  {
    @EJB
    private LogServidorFactory logFactory;
    
    public LibroDaoImpl() {
    }
    
    @Override
    protected Class<LibroEntidad> claseEntidad() {
        return Definicion.INSTANCIA.clase();
    }
    @Override
    protected HasComparableOperators<LibroEntidad, Integer> campoId() {
        return Definicion.INSTANCIA.id();
    }
    @Override
    protected LogServidorFactory logFactory() {
        return this.logFactory;
    }
    
    @Override
    @Transactional(TxType.SUPPORTS)
    public List<Libro> listar() {
        return this.streamListado()
                .map(p -> new Libro(p))
                .collect(Collectors.toList());
    }
    @Override
    @Transactional(TxType.SUPPORTS)
    public List<Libro> listarLibro(Function<? extends LibroDefinicion, SpeedmentPredicate<? extends Libro>> funcionPredicado) {
        return this.streamListado(LibroDaoImpl.predicado(funcionPredicado))
                .map(p -> new Libro(p))
                .collect(Collectors.toList());
    }
    @Override
    @Transactional(TxType.SUPPORTS)
    public Optional<Libro> encontrar(Integer id) {
        return this.streamEncontrar(id)
                .map(p -> new Libro(p))
                .findAny();
    }
    @Override
    @Transactional(TxType.REQUIRES_NEW)
    public Libro guardar(Libro entidad) {
        this.initialize(false);
        LibroEntidad resultado = LibroEntidad.crearEntidad(entidad);
        if (this.esActualizacion(entidad)) {
            return this.entityManager().merge(resultado);
        }
        this.entityManager().persist(resultado);
        return resultado;
    }
    @Override
    @Transactional(TxType.REQUIRES_NEW)
    public boolean eliminar(Integer id) {
        Optional<LibroEntidad> Libro = this.streamer()
                .stream(Definicion.INSTANCIA.clase())
                .filter(Definicion.INSTANCIA.id().equal(id))
                .findAny();
        if (Libro.isPresent()) {
            this.entityManager().joinTransaction();
            this.entityManager().remove(this.entityManager().merge(Libro.get()));
            return true;
        }
        return false;
    }

    @Override
    public List<LibroReferencia> listarDetallado() {
        return this.streamListado()
                .map(p -> new LibroReferencia(p))
                .collect(Collectors.toList());
    }
    @Override
    public List<LibroReferencia> listarLibroDetallado(Function<? extends LibroDefinicion, SpeedmentPredicate<? extends Libro>> funcionPredicado) {
        return this.streamListado(LibroDaoImpl.predicado(funcionPredicado))
                .map(p -> new LibroReferencia(p))
                .collect(Collectors.toList());
    }
    @Override
    public Optional<LibroReferencia> encontrarDetallado(Integer id) {
        return this.streamEncontrar(id)
                .map(p -> new LibroReferencia(p))
                .findAny();
    }
    
    private static SpeedmentPredicate<LibroEntidad> predicado(Function<? extends LibroDefinicion, SpeedmentPredicate<? extends Libro>> funcionPredicado) {
        Function<Definicion, SpeedmentPredicate<LibroEntidad>> predicado = (Function)funcionPredicado;
        return predicado.apply(Definicion.INSTANCIA);
    }

    private static final class Definicion implements LibroDefinicion<LibroEntidad, AutorEntidad, PaisEntidad, GeneroEntidad> {
        private static final Definicion INSTANCIA = new Definicion();
        
        private static final IntField<LibroEntidad> ID = IntField.create(LibroEntidad.class, "id", LibroEntidad::getLibroId, true);
        private static final StringField<LibroEntidad> TITULO = StringField.create(LibroEntidad.class, "titulo", LibroEntidad::getTitulo, false);
        private static final StringField<LibroEntidad> ISBN = StringField.create(LibroEntidad.class, "isbn", LibroEntidad::getIsbn, false);
        private static final ReferenceField<LibroEntidad, String> SINOPSIS = ReferenceField.create(LibroEntidad.class, "sinopsis", LibroEntidad::getSinopsis, false);
        private static final IntField<LibroEntidad> AUTOR_ID = IntField.create(LibroEntidad.class, "id_autor", LibroEntidad::getAutorId, false);
        private static final ShortField<LibroEntidad> GENERO_ID = ShortField.create(LibroEntidad.class, "id_genero", LibroEntidad::getGeneroId, false);
        private static final ShortField<LibroEntidad> PAIS_ID = ShortField.create(LibroEntidad.class, "id_pais", LibroEntidad::getPaisId, false);
        
        private static final ReferenceField<LibroEntidad, PaisEntidad> PAIS = ReferenceField.create(LibroEntidad.class, "id_pais", LibroEntidad::getPais, false);
        private static final ReferenceField<LibroEntidad, AutorEntidad> AUTOR = ReferenceField.create(LibroEntidad.class, "id_autor", LibroEntidad::getAutor, false);
        private static final ReferenceField<LibroEntidad, GeneroEntidad> GENERO = ReferenceField.create(LibroEntidad.class, "id_genero", LibroEntidad::getGenero, false);
        
        
        private Definicion() {}
        @Override
        public Class<LibroEntidad> clase() {
            return LibroEntidad.class;
        }
        @Override
        public IntField<LibroEntidad> id() {
            return ID;
        }
        @Override
        public StringField<LibroEntidad> titulo() {
            return TITULO;
        }
        @Override
        public StringField<LibroEntidad> isbn() {
            return ISBN;
        }
        @Override
        public ReferenceField<LibroEntidad, String> sinopsis() {
            return SINOPSIS;
        }
        @Override
        public IntField<LibroEntidad> autorId() {
            return AUTOR_ID;
        }
        @Override
        public ShortField<LibroEntidad> generoId() {
            return GENERO_ID;
        }
        @Override
        public ShortField<LibroEntidad> PaisId() {
            return PAIS_ID;
        }
        @Override
        public ReferenceField<LibroEntidad, AutorEntidad> autor() {
            return AUTOR;
        }
        @Override
        public ReferenceField<LibroEntidad, GeneroEntidad> genero() {
            return GENERO;
        }
        @Override
        public ReferenceField<LibroEntidad, PaisEntidad> paisPublicacion() {
            return PAIS;
        }
    }
}