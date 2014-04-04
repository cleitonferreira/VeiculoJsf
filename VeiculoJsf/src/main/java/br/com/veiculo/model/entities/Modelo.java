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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

/**
 *
 * @author XPredator
 */
@Entity
@Table(name = "TB_MODELO")
public class Modelo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "mod_id", nullable = false)
    private Integer mod_id;
    @Column(name = "mod_nome", nullable = false, length = 50)
    private String mod_nome;
    @Column(name = "mod_flag", nullable = false, length = 1)
    private String mod_flag;

    @ManyToOne(optional = false)
    @ForeignKey(name = "Marca_Modelo")
    @JoinColumn(name = "mar_id", referencedColumnName = "mar_id")
    private Marca marca;

    @OneToMany(mappedBy = "TB_MODELO", fetch = FetchType.LAZY)
    @ForeignKey(name = "Veiculo_Modelo")
    private List<Veiculo> veiculos;

    public Modelo() {
    }

    public Integer getMod_id() {
        return mod_id;
    }

    public void setMod_id(Integer mod_id) {
        this.mod_id = mod_id;
    }

    public String getMod_nome() {
        return mod_nome;
    }

    public void setMod_nome(String mod_nome) {
        this.mod_nome = mod_nome;
    }

    public String getMod_flag() {
        return mod_flag;
    }

    public void setMod_flag(String mod_flag) {
        this.mod_flag = mod_flag;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(List<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }

 

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + (this.mod_id != null ? this.mod_id.hashCode() : 0);
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
        final Modelo other = (Modelo) obj;
        if (this.mod_id != other.mod_id && (this.mod_id == null || !this.mod_id.equals(other.mod_id))) {
            return false;
        }
        return true;
    }

}
