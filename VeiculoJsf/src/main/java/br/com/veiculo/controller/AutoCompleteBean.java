/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.veiculo.controller;

import br.com.veiculo.converter.PessoaConverter;
import br.com.veiculo.model.entities.Pessoa;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author cleiton
 */
@ManagedBean(name = "autoCompleteBean")
public class AutoCompleteBean {
    
    private Pessoa selectedPessoa1;  
      
    public AutoCompleteBean(List<Pessoa> pessoa) {  
        pessoa = PessoaConverter.pessoaDB;  
    }  
  
    public Pessoa getSelectedPessoa1() {  
        return selectedPessoa1;  
    }  
  
    public void setSelectedPessoa1(Pessoa selectedPessoa1) {  
        this.selectedPessoa1 = selectedPessoa1;  
    }  
  
    public List<Pessoa> completePessoa(String query, Iterable<Pessoa> pessoa) {  
        List<Pessoa> suggestions = new ArrayList<Pessoa>();  
          
        for(Pessoa p : pessoa) {  
            if(p.getPes_cpf().startsWith(query))  
                suggestions.add(p);  
        }  
          
        return suggestions;  
    }  
}  