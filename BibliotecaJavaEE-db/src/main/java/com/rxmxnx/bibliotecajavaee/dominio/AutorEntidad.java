/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rxmxnx.bibliotecajavaee.dominio;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author atem94
 */
@Entity
@Table(name = "AUTORES", catalog = "BIBLIOTECA_JEE", schema = "")
@XmlRootElement
public class AutorEntidad extends Autor implements Serializable {
}
