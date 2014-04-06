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
@Table(name = "setor")
public class Setor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "set_id", nullable = false)
    private Integer set_id;
    @Column(name = "set_nome", nullable = false, length = 50)
    private String set_nome;
    @Column(name = "set_ramal", nullable = false, length = 4)
    private String set_ramal;
    @Column(name = "set_responsavel", nullable = false, length = 50)
    private String set_responsavel;

    @OneToMany(mappedBy = "setor", fetch = FetchType.LAZY)
    @ForeignKey(name = "SetorUsuario")
    private List<Usuario> usuarios;

    public Setor() {
    }

    public Integer getSet_id() {
        return set_id;
    }

    public void setSet_id(Integer set_id) {
        this.set_id = set_id;
    }

    public String getSet_nome() {
        return set_nome;
    }

    public void setSet_nome(String set_nome) {
        this.set_nome = set_nome;
    }

    public String getSet_ramal() {
        return set_ramal;
    }

    public void setSet_ramal(String set_ramal) {
        this.set_ramal = set_ramal;
    }

    public String getSet_responsavel() {
        return set_responsavel;
    }

    public void setSet_responsavel(String set_responsavel) {
        this.set_responsavel = set_responsavel;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    



    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (this.set_id != null ? this.set_id.hashCode() : 0);
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
        final Setor other = (Setor) obj;
        if (this.set_id != other.set_id && (this.set_id == null || !this.set_id.equals(other.set_id))) {
            return false;
        }
        return true;
    }

}
