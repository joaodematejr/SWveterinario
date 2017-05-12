package br.sc.joaodemate.rn;

import br.sc.joaodemate.dao.ClinicaDao;
import br.sc.joaodemate.entity.Clinica;

public class ClinicaRn {
	private ClinicaDao dao;

	public ClinicaRn() {
		dao = new ClinicaDao();
	}

	public void salvar(Clinica clinica) {
		dao.salvar(clinica);

	}

}
