/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.veiculo.model.dao;

import br.com.veiculo.model.entities.Categoria;
import br.com.veiculo.model.entities.Cidade;
import br.com.veiculo.model.entities.Empresa;
import br.com.veiculo.model.entities.Estado;
import br.com.veiculo.model.entities.Marca;
import br.com.veiculo.model.entities.Modelo;
import br.com.veiculo.model.entities.Pais;
import br.com.veiculo.model.entities.Pessoa;
import br.com.veiculo.model.entities.Setor;
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
    public List<Pessoa> consultaTodasPessoas() {
        Criteria crit = HibernateCombos.getSession().createCriteria(Pessoa.class);
        return crit.list();
    }

    @Override
    public Empresa getByIdEmpresa(Integer id) {
        return (Empresa) HibernateCombos.getSession().get(Empresa.class, id);
    }

    @Override
    public List<Empresa> consultaTodasEmpresas() {
        Criteria crit = HibernateCombos.getSession().createCriteria(Empresa.class);
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

    @Override
    public Object consultaPlaca(String placa) {
        System.out.println("Variavel>>>>>>" + placa);
        SQLQuery sql = HibernateCombos.getSession().createSQLQuery("SELECT COUNT(*) FROM `veiculo` WHERE `veic_placa` = '" + placa + "'");

        List resultados = new ArrayList();
        resultados = sql.list();
        System.out.println("List >>>>" + resultados);

        return resultados;
    }

    //Setor
    @Override
    public Setor getByIdSetor(Integer id) {
        return (Setor) HibernateCombos.getSession().get(Setor.class, id);
    }

    @Override
    public List<Setor> consultaTodosSetores() {
        Criteria crit = HibernateCombos.getSession().createCriteria(Setor.class);
        return crit.list();
    }

    @Override
    public Pais getByIdPais(Integer id) {
        return (Pais) HibernateCombos.getSession().get(Pais.class, id);
    }

    @Override
    public List<Pais> consultaTodosPaises() {
        Criteria crit = HibernateCombos.getSession().createCriteria(Pais.class);
        return crit.list();
    }

    @Override
    public Categoria getByIdCategoria(Integer id) {
        return (Categoria) HibernateCombos.getSession().get(Categoria.class, id);
    }

    @Override
    public List<Categoria> consultaTodasCategorias() {
        Criteria crit = HibernateCombos.getSession().createCriteria(Categoria.class);
        return crit.list();
    }

}
