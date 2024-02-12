
package main.dao;

//Importando collection List
import java.util.List;

//Importando classe necessária para os métodos abstratos
import main.serviços.Fornecedor;

public interface IFornecedorDAO {
    Fornecedor searchForName(String Nome);
    List<Fornecedor> searchAll(); 
    void add(Fornecedor funcionario);
    void delete(Fornecedor funcionario);
}
