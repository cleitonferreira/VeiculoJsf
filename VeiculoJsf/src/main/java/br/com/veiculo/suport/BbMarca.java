/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.veiculo.suport;

import br.com.veiculo.model.dao.HibernateDAO;
import br.com.veiculo.model.dao.InterfaceDAO;
import br.com.veiculo.model.entities.Marca;
import br.com.veiculo.util.FacesContextUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.hibernate.Session;

/**
 *
 * @author cleiton
 */
@ManagedBean(name="bbMarca")
@RequestScoped
public class BbMarca  implements Serializable {
    
    private static final long serialVersionUID = 1L;

    public List<Marca> getMarcas() {
        Session session = FacesContextUtil.getRequestSession();
        InterfaceDAO<Marca> marcaDAO = new HibernateDAO<Marca>(Marca.class, session);
        return marcaDAO.getEntities();
    }	
}
