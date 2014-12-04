/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.veiculo.controller;

import br.com.veiculo.model.dao.HibernateDAO;
import br.com.veiculo.model.dao.InterfaceDAO;
import br.com.veiculo.model.dao.MeuDaoImpl;
import br.com.veiculo.model.entities.Cidade;
import br.com.veiculo.model.entities.Empresa;
import br.com.veiculo.model.entities.Estado;
import br.com.veiculo.util.FacesContextUtil;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

/**
 *
 * @author cleiton
 */
@ManagedBean(name = "mbEmpresa")
@ViewScoped
public class MbEmpresa implements Serializable {

    private static final long serialVersionUID = 1L;

    private Empresa empresa = new Empresa();
    private List<Empresa> empresas;
    private List<Empresa> filteredEmpresas;
    private List<Empresa> consultaEmpresas;

    ///// Objetos para os ComBos Estado Cidade \\\\\
    private final MeuDaoImpl dao = new MeuDaoImpl();
    private List<Estado> estados;
    private List<Cidade> cidades;
    private Cidade cidade;
    private Estado estado;
    //////////////////////////////////

    public MbEmpresa() {
    }

    @PostConstruct
    public void init() {
        estados = dao.consultaTodosEstados();
    }

    public void listaCidades(AjaxBehaviorEvent event) {
//        System.out.println("Busca Cidade>>>>>>>>>>>>");
        cidades = dao.consultaCidades(estado);
    }

    private InterfaceDAO<Empresa> empresaDAO() {
        InterfaceDAO<Empresa> empresaDAO = new HibernateDAO<Empresa>(Empresa.class, FacesContextUtil.getRequestSession());
        return empresaDAO;
    }

    public String limpEmpresa() {
        empresa = new Empresa();
        estado = new Estado();
        cidade = new Cidade();
        return editEmpresa();
    }

    public String editEmpresa() {
        return "/restrict/cadastros/cadastrarempresa.faces";
    }

    public String addEmpresa() {
        // verifica a id veio igual a null ou id igual a 0
        if (empresa.getEmp_id() == null || empresa.getEmp_id() == 0) {
            insertEmpresa();
        } else {
            updateEmpresa();
        }
        limpEmpresa();
        return null;
    }

    private void insertEmpresa() {
        try {
            empresa.setEstado(estado);
            empresa.setCidade(cidade);
            empresaDAO().save(empresa);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Gravação efetuada com sucesso", ""));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro ao [Cadastrar],  no Banco de Dados", "" + ex));
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Entre em contato com o Administrador", "" + ex));
        }
    }

    private void updateEmpresa() {
        try {
            empresa.setEstado(estado);
            empresa.setCidade(cidade);
            empresaDAO().update(empresa);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Atualização efetuada com sucesso", ""));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro ao [Atualizar], no Banco de Dados", "" + ex));
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Entre em contato com o Administrador", "" + ex));
        }
    }

    public void deleteEmpresa() {
        try {
            empresaDAO().remove(empresa);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro excluído com sucesso", ""));
            limpEmpresa();
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro ao [Excluir], no Banco de Dados", "" + ex));
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Entre em contato com o Administrador", "" + ex));
        }

    }

    public List<Empresa> getEmpresas() {
        empresas = empresaDAO().getEntities();
        return empresas;
    }

    public void setEmpresas(List<Empresa> empresas) {
        this.empresas = empresas;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public List<Estado> getEstados() {
        return estados;
    }

    public void setEstados(List<Estado> estados) {
        this.estados = estados;
    }

    public List<Cidade> getCidades() {
        return cidades;
    }

    public void setCidades(List<Cidade> cidades) {
        this.cidades = cidades;
    }

    public List<Empresa> getFilteredEmpresas() {
        return filteredEmpresas;
    }

    public void setFilteredEmpresas(List<Empresa> filteredEmpresas) {
        this.filteredEmpresas = filteredEmpresas;
    }

    public List<Empresa> getConsultaEmpresas() {
        return consultaEmpresas;
    }

    public void setConsultaEmpresas(List<Empresa> consultaEmpresas) {
        this.consultaEmpresas = consultaEmpresas;
    }

}
