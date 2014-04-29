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
@Table(name = "veiculo")
public class Veiculo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "veic_id", nullable = false)
    private Integer veic_id;
    @Column(name = "veic_ano", nullable = false, length = 10)
    private String veic_ano;
    @Column(name = "veic_placa", nullable = false, length = 10)
    private String veic_placa;
    @Column(name = "veic_cor", nullable = false, length = 15)
    private String veic_cor;

    //Relacionamento 1 / 1
    @OneToOne(optional = true, fetch = FetchType.LAZY)
    @ForeignKey(name = "VeiculoPessoa")
    @JoinColumn(name = "pes_id", referencedColumnName = "pes_id")
    private Pessoa pessoa;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @ForeignKey(name = "VeiculoMarca")
    @JoinColumn(name = "mar_id", referencedColumnName = "mar_id")
    private Marca marca;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @ForeignKey(name = "VeiculoModelo")
    @JoinColumn(name = "mod_id", referencedColumnName = "mod_id")
    private Modelo modelo;

    public Veiculo() {
        this.pessoa = new Pessoa();
        this.marca = new Marca();
        this.modelo = new Modelo();
    }

    public Integer getVeic_id() {
        return veic_id;
    }

    public void setVeic_id(Integer veic_id) {
        this.veic_id = veic_id;
    }

    public String getVeic_ano() {
        return veic_ano;
    }

    public void setVeic_ano(String veic_ano) {
        this.veic_ano = veic_ano;
    }



    public String getVeic_placa() {
        return veic_placa;
    }

    public void setVeic_placa(String veic_placa) {
        this.veic_placa = veic_placa;
    }

    public String getVeic_cor() {
        return veic_cor;
    }

    public void setVeic_cor(String veic_cor) {
        this.veic_cor = veic_cor;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    

    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 73 * hash + (this.veic_id != null ? this.veic_id.hashCode() : 0);
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
        final Veiculo other = (Veiculo) obj;
        if (this.veic_id != other.veic_id && (this.veic_id == null || !this.veic_id.equals(other.veic_id))) {
            return false;
        }
        return true;
    }

}
