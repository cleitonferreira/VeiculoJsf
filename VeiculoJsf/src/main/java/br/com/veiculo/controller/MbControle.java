/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.veiculo.controller;

import br.com.veiculo.model.dao.HibernateDAO;
import br.com.veiculo.model.dao.InterfaceDAO;
import br.com.veiculo.model.dao.MeuDaoImpl;
import br.com.veiculo.model.entities.Controle;
import br.com.veiculo.model.entities.Empresa;
import br.com.veiculo.model.entities.Setor;
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
@ManagedBean(name = "mbControle")
@ViewScoped
public class MbControle implements Serializable {

    private static final long serialVersionUID = 1L;

    private Controle controle = new Controle();
    private List<Controle> controles;
    private List<Controle> filteredControles;
    private List<Controle> consultaControles;

    private Empresa selected;

    ///// Objetos para o Combo Setor \\\\\
    //private final MeuDaoImpl mmdao = new MeuDaoImpl();
    private final MeuDaoImpl dao = new MeuDaoImpl();
    private List<Setor> setores;
    private Setor setor;
    ////////////////////////////////////////////////////////

    public MbControle() {
    }

    @PostConstruct
    public void init() {
        setores = dao.consultaTodosSetores();
    }

    private InterfaceDAO<Controle> controleDAO() {
        InterfaceDAO<Controle> controleDAO = new HibernateDAO<Controle>(Controle.class, FacesContextUtil.getRequestSession());
        return controleDAO;
    }

    public String limpControle() {
        controle = new Controle();
        selected = new Empresa();
        setor = new Setor();
        return editControle();
    }

    public String editControle() {
        return "/restrict/cadastros/cadastrarcontrole.faces";
    }

    public String addControle() {
        // verifica a id veio igual a null ou id igual a 0
        if (controle.getContr_id() == null || controle.getContr_id() == 0) {
            insertControle();
        } else {
            updateControle();
        }
        limpControle();
        return null;
    }

    private void insertControle() {
        try {
            controle.setEmpresa(selected);
            controle.setSetor(setor);
            controleDAO().save(controle);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Gravação efetuada com sucesso", ""));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro ao [Cadastrar],  no Banco de Dados", "" + ex));
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Entre em contato com o Administrador", "" + ex));
        }

    }

    private void updateControle() {
        try {
            controle.setEmpresa(selected);
            controle.setSetor(setor);
            controleDAO().update(controle);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Atualização efetuada com sucesso", ""));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro ao [Atualizar], no Banco de Dados", "" + ex));
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Entre em contato com o Administrador", "" + ex));
        }

    }

    public void deleteControle() {
        try {
            controleDAO().remove(controle);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro excluído com sucesso", ""));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro ao [Excluir], no Banco de Dados", "" + ex));
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Entre em contato com o Administrador", "" + ex));
        }

    }

    public Empresa getSelected() {
        return selected;
    }

    public void setSelected(Empresa selected) {
        this.selected = selected;
    }

    // Actions
    public List<Empresa> completeEmpresa() {
        return dao.consultaTodasEmpresas();
    }

    public String clear() {
        this.selected = null;
//        this.marca = null;
//        this.modelo = null;
        return "";
    }

    public List<Controle> getControles() {
        controles = controleDAO().getEntities();
        return controles;
    }

    public void setControles(List<Controle> controles) {
        this.controles = controles;
    }

    public Controle getControle() {
        return controle;
    }

    public void setControle(Controle controle) {
        this.controle = controle;
    }

    public List<Setor> getSetores() {
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

    public List<Controle> getFilteredControles() {
        return filteredControles;
    }

    public void setFilteredControles(List<Controle> filteredControles) {
        this.filteredControles = filteredControles;
    }

    public List<Controle> getConsultaControles() {
        return consultaControles;
    }

    public void setConsultaControles(List<Controle> consultaControles) {
        this.consultaControles = consultaControles;
    }

}
