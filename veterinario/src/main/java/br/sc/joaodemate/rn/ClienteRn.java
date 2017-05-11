package br.sc.joaodemate.rn;

import java.util.List;

import br.sc.joaodemate.dao.ClienteDao;
import br.sc.joaodemate.entity.Cliente;

public class ClienteRn {
	private ClienteDao dao;

	public ClienteRn() {
		dao = new ClienteDao();
	}

	public Cliente buscarPorId(Long id) {
		return dao.buscarPorId(id);
	}

	public void salvar(Cliente cliente) {
		dao.salvar(cliente);
	}

	public Cliente buscarPorCpf(String cpf) {
		return dao.buscarPorCpf(cpf);
	}

	public List<Cliente> listarDonoAnimal() {
		return dao.listarDonoAnimal();
	}

}
