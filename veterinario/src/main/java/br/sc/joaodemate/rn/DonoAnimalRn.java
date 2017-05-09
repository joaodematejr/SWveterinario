package br.sc.joaodemate.rn;

import br.sc.joaodemate.dao.DonoAnimalDao;
import br.sc.joaodemate.entity.DonoAnimal;

public class DonoAnimalRn {
	private DonoAnimalDao dao;

	public DonoAnimalRn() {
		dao = new DonoAnimalDao();
	}

	public DonoAnimal buscarPorId(Long id) {
		return dao.buscarPorId(id);
	}

	public void salvar(DonoAnimal donoAnimal) {
		dao.salvar(donoAnimal);
	}

	public DonoAnimal buscarPorCpf(String cpf) {
		return dao.buscarPorCpf(cpf);
	}

}
