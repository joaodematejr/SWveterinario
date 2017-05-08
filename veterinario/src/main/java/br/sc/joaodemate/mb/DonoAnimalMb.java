package br.sc.joaodemate.mb;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

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
		donoAnimalRn.salvar(donoAnimal);
		return null;

	}

}
