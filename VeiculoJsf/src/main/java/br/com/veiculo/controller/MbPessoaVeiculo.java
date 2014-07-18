/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.veiculo.controller;

import br.com.veiculo.model.dao.HibernateDAO;
import br.com.veiculo.model.dao.InterfaceDAO;
import br.com.veiculo.model.dao.MeuDaoImpl;
import br.com.veiculo.model.entities.Cidade;
import br.com.veiculo.model.entities.Estado;
import br.com.veiculo.model.entities.Marca;
import br.com.veiculo.model.entities.Modelo;
import br.com.veiculo.model.entities.Pessoa;
import br.com.veiculo.model.entities.Veiculo;
import br.com.veiculo.util.FacesContextUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import org.primefaces.event.FlowEvent;

/**
 *
 * @author cleiton
 */
@ManagedBean(name = "mbPessoaVeiculo")
@ViewScoped
public class MbPessoaVeiculo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Pessoa pessoa = new Pessoa();
    private Veiculo veiculo = new Veiculo();
    private List<Pessoa> pessoas;
    private List<Veiculo> veiculos;
    private List<Veiculo> filteredVeiculos;
    private List<Veiculo> consultaVeiculos;

    ///// Objetos para os ComBos Estado Cidade \\\\\
    private final MeuDaoImpl dao = new MeuDaoImpl();
    private List<Estado> estados;
    private List<Cidade> cidades;
    private Cidade cidade;
    private Estado estado;
    //////////////////////////////////

    ///// Objetos para os ComBos Marcas e Modelos \\\\\
//    private final MeuDaoImpl mmdao = new MeuDaoImpl();
    private List<Marca> marcas;
    private List<Modelo> modelos;
    private Marca marca;
    private Modelo modelo;
    //////////////////////////////////

    public MbPessoaVeiculo() {
    }

    @PostConstruct
    public void init() {
        marcas = dao.consultaTodasMarcas();
        estados = dao.consultaTodosEstados();
    }

    public void listaCidades(AjaxBehaviorEvent event) {
        cidades = dao.consultaCidades(estado);
    }

    public void listaModelos(AjaxBehaviorEvent event) {
        modelos = dao.consultaModelos(marca);
    }

    private InterfaceDAO<Pessoa> pessoaDAO() {
        InterfaceDAO<Pessoa> pessoaDAO = new HibernateDAO<Pessoa>(Pessoa.class, FacesContextUtil.getRequestSession());
        return pessoaDAO;
    }

    private InterfaceDAO<Veiculo> veiculoDAO() {
        InterfaceDAO<Veiculo> veiculoDAO = new HibernateDAO<Veiculo>(Veiculo.class, FacesContextUtil.getRequestSession());
        return veiculoDAO;
    }

    //metodo Primefaces 5.0
    public String onFlowProcess(FlowEvent event) {
        return event.getNewStep();
    }

    public String limpPessoa() {
        pessoa = new Pessoa();
        estado = new Estado();
        cidade = new Cidade();
        veiculo = new Veiculo();
        marca = new Marca();
        modelo = new Modelo();
        return editPessoa();
    }

    public String editPessoa() {
        return "/restrict/cadastros/cadastrarpessoaveiculo.faces";
    }

    public String addPessoa() {
        
        Date date = new Date();
        
        // verifica a id veio igual a null ou id igual a 0
        if (pessoa.getPes_id() == null || pessoa.getPes_id() == 0) {
            pessoa.setPes_datacad(date);
            veiculo.setVeic_datacad(date);
            insertPessoa();
        } else {
            //updatePessoa();
            limpPessoa();
        }
        limpPessoa();
        return null;
    }

    private void insertPessoa() {

        //Verifica se o cpf foi alterado
        String cpf = pessoa.getPes_cpf();
        ArrayList results = (ArrayList) dao.consultaCpf(cpf);
        System.out.println("Resultsss>>>>" + results.toString());

        if (results.toString().equals("[1]")) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro ao C[adastrar], no Banco de Dados!!!", ""));
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Cpf já se encontra cadastrado no sistema", "" + cpf));
        } else {

            //Verfica se a placa do veiculo foi alterado
            String placa = veiculo.getVeic_placa();
            ArrayList resultado = (ArrayList) dao.consultaPlaca(placa);
            System.out.println("Resultado>>>>" + resultado.toString());

            if (resultado.toString().equals("[1]")) {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro ao [Cadastrar], no Banco de Dados!!!", ""));
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_WARN, "A placa do veículo se encontra, cadastrado no sistema", "" + placa));
            } else {

                try {

                    pessoa.setEstado(estado);
                    pessoa.setCidade(cidade);
                    pessoaDAO().save(pessoa);

                    veiculo.setPessoa(pessoa);
                    veiculo.setMarca(marca);
                    veiculo.setModelo(modelo);
                    veiculoDAO().save(veiculo);

                    FacesContext.getCurrentInstance().addMessage(null,
                            new FacesMessage(FacesMessage.SEVERITY_INFO, "Gravação efetuada com sucesso", ""));
                    //Limpar os campos
                    limpPessoa();
                } catch (Exception ex) {
                    FacesContext.getCurrentInstance().addMessage(null,
                            new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro ao [Cadastrar],  no Banco de Dados", "" + ex));
                    FacesContext.getCurrentInstance().addMessage(null,
                            new FacesMessage(FacesMessage.SEVERITY_WARN, "Entre em contato com o Administrador", "" + ex));
                }

            } //fim else placa veiculo

        } //fim do else cpf pessoa

    }
    /*
     private void updatePessoa() {
     //Verfica Cpf da pessoa foi alterada
     String cpf = pessoa.getPes_cpf();
     ArrayList results = (ArrayList) dao.consultaCpf(cpf);
     System.out.println("Resultsss>>>>" + results.toString());

     if (results.toString().equals("[1]")) {

     //Verfica Placa do veiculo foi alterada
     String placa = veiculo.getVeic_placa();
     ArrayList resultado = (ArrayList) dao.consultaPlaca(placa);
     System.out.println("Resultado>>>>" + resultado.toString());

     if (resultado.toString().equals("[1]")) {
     try {
     pessoa.setEstado(estado);
     pessoa.setCidade(cidade);
     pessoaDAO().update(pessoa);

     veiculo.setPessoa(pessoa);
     veiculo.setMarca(marca);
     veiculo.setModelo(modelo);
     veiculoDAO().update(veiculo);
     FacesContext.getCurrentInstance().addMessage(null,
     new FacesMessage(FacesMessage.SEVERITY_INFO, "Atualização efetuada com sucesso", ""));
     } catch (Exception ex) {
     FacesContext.getCurrentInstance().addMessage(null,
     new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro ao [Atualizar], no Banco de Dados", "" + ex));
     FacesContext.getCurrentInstance().addMessage(null,
     new FacesMessage(FacesMessage.SEVERITY_WARN, "Entre em contato com o Administrador", "" + ex));
     }
     } else { //else Placa veiculo
     FacesContext.getCurrentInstance().addMessage(null,
     new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro ao [Atualizar], no Banco de Dados!!!", ""));
     FacesContext.getCurrentInstance().addMessage(null,
     new FacesMessage(FacesMessage.SEVERITY_WARN, "Por Favor, não altere a placa do veículo", "" + placa));
     } //fim do else Placa veiculo

     } else { //else Cpf pessoa

     FacesContext.getCurrentInstance().addMessage(null,
     new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro ao [Atualizar], no Banco de Dados!!!", ""));
     FacesContext.getCurrentInstance().addMessage(null,
     new FacesMessage(FacesMessage.SEVERITY_WARN, "Cpf já se encontra cadastrado no sistema", "" + cpf));
     } //fim do else Cpf
     }
     */

