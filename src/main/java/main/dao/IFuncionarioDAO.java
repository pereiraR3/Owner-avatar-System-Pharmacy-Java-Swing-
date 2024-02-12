
package main.dao;

//Importando a classe Funcionario, na qual vamos precisar para criar as estruturas de dados do DAO
import main.serviços.Funcionario;
        
//Importando os collectios necessários para se construir os modelos de métodos abstratos
import java.util.ArrayList;
import java.util.List;

public interface IFuncionarioDAO {
    Funcionario searchForName(String Nome);
    List<Funcionario> searchAll(); 
    void add(Funcionario funcionario);
    void delete(Funcionario funcionario);
}
