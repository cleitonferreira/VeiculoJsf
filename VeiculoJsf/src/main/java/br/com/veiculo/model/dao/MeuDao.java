/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.veiculo.model.dao;


import br.com.veiculo.model.entities.Cidade;
import br.com.veiculo.model.entities.Estado;
import br.com.veiculo.model.entities.Marca;
import br.com.veiculo.model.entities.Modelo;
import br.com.veiculo.model.entities.Pessoa;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author altitdb
 */
public interface MeuDao {
    
    public List<Estado> consultaTodosEstados();
    
    public List<Cidade> consultaCidades(Estado estado);
    
    public Cidade getByIdCidade(Integer id);
    
    public Estado getByIdEstado(Integer id);
    
    
    //Marca e Modelo
    public List<Marca> consultaTodasMarcas();
    
    public List<Modelo> consultaModelos(Marca marca);
    
    public Marca getByIdMarca(Integer id);
    
    public Modelo getByIdModelo(Integer id);
    
    
    //Consultas na hora do cadastro
    public Object consultaCpf(String cpf);
    
    public Object atualizaCpf(Integer cpf);
    
//    public Object consultaPlaca(String placa); 
    
    
    
    //AutoComplete
    public Pessoa getByIdPessoa(Integer id);
    
    public List<Pessoa> consultaTodosPessoas();
    
    
}
