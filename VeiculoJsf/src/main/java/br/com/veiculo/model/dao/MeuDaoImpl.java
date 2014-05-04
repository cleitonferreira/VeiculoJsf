/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.veiculo.model.dao;

import br.com.veiculo.model.entities.Cidade;
import br.com.veiculo.model.entities.Estado;
import br.com.veiculo.model.entities.Marca;
import br.com.veiculo.model.entities.Modelo;
import br.com.veiculo.model.entities.Pessoa;
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

    
    
    

    
    
    
    

    //Marcas e Modelos
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

    //http://www.devmedia.com.br/hibernate-api-criteria-realizando-consultas/29627
    @Override
    public List<Pessoa> consultaCpf(String cpf) {
        Pessoa pessoa = new Pessoa();
        Criteria crit = HibernateCombos.getSession().createCriteria(Pessoa.class);
//        crit.add(Restrictions.eq("pes_cpf", pessoa.getPes_cpf()));
        crit.add(Restrictions.like("pes_cpf", cpf));
        return crit.list();
    }

    @Override
    public Pessoa getByIdPessoa(Integer id) {
        return (Pessoa) HibernateCombos.getSession().get(Pessoa.class, id);
    }

    @Override
    public List<Pessoa> consultaTodosPessoas() {
           Criteria crit = HibernateCombos.getSession().createCriteria(Pessoa.class);
        return crit.list();
    }

}
