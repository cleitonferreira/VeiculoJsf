/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.veiculo.controller;

import br.com.veiculo.model.dao.HibernateDAO;
import br.com.veiculo.model.dao.InterfaceDAO;
import br.com.veiculo.model.dao.MeuDaoImpl;
import br.com.veiculo.model.entities.Agenda;
import br.com.veiculo.model.entities.Categoria;
import br.com.veiculo.util.FacesContextUtil;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author cleiton
 */
@ManagedBean(name = "mbAgenda")
@ViewScoped
public class MbAgenda implements Serializable {

    private static final long serialVersionUID = 1L;

    private Agenda agenda = new Agenda();
    private List<Agenda> agendas;
    private List<Agenda> filteredAgendas;
    private List<Agenda> consultaAgendas;

    ///// Objetos para o Combo Categoria \\\\\
    //private final MeuDaoImpl mmdao = new MeuDaoImpl();
    private final MeuDaoImpl dao = new MeuDaoImpl();
    private List<Categoria> categorias;
    private Categoria categoria;

    ////////////////////////////////////////////////////////
    public MbAgenda() {
    }

    @PostConstruct
    public void init() {
        categorias = dao.consultaTodasCategorias();
    }

    private InterfaceDAO<Agenda> agendaDAO() {
        InterfaceDAO<Agenda> agendaDAO = new HibernateDAO<Agenda>(Agenda.class, FacesContextUtil.getRequestSession());
        return agendaDAO;
    }

    public String limpAgenda() {
        agenda = new Agenda();
        categoria = new Categoria();
        return editAgenda();
    }

    public String editAgenda() {
        return "/restrict/cadastros/cadastraragenda.faces";
    }

    public String addAgenda() {
        // verifica a id veio igual a null ou id igual a 0
        if (agenda.getAge_id() == null || agenda.getAge_id() == 0) {
            insertAgenda();
        } else {
            updateAgenda();
        }
        limpAgenda();
        return null;
    }

    private void insertAgenda() {
        try {
            agenda.setCategoria(categoria);
            agendaDAO().save(agenda);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Gravação efetuada com sucesso", ""));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro ao [Cadastrar],  no Banco de Dados", "" + ex));
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Entre em contato com o Administrador", "" + ex));
        }

    }

    private void updateAgenda() {
        try {
            agenda.setCategoria(categoria);
            agendaDAO().update(agenda);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Atualização efetuada com sucesso", ""));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro ao [Atualizar], no Banco de Dados", "" + ex));
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Entre em contato com o Administrador", "" + ex));
        }

    }

    public void deleteAgenda() {
        try {
            agendaDAO().remove(agenda);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro excluído com sucesso", ""));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro ao [Excluir], no Banco de Dados", "" + ex));
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Entre em contato com o Administrador", "" + ex));
        }

    }

    public List<Agenda> getAgendas() {
        agendas = agendaDAO().getEntities();
        return agendas;
    }

    public void setAgendas(List<Agenda> agendas) {
        this.agendas = agendas;
    }

    public Agenda getAgenda() {
        return agenda;
    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<Agenda> getFilteredAgendas() {
        return filteredAgendas;
    }

    public void setFilteredAgendas(List<Agenda> filteredAgendas) {
        this.filteredAgendas = filteredAgendas;
    }

    public List<Agenda> getConsultaAgendas() {
        return consultaAgendas;
    }

    public void setConsultaAgendas(List<Agenda> consultaAgendas) {
        this.consultaAgendas = consultaAgendas;
    }

}
