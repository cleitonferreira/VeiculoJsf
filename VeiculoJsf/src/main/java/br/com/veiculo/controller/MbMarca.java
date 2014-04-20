/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.veiculo.controller;

import br.com.veiculo.model.dao.HibernateDAO;
import br.com.veiculo.model.dao.InterfaceDAO;
import br.com.veiculo.model.entities.Marca;
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
@ManagedBean(name = "mbMarca")
@SessionScoped
public class MbMarca implements Serializable {

    private static final long serialVersionUID = 1L;

    private Marca marca = new Marca();
    private List<Marca> marcas;

    public MbMarca() {
    }

    private InterfaceDAO<Marca> marcaDAO() {
        InterfaceDAO<Marca> marcaDAO = new HibernateDAO<Marca>(Marca.class, FacesContextUtil.getRequestSession());
        return marcaDAO;
    }

    public String limpMarca() {
        marca = new Marca();
        return editMarca();
    }

    public String editMarca() {
        return "/restrict/cadastrarmarca.faces";
    }

    public String addMarca() {
        // verifica a id veio igual a null ou id igual a 0
        if (marca.getMar_id() == null || marca.getMar_id() == 0) {
            insertMarca();
        } else {
            updateMarca();
        }
        limpMarca();
        return null;
    }

    private void insertMarca() {
        marcaDAO().save(marca);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Gravação efetuada com sucesso", ""));
    }

    private void updateMarca() {
        marcaDAO().update(marca);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Atualização efetuada com sucesso", ""));
    }

    public void deleteMarca() {
        marcaDAO().remove(marca);
    }

    public List<Marca> getMarcas() {
        marcas = marcaDAO().getEntities();
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

}
