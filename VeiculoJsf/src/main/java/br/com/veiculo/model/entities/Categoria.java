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
 * @author cleiton
 */
@Entity
@Table(name = "categoria")
public class Categoria implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "cat_id", nullable = false)
    private Integer cat_id;
    @Column(name = "cat_nome", nullable = false, length = 80)
    private String cat_nome;
    @Column(name = "cat_flag", nullable = false, length = 1)
    private String cat_flag;
    @Column(name = "cat_obs", nullable = false, length = 500)
    private String cat_obs;

    @OneToMany(mappedBy = "categoria", fetch = FetchType.LAZY)
    @ForeignKey(name = "CategoriaAgenda")
    private List<Agenda> agendas;

    public Categoria() {
    }

    public Integer getCat_id() {
        return cat_id;
    }

    public void setCat_id(Integer cat_id) {
        this.cat_id = cat_id;
    }

    public String getCat_nome() {
        return cat_nome;
    }

    public void setCat_nome(String cat_nome) {
        this.cat_nome = cat_nome;
    }

    public String getCat_flag() {
        return cat_flag;
    }

    public void setCat_flag(String cat_flag) {
        this.cat_flag = cat_flag;
    }

    public String getCat_obs() {
        return cat_obs;
    }

    public void setCat_obs(String cat_obs) {
        this.cat_obs = cat_obs;
    }

    public List<Agenda> getAgendas() {
        return agendas;
    }

    public void setAgendas(List<Agenda> agendas) {
        this.agendas = agendas;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + (this.cat_id != null ? this.cat_id.hashCode() : 0);
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
        final Categoria other = (Categoria) obj;
        if (this.cat_id != other.cat_id && (this.cat_id == null || !this.cat_id.equals(other.cat_id))) {
            return false;
        }
        return true;
    }

}
