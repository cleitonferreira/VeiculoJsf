/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.veiculo.controller;

import br.com.veiculo.model.dao.HibernateDAO;
import br.com.veiculo.model.dao.InterfaceDAO;
import br.com.veiculo.model.entities.Estado;
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
@ManagedBean(name = "mbEstado")
@SessionScoped
public class MbEstado implements Serializable {

    private static final long serialVersionUID = 1L;

    private Estado estado = new Estado();
    private List<Estado> estados;

    public MbEstado() {
    }

    private InterfaceDAO<Estado> estadoDAO() {
        InterfaceDAO<Estado> estadoDAO = new HibernateDAO<Estado>(Estado.class, FacesContextUtil.getRequestSession());
        return estadoDAO;
    }

    public String limpEstado() {
        estado = new Estado();
        return editEstado();
    }

    public String editEstado() {
        return "/restrict/cadastrarestado.faces";
    }

    public String addEstado() {
        // verifica a id veio igual a null ou id igual a 0
        if (estado.getEst_id() == null || estado.getEst_id() == 0) {
            insertEstado();
        } else {
            updateEstado();
        }
        limpEstado();
        return null;
    }

    private void insertEstado() {
        estadoDAO().save(estado);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Gravação efetuada com sucesso", ""));
    }

    private void updateEstado() {
        estadoDAO().update(estado);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Atualização efetuada com sucesso", ""));
    }

    public void deleteEstado() {
        estadoDAO().remove(estado);
    }

    public List<Estado> getEstados() {
        estados = estadoDAO().getEntities();
        return estados;
    }

    public void setEstados(List<Estado> estados) {
        this.estados = estados;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

}
