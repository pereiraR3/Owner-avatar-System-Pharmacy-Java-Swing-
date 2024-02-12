package main.impl.dao;

//Importando os collections List e ArrayList
import java.util.ArrayList;
import java.util.List;

//Importando classe DAO de fornecedor, mais a própria classe
import main.dao.IFornecedorDAO;
import main.serviços.Fornecedor;

public class FornecedorDAOImpl implements IFornecedorDAO{
    
    private List<Fornecedor> fornecedores;
    
    public FornecedorDAOImpl(){
        this.fornecedores = new ArrayList<>();
    }
    
    @Override
    public Fornecedor searchForName(String Nome){
        for(Fornecedor fornecedor : fornecedores){
            if(fornecedor.getNome().equals(Nome)){
               return fornecedor; 
            }
        }
        return null;
    }
    
    @Override
    public List<Fornecedor> searchAll(){
        return fornecedores;
    }
    
    @Override 
    public void add(Fornecedor fornecedor){
        fornecedores.add(fornecedor);
    }
    
    @Override 
    public void delete(Fornecedor funcionarioInput){
        fornecedores.removeIf(funcionario -> funcionario.getNome() == funcionarioInput.getNome());
    }
    
}
