
package main.impl.dao;

//Importando a interface para trabalhar com DAO
import main.dao.IProdutoDAO;

//Importando a classe produto para construir as estruturas que vamos precisar 
import main.produtos.Produto;

//Importando o collections que vamos necessitar
import java.util.List;
import java.util.ArrayList;

public class ProdutoDAOImpl implements IProdutoDAO {
    
    private List<Produto> produtos;
    
    public ProdutoDAOImpl(){
        this.produtos = new ArrayList<>();
    }
    
    @Override
    public Produto searchForName(String Nome){
        for (Produto produto : produtos){
            if(produto.getNome().equals(Nome)){
                return produto;
            }
        }
        return null;
    }
    
    @Override 
    public List<Produto> searchAll(){
        return produtos;
    }
    
    @Override
    public void add(Produto produto){
        produtos.add(produto);
    }
    
    @Override
    public void delete(Produto produtoInput){
        produtos.removeIf(produto -> produto.getNome() == produtoInput.getNome());
    }
    
    @Override 
    public String allData(Produto produtoInput, String type){
        String result = "";
        if(type.equals("Remedio")){
            
        }else if(type.equals( "Nremedio")){
            
        }
        
        return result;
        
    }
}
