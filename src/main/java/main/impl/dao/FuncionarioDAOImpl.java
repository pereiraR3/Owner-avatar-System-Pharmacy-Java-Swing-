
package main.impl.dao;

//Importando os collections List e ArrayList
import java.util.List;
import java.util.ArrayList;

//Importando o DAO relativo a funcionario, mais a própria classe
import main.dao.IFuncionarioDAO;
import main.serviços.Funcionario;

public class FuncionarioDAOImpl implements IFuncionarioDAO{
    
    private List<Funcionario> funcionarios;
    
    public FuncionarioDAOImpl(){
        this.funcionarios = new ArrayList<>();
    }
    
    @Override
    public Funcionario searchForName(String Nome){
        for(Funcionario funcionario : funcionarios){
            if(funcionario.getNome().equals(Nome)){
               return funcionario; 
            }
        }
        return null;
    }
    
    @Override
    public List<Funcionario> searchAll(){
        return funcionarios;
    }
    
    @Override 
    public void add(Funcionario funcionario){
        funcionarios.add(funcionario);
    }
    
    @Override 
    public void delete(Funcionario funcionarioInput){
        funcionarios.removeIf(funcionario -> funcionario.getNome() == funcionarioInput.getNome());
    }

}
