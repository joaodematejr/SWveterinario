package br.sc.joaodemate.converter;

import javax.faces.convert.FacesConverter;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import br.sc.joaodemate.entity.DonoAnimal;
import br.sc.joaodemate.rn.DonoAnimalRn;

@FacesConverter(forClass = DonoAnimal.class)
public class DonoAnimalConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
		DonoAnimalRn DonoAnimalRn = new DonoAnimalRn();
		Long id = Long.parseLong(value);
		return DonoAnimalRn.buscarPorId(id);
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
		DonoAnimal donoAnimal = (DonoAnimal) value;
		return String.valueOf(donoAnimal.getId());
	}

}
