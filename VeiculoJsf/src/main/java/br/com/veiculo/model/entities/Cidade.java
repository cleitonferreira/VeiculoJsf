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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

/**
 *
 * @author XPredator
 */
@Entity
@Table(name = "TB_CIDADE")
public class Cidade implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "cid_id", nullable = false)
    private Integer cid_id;
    @Column(name = "cid_nome", nullable = false, length = 255)
    private String cid_nome;

    @ManyToOne(optional = false)
    @ForeignKey(name = "Estado_Cidade")
    @JoinColumn(name = "est_id", referencedColumnName = "est_id")
    private Estado estado;

    @OneToMany(mappedBy = "TB_CIDADE", fetch = FetchType.LAZY)
    @ForeignKey(name = "Cidade_Pessoa")
    private Pessoa pessoa;

    public Cidade() {
        this.estado = new Estado();
    }

    public Integer getCid_id() {
        return cid_id;
    }

    public void setCid_id(Integer cid_id) {
        this.cid_id = cid_id;
    }

    public String getCid_nome() {
        return cid_nome;
    }

    public void setCid_nome(String cid_nome) {
        this.cid_nome = cid_nome;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + (this.cid_id != null ? this.cid_id.hashCode() : 0);
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
        final Cidade other = (Cidade) obj;
        if (this.cid_id != other.cid_id && (this.cid_id == null || !this.cid_id.equals(other.cid_id))) {
            return false;
        }
        return true;
    }

}
