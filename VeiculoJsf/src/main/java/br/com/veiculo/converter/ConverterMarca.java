/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.veiculo.converter;

import br.com.veiculo.model.dao.ImplDaoMarcaModelo;
import br.com.veiculo.model.dao.MeuDaoMarcaModelo;
import br.com.veiculo.model.entities.Marca;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author XPredator
 */
@FacesConverter(value = "converterMarca")
public class ConverterMarca implements Converter{
 
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null && !value.equals("")) {
            MeuDaoMarcaModelo dao = new ImplDaoMarcaModelo();
            return dao.getByIdMarca(Integer.valueOf(value));
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value instanceof Marca) {
            Marca marca = (Marca) value;
            return String.valueOf(marca.getMar_id());
        }
        return "";
    }
}
