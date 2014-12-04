/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.veiculo.model.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

/**
 *
 * @author cleiton
 */
@Entity
@Table(name = "agenda")
public class Agenda implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "age_id", nullable = false)
    private Integer age_id;
    @Column(name = "age_nome", nullable = false, length = 80)
    private String age_nome;
    @Column(name = "age_tel", nullable = false, length = 14)//(34)-8888-8888
    private String age_tel;
    @Column(name = "age_tel2", nullable = false, length = 14)//(34)-8888-8888
    private String age_tel2;
    @Column(name = "age_cel", nullable = false, length = 15)
    private String age_cel;
    @Column(name = "age_cel2", nullable = false, length = 15)
    private String age_cel2;
    @Column(name = "age_obs", nullable = false, length = 500)
    private String age_obs;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @ForeignKey(name = "CategoriaAgenda")
    @JoinColumn(name = "cat_id", referencedColumnName = "cat_id")
    private Categoria categoria;

    public Agenda() {
        this.categoria = new Categoria();
    }

    public Integer getAge_id() {
        return age_id;
    }

    public void setAge_id(Integer age_id) {
        this.age_id = age_id;
    }

    public String getAge_nome() {
        return age_nome;
    }

    public void setAge_nome(String age_nome) {
        this.age_nome = age_nome;
    }

    public String getAge_tel() {
        return age_tel;
    }

    public void setAge_tel(String age_tel) {
        this.age_tel = age_tel;
    }

    public String getAge_tel2() {
        return age_tel2;
    }

    public void setAge_tel2(String age_tel2) {
        this.age_tel2 = age_tel2;
    }

    public String getAge_cel() {
        return age_cel;
    }

    public void setAge_cel(String age_cel) {
        this.age_cel = age_cel;
    }

    public String getAge_cel2() {
        return age_cel2;
    }

    public void setAge_cel2(String age_cel2) {
        this.age_cel2 = age_cel2;
    }

    public String getAge_obs() {
        return age_obs;
    }

    public void setAge_obs(String age_obs) {
        this.age_obs = age_obs;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (this.age_id != null ? this.age_id.hashCode() : 0);
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
        final Agenda other = (Agenda) obj;
        if (this.age_id != other.age_id && (this.age_id == null || !this.age_id.equals(other.age_id))) {
            return false;
        }
        return true;
    }

    
}
