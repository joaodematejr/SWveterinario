package br.sc.joaodemate.rn;

import br.sc.joaodemate.dao.ClinicaDao;
import br.sc.joaodemate.entity.Clinica;

public class ClinicaRn {
	private ClinicaDao dao;

	public void salvar(Clinica clinica) {
		dao.salvar(clinica);
	}

	public Object buscarPodId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
