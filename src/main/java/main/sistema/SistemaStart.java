
package main.sistema;

//Importando pacotes relacionados a conexao com dados e tratamento de erros
import java.awt.Window;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;

//Importando uma biblioteca de interfaces gráficas prontas
import javax.swing.JOptionPane;
import main.impl.dao.ConnectionDAOImpl;
import main.impl.dao.FornecedorDAOImpl;
import main.impl.dao.FuncionarioDAOImpl;
import main.impl.dao.ProdutoDAOImpl;

//Importando todas as screens do projeto
import screens.MenuPrincipal;
import screens.MenuCadastro;
import screens.MenuConsultar;

//Importando biblioteca necessaria para chamar as telas
import main.singlenton.getConnection;
import main.singlenton.utilsSwing;
import screens.ApagarDado;
import screens.CadastroFornecedor;
import screens.CadastroFuncionario;
import screens.CadastroProduto;
import screens.CadastroRemedio;
import screens.Consultando;
import screens.MenuApagar;
import screens.Sobre;

public class SistemaStart {
  
    //Funcao para retornar ao Menu Cadastrar
    public static <T extends Window> void addWindowListenerReturnCadastrar(T window, utilsSwing utils, ConnectionDAOImpl connectionOp, FuncionarioDAOImpl funcionarioOp, ProdutoDAOImpl produtoOp, FornecedorDAOImpl fornecedorOp, getConnection connect) {
        window.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                // A janela foi fechada
                
                MenuCadastrar(utils, connectionOp, funcionarioOp, produtoOp, fornecedorOp, connect);
            }
        });
    }
    
    //Funcao para retornar ao Menu MenuConsultar
    public static <T extends Window> void addWindowListenerReturnConsultar(T window, utilsSwing utils, ConnectionDAOImpl connectionOp, FuncionarioDAOImpl funcionarioOp, ProdutoDAOImpl produtoOp, FornecedorDAOImpl fornecedorOp, getConnection connect) {
        window.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                // A janela foi fechada
                
                MenuConsultar(utils, connectionOp, funcionarioOp, produtoOp, fornecedorOp, connect);
            }
        });
    }
    
    //Funcao para retornar ao Menu Apagar
    public static <T extends Window> void addWindowListenerReturnApagar(T window, utilsSwing utils, ConnectionDAOImpl connectionOp, FuncionarioDAOImpl funcionarioOp, ProdutoDAOImpl produtoOp, FornecedorDAOImpl fornecedorOp, getConnection connect) {
        window.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                //A janela foi fechada
                
                MenuApagar(utils, connectionOp, funcionarioOp, produtoOp, fornecedorOp, connect);
            }
        });
    }    
    
    //Funcao para retornar ao Menu Principal
    public static void addWindowListenerReturnMenuPrincipal(utilsSwing utils, ConnectionDAOImpl connectionOp, FuncionarioDAOImpl funcionarioOp, ProdutoDAOImpl produtoOp, FornecedorDAOImpl fornecedorOp, getConnection connect) {
     
        MenuPrincipal telaPrincipal = new MenuPrincipal();
        telaPrincipal.setVisible(true);

        telaPrincipal.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                
                // A janela foi fechada
                String chooseScreen = telaPrincipal.getChangeWindow();

                // Escolhendo a tela que será criada de acordo com a mudanca de janela que aconteceu na tela do Menu Principal
                if (chooseScreen.equals("Cadastrar")) {
                    MenuCadastrar(utils, connectionOp, funcionarioOp, produtoOp, fornecedorOp, connect);
                } else if (chooseScreen.equals("Consultar")){
                    MenuConsultar(utils, connectionOp, funcionarioOp, produtoOp, fornecedorOp, connect);
                } else if (chooseScreen.equals("Apagar")){
                   MenuApagar(utils, connectionOp, funcionarioOp, produtoOp, fornecedorOp, connect);
                } else if(chooseScreen.equals("Sobre")){
                    TelaSobre(utils, connectionOp, funcionarioOp, produtoOp, fornecedorOp, connect);
                }
            }
        });               
                
    }      
    
    public static void TelaSobre(utilsSwing utils, ConnectionDAOImpl connectionOp, FuncionarioDAOImpl funcionarioOp, ProdutoDAOImpl produtoOp, FornecedorDAOImpl fornecedorOp, getConnection connect){
        //Criando a tela Menu Cadastro e deixando visível
        Sobre telaSobre = new Sobre();
        telaSobre.setVisible(true);
        
        telaSobre.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
               // A janela foi fechada
               addWindowListenerReturnMenuPrincipal(utils, connectionOp, funcionarioOp, produtoOp, fornecedorOp, connect);
            }
        });
    }
    
    //Funcao para Iniciar o processo de cadastro
    public static void MenuCadastrar(utilsSwing utils, ConnectionDAOImpl connectionOp, FuncionarioDAOImpl funcionarioOp, ProdutoDAOImpl produtoOp, FornecedorDAOImpl fornecedorOp, getConnection connect){
        
        //Criando a tela Menu Cadastro e deixando visível
        MenuCadastro telaCadastro = new MenuCadastro();
        telaCadastro.setVisible(true);
        
        telaCadastro.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                // A janela foi fechada
                
                if(telaCadastro.getRetornar()){
                    addWindowListenerReturnMenuPrincipal(utils, connectionOp, funcionarioOp, produtoOp, fornecedorOp, connect);
                }else{  

                    String chooseScreen = telaCadastro.getChangeWindow();
                    
                    // Escolhendo a tela que será criada de acordo com a mudanca de janela que aconteceu na tela do Menu Principal
                    if (chooseScreen.equals("Cadastrar Remédios")){
                        CadastroRemedio telaCadRemedio = new CadastroRemedio(utils, connectionOp, produtoOp);
                        telaCadRemedio.setVisible(true);

                        //Chamando a funcao para retornar ao Menu Cadastrar
                        addWindowListenerReturnCadastrar(telaCadRemedio, utils, connectionOp, funcionarioOp, produtoOp, fornecedorOp, connect);

                    } else if (chooseScreen.equals("Cadastrar Funcionários")){

                        CadastroFuncionario telaCadFuncionario = new CadastroFuncionario(utils, connectionOp, funcionarioOp);
                        telaCadFuncionario.setVisible(true);
                        
                        //Chamando a funcao para retornar ao Menu Cadastrar
                        addWindowListenerReturnCadastrar(telaCadFuncionario, utils, connectionOp, funcionarioOp, produtoOp, fornecedorOp, connect);

                    } else if (chooseScreen.equals("Cadastrar Fornecedor")){

                        CadastroFornecedor telaCadFornecedor = new CadastroFornecedor(utils, connectionOp, fornecedorOp);
                        telaCadFornecedor.setVisible(true);
                        
                        //Chamando a funcao para retornar ao Menu Cadastrar
                        addWindowListenerReturnCadastrar(telaCadFornecedor, utils, connectionOp, funcionarioOp, produtoOp, fornecedorOp, connect);

                    } else if (chooseScreen.equals("Cadastrar Produto")){

                        CadastroProduto telaCadProduto = new CadastroProduto(utils, connectionOp, produtoOp);
                        telaCadProduto.setVisible(true);

                        //Chamando a funcao para retornar ao Menu Cadastrar
                        addWindowListenerReturnCadastrar(telaCadProduto, utils, connectionOp, funcionarioOp, produtoOp, fornecedorOp, connect);
                    }
                }
            }
        });
    }
    
    public static void MenuConsultar(utilsSwing utils, ConnectionDAOImpl connectionOp, FuncionarioDAOImpl funcionarioOp, ProdutoDAOImpl produtoOp, FornecedorDAOImpl fornecedorOp, getConnection connect){
        
        //Instanciando e deixando visível a tela
        MenuConsultar telaConsultar = new MenuConsultar();
        telaConsultar.setVisible(true);
       
        
        telaConsultar.addWindowListener(new WindowAdapter() {
            
            @Override
            public void windowClosed(WindowEvent e) {
                if(telaConsultar.getRetornar()){
                    addWindowListenerReturnMenuPrincipal(utils, connectionOp, funcionarioOp, produtoOp, fornecedorOp, connect);
                }else{      
                    
                    // A janela foi fechada; agora você pode acessar getChangeWindow
                    String chooseScreen = telaConsultar.getChangeWindow();
                    
                    // Escolhendo a tela que será criada de acordo com a mudanca de janela que aconteceu na tela do Menu Principal
                    // No caso, aqui essa escolha será feita dentro da tela Consultando
                    Consultando telaConsultando = new Consultando(chooseScreen, connectionOp, connect);
                    
                    //Fazendo a tela ficar visível 
                    telaConsultando.setVisible(true);
                    
                    //Chamando a funcao para retornar ao Menu Consultar 
                    addWindowListenerReturnConsultar(telaConsultando,  utils, connectionOp, funcionarioOp, produtoOp, fornecedorOp, connect);
                }
            }
        });
    }
    
    public static void MenuApagar(utilsSwing utils, ConnectionDAOImpl connectionOp, FuncionarioDAOImpl funcionarioOp, ProdutoDAOImpl produtoOp, FornecedorDAOImpl fornecedorOp, getConnection connect){
        
        //Criando e tornando visível a tela Menu Apagar
        MenuApagar telaApagar = new MenuApagar();
        telaApagar.setVisible(true);
        
        telaApagar.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                // A janela foi fechada
                if(telaApagar.getRetornar()){
                    addWindowListenerReturnMenuPrincipal(utils, connectionOp, funcionarioOp, produtoOp, fornecedorOp, connect);
                }else{ 

                    String chooseScreen = telaApagar.getChangeWindow();
                    ApagarDado telaApagarDado = new ApagarDado(chooseScreen, connectionOp, connect, funcionarioOp, produtoOp, fornecedorOp);

                    //Fazendo a tela ficar visível
                    telaApagarDado.setVisible(true);

                    //Chamando a funcao para retornar ao Menu Apagar 
                    addWindowListenerReturnApagar(telaApagarDado, utils, connectionOp, funcionarioOp, produtoOp, fornecedorOp,  connect);
                }
            }
        });
    }
    
    public static void main(String[] args){
        
        //Dados de acesso ao Banco de Dados
        String username = "root";
        String password = "#Xswcde122123";
        String database = "pharmacy";
          
        //instanciando getConnection
        getConnection connect = new getConnection(username, password, database);
        
        //Instanciando a singleton utilsSwing
        utilsSwing utils = new utilsSwing(connect);
        
        //Instanciando classes DAOimpl
        ConnectionDAOImpl connectionOp = new ConnectionDAOImpl();
        FuncionarioDAOImpl funcionarioOp = new FuncionarioDAOImpl();
        ProdutoDAOImpl produtoOp = new ProdutoDAOImpl();
        FornecedorDAOImpl fornecedorOp = new FornecedorDAOImpl();
        
        //Iniciando o sistema, pelo Menu Principal
        addWindowListenerReturnMenuPrincipal(utils, connectionOp, funcionarioOp, produtoOp, fornecedorOp, connect);

    }
}
