package br.sc.joaodemate.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;

import br.sc.joaodemate.entity.DonoAnimal;
import br.sc.joaodemate.rn.DonoAnimalRn;

@ViewScoped
@ManagedBean
public class DonoAnimalMb {
	private DonoAnimal donoAnimal;
	private DonoAnimalRn donoAnimalRn;
	private List<DonoAnimal> listarDonoAnimal;
	private Long editarId;

	@PostConstruct
	public void init() {
		donoAnimal = new DonoAnimal();
		donoAnimalRn = new DonoAnimalRn();
	}

	public DonoAnimal getDonoAnimal() {
		return donoAnimal;
	}

	public void setDonoAnimal(DonoAnimal donoAnimal) {
		this.donoAnimal = donoAnimal;
	}

	public DonoAnimalRn getDonoAnimalRn() {
		return donoAnimalRn;
	}

	public void setDonoAnimalRn(DonoAnimalRn donoAnimalRn) {
		this.donoAnimalRn = donoAnimalRn;
	}

	public List<DonoAnimal> getListarDonoAnimal() {
		if (listarDonoAnimal == null) {
			listarDonoAnimal = donoAnimalRn.listarDonoAnimal();
		}
		return listarDonoAnimal;
	}

	public void setListarDonoAnimal(List<DonoAnimal> listarDonoAnimal) {
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
		donoAnimal = donoAnimalRn.buscarPorId(editarId);
	}

	// -------Salvar---------
	public String salvar() {
		DonoAnimal carregarCpf = donoAnimalRn.buscarPorCpf(donoAnimal.getCpf());
		// -------Validar Algum Campo Vazio---------
		if (donoAnimal.getNome().length() <= 4 || donoAnimal.getCpf().length() <= 11 || donoAnimal.getRg().length() <= 9
				|| donoAnimal.getEmail().length() <= 5 || donoAnimal.getTelefone().length() <= 11
				|| donoAnimal.getCelular().length() <= 11) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Existe algum campos em branco ! ", ""));
			// -------Validar Se CPF Já é cadastrado no sistema---------
		} else if (donoAnimal.getId() == 0 && carregarCpf == null) {
			donoAnimalRn.salvar(donoAnimal);
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, " Cadastrado(a) com sucesso ! ", "");
			FacesContext.getCurrentInstance().addMessage(null, message);
			donoAnimal = new DonoAnimal();
			listarDonoAnimal = null;
		} else if (donoAnimal.getId() != 0 && (carregarCpf == null || carregarCpf.getId() == donoAnimal.getId())) {
			donoAnimalRn.salvar(donoAnimal);
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, " Alterado(a) com sucesso ! ", "");
			FacesContext.getCurrentInstance().addMessage(null, message);
			donoAnimal = new DonoAnimal();
			listarDonoAnimal = null;
		} else {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "O CPF já está cadastrado ! ", "");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		return null;

	}

}
