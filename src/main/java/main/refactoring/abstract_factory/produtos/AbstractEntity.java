
package main.refactoring.abstract_factory.produtos;

import main.produtos.Produto;
import main.serviços.Farmaceutico;
import main.serviços.Fornecedor;
import main.serviços.Funcionario;
import main.serviços.Vendedor;

public interface AbstractEntity {
    
    Produto createProduto(String nome, double preco, String marca, int quantidade, String tipo, boolean receita, String tipo_tarja, 
        String formaAdministracao, String composicao_remedio, String data_validade, String data_fabricacao, String secao);
    
    Vendedor createVendedor(String cpf, String nome, String telefone, boolean certificado, String cargo, Double comissao, Double salario);
    
    Farmaceutico createFarmaceutico(String cpf, String nome, String telefone, boolean certificado, String cargo, Double comissao, Double salario);

    Fornecedor createFornecedor(String nome, String cpf, String telefone, String endereco, String portifolio);

}

