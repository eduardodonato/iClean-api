package com.iCleanApi.Dominio;

import java.util.Iterator;
import java.util.List;

import com.iCleanApi.Dominio.PadraoAbstrato.Observador.Observador;

public class ObservadorIterator implements Iterator<Object> {
	private List<Observador> observadores;
	
	public ObservadorIterator (List<Observador> observadores) {
		this.observadores = observadores;
	}
	
	@Override
	public boolean hasNext() {
		return !observadores.isEmpty();
	}

	@Override
	public Observador next() {
		return observadores.remove(0);
	}

}
