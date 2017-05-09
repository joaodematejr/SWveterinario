package br.sc.joaodemate.dao;

import br.sc.joaodemate.entity.Veterinario;

public class VeterinarioDao extends Dao {

	public void salvar(Veterinario veterinario) {
		getEM().merge(veterinario);
	}
}
