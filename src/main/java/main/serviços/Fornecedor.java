package main.serviços;

public class Fornecedor {

    private String nome;
    private String cpf;
    private String telefone;
    private String endereco;
    private String portifolio;
    
    public Fornecedor(String nome, String cpf, String telefone, String endereco, String portifolio){
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.endereco = endereco;
        this.portifolio = portifolio;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getPortifolio() {
        return portifolio;
    }

    public void setPortifolio(String portifolio) {
        this.portifolio = portifolio;
    }
    
}
