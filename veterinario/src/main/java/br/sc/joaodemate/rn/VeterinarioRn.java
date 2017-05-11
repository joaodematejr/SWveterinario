package br.sc.joaodemate.rn;

import java.util.List;

import br.sc.joaodemate.dao.VeterinarioDao;
import br.sc.joaodemate.entity.Veterinario;

public class VeterinarioRn {
	private VeterinarioDao dao;

	public VeterinarioRn() {
		dao = new VeterinarioDao();
	}

	public Veterinario buscarPorId(Long id) {
		return dao.buscarPorId(id);
	}

	public void salvar(Veterinario veterinario) {
		dao.salvar(veterinario);

	}

	public List<Veterinario> listarVeterinario() {
		return dao.listarVeterinario();
	}

}
