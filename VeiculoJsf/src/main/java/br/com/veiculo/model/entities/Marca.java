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
@Table(name = "TB_MARCA")
public class Marca implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "mar_id", nullable = false)
    private Integer mar_id;
    @Column(name = "mar_nome", nullable = false, length = 50)
    private String mar_nome;
    @Column(name = "mar_flag", nullable = false, length = 1)
    private String mar_flag;

    @OneToMany(mappedBy = "TB_MARCA", fetch = FetchType.LAZY)
    @ForeignKey(name = "Veiculo_Marca")
    private List<Veiculo> veiculos;

    @OneToMany(mappedBy = "TB_MARCA", fetch = FetchType.LAZY)
    @ForeignKey(name = "Marca_Modelo")
    private List<Modelo> modelos;

    public Marca() {
    }

    public Integer getMar_id() {
        return mar_id;
    }

    public void setMar_id(Integer mar_id) {
        this.mar_id = mar_id;
    }

    public String getMar_nome() {
        return mar_nome;
    }

    public void setMar_nome(String mar_nome) {
        this.mar_nome = mar_nome;
    }

    public String getMar_flag() {
        return mar_flag;
    }

    public void setMar_flag(String mar_flag) {
        this.mar_flag = mar_flag;
    }

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(List<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }

    public List<Modelo> getModelos() {
        return modelos;
    }

    public void setModelos(List<Modelo> modelos) {
        this.modelos = modelos;
    }

    
    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + (this.mar_id != null ? this.mar_id.hashCode() : 0);
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
        final Marca other = (Marca) obj;
        if (this.mar_id != other.mar_id && (this.mar_id == null || !this.mar_id.equals(other.mar_id))) {
            return false;
        }
        return true;
    }

}
