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
 * @author cleiton
 */
@Entity
@Table(name = "empresa")
public class Empresa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "emp_id", nullable = false)
    private Integer emp_id;
    @Column(name = "emp_razaosocial", nullable = false, length = 80)
    private String emp_razaosocial;
    @Column(name = "emp_nomefantasia", nullable = false, length = 80)
    private String emp_nomefantasia;
    @Column(name = "emp_cnpj", unique = true, nullable = false, length = 18)
    private String emp_cnpj;
    @Column(name = "emp_inscestadual", nullable = false, length = 10)
    private String emp_inscestadual;
    @Column(name = "emp_endereco", nullable = false, length = 40)
    private String emp_endereco;
    @Column(name = "emp_bairro", nullable = false, length = 40)
    private String emp_bairro;
    @Column(name = "emp_tel", nullable = false, length = 14)//(34)-8888-8888
    private String emp_tel;
    @Column(name = "emp_obs", nullable = false, length = 500)
    private String emp_obs;

    
    
    
    @OneToMany(mappedBy = "empresa", fetch = FetchType.LAZY)
    @ForeignKey(name = "EmpresaControle")
    private List<Controle> controles;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @ForeignKey(name = "EstadoEmpresa")
    @JoinColumn(name = "est_id", referencedColumnName = "est_id")
    private Estado estado;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @ForeignKey(name = "CidadeEmpresa")
    @JoinColumn(name = "cid_id", referencedColumnName = "cid_id")
    private Cidade cidade;
    
    
    
    

    public Empresa() {
        this.estado = new Estado();
        this.cidade = new Cidade();
    }

    public Integer getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(Integer emp_id) {
        this.emp_id = emp_id;
    }

    public String getEmp_razaosocial() {
        return emp_razaosocial;
    }

    public void setEmp_razaosocial(String emp_razaosocial) {
        this.emp_razaosocial = emp_razaosocial;
    }

    public String getEmp_nomefantasia() {
        return emp_nomefantasia;
    }

    public void setEmp_nomefantasia(String emp_nomefantasia) {
        this.emp_nomefantasia = emp_nomefantasia;
    }

    public String getEmp_cnpj() {
        return emp_cnpj;
    }

    public void setEmp_cnpj(String emp_cnpj) {
        this.emp_cnpj = emp_cnpj;
    }

    public String getEmp_inscestadual() {
        return emp_inscestadual;
    }

    public void setEmp_inscestadual(String emp_inscestadual) {
        this.emp_inscestadual = emp_inscestadual;
    }

    public String getEmp_endereco() {
        return emp_endereco;
    }

    public void setEmp_endereco(String emp_endereco) {
        this.emp_endereco = emp_endereco;
    }

    public String getEmp_bairro() {
        return emp_bairro;
    }

    public void setEmp_bairro(String emp_bairro) {
        this.emp_bairro = emp_bairro;
    }

    public String getEmp_tel() {
        return emp_tel;
    }

    public void setEmp_tel(String emp_tel) {
        this.emp_tel = emp_tel;
    }

    public String getEmp_obs() {
        return emp_obs;
    }

    public void setEmp_obs(String emp_obs) {
        this.emp_obs = emp_obs;
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

    public List<Controle> getControles() {
        return controles;
    }

    public void setControles(List<Controle> controles) {
        this.controles = controles;
    }


    
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + (this.emp_id != null ? this.emp_id.hashCode() : 0);
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
        final Empresa other = (Empresa) obj;
        if (this.emp_id != other.emp_id && (this.emp_id == null || !this.emp_id.equals(other.emp_id))) {
            return false;
        }
        return true;
    }

}
