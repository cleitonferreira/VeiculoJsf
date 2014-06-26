/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.veiculo.controller;

import br.com.veiculo.model.dao.HibernateDAO;
import br.com.veiculo.model.dao.InterfaceDAO;
import br.com.veiculo.model.entities.Setor;
import br.com.veiculo.util.FacesContextUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author cleiton
 */
@ManagedBean(name = "mbSetor")
@ViewScoped
public class MbSetor implements Serializable {

    private static final long serialVersionUID = 1L;

    private Setor setor = new Setor();
    private List<Setor> setores;
    private List<Setor> filteredSetores;
    private List<Setor> consultaSetores;

    public MbSetor() {
    }

    private InterfaceDAO<Setor> setorDAO() {
        InterfaceDAO<Setor> setorDAO = new HibernateDAO<Setor>(Setor.class, FacesContextUtil.getRequestSession());
        return setorDAO;
    }

    public String limpSetor() {
        setor = new Setor();
        return editSetor();
    }

    public String editSetor() {
        return "/restrict/cadastros/cadastrarsetor.faces";
    }

    public String addSetor() {
        // verifica a id veio igual a null ou id igual a 0
        if (setor.getSet_id() == null || setor.getSet_id() == 0) {
            insertSetor();
        } else {
            updateSetor();
        }
        limpSetor();
        return null;
    }

    private void insertSetor() {
        try {
            setorDAO().save(setor);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Gravação efetuada com sucesso", ""));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro ao [Cadastrar],  no Banco de Dados", "" + ex));
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Entre em contato com o Administrador", "" + ex));
        }
    }

    private void updateSetor() {
        try {
            setorDAO().update(setor);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Atualização efetuada com sucesso", ""));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro ao [Atualizar], no Banco de Dados", "" + ex));
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Entre em contato com o Administrador", "" + ex));
        }
    }

    public void deleteSetor() {
        try {
            setorDAO().remove(setor);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro excluído com sucesso", ""));
            limpSetor();
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro ao [Excluir], no Banco de Dados", "" + ex));
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Entre em contato com o Administrador", "" + ex));
        }

    }

    public List<Setor> getSetores() {
        setores = setorDAO().getEntities();
        return setores;
    }

    public void setSetores(List<Setor> setores) {
        this.setores = setores;
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    public List<Setor> getFilteredSetores() {
        return filteredSetores;
    }

    public void setFilteredSetores(List<Setor> filteredSetores) {
        this.filteredSetores = filteredSetores;
    }

    public List<Setor> getConsultaSetores() {
        return consultaSetores;
    }

    public void setConsultaSetores(List<Setor> consultaSetores) {
        this.consultaSetores = consultaSetores;
    }

    
    

}
