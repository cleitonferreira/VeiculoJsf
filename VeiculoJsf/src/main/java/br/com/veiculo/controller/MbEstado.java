/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.veiculo.controller;

import br.com.veiculo.model.dao.HibernateDAO;
import br.com.veiculo.model.dao.InterfaceDAO;
import br.com.veiculo.model.dao.MeuDaoImpl;
import br.com.veiculo.model.entities.Estado;
import br.com.veiculo.model.entities.Pais;
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
@ManagedBean(name = "mbEstado")
@ViewScoped
public class MbEstado implements Serializable {

    private static final long serialVersionUID = 1L;

    private Estado estado = new Estado();
    private List<Estado> estados;
    private List<Estado> filteredEstados;
    private List<Estado> consultaEstados;

    ///// Objetos para o Combo Setor \\\\\
    //private final MeuDaoImpl mmdao = new MeuDaoImpl();
    private final MeuDaoImpl dao = new MeuDaoImpl();
    private List<Pais> paises;
    private Pais pais;
    ////////////////////////////////////////////////////////

    public MbEstado() {
    }

    @PostConstruct
    public void init() {
        paises = dao.consultaTodosPaises();
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
        return "/restrict/cadastros/cadastrarestado.faces";
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
        try {
            estado.setPais(pais);
            estadoDAO().save(estado);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Gravação efetuada com sucesso", ""));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro ao [Cadastrar],  no Banco de Dados", "" + ex));
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Entre em contato com o Administrador", "" + ex));
        }

    }

    private void updateEstado() {
        try {
            estado.setPais(pais);
            estadoDAO().update(estado);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Atualização efetuada com sucesso", ""));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro ao [Atualizar], no Banco de Dados", "" + ex));
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Entre em contato com o Administrador", "" + ex));
        }

    }

    public void deleteEstado() {
        try {
            estadoDAO().remove(estado);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro excluído com sucesso", ""));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro ao [Excluir], no Banco de Dados", "" + ex));
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Entre em contato com o Administrador", "" + ex));
        }

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

    public List<Estado> getFilteredEstados() {
        return filteredEstados;
    }

    public void setFilteredEstados(List<Estado> filteredEstados) {
        this.filteredEstados = filteredEstados;
    }

    public List<Pais> getPaises() {
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

    public List<Estado> getConsultaEstados() {
        return consultaEstados;
    }

    public void setConsultaEstados(List<Estado> consultaEstados) {
        this.consultaEstados = consultaEstados;
    }
    
    

}
