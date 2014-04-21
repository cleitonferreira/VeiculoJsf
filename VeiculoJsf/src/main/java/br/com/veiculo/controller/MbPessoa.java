/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.veiculo.controller;

import br.com.veiculo.model.dao.HibernateDAO;
import br.com.veiculo.model.dao.InterfaceDAO;
import br.com.veiculo.model.dao.MeuDao;
import br.com.veiculo.model.dao.MeuDaoImpl;
import br.com.veiculo.model.entities.Cidade;
import br.com.veiculo.model.entities.Estado;
import br.com.veiculo.model.entities.Pessoa;
import br.com.veiculo.model.entities.Veiculo;
import br.com.veiculo.util.FacesContextUtil;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

/**
 *
 * @author cleiton
 */
@ManagedBean(name = "mbPessoa")
@SessionScoped
public class MbPessoa implements Serializable {

    private static final long serialVersionUID = 1L;

    private Pessoa pessoa = new Pessoa();
    private Veiculo veiculo = new Veiculo();
    private List<Pessoa> pessoas;
    private List<Veiculo> veiculos;

    ///// Objetos para os ComBos \\\\\
    private final MeuDao dao = new MeuDaoImpl();
    private List<Estado> estados;
    private List<Cidade> cidades;
    private Cidade cidade;
    private Estado estado;
    //////////////////////////////////

    public MbPessoa() {
    }

    @PostConstruct
    public void init() {
        estados = dao.consultaTodosEstados();
    }

    public void listaCidades(AjaxBehaviorEvent event) {
        cidades = dao.consultaCidades(estado);
    }

    private InterfaceDAO<Pessoa> pessoaDAO() {
        InterfaceDAO<Pessoa> pessoaDAO = new HibernateDAO<Pessoa>(Pessoa.class, FacesContextUtil.getRequestSession());
        return pessoaDAO;
    }

    private InterfaceDAO<Veiculo> veiculoDAO() {
        InterfaceDAO<Veiculo> veiculoDAO = new HibernateDAO<Veiculo>(Veiculo.class, FacesContextUtil.getRequestSession());
        return veiculoDAO;
    }

    public String limpPessoa() {
        pessoa = new Pessoa();
        veiculo = new Veiculo();
        return editPessoa();
    }

    public String editPessoa() {
        return "/restrict/cadastrarpessoa.faces";
    }

    public String addPessoa() {
        // verifica a id veio igual a null ou id igual a 0
        if (pessoa.getPes_id() == null || pessoa.getPes_id() == 0) {
            insertPessoa();
        } else {
            updatePessoa();
        }
        limpPessoa();
        return null;
    }

    private void insertPessoa() {
        pessoaDAO().save(pessoa);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Gravação efetuada com sucesso", ""));
    }

    private void updatePessoa() {
        pessoaDAO().update(pessoa);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Atualização efetuada com sucesso", ""));
    }

    public void deletePessoa() {
        pessoaDAO().remove(pessoa);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro excluído com sucesso", ""));
    }

    //tomar cuidado com esses dois get aqui
    //realizar as modificações.
    public List<Pessoa> getPessoas() {
        pessoas = pessoaDAO().getEntities();
        return pessoas;
    }

    public List<Veiculo> getVeiculos() {
        veiculos = veiculoDAO().getEntities();
        return veiculos;
    }
    
    ////////////////////////////////////////////

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public List<Estado> getEstados() {
        return estados;
    }

    public void setEstados(List<Estado> estados) {
        this.estados = estados;
    }

    public List<Cidade> getCidades() {
        return cidades;
    }

    public void setCidades(List<Cidade> cidades) {
        this.cidades = cidades;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public void setVeiculos(List<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }

}
