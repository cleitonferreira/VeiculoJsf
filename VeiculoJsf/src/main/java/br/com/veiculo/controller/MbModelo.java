/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.veiculo.controller;

import br.com.veiculo.model.dao.HibernateDAO;
import br.com.veiculo.model.dao.InterfaceDAO;
import br.com.veiculo.model.dao.MeuDaoImpl;
import br.com.veiculo.model.entities.Marca;
import br.com.veiculo.model.entities.Modelo;
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
@ManagedBean(name = "mbModelo")
@ViewScoped
public class MbModelo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Modelo modelo = new Modelo();
    public List<Modelo> modelos;
    private List<Modelo> filteredModelos;
    private List<Modelo> consultaModelos;

    ///// Objetos para o Combo Marca \\\\\
    //private final MeuDaoImpl mmdao = new MeuDaoImpl();
    private final MeuDaoImpl dao = new MeuDaoImpl();
    private List<Marca> marcas;
    private Marca marca;
    ////////////////////////////////////////////////////////

    public MbModelo() {
    }

    @PostConstruct
    public void init() {
        marcas = dao.consultaTodasMarcas();
    }

    private InterfaceDAO<Modelo> modeloDAO() {
        InterfaceDAO<Modelo> modeloDAO = new HibernateDAO<Modelo>(Modelo.class, FacesContextUtil.getRequestSession());
        return modeloDAO;
    }

    public String limpModelo() {
        modelo = new Modelo();
        marca = new Marca();
        return editModelo();
    }

    public String editModelo() {
        return "/restrict/cadastros/cadastrarmodelo.faces";
    }

    public String addModelo() {
        // verifica a id veio igual a null ou id igual a 0
        if (modelo.getMod_id() == null || modelo.getMod_id() == 0) {
            insertModelo();
        } else {
            updateModelo();
        }
        limpModelo();
        return null;
    }

    private void insertModelo() {

        try {
            modelo.setMarca(marca);
            modeloDAO().save(modelo);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Gravação efetuada com sucesso", ""));

        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro ao [Cadastrar], no Banco de Dados", "" + ex));
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Entre em contato com o Administrador", "" + ex));
        }

    }

    private void updateModelo() {
        try {
            modelo.setMarca(marca);
            modeloDAO().update(modelo);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Atualização efetuada com sucesso", ""));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro ao [Atualizar], no Banco de Dados", "" + ex));
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Entre em contato com o Administrador", "" + ex));
        }

    }

    public void deleteModelo() {
        try {
            modeloDAO().remove(modelo);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro excluído com sucesso", ""));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro ao [Excluir], no Banco de Dados", "" + ex));
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Entre em contato com o Administrador", "" + ex));
        }
    }

    public List<Modelo> getModelos() {
        modelos = modeloDAO().getEntities();
        return modelos;
    }

    public void setModelos(List<Modelo> modelos) {
        this.modelos = modelos;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public List<Modelo> getFilteredModelos() {
        return filteredModelos;
    }

    public void setFilteredModelos(List<Modelo> filteredModelos) {
        this.filteredModelos = filteredModelos;
    }

    public List<Marca> getMarcas() {
        return marcas;
    }

    public void setMarcas(List<Marca> marcas) {
        this.marcas = marcas;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public List<Modelo> getConsultaModelos() {
        return consultaModelos;
    }

    public void setConsultaModelos(List<Modelo> consultaModelos) {
        this.consultaModelos = consultaModelos;
    }

}
