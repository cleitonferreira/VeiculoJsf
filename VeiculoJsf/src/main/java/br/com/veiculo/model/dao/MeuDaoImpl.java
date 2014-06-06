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
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author altitdb
 */
public class MeuDaoImpl implements MeuDao, Serializable {

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

    @Override
    public Pessoa getByIdPessoa(Integer id) {
        return (Pessoa) HibernateCombos.getSession().get(Pessoa.class, id);
    }

    @Override
    public List<Pessoa> consultaTodosPessoas() {
        Criteria crit = HibernateCombos.getSession().createCriteria(Pessoa.class);
        return crit.list();
    }

    //http://www.devmedia.com.br/hibernate-api-criteria-realizando-consultas/29627
    //http://www.developerhelpway.com/framework/hibernate/criteria/criteria-unique-result.php
    @Override
    public Object consultaCpf(String cpf) {
        System.out.println("Variavel>>>>>>" + cpf);
        SQLQuery sql = HibernateCombos.getSession().createSQLQuery("SELECT COUNT(*) FROM `pessoa` WHERE `pes_cpf` = " + cpf);
//        projList.add(Projections.count("pes_cpf"), cpf);
//        crit.setProjection(projList);
//        List results = crit.list();

        List results = new ArrayList();
        results = sql.list();
        System.out.println("List >>>>" + results);

        return results;
    }

    //Verifica Cpf, se for igual atualiza
    @Override
    public Object atualizaCpf(Integer id) {
        System.out.println("Variavel>>>>>>" + id);
        SQLQuery crit = HibernateCombos.getSession().createSQLQuery("SELECT `pes_cpf` FROM `pessoa` WHERE `pes_id` = " + id);
//        ProjectionList projList = Projections.projectionList();
//        projList.add(Projections.groupProperty("pes_cpf"),cpf);
//        crit.setProjection(projList);
//        crit.add(Restrictions.ne("pes_cpf", cpf));

        List result = crit.list();
        System.out.println("List >>>>" + result.toString());
        return result;
    }

//    @Override
//    public Object consultaPlaca(String placa) {
////        System.out.println("Variavel>>>>>>" + placa);
//        Criteria crit = HibernateCombos.getSession().createCriteria(Pessoa.class);
//        ProjectionList projList = Projections.projectionList();
//        projList.add(Projections.groupProperty("veic_placa"), placa);
//        crit.setProjection(projList);
//        List results_placas = crit.list();
//
//        return results_placas;
//    }
}
