/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.veiculo.converter;

import br.com.veiculo.model.dao.MeuDao;
import br.com.veiculo.model.dao.MeuDaoImpl;
import br.com.veiculo.model.entities.Pessoa;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author cleiton
 */
@FacesConverter(value="pessoaConverter")
public class PessoaConverter implements Converter {

     MeuDao dao = new MeuDaoImpl();
     
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Pessoa c = dao.getByIdPessoa(Integer.valueOf(value) );
        return c;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Pessoa c = (Pessoa) value;
        return String.valueOf( c.getPes_id() );
    }

}
