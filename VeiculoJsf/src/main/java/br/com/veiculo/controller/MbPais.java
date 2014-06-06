/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.veiculo.controller;

import br.com.veiculo.model.dao.HibernateDAO;
import br.com.veiculo.model.dao.InterfaceDAO;
import br.com.veiculo.model.entities.Pais;
import br.com.veiculo.util.FacesContextUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author cleiton
 */
@ManagedBean(name = "mbPais")
@SessionScoped
public class MbPais implements Serializable {

    private static final long serialVersionUID = 1L;

    private Pais pais = new Pais();
    private List<Pais> paises;
    private List<Pais> filteredPaises;

    public MbPais() {
    }

    private InterfaceDAO<Pais> paisDAO() {
        InterfaceDAO<Pais> paisDAO = new HibernateDAO<Pais>(Pais.class, FacesContextUtil.getRequestSession());
        return paisDAO;
    }

    public String limpPais() {
        pais = new Pais();
        return editPais();
    }

    public String editPais() {
        return "/restrict/cadastros/cadastrarpais.faces";
    }

    public String addPais() {
        // verifica a id veio igual a null ou id igual a 0
        if (pais.getPa_id() == null || pais.getPa_id() == 0) {
            insertPais();
        } else {
            updatePais();
        }
        limpPais();
        return null;
    }

    private void insertPais() {
        try {
            paisDAO().save(pais);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Gravação efetuada com sucesso", ""));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro ao [Cadastrar],  no Banco de Dados", "" + ex));
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Entre em contato com o Administrador", "" + ex));
        }

    }

    private void updatePais() {
        try {
            paisDAO().update(pais);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Atualização efetuada com sucesso", ""));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro ao [Atualizar], no Banco de Dados", "" + ex));
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Entre em contato com o Administrador", "" + ex));
        }

    }

    public void deletePais() {
        try {
            paisDAO().remove(pais);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro excluído com sucesso", ""));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro ao [Excluir], no Banco de Dados", "" + ex));
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Entre em contato com o Administrador", "" + ex));
        }
    }

    public List<Pais> getPaises() {
        paises = paisDAO().getEntities();
        return paises;
    }

    public void setPaises(List<Pais> paises) {
        this.paises = paises;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public List<Pais> getFilteredPaises() {
        return filteredPaises;
    }

    public void setFilteredPaises(List<Pais> filteredPaises) {
        this.filteredPaises = filteredPaises;
    }
    

}
