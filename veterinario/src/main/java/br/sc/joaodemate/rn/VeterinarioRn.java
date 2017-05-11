package br.sc.joaodemate.rn;

import java.util.List;

import br.sc.joaodemate.dao.VeterinarioDao;
import br.sc.joaodemate.entity.Veterinario;

public class VeterinarioRn {
	private VeterinarioDao dao;

	public VeterinarioRn() {
		dao = new VeterinarioDao();
	}

	public static Object buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void salvar(Veterinario veterinario) {
		dao.salvar(veterinario);

	}

	public List<Veterinario> listarVeterinario() {
		return dao.listarVeterinario();
	}

}
