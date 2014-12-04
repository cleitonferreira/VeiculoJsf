/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.veiculo.model.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.hibernate.annotations.ForeignKey;

/**
 *
 * @author cleiton
 */
@Entity
@Table(name = "controle")
public class Controle implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "contr_id", nullable = false)
    private Integer contr_id;
    @Column(name = "contr_motorista", nullable = false, length = 80)
    private String contr_motorista;
    @Column(name = "contr_placa", nullable = false, length = 8) //AAA-0000
    private String contr_placa;
    @Column(name = "contr_entrada", nullable = false)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date contr_entrada;
    @Column(name = "contr_saida", nullable = false)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date contr_saida;
    @Column(name = "contr_obs", nullable = false, length = 500)
    private String contr_obs;

    //Relacionamentos
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @ForeignKey(name = "EmpresaControle")
    @JoinColumn(name = "emp_id", referencedColumnName = "emp_id")
    private Empresa empresa;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @ForeignKey(name = "SetorControle")
    @JoinColumn(name = "set_id", referencedColumnName = "set_id")
    private Setor setor;

    public Controle() {
        this.empresa = new Empresa();
        this.setor = new Setor();
    }

    public Integer getContr_id() {
        return contr_id;
    }

    public void setContr_id(Integer contr_id) {
        this.contr_id = contr_id;
    }

    public String getContr_motorista() {
        return contr_motorista;
    }

    public void setContr_motorista(String contr_motorista) {
        this.contr_motorista = contr_motorista;
    }

    public String getContr_placa() {
        return contr_placa;
    }

    public void setContr_placa(String contr_placa) {
        this.contr_placa = contr_placa;
    }

    public Date getContr_entrada() {
        return contr_entrada;
    }

    public void setContr_entrada(Date contr_entrada) {
        this.contr_entrada = contr_entrada;
    }

    public Date getContr_saida() {
        return contr_saida;
    }

    public void setContr_saida(Date contr_saida) {
        this.contr_saida = contr_saida;
    }

    public String getContr_obs() {
        return contr_obs;
    }

    public void setContr_obs(String contr_obs) {
        this.contr_obs = contr_obs;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }



    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + (this.contr_id != null ? this.contr_id.hashCode() : 0);
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
        final Controle other = (Controle) obj;
        if (this.contr_id != other.contr_id && (this.contr_id == null || !this.contr_id.equals(other.contr_id))) {
            return false;
        }
        return true;
    }

}
