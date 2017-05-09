package br.sc.joaodemate.mb;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.sc.joaodemate.entity.DonoAnimal;
import br.sc.joaodemate.rn.DonoAnimalRn;

@ViewScoped
@ManagedBean
public class DonoAnimalMb {
	private DonoAnimal donoAnimal;
	private DonoAnimalRn donoAnimalRn;

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

	public String salvar() {
		DonoAnimal carregarCpf = donoAnimalRn.buscarPorCpf(donoAnimal.getCpf());
		if (donoAnimal.getNome().length() <= 4 || donoAnimal.getCpf().length() <= 11 || donoAnimal.getRg().length() <= 9
				|| donoAnimal.getEmail().length() <= 5 || donoAnimal.getTelefone().length() <= 11
				|| donoAnimal.getCelular().length() <= 11) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Existe algum campos em branco ! ", ""));
			return null;
		} else if (carregarCpf == null) {
			/* donoAnimalRn.salvar(donoAnimal); */
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Registrado com sucesso ! ", ""));
			return "adicionarclientes.xhtml";
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "CPF já cadastrado no sistema ! ", ""));
			return null;
		}

	}

}
