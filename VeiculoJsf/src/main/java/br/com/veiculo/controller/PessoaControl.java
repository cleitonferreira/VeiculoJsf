/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.veiculo.controller;

import br.com.veiculo.model.dao.MeuDao;
import br.com.veiculo.model.dao.MeuDaoImpl;
import br.com.veiculo.model.entities.Pessoa;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Cleiton
 */
@ManagedBean(name = "pessoaControl")
@SessionScoped
public class PessoaControl implements Serializable {

    private static final long serialVersionUID = 1L;
    
    MeuDao dao = new MeuDaoImpl();
    private Pessoa selected;
    

    public Pessoa getSelected() {
        return selected;
    }

    public void setSelected(Pessoa selected) {
        this.selected = selected;
    }

    // Actions
    public List<Pessoa> completePessoa(){
        return dao.consultaTodosPessoas();
    }
    
    public String clear(){
        this.selected = null;
        return "";
    }
}
