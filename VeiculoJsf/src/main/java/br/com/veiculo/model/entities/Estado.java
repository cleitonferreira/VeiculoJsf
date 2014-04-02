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
@Table(name="TB_PESSOA")
public class Estado implements Serializable{
    
    private static  final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    @Column(name="est_id", nullable = false)
    private Integer est_id;
    @Column(name="est_nome", nullable = false, length = 255)
    private String est_nome;
    @Column(name="est_uf", nullable = false, length = 3)//RJ, MG, SP
    private String est_uf;
    
    @ManyToOne(optional = false)
    @ForeignKey(name = "Estado_Cidade")
    @JoinColumn(name="cid_id", referencedColumnName = "cid_id")
    private Cidade cidade;
    
    @OneToMany(mappedBy = "TB_PESSOA", fetch = FetchType.LAZY)
    @ForeignKey(name = "Pais_Estado")
    private List<Pais> paises;
    

    public Estado() {
    }

    public Integer getEst_id() {
        return est_id;
    }

    public void setEst_id(Integer est_id) {
        this.est_id = est_id;
    }

    public String getEst_nome() {
        return est_nome;
    }

    public void setEst_nome(String est_nome) {
        this.est_nome = est_nome;
    }

    public String getEst_uf() {
        return est_uf;
    }

    public void setEst_uf(String est_uf) {
        this.est_uf = est_uf;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public List<Pais> getPaises() {
        return paises;
    }

    public void setPaises(List<Pais> paises) {
        this.paises = paises;
    }
    
    
    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + (this.est_id != null ? this.est_id.hashCode() : 0);
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
        final Estado other = (Estado) obj;
        if (this.est_id != other.est_id && (this.est_id == null || !this.est_id.equals(other.est_id))) {
            return false;
        }
        return true;
    }

    
    
    
    
}