package br.sc.joaodemate.dao;

import java.util.List;

import javax.persistence.Query;

import br.sc.joaodemate.entity.Veterinario;

public class VeterinarioDao extends Dao {

	public void salvar(Veterinario veterinario) {
		getEM().merge(veterinario);
	}

	@SuppressWarnings("unchecked")
	public List<Veterinario> listarVeterinario() {
		Query query = getEM().createQuery("FROM Veterinario", Veterinario.class);
		return query.getResultList();
	}
}