//    public void deletePessoa() {
//        try {
//            pessoaDAO().remove(pessoa);
//            veiculoDAO().remove(veiculo);
//            FacesContext.getCurrentInstance().addMessage(null,
//                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro excluído com sucesso", ""));
//        } catch (Exception ex) {
//            FacesContext.getCurrentInstance().addMessage(null,
//                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro ao [Excluir], no Banco de Dados", "" + ex));
//            FacesContext.getCurrentInstance().addMessage(null,
//                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Entre em contato com o Administrador", "" + ex));
//        }
//
//    }
    //tomar cuidado com esses dois get aqui
    //realizar as modificações.
    public List<Pessoa> getPessoas() {
        pessoas = pessoaDAO().getEntities();
        return pessoas;
    }

    public List<Veiculo> getVeiculos() {
        veiculos = veiculoDAO().getEntities();
        return veiculos;
    }

    ////////////////////////////////////////////
    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public List<Estado> getEstados() {
        return estados;
    }

    public void setEstados(List<Estado> estados) {
        this.estados = estados;
    }

    public List<Cidade> getCidades() {
        return cidades;
    }

    public void setCidades(List<Cidade> cidades) {
        this.cidades = cidades;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public void setVeiculos(List<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }

    public List<Marca> getMarcas() {
        return marcas;
    }

    public void setMarcas(List<Marca> marcas) {
        this.marcas = marcas;
    }

    public List<Modelo> getModelos() {
        return modelos;
    }

    public void setModelos(List<Modelo> modelos) {
        this.modelos = modelos;
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

    public List<Veiculo> getFilteredVeiculos() {
        return filteredVeiculos;
    }

    public void setFilteredPessoas(List<Veiculo> filteredVeiculos) {
        this.filteredVeiculos = filteredVeiculos;
    }

    public List<Veiculo> getConsultaVeiculos() {
        return consultaVeiculos;
    }

    public void setConsultaVeiculos(List<Veiculo> consultaVeiculos) {
        this.consultaVeiculos = consultaVeiculos;
    }
    
    

}
