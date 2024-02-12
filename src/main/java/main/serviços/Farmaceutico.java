
package main.serviços;
public class Farmaceutico extends Funcionario {

    private double salario = 0;

    public Farmaceutico(String cpf, String nome, String telefone, boolean certificado, String cargo, Double comissao, Double salario) {
        super(cpf, nome, telefone, certificado, cargo, comissao);
    }

    public void setSalario(double input) {
        this.salario += input;
    }

    public double getSalario() {
        return this.salario;
    }

}
