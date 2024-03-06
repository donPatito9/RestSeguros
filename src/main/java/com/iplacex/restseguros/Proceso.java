/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iplacex.restseguros;

import java.util.Date;

/**
 *
 * @author UserDevs
 */
public class Proceso {
    private int id;
	    private String nombre;
	    private Date inicio;
	    private Date termino;

	    public Proceso() {
	    }

	    public Proceso(int id, String nombre, Date inicio, Date termino) {
	        this.id = id;
	        this.nombre = nombre;
	        this.inicio = inicio;
	        this.termino = termino;
	    }

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public Date getInicio() {
			return inicio;
		}

		public void setInicio(Date inicio) {
			this.inicio = inicio;
		}

		public Date getTermino() {
			return termino;
		}

		public void setTermino(Date termino) {
			this.termino = termino;
		}

}
