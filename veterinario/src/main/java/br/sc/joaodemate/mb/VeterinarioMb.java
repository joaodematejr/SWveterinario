package br.sc.joaodemate.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.sc.joaodemate.entity.Veterinario;
import br.sc.joaodemate.rn.VeterinarioRn;

@ViewScoped
@ManagedBean
public class VeterinarioMb {
	private Veterinario veterinario;
	private VeterinarioRn veterinarioRn;
	private List<Veterinario> listarVeterinario;

	@PostConstruct
	public void init() {
		veterinario = new Veterinario();
		veterinarioRn = new VeterinarioRn();
	}

	public Veterinario getVeterinario() {
		return veterinario;
	}

	public void setVeterinario(Veterinario veterinario) {
		this.veterinario = veterinario;
	}

	public VeterinarioRn getVeterinarioRn() {
		return veterinarioRn;
	}

	public void setVeterinarioRn(VeterinarioRn veterinarioRn) {
		this.veterinarioRn = veterinarioRn;
	}

	public List<Veterinario> getListarVeterinario() {
		if (listarVeterinario == null) {
			listarVeterinario = veterinarioRn.listarVeterinario();

		}
		return listarVeterinario;
	}

	public void setListarVeterinario(List<Veterinario> listarVeterinario) {
		this.listarVeterinario = listarVeterinario;
	}

	public String salvar() {
		veterinarioRn.salvar(veterinario);
		return null;
	}

}
