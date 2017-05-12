package br.sc.joaodemate.dao;

import br.sc.joaodemate.entity.Clinica;

public class ClinicaDao extends Dao {
	public void salvar(Clinica clinica) {
		getEM().merge(clinica);
	}

}
