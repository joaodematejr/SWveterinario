package br.sc.joaodemate.dao;

import br.sc.joaodemate.entity.DonoAnimal;

public class DonoAnimalDao extends Dao {

	public DonoAnimal buscarPorId(Long id) {
		return getEM().find(DonoAnimal.class, id);
	}

	public void salvar(DonoAnimal donoAnimal) {
		getEM().merge(donoAnimal);

	}

}
