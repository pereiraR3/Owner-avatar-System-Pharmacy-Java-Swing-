
package main.dao;

//Importando o collection List
import java.util.List;

//Importando a classe produto
import main.produtos.Produto;

public interface IProdutoDAO {
    Produto searchForName(String Nome);
    List<Produto> searchAll();
    void add(Produto produto);
    void delete (Produto produto); 
    String allData(Produto produto, String type);
}
