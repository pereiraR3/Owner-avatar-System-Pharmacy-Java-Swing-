
package main.refactoring.abstract_factory.produtos;

import main.produtos.Produto;
import main.serviços.Farmaceutico;
import main.serviços.Fornecedor;
import main.serviços.Vendedor;

public class ConcreteEntity implements AbstractEntity {
    
    private String type; //Nao sei se vai ser preciso manter...
    
    @Override
    public Produto createProduto(String nome, double preco, String marca, int quantidade, String tipo, boolean receita, String tipo_tarja, 
        String formaAdministracao, String composicao_remedio, String data_validade, String data_fabricacao, String secao){
        Produto produto = new Produto(nome, preco, marca, quantidade, tipo, receita, tipo_tarja, formaAdministracao, composicao_remedio, data_validade, data_fabricacao, secao);
        return produto;
    }
    
    @Override 
    public Vendedor createVendedor(String cpf, String nome, String telefone, boolean certificado, String cargo, Double comissao, Double salario){
        Vendedor vendedor = new Vendedor(cpf, nome, telefone, certificado, cargo, comissao, salario);
        return vendedor;
    }
    
    @Override
    public Farmaceutico createFarmaceutico(String cpf, String nome, String telefone, boolean certificado, String cargo, Double comissao, Double salario){
        Farmaceutico farmaceutico = new Farmaceutico(cpf, nome, telefone, certificado, cargo, comissao, salario);
        return farmaceutico;
    }
    
    
    @Override
    public Fornecedor createFornecedor(String nome, String cpf, String telefone, String endereco, String portifolio){
        Fornecedor fornecedor = new Fornecedor(nome, cpf, telefone, endereco, portifolio);
        return fornecedor;
    }
}

