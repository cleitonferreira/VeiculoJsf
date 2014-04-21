/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.veiculo.model.dao;

import br.com.veiculo.model.entities.Marca;
import br.com.veiculo.model.entities.Modelo;
import br.com.veiculo.util.HibernateCombos;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author XPredator
 */
public class ImplDaoMarcaModelo implements MeuDaoMarcaModelo {

    @Override
    public Marca getByIdMarca(Integer id) {
        return (Marca) HibernateCombos.getSession().get(Marca.class, id);
    }

    @Override
    public Modelo getByIdModelo(Integer id) {
        return (Modelo) HibernateCombos.getSession().get(Modelo.class, id);
    }

    @Override
    public List<Marca> consultaTodasMarcas() {
        Criteria crit = HibernateCombos.getSession().createCriteria(Marca.class);
        return crit.list();
    }

    @Override
    public List<Modelo> consultaModelos(Marca marca) {
        Criteria crit = HibernateCombos.getSession().createCriteria(Modelo.class);
        crit.add(Restrictions.eq("marca", marca));
        return crit.list();
    }

}
