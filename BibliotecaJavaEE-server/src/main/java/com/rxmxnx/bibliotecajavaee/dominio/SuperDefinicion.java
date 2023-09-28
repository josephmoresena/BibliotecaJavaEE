/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rxmxnx.bibliotecajavaee.dominio;

import com.speedment.jpastreamer.field.comparator.FieldComparator;

/**
 *
 * @author atem94
 * @param <TEntidad>
 */
public interface SuperDefinicion<TEntidad extends SuperEntidad> {
    FieldComparator<TEntidad> id();
}