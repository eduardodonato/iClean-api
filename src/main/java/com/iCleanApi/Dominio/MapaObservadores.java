package com.iCleanApi.Dominio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.iCleanApi.Dominio.PadraoAbstrato.Observador.Observador;

public class MapaObservadores implements Iterable<Object> {
	private Map<Long ,List<Observador>> mapObservadores;
	
	@Override
	public Iterator<Object> iterator() {
		return new ObservadorIterator(getObservadores());
	}
	
	public MapaObservadores () {
		mapObservadores = new HashMap<>();
	}
	
	public void add(Observador o) {
		if (mapObservadores.containsKey(o.getId())) mapObservadores.get(o.getId()).add(o);
		else {
			mapObservadores.put(o.getId(), new ArrayList<Observador>());
			mapObservadores.get(o.getId()).add(o);
		}
	}

	public void remove(Observador o) throws Exception {
		if (!mapObservadores.containsKey(o.getId())) throw new Exception("Observador não encontrado");
		if (!mapObservadores.get(o.getId()).contains(o)) throw new Exception("Observador não encontrado");
		mapObservadores.get(o.getId()).remove(o);
		
	}

	public List<Observador> getObservadores() {
		List<Observador> listaResultado = new ArrayList<>();
		for (List<Observador> listaAtual : mapObservadores.values()) {
			listaResultado.addAll(listaAtual);
		} return listaResultado;
	}

	
	public void reset () {
		mapObservadores = new HashMap<>();
	}

}
