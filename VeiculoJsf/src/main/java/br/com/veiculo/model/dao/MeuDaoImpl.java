/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.veiculo.model.dao;


import br.com.veiculo.model.entities.Cidade;
import br.com.veiculo.model.entities.Estado;
import br.com.veiculo.util.HibernateCombos;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author altitdb
 */
public class MeuDaoImpl implements MeuDao {

    @Override
    public Cidade getByIdCidade(Integer id) {
        return (Cidade) HibernateCombos.getSession().get(Cidade.class, id);
    }

    @Override
    public Estado getByIdEstado(Integer id) {
        return (Estado) HibernateCombos.getSession().get(Estado.class, id);
    }

    @Override
    public List<Estado> consultaTodosEstados() {
        Criteria crit = HibernateCombos.getSession().createCriteria(Estado.class);
        return crit.list();
    }

    @Override
    public List<Cidade> consultaCidades(Estado estado) {
        Criteria crit = HibernateCombos.getSession().createCriteria(Cidade.class);
        crit.add(Restrictions.eq("estado", estado));
        return crit.list();
    }
}
