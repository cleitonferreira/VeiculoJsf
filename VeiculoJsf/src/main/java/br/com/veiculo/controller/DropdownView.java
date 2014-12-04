/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.veiculo.controller;

import br.com.veiculo.model.dao.MeuDaoImpl;
import br.com.veiculo.model.entities.Cidade;
import br.com.veiculo.model.entities.Estado;
import br.com.veiculo.model.entities.Pessoa;
import br.com.veiculo.model.entities.Veiculo;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author cleiton
 */
@ManagedBean
@ViewScoped
public class DropdownView implements Serializable {

    private Map<String, Map<String, String>> data = new HashMap<String, Map<String, String>>();
    private String country;
    private String city;
    private Map<String, String> countries;
    private Map<String, String> cities;

    private Pessoa pessoa = new Pessoa();
    private Veiculo veiculo = new Veiculo();
    private List<Pessoa> pessoas;

    ///// Objetos para os ComBos Estado Cidade \\\\\
    private final MeuDaoImpl dao = new MeuDaoImpl();
    private List<Estado> estados;
    private List<Cidade> cidades;
    private Cidade cidade;
    private Estado estado;
    //////////////////////////////////

    @PostConstruct
    public void init() {
//        countries = new HashMap<String, String>();
//        countries.put("USA", "USA");
//        countries.put("Germany", "Germany");
//        countries.put("Brazil", "Brazil");
//
//        Map<String, String> map = new HashMap<String, String>();
//        map.put("New York", "New York");
//        map.put("San Francisco", "San Francisco");
//        map.put("Denver", "Denver");
//        data.put("USA", map);
//
//        map = new HashMap<String, String>();
//        map.put("Berlin", "Berlin");
//        map.put("Munich", "Munich");
//        map.put("Frankfurt", "Frankfurt");
//        data.put("Germany", map);
//
//        map = new HashMap<String, String>();
//        map.put("Sao Paulo", "Sao Paulo");
//        map.put("Rio de Janerio", "Rio de Janerio");
//        map.put("Salvador", "Salvador");
//        data.put("Brazil", map);
        
        estados = dao.consultaTodosEstados();

    }

    public Map<String, Map<String, String>> getData() {
        return data;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Map<String, String> getCountries() {
        return countries;
    }

    public Map<String, String> getCities() {
        return cities;
    }

    public void onCountryChange() {
        if (estado != null && !estado.equals("")) {
            cities = data.get(country);
        } else {
            cities = new HashMap<String, String>();
        }
    }

    public void displayLocation() {
        FacesMessage msg;
        if (city != null && country != null) {
            msg = new FacesMessage("Selected", city + " of " + country);
        } else {
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid", "City is not selected.");
        }

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
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

}
