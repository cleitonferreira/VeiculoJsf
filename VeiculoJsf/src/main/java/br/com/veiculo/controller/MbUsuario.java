/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.veiculo.controller;

import br.com.veiculo.converter.ConverterSHA1;
import br.com.veiculo.model.dao.HibernateDAO;
import br.com.veiculo.model.dao.InterfaceDAO;
import br.com.veiculo.model.dao.MeuDaoImpl;
import br.com.veiculo.model.entities.Setor;
import br.com.veiculo.model.entities.Usuario;
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
@ManagedBean(name = "mbUsuario")
@ViewScoped
public class MbUsuario implements Serializable {

    private static final long serialVersionUID = 1L;

    private Usuario usuario = new Usuario();
    private List<Usuario> usuarios;
    private List<Usuario> filteredUsuarios;
    private List<Usuario> consultaUsuarios;

    ///// Objetos para o Combo Setor \\\\\
    //private final MeuDaoImpl mmdao = new MeuDaoImpl();
    private final MeuDaoImpl dao = new MeuDaoImpl();
    private List<Setor> setores;
    private Setor setor;
    ////////////////////////////////////////////////////////
    
    public MbUsuario() {
    }

    @PostConstruct
    public void init() {
        setores = dao.consultaTodosSetores();
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
        return "/restrict/cadastros/cadastrarusuario.faces";
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
            usuario.setSetor(setor);
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
            usuario.setSetor(setor);
            usuario.setUsu_senha(ConverterSHA1.cipher(usuario.getUsu_senha()));
            usuario.setUsu_permissao("ROLE_ADMIN");
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

    public List<Usuario> getFilteredUsuarios() {
        return filteredUsuarios;
    }

    public void setFilteredUsuarios(List<Usuario> filteredUsuarios) {
        this.filteredUsuarios = filteredUsuarios;
    }

    public List<Usuario> getConsultaUsuarios() {
        return consultaUsuarios;
    }

    public void setConsultaUsuarios(List<Usuario> consultaUsuarios) {
        this.consultaUsuarios = consultaUsuarios;
    }
    

}
