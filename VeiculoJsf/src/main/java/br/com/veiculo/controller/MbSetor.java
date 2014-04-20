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
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author cleiton
 */
@ManagedBean(name = "mbSetor")
@SessionScoped
public class MbSetor implements Serializable {

    private static final long serialVersionUID = 1L;

    private Setor setor = new Setor();
    private List<Setor> setores;

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
        return "/restrict/cadastrarsetor.faces";
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
        setorDAO().save(setor);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Gravação efetuada com sucesso", ""));
    }

    private void updateSetor() {
        setorDAO().update(setor);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Atualização efetuada com sucesso", ""));
    }

    public void deleteSetor() {
        setorDAO().remove(setor);
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

}
