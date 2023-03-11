package cat.prateducacio.dam.mp09.uf01.c11.p01.model.service;

import java.util.List;

import cat.prateducacio.dam.mp09.uf01.c11.p01.model.config.DataConfiguration;
import cat.prateducacio.dam.mp09.uf01.c11.p01.model.domain.VisitaMedica;
import cat.prateducacio.dam.mp09.uf01.c11.p01.model.repository.VisitaMedicaRepository;
import cat.prateducacio.dam.mp09.uf01.c11.p01.model.security.EncriptacioFactory;
import cat.prateducacio.dam.mp09.uf01.c11.p01.model.security.EnumAlgoritmeEncriptacio;
import cat.prateducacio.dam.mp09.uf01.c11.p01.model.security.IEncriptacio;

public class VisitaMedicaService {

	private VisitaMedicaService() throws Exception {

		VisitaMedicaRepository = VisitaMedicaRepository.getInstance();
		dataConfiguration = DataConfiguration.getInstance();
	}

	private static VisitaMedicaService instance;

	public static VisitaMedicaService getInstance() throws Exception {
		if (instance == null) {
			instance = new VisitaMedicaService();
		}

		return instance;

	}

	private VisitaMedicaRepository VisitaMedicaRepository;
	private DataConfiguration dataConfiguration;

	public VisitaMedica add(VisitaMedica medicina) {

		VisitaMedica VisitaMedicaRetornat = VisitaMedicaRepository.getOne(medicina.getIdVisita());

		if (VisitaMedicaRetornat != null) {
			throw new RuntimeException("La visita ja existeix, no la podem agregar una altra vegada");
		}

		String nomPacientEncriptat = this.encriptar(medicina.getNomPacient());
		String diagnosticEncriptat = this.encriptar(medicina.getDiagnostic());
		medicina.setNomPacient(nomPacientEncriptat);
		medicina.setDiagnostic(diagnosticEncriptat);

		VisitaMedicaRepository.add(medicina);
		return medicina;
	}

	public List<VisitaMedica> getAll() {

		List<VisitaMedica> VisitaMedicaList = VisitaMedicaRepository.getAll();

		for (VisitaMedica v : VisitaMedicaList) {
			String nomPacientDesencriptat = this.desencriptar(v.getNomPacient());
			String diagnosticDesencriptat = this.desencriptar(v.getDiagnostic());
			v.setNomPacient(nomPacientDesencriptat);
			v.setDiagnostic(diagnosticDesencriptat);
		}

		return VisitaMedicaList;
	}

	public VisitaMedica getOne(int IdVisita) {
		VisitaMedica visitaMedica = VisitaMedicaRepository.getOne(IdVisita);
		String nomPacientDesencriptat = this.desencriptar(visitaMedica.getNomPacient());
		String diagnosticDesencriptat = this.desencriptar(visitaMedica.getDiagnostic());
		visitaMedica.setNomPacient(nomPacientDesencriptat);
		visitaMedica.setDiagnostic(diagnosticDesencriptat);
		
		return visitaMedica;
	}

	private String encriptar(String valor) {
		String resultat = valor;

		EnumAlgoritmeEncriptacio algoritme = dataConfiguration.getAlgoritmeSeguretat();
		EncriptacioFactory encriptacioFactory = EncriptacioFactory.getInstance();

		IEncriptacio iencriptacio = encriptacioFactory.getAlgoritme(algoritme);

		if (iencriptacio != null) {
			resultat = iencriptacio.encripta(valor);
		}

		return resultat;
	}

	private String desencriptar(String valor) {
		String resultat = valor;

		EnumAlgoritmeEncriptacio algoritme = dataConfiguration.getAlgoritmeSeguretat();
		EncriptacioFactory encriptacioFactory = EncriptacioFactory.getInstance();

		IEncriptacio iencriptacio = encriptacioFactory.getAlgoritme(algoritme);

		if (iencriptacio != null) {
			resultat = iencriptacio.desencripta(valor);
		}

		return resultat;
	}

}
