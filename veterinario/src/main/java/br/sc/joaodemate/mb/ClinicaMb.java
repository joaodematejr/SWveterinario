package br.sc.joaodemate.mb;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.sc.joaodemate.entity.Clinica;
import br.sc.joaodemate.rn.ClinicaRn;

@ViewScoped
@ManagedBean
public class ClinicaMb {
	private Clinica clinica;
	private ClinicaRn clinicaRn;

	@PostConstruct
	public void init() {
		clinica = new Clinica();
		clinicaRn = new ClinicaRn();
	}

	public Clinica getClinica() {
		return clinica;
	}

	public void setClinica(Clinica clinica) {
		this.clinica = clinica;
	}

	public ClinicaRn getClinicaRn() {
		return clinicaRn;
	}

	public void setClinicaRn(ClinicaRn clinicaRn) {
		this.clinicaRn = clinicaRn;
	}

	public String salvar() {
		clinicaRn.salvar(clinica);
		return null;
	}

}
