
package main.serviços;

public abstract class Funcionario {

    protected String Nome;
    protected String CPF;
    protected String telefone;
    protected boolean certificado;
    private String cargo;
    private double comissao;
    
    public Funcionario(String CPF, String Nome,  String telefone, boolean certificado, String cargo, Double comissao) {
        this.Nome = Nome;
        this.CPF = CPF;
        this.telefone = telefone;
        this.certificado = certificado;
        this.cargo = cargo;
        this.comissao = comissao;
    }

    public String getCargo() {
        return cargo;
    }


    public void setCargo(String cargo) {
        this.cargo = cargo;
    }


    public double getComissao() {
        return comissao;
    }

    public void setComissao(double comissao) {
        this.comissao = comissao;
    }
    
    public void setNome(String input) {
        this.Nome = input;
    }

    public String getNome() {
        return this.Nome;
    }

    public void setCPF(String input) {
        this.CPF = input;
    }

    public String getCPF() {
        return this.CPF;
    }

    public void setTipoFuncionario(String input) {
        this.telefone = input;
    }

    public String getTipoFuncionario() {
        return this.telefone;
    }

    public void setCertificado(boolean input) {
        this.certificado = input;
    }

    public boolean getCertificado() {
        return this.certificado;
    }


}
