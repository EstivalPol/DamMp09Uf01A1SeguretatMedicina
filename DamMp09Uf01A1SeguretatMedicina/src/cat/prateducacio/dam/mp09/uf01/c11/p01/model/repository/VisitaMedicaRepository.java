package cat.prateducacio.dam.mp09.uf01.c11.p01.model.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import cat.prateducacio.dam.mp09.uf01.c11.p01.model.domain.VisitaMedica;

public class VisitaMedicaRepository {

	private VisitaMedicaRepository() {

		llistaVisitaMedica = new ArrayList<VisitaMedica>();
	}

	private static VisitaMedicaRepository instance = null;

	public static VisitaMedicaRepository getInstance() {
		if (instance == null) {
			instance = new VisitaMedicaRepository();
		}

		return instance;
	}

	private List<VisitaMedica> llistaVisitaMedica;

	public void add(VisitaMedica VisitaMedica) {
		llistaVisitaMedica.add(VisitaMedica);

	}


	public List<VisitaMedica> getAll() {
		return llistaVisitaMedica;
	}

	public VisitaMedica getOne(int IdVisita) {
		VisitaMedica resultat = null;

		for (VisitaMedica u : llistaVisitaMedica) {
			if (u.getIdVisita() == (IdVisita)) {
				resultat = u;
				break;  
			}
		}

		return resultat;
	}

}
