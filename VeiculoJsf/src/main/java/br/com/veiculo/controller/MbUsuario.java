/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.veiculo.controller;

import br.com.veiculo.converter.ConverterSHA1;
import br.com.veiculo.model.dao.HibernateDAO;
import br.com.veiculo.model.dao.InterfaceDAO;
import br.com.veiculo.model.entities.Usuario;
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
@ManagedBean(name = "mbUsuario")
@SessionScoped
public class MbUsuario implements Serializable {

    private static final long serialVersionUID = 1L;

    private Usuario usuario = new Usuario();
    private List<Usuario> usuarios;

    public MbUsuario() {
    }

    private InterfaceDAO<Usuario> usuarioDAO() {
        InterfaceDAO<Usuario> usuarioDAO = new HibernateDAO<Usuario>(Usuario.class, FacesContextUtil.getRequestSession());
        return usuarioDAO;
    }

    public String limpUsuario() {
        usuario = new Usuario();
        return editUsuario();
    }

    public String editUsuario() {
        return "/restrict/cadastrarusuario.faces";
    }

    public String addUsuario() {
        // verifica a id veio igual a null ou id igual a 0
        if (usuario.getUsu_id() == null || usuario.getUsu_id() == 0) {
            insertUsuario();
        } else {
            updateUsuario();
        }
        limpUsuario();
        return null;
    }

    private void insertUsuario() {
        try {
            usuario.setUsu_senha(ConverterSHA1.cipher(usuario.getUsu_senha()));
            usuario.setUsu_permissao("ROLE_ADMIN");
            usuarioDAO().save(usuario);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Gravação efetuada com sucesso", ""));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro ao [Cadastrar],  no Banco de Dados", "" + ex));
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Entre em contato com o Administrador", "" + ex));
        }

    }

    private void updateUsuario() {
        try {
            usuarioDAO().update(usuario);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Atualização efetuada com sucesso", ""));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro ao [Atualizar], no Banco de Dados", "" + ex));
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Entre em contato com o Administrador", "" + ex));
        }

    }

    public void deleteUsuario() {
        try {
            usuarioDAO().remove(usuario);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro excluído com sucesso", ""));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro ao [Excluir], no Banco de Dados", "" + ex));
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Entre em contato com o Administrador", "" + ex));
        }

    }

    public List<Usuario> getUsuarios() {
        usuarios = usuarioDAO().getEntities();
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
