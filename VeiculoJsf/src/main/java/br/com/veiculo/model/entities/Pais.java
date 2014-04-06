/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.veiculo.model.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

/**
 *
 * @author XPredator
 */
@Entity
@Table(name="pais")
public class Pais implements Serializable{
    
    private static  final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    @Column(name="pa_id", nullable = false)
    private Integer pa_id;
    @Column(name="pa_nome", nullable = false, length = 255)
    private String pa_nome;
    @Column(name="pa_sigla", nullable = false, length = 3)
    private String pa_sigla;
    
 
    @OneToMany(mappedBy = "pais", fetch = FetchType.LAZY)
    @ForeignKey(name = "PaisEstado")
    private List<Estado> estados;
    
    
    public Pais() {
    }

    
    public Integer getPa_id() {
        return pa_id;
    }

    public void setPa_id(Integer pa_id) {
        this.pa_id = pa_id;
    }

    public String getPa_nome() {
        return pa_nome;
    }

    public void setPa_nome(String pa_nome) {
        this.pa_nome = pa_nome;
    }

    public String getPa_sigla() {
        return pa_sigla;
    }

    public void setPa_sigla(String pa_sigla) {
        this.pa_sigla = pa_sigla;
    }

    public List<Estado> getEstados() {
        return estados;
    }

    public void setEstados(List<Estado> estados) {
        this.estados = estados;
    }

    
 
    
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (this.pa_id != null ? this.pa_id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pais other = (Pais) obj;
        if (this.pa_id != other.pa_id && (this.pa_id == null || !this.pa_id.equals(other.pa_id))) {
            return false;
        }
        return true;
    }
    
    
    
}
