/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.produtos;

/**
 *
 * @author anthony3r
 */
public class Produto {

    
    private String Nome;
    private double Preco;
    private String Marca;
    private int quantidade;
    private String Tipo;
    private boolean receita;
    private String tipoTarja;
    private String formaAdministracao;
    private String composicao_remedio;
    private String dataValidade;
    private String dataFabricacao;
    private String secao;

    public Produto(String nome, double preco, String marca, int quantidade, String tipo, boolean receita, String tipo_tarja, 
        String formaAdministracao, String composicao_remedio, String data_validade, String data_fabricacao, String secao){
        this.Nome = nome;
        this.Preco = preco;
        this.Marca = marca;
        this.quantidade = quantidade;
        this.Tipo = tipo;
        this.receita = receita;
        this.tipoTarja = tipo_tarja;
        this.formaAdministracao = formaAdministracao;
        this.composicao_remedio = composicao_remedio;
        this.dataValidade = data_validade;
        this.dataFabricacao = data_fabricacao;
        this.secao = secao;
    }
    
    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    public String getSecao() {
        return secao;
    }

    public void setSecao(String secao) {
        this.secao = secao;
    }
    
    public String getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(String dataValidade) {
        this.dataValidade = dataValidade;
    }
    
    public String getComposicao_remedio() {
        return composicao_remedio;
    }

    public void setComposicao_remedio(String composicao_remedio) {
        this.composicao_remedio = composicao_remedio;
    }
    
    public String getDataFabricacao() {
        return dataFabricacao;
    }

    public void setDataFabricacao(String dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }
    
    public String getFormaAdministracao() {
        return formaAdministracao;
    }

    public void setFormaAdministracao(String formaAdministracao) {
        this.formaAdministracao = formaAdministracao;
    }    
    
    public String getTipo_tarja() {
        return tipoTarja;
    }

    public void setTipo_tarja(String tipoTarja) {
        this.tipoTarja = tipoTarja;
    }
    
    public String getNome() {
        return this.Nome;
    }

    public double getPreco() {
        return this.Preco;
    }

    public String getTipo() {
        return this.Tipo;
    }

    public String getMarca() {
        return this.Marca;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }
    
    public boolean getReceita() {
        return receita;
    }

    public void setReceita(boolean receita) {
        this.receita = receita;
    }

    public void setPreco(double Preco) {
        this.Preco = Preco;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }
}
