package com.iCleanApi.Dominio.PadraoAbstrato.Observador;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class Sujeito {
	private List<Observador> observadores = new ArrayList<>();
	
	public void adicionar(Observador o) throws Exception {
		observadores.add(o);
	}

	public void remover(Observador o) {
		observadores.remove(o);
	}

	public void notificar() {
		Iterator<Observador> it = observadores.iterator();
		while (it.hasNext()) {
			Observador o = (Observador) it.next();
			o.atualizar();
		}
	}
	
	public List<Observador> getObservadores () {
		return this.observadores;
	}
	
	protected void setObservadores (List<Observador> observadores) {
		this.observadores = observadores;
	}

}
