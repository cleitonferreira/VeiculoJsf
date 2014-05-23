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
import br.com.veiculo.util.FacesContextUtil;
import java.io.Serializable;
import java.util.ArrayList;
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
@ManagedBean(name = "mbTestePessoa")
@SessionScoped
public class MbTestePessoa implements Serializable {

    private static final long serialVersionUID = 2L;

    private Pessoa pessoa = new Pessoa();
    public List<Pessoa> pessoas;

    ///// Objetos para os ComBos Estado Cidade \\\\\
    private final MeuDao dao = new MeuDaoImpl();
    private List<Estado> estados;
    private List<Cidade> cidades;
    private Cidade cidade;
    private Estado estado;
    //////////////////////////////////

    public MbTestePessoa() {
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

    public String limpPessoa() {
        pessoa = new Pessoa();
        estado = new Estado();
        cidade = new Cidade();
        return editPessoa();
    }

    public String editPessoa() {
        return "/restrict/cadastrartestepessoa.faces";
    }
//Desabilitar o campo Cpf
//    public boolean disable() {
//        if(pessoa.getPes_cpf().equals("")){
//           return false; 
//        }else{
//        return true;
//        }
//    }

    public String addPessoa() {

        if (pessoa.getPes_id() == null || pessoa.getPes_id() == 0) {
            insertPessoa();
        } else {
            updatePessoa();
        }
        //Limpar os campos
        limpPessoa();
        return null;
    }

    private void insertPessoa() {
        String cpf = pessoa.getPes_cpf();
        ArrayList consultacpf = (ArrayList) dao.consultaCpf(cpf);
        System.out.println("Resultsss>>>>" + consultacpf.toString());

//        if ( consultacpf.toString().contains("[0]")) {
//            System.out.println("Cpf não está no BD");
//        } else if (consultacpf.toString().contains("[1]")) {
//            System.out.println("Cpf está no BD");
//        } else {
//            System.out.println("Não encontrei");
//        }

        if (consultacpf.toString().contains("[0]")) {

            try {

                pessoaDAO().save(pessoa);
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "Gravação efetuada com sucesso", ""));
            } catch (Exception ex) {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro ao [Cadastrar],  no Banco de Dados", "" + ex));
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_WARN, "Entre em contato com o Administrador", "" + ex));
            }

        } else if (consultacpf.toString().contains("[1]")) {

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro ao [Cadastrar], no Banco de Dados!!!", ""));
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Cpf já se encontra cadastrado no sistema", "" + cpf));

        }
    }

    private void updatePessoa() {
        String cpf = pessoa.getPes_cpf();
        Integer id = pessoa.getPes_id();
        ArrayList atualizaCpf = (ArrayList) dao.atualizaCpf(id);
        System.out.println("Resultsss>>>>" + atualizaCpf.toString());
        System.out.println("Cpf da tela >>>" + cpf);

        //verificação negativa com Cpf do BD com Cpf da tela
        if (atualizaCpf.contains(cpf)) {

            try {
                pessoaDAO().update(pessoa);
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "Atualização efetuada com sucesso", ""));
                //Limpar os campos
                limpPessoa();
            } catch (Exception ex) {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro ao [Atualizar], no Banco de Dados", "" + ex));
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_WARN, "Entre em contato com o Administrador", "" + ex));

            }

        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Por Favor, Cpf não poderá ser alterado", "" + cpf));

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

    public List<Pessoa> getPessoas() {
        pessoas = pessoaDAO().getEntities();
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
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

}
