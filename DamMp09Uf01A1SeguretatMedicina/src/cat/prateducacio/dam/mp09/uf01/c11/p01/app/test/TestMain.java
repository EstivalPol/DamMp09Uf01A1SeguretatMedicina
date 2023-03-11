package cat.prateducacio.dam.mp09.uf01.c11.p01.app.test;

import cat.prateducacio.dam.mp09.uf01.c11.p01.controllers.VisitaMedicaController;

public class TestMain {

	public static void main(String[] args) {
		VisitaMedicaController visitaMedicaController = VisitaMedicaController.getInstance();
		visitaMedicaController.inici();
		visitaMedicaController.llistaVisitaMedica();

	}

}
