/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.veiculo.controller;

import br.com.veiculo.model.dao.HibernateDAO;
import br.com.veiculo.model.dao.InterfaceDAO;
import br.com.veiculo.model.entities.Categoria;
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
@ManagedBean(name = "mbCategoria")
@ViewScoped
public class MbCategoria implements Serializable {

    private static final long serialVersionUID = 1L;

    private Categoria categoria = new Categoria();
    private List<Categoria> categorias;
    private List<Categoria> filteredCategorias;
    private List<Categoria> consultaCategorias;

    public MbCategoria() {
    }

       private InterfaceDAO<Categoria> categoriaDAO() {
        InterfaceDAO<Categoria> categoriaDAO = new HibernateDAO<Categoria>(Categoria.class, FacesContextUtil.getRequestSession());
        return categoriaDAO;
    }

    public String limpCategoria() {
        categoria = new Categoria();
        return editCategoria();
    }

    public String editCategoria() {
        return "/restrict/cadastros/cadastrarcategoria.faces";
    }

    public String addCategoria() {
        // verifica a id veio igual a null ou id igual a 0
        if (categoria.getCat_id() == null || categoria.getCat_id() == 0) {
            insertCategoria();
        } else {
            updateCategoria();
        }
        limpCategoria();
        return null;
    }

    private void insertCategoria() {
        try {
            categoriaDAO().save(categoria);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Gravação efetuada com sucesso", ""));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro ao [Cadastrar],  no Banco de Dados", "" + ex));
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Entre em contato com o Administrador", "" + ex));
        }
    }

    private void updateCategoria() {
        try {
            categoriaDAO().update(categoria);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Atualização efetuada com sucesso", ""));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro ao [Atualizar], no Banco de Dados", "" + ex));
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Entre em contato com o Administrador", "" + ex));
        }
    }

    public void deleteCategoria() {
        try {
            categoriaDAO().remove(categoria);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro excluído com sucesso", ""));
            limpCategoria();
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro ao [Excluir], no Banco de Dados", "" + ex));
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Entre em contato com o Administrador", "" + ex));
        }

    }

    public List<Categoria> getCategorias() {
        categorias = categoriaDAO().getEntities();
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

    public List<Categoria> getFilteredCategorias() {
        return filteredCategorias;
    }

    public void setFilteredCategorias(List<Categoria> filteredCategorias) {
        this.filteredCategorias = filteredCategorias;
    }

    public List<Categoria> getConsultaCategorias() {
        return consultaCategorias;
    }

    public void setConsultaCategorias(List<Categoria> consultaCategorias) {
        this.consultaCategorias = consultaCategorias;
    }

    
    

}
