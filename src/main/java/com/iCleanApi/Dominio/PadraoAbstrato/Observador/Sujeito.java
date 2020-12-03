package com.iCleanApi.Dominio.PadraoAbstrato.Observador;

import java.util.Iterator;

import com.iCleanApi.Dominio.MapaObservadores;

public abstract class Sujeito {
	private MapaObservadores observadores = new MapaObservadores();
	
	public void adicionar(Observador o) {
		observadores.add(o);
	}

	public void remover(Observador o) throws Exception {
		observadores.remove(o);
	}

	public void notificar() {
		Iterator<Object> it = observadores.iterator();
		while (it.hasNext()) {
			Observador o = (Observador) it.next();
			o.atualizar();
		}
		observadores = new MapaObservadores();
	}
	
	public MapaObservadores getObservadores () {
		return this.observadores;
	}

}
