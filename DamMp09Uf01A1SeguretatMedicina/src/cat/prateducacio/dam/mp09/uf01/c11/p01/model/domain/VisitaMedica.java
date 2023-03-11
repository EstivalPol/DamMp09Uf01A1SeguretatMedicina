package cat.prateducacio.dam.mp09.uf01.c11.p01.model.domain;

import java.time.LocalDate;

public class VisitaMedica {
	
	public VisitaMedica(int IdVisita, String nomPacient, String nomMetge, LocalDate data, String diagnostic) {
		super();
		this.IdVisita = IdVisita;
		this.nomPacient = nomPacient;
		this.nomMetge = nomMetge;
		this.data = data;
		this.diagnostic = diagnostic;
	}

	private int IdVisita;
	private String nomPacient;
	private String nomMetge;
	private LocalDate data;
	private String diagnostic;
	
	public int getIdVisita() {
		return IdVisita;
	}
	public void setIdVisita(int idVisita) {
		IdVisita = idVisita;
	}
	public String getNomPacient() {
		return nomPacient;
	}
	public void setNomPacient(String nomPacient) {
		this.nomPacient = nomPacient;
	}
	public String getNomMetge() {
		return nomMetge;
	}
	public void setNomMetge(String nomMetge) {
		this.nomMetge = nomMetge;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public String getDiagnostic() {
		return diagnostic;
	}
	public void setDiagnostic(String diagnostic) {
		this.diagnostic = diagnostic;
	}
	@Override
	public String toString() {
		return "VisitaMedica [IdVisita=" + IdVisita + ", nomPacient=" + nomPacient + ", nomMetge=" + nomMetge
				+ ", data=" + data + ", diagnostic=" + diagnostic + "]";
	}

	

}

