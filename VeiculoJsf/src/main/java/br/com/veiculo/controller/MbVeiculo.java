/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.veiculo.controller;

import br.com.veiculo.model.dao.HibernateDAO;
import br.com.veiculo.model.dao.ImplDaoMarcaModelo;
import br.com.veiculo.model.dao.InterfaceDAO;
import br.com.veiculo.model.dao.MeuDaoMarcaModelo;
import br.com.veiculo.model.entities.Marca;
import br.com.veiculo.model.entities.Modelo;
import br.com.veiculo.model.entities.Veiculo;
import br.com.veiculo.util.FacesContextUtil;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

/**
 *
 * @author cleiton
 */
@ManagedBean(name = "mbVeiculo")
@SessionScoped
public class MbVeiculo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Veiculo veiculo = new Veiculo();
    private List<Veiculo> veiculos;

    ///// Objetos para os ComBos \\\\\
    private final MeuDaoMarcaModelo dao = new ImplDaoMarcaModelo();
    private List<Marca> marcas;
    private List<Modelo> modelos;
    private Marca marca;
    private Modelo modelo;

    //////////////////////////////////
    public MbVeiculo() {
    }

    @PostConstruct
    public void init() {
        marcas = dao.consultaTodasMarcas();
    }

    public void listaModelos(AjaxBehaviorEvent event) {
        modelos = dao.consultaModelos(marca);
    }

    private InterfaceDAO<Veiculo> veiculoDAO() {
        InterfaceDAO<Veiculo> veiculoDAO = new HibernateDAO<Veiculo>(Veiculo.class, FacesContextUtil.getRequestSession());
        return veiculoDAO;
    }

    public String limpVeiculo() {
        veiculo = new Veiculo();
        return editVeiculo();
    }

    public String editVeiculo() {
        return "/restrict/cadastrarveiculo.faces";
    }

    public String addVeiculo() {
        // verifica a id veio igual a null ou id igual a 0
        if (veiculo.getVeic_id() == null || veiculo.getVeic_id() == 0) {
            insertVeiculo();
        } else {
            updateVeiculo();
        }
        limpVeiculo();
        return null;
    }

    private void insertVeiculo() {
        veiculoDAO().save(veiculo);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Gravação efetuada com sucesso", ""));
    }

    private void updateVeiculo() {
        veiculoDAO().update(veiculo);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Atualização efetuada com sucesso", ""));
    }

    public void deleteVeiculo() {
        veiculoDAO().remove(veiculo);
    }

    //tomar cuidado com esse get aqui
    //realizar as modificações.
    public List<Veiculo> getVeiculos() {
        veiculos = veiculoDAO().getEntities();
        return veiculos;
    }
    //////////////////////////////////
    

    public void setVeiculos(List<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public List<Marca> getMarcas() {
        return marcas;
    }

    public void setMarcas(List<Marca> marcas) {
        this.marcas = marcas;
    }

    public List<Modelo> getModelos() {
        return modelos;
    }

    public void setModelos(List<Modelo> modelos) {
        this.modelos = modelos;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }
    
    

}
