/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.veiculo.model.dao;



import br.com.veiculo.model.entities.Marca;
import br.com.veiculo.model.entities.Modelo;
import java.util.List;

/**
 *
 * @author XPredator
 */
public interface MeuDaoMarcaModelo {
    
    public List<Marca> consultaTodasMarcas();
    
    public List<Modelo> consultaModelos(Marca marca);
    
    public Marca getByIdMarca(Integer id);
    
    public Modelo getByIdModelo(Integer id);
    
}
