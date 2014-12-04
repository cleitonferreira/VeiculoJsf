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
 * @author XPredator
 */
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "usu_id", nullable = false)
    private Integer usu_id;
    @Column(name = "usu_nome", nullable = false, length = 80)
    private String usu_nome;
    @Column(name = "usu_email", unique = true, nullable = false, length = 50)
    private String usu_email;
    @Column(name = "usu_senha", length = 40)
    private String usu_senha;
    @Column(name = "usu_permisao", length = 20)
    private String usu_permissao;
    @Column(name = "usu_tel", nullable = false, length = 14)//(34)-8888-8888
    private String usu_tel;
    @Column(name = "usu_cel", nullable = false, length = 15)
    private String usu_cel;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @ForeignKey(name = "SetorUsuario")
    @JoinColumn(name = "set_id", referencedColumnName = "set_id")
    private Setor setor;

    public Usuario() {
        this.setor = new Setor();
    }

    public Integer getUsu_id() {
        return usu_id;
    }

    public void setUsu_id(Integer usu_id) {
        this.usu_id = usu_id;
    }

    public String getUsu_nome() {
        return usu_nome;
    }

    public void setUsu_nome(String usu_nome) {
        this.usu_nome = usu_nome;
    }

    public String getUsu_email() {
        return usu_email;
    }

    public void setUsu_email(String usu_email) {
        this.usu_email = usu_email;
    }

    public String getUsu_senha() {
        return usu_senha;
    }

    public void setUsu_senha(String usu_senha) {
        this.usu_senha = usu_senha;
    }

    public String getUsu_tel() {
        return usu_tel;
    }

    public void setUsu_tel(String usu_tel) {
        this.usu_tel = usu_tel;
    }

    public String getUsu_cel() {
        return usu_cel;
    }

    public void setUsu_cel(String usu_cel) {
        this.usu_cel = usu_cel;
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    public String getUsu_permissao() {
        return usu_permissao;
    }

    public void setUsu_permissao(String usu_permissao) {
        this.usu_permissao = usu_permissao;
    }

    
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + (this.usu_id != null ? this.usu_id.hashCode() : 0);
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
        final Usuario other = (Usuario) obj;
        if (this.usu_id != other.usu_id && (this.usu_id == null || !this.usu_id.equals(other.usu_id))) {
            return false;
        }
        return true;
    }
    
    



}
