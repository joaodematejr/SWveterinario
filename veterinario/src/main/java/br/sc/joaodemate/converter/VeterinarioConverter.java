package br.sc.joaodemate.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.sc.joaodemate.entity.Veterinario;
import br.sc.joaodemate.rn.VeterinarioRn;

@FacesConverter(forClass = Veterinario.class)
public class VeterinarioConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
		Long id = Long.parseLong(value);
		return VeterinarioRn.buscarPorId(id);
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
		Veterinario veterinario = (Veterinario) value;
		return String.valueOf(veterinario.getId());
	}

}
