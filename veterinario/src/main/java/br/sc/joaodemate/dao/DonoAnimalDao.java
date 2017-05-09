package br.sc.joaodemate.dao;

import javax.persistence.Query;
import br.sc.joaodemate.entity.DonoAnimal;

public class DonoAnimalDao extends Dao {

	public void salvar(DonoAnimal donoAnimal) {
		getEM().merge(donoAnimal);

	}

	public DonoAnimal buscarPorId(Long id) {
		return getEM().find(DonoAnimal.class, id);
	}

	public DonoAnimal buscarPorCpf(String cpf) {
		Query query = getEM().createQuery("SELECT c FROM DonoAnimal c WHERE c.cpf = :cpf");
		query.setParameter("cpf", cpf);
		try {
			return (DonoAnimal) query.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}

}
