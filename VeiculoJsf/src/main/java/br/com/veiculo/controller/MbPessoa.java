/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.veiculo.controller;

import br.com.veiculo.model.dao.HibernateDAO;
import br.com.veiculo.model.dao.InterfaceDAO;
import br.com.veiculo.model.dao.MeuDaoImpl;
import br.com.veiculo.model.entities.Cidade;
import br.com.veiculo.model.entities.Estado;
import br.com.veiculo.model.entities.Pessoa;
import br.com.veiculo.util.FacesContextUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

/**
 *
 * @author cleiton
 */
@ManagedBean(name = "mbPessoa")
@ViewScoped
public class MbPessoa implements Serializable {

    private static final long serialVersionUID = 1L;

    private Pessoa pessoa = new Pessoa();
    private List<Pessoa> pessoas;
    private List<Pessoa> filteredPessoas;
    private List<Pessoa> consultaPessoas;

    ///// Objetos para os ComBos Estado Cidade \\\\\
    private final MeuDaoImpl dao = new MeuDaoImpl();
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
//        System.out.println("Busca Cidade>>>>>>>>>>>>");
        cidades = dao.consultaCidades(estado);
    }

    private InterfaceDAO<Pessoa> pessoaDAO() {
        InterfaceDAO<Pessoa> pessoaDAO = new HibernateDAO<Pessoa>(Pessoa.class, FacesContextUtil.getRequestSession());
        return pessoaDAO;
    }

    public String limpPessoa() {
        pessoa = new Pessoa();
        estado = new Estado();
        cidade = new Cidade();
        return editPessoa();
    }

    public String editPessoa() {
        return "/restrict/cadastros/cadastrarpessoa.faces";
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

        String cpf = pessoa.getPes_cpf();
        ArrayList results = (ArrayList) dao.consultaCpf(cpf);
        System.out.println("Resultsss>>>>" + results.toString());

        if (results.toString().equals("[1]")) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro ao [Cadastrar], no Banco de Dados!!!", ""));
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Cpf já se encontra cadastrado no sistema", "" + cpf));
        } else {
            try {

                pessoa.setEstado(estado);
                pessoa.setCidade(cidade);
                pessoaDAO().save(pessoa);

                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "Gravação efetuada com sucesso", ""));
                //Limpar os campos
                limpPessoa();
            } catch (Exception ex) {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro ao [Cadastrar],  no Banco de Dados", "" + ex));
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_WARN, "Entre em contato com o Administrador", "" + ex));
            }
        }

    }

    private void updatePessoa() {
        String cpf = pessoa.getPes_cpf();
        ArrayList results = (ArrayList) dao.consultaCpf(cpf);
        System.out.println("Resultsss>>>>" + results.toString());

        if (results.toString().equals("[1]")) {
            try {
                pessoa.setEstado(estado);
                pessoa.setCidade(cidade);
                pessoaDAO().update(pessoa);
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "Atualização efetuada com sucesso", ""));
            } catch (Exception ex) {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro ao [Atualizar], no Banco de Dados", "" + ex));
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_WARN, "Entre em contato com o Administrador", "" + ex));
            }

        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro ao [Atualizar], no Banco de Dados!!!", ""));
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Por Favor, não altere o cpf do pessoa", "" + cpf));

        }
    }

    public void deletePessoa() {
        try {
            pessoaDAO().remove(pessoa);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro excluído com sucesso", ""));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro ao [Excluir], no Banco de Dados", "" + ex));
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Entre em contato com o Administrador", "" + ex));
        }

    }

    //tomar cuidado com esses dois get aqui
    //realizar as modificações.
    public List<Pessoa> getPessoas() {
        pessoas = pessoaDAO().getEntities();
        return pessoas;
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

    public List<Pessoa> getFilteredPessoas() {
        return filteredPessoas;
    }

    public void setFilteredPessoas(List<Pessoa> filteredPessoas) {
        this.filteredPessoas = filteredPessoas;
    }

    public List<Pessoa> getConsultaPessoas() {
        return consultaPessoas;
    }

    public void setConsultaPessoas(List<Pessoa> consultaPessoas) {
        this.consultaPessoas = consultaPessoas;
    }

}
