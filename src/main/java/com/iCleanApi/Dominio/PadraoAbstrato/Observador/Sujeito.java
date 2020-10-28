package com.iCleanApi.Dominio.PadraoAbstrato.Observador;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



public abstract class Sujeito {
	List observadores = new ArrayList<>();
	
	public void adicionar(Observador o) {
		observadores.add(o);
	}

	public void remover(Observador o) {
		observadores.remove(o);
	}

	public void notificar() {
		Iterator it = observadores.iterator();
		while (it.hasNext()) {
			Observador o = (Observador) it.next();
			o.atualizar(this);
		}
	}

}
