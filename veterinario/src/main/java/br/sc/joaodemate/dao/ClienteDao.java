package br.sc.joaodemate.dao;

import java.util.List;

import javax.persistence.Query;

import br.sc.joaodemate.entity.Cliente;

public class ClienteDao extends Dao {

	public void salvar(Cliente cliente) {
		getEM().merge(cliente);

	}

	public Cliente buscarPorId(Long id) {
		return getEM().find(Cliente.class, id);
	}

	public Cliente buscarPorCpf(String cpf) {
		Query query = getEM().createQuery("SELECT c FROM Cliente c WHERE c.cpf = :cpf");
		query.setParameter("cpf", cpf);
		try {
			return (Cliente) query.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Cliente> listarDonoAnimal() {
		Query query = getEM().createQuery("FROM Cliente", Cliente.class);//
		return query.getResultList();
	}

}
