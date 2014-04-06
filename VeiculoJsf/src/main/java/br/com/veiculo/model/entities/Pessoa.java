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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

/**
 *
 * @author XPredator
 */
@Entity
@Table(name = "pessoa")
public class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "pes_id", nullable = false)
    private Integer pes_id;
    @Column(name = "pes_nome", nullable = false, length = 50)
    private String pes_nome;
    @Column(name = "pes_cpf", unique = true, nullable = false, length = 14)
    private String pes_cpf;
    @Column(name = "pes_rg", nullable = false, length = 12)
    private String pes_rg;
    @Column(name = "pes_tel", nullable = false, length = 14)//(34)-8888-8888
    private String pes_tel;
    @Column(name = "usu_cel", nullable = false, length = 15)
    private String pes_cel;

    //Relacionamento 1 / 1 com veiculo
    @OneToOne(mappedBy = "pessoa", fetch = FetchType.LAZY)
    @ForeignKey(name = "VeiculoPessoa")
    private Veiculo veiculo;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @ForeignKey(name = "EstadoPessoa")
    @JoinColumn(name = "est_id", referencedColumnName = "est_id")
    private Estado estado;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @ForeignKey(name = "CidadePessoa")
    @JoinColumn(name = "cid_id", referencedColumnName = "cid_id")
    private Cidade cidade;

    public Pessoa() {
        this.estado = new Estado();
        this.cidade = new Cidade();
    }

    public Integer getPes_id() {
        return pes_id;
    }

    public void setPes_id(Integer pes_id) {
        this.pes_id = pes_id;
    }

    public String getPes_nome() {
        return pes_nome;
    }

    public void setPes_nome(String pes_nome) {
        this.pes_nome = pes_nome;
    }

    public String getPes_cpf() {
        return pes_cpf;
    }

    public void setPes_cpf(String pes_cpf) {
        this.pes_cpf = pes_cpf;
    }

    public String getPes_rg() {
        return pes_rg;
    }

    public void setPes_rg(String pes_rg) {
        this.pes_rg = pes_rg;
    }

    public String getPes_tel() {
        return pes_tel;
    }

    public void setPes_tel(String pes_tel) {
        this.pes_tel = pes_tel;
    }

    public String getPes_cel() {
        return pes_cel;
    }

    public void setPes_cel(String pes_cel) {
        this.pes_cel = pes_cel;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    
 


    
    
    
    
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + (this.pes_id != null ? this.pes_id.hashCode() : 0);
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
        final Pessoa other = (Pessoa) obj;
        if (this.pes_id != other.pes_id && (this.pes_id == null || !this.pes_id.equals(other.pes_id))) {
            return false;
        }
        return true;
    }

}
