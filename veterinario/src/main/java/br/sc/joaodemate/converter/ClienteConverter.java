package br.sc.joaodemate.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.sc.joaodemate.entity.Cliente;
import br.sc.joaodemate.rn.ClienteRn;

@FacesConverter(forClass = Cliente.class)
public class ClienteConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
		ClienteRn clienteRn = new ClienteRn();
		Long id = Long.parseLong(value);
		return clienteRn.buscarPorId(id);
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
		Cliente donoAnimal = (Cliente) value;
		return String.valueOf(donoAnimal.getId());
	}

}
