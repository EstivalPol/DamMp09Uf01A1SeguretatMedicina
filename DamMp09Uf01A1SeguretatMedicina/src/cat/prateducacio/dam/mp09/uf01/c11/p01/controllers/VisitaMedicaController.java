package cat.prateducacio.dam.mp09.uf01.c11.p01.controllers;

import java.util.List;
import java.util.Scanner;

import cat.prateducacio.dam.mp09.uf01.c11.p01.model.domain.VisitaMedica;
import cat.prateducacio.dam.mp09.uf01.c11.p01.model.service.VisitaMedicaService;
import cat.prateducacio.dam.mp09.uf01.c11.p01.view.console.VisitaMedicaView;

public class VisitaMedicaController {

	private VisitaMedicaController() {

		visitaMedicaView = VisitaMedicaView.getInstance();

		try {
			visitaMedicaService = VisitaMedicaService.getInstance();
		} catch (Exception e) {
			visitaMedicaView.mostrarDada(e.getMessage(), true);
		}
	}

	private VisitaMedicaView visitaMedicaView;
	private VisitaMedicaService visitaMedicaService;
	private static VisitaMedicaController instance = null;

	public static VisitaMedicaController getInstance() {
		if (instance == null) {
			instance = new VisitaMedicaController();
		}
		return instance;
	}
	
	public void inici() {
		int i = 0;
		
		while(i != 2) {
			
			i = visitaMedicaView.inici();
			
			if(i == 1) {
				afegirVisitaMedica();
			}
			else if(i == 2) {
				break;
			}
			else {
				visitaMedicaView.mostrarDada("Error.", true);
			}
		}
	}

	public void afegirVisitaMedica() {
		try {
			VisitaMedica visitaMedica = visitaMedicaView.demanaVisitaMedica();
			visitaMedica = visitaMedicaService.add(visitaMedica);
			visitaMedicaView.mostrarDada(visitaMedica.toString(), false);

		} catch (Exception ex) {
			visitaMedicaView.mostrarDada(ex.getMessage(), true);
		}
	}

	public void llistaVisitaMedica() {
		try {
			List<VisitaMedica> llista = visitaMedicaService.getAll();
			visitaMedicaView.mostrarDada(llista.toString(), false);
		} catch (Exception ex) {
			visitaMedicaView.mostrarDada(ex.getMessage(), true);
		}
	}

	public void getOneVisitaMedica() {
		try {
			int IdVisita = visitaMedicaView.demanaIdVisita();
			VisitaMedica visitaMedica = visitaMedicaService.getOne(IdVisita);
			visitaMedicaView.mostrarDada(visitaMedica.toString(), false);
		} catch (Exception ex) {
			visitaMedicaView.mostrarDada(ex.getMessage(), true);
		}
	}
	
	
}
