/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.veiculo.converter;


import br.com.veiculo.model.dao.MeuDao;
import br.com.veiculo.model.dao.MeuDaoImpl;
import br.com.veiculo.model.entities.Cidade;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;



/**
 *
 * @author altitdb
 */
@FacesConverter(value="converterCidade")
public class ConverterCidade implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null && !value.equals("")) {
            MeuDao dao = new MeuDaoImpl();
            return dao.getByIdCidade(Integer.valueOf(value));
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value instanceof Cidade) {
            Cidade cidade = (Cidade) value;
            return String.valueOf(cidade.getCid_id());
        }
        return "";
    }

}
