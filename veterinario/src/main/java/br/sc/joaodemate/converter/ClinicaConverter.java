package br.sc.joaodemate.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.sc.joaodemate.entity.Clinica;
import br.sc.joaodemate.rn.ClinicaRn;

@FacesConverter(forClass = Clinica.class)
public class ClinicaConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
		ClinicaRn clinicaRn = new ClinicaRn();
		Long id = Long.parseLong(value);
		return clinicaRn.buscarPodId(id);
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
		Clinica clinica = (Clinica) value;
		return String.valueOf(clinica.getId());
	}

}
