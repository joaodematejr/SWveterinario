package br.sc.joaodemate.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;

import br.sc.joaodemate.entity.Cliente;
import br.sc.joaodemate.rn.ClienteRn;

@ViewScoped
@ManagedBean
public class ClienteMb {
	private Cliente cliente;
	private ClienteRn clienteRn;
	private List<Cliente> listarDonoAnimal;
	private Long editarId;

	@PostConstruct
	public void init() {
		cliente = new Cliente();
		clienteRn = new ClienteRn();
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente donoAnimal) {
		this.cliente = donoAnimal;
	}

	public ClienteRn getClienteRn() {
		return clienteRn;
	}

	public void setClienteRn(ClienteRn donoAnimalRn) {
		this.clienteRn = donoAnimalRn;
	}

	public List<Cliente> getListarDonoAnimal() {
		if (listarDonoAnimal == null) {
			listarDonoAnimal = clienteRn.listarDonoAnimal();
		}
		return listarDonoAnimal;
	}

	public void setListarDonoAnimal(List<Cliente> listarDonoAnimal) {
		this.listarDonoAnimal = listarDonoAnimal;
	}

	public Long getEditarId() {
		return editarId;
	}

	public void setEditarId(Long editarId) {
		this.editarId = editarId;
	}

	public void carregarDonoAnimal(ComponentSystemEvent event) {
		if (editarId == null) {
			return;
		}
		cliente = clienteRn.buscarPorId(editarId);
	}

	// -------Salvar---------
	public String salvar() {
		Cliente carregarCpf = clienteRn.buscarPorCpf(cliente.getCpf());
		// -------Validar Algum Campo Vazio---------
		if (cliente.getNome().length() <= 4 || cliente.getCpf().length() <= 11 || cliente.getRg().length() <= 9
				|| cliente.getEmail().length() <= 5 || cliente.getTelefone().length() <= 11
				|| cliente.getCelular().length() <= 11) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Existe algum campos em branco ! ", ""));
			// -------Validar Se CPF Já é cadastrado no sistema---------
		} else if (cliente.getId() == 0 && carregarCpf == null) {
			clienteRn.salvar(cliente);
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, " Cadastrado(a) com sucesso ! ", "");
			FacesContext.getCurrentInstance().addMessage(null, message);
			cliente = new Cliente();
			listarDonoAnimal = null;
		} else if (cliente.getId() != 0 && (carregarCpf == null || carregarCpf.getId() == cliente.getId())) {
			clienteRn.salvar(cliente);
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, " Alterado(a) com sucesso ! ", "");
			FacesContext.getCurrentInstance().addMessage(null, message);
			cliente = new Cliente();
			listarDonoAnimal = null;
			return "listarclientes.xhtml";
		} else {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "O CPF já está cadastrado ! ", "");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		return null;

	}

}
