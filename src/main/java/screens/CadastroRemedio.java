/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package screens;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;

import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import main.impl.dao.ConnectionDAOImpl;
import main.impl.dao.FuncionarioDAOImpl;
import main.impl.dao.ProdutoDAOImpl;
import main.produtos.Produto;
import main.refactoring.abstract_factory.produtos.ConcreteEntity;
import main.singlenton.getConnection;
import main.singlenton.utilsSwing;

public class CadastroRemedio extends javax.swing.JFrame {

    private boolean retornar = false;
    private String dataValidade;
    private String dataFabricacao;
    private utilsSwing utils;
    private ArrayList<String> textFields = new ArrayList<>(); 
    private ConnectionDAOImpl connectOp;
    private ProdutoDAOImpl produtoOp;
    private ConcreteEntity factory = new ConcreteEntity();
    
    public boolean getRetornar() {
        return retornar;
    }

    public void setRetornar(boolean retornar) {
        this.retornar = retornar;
    }

    public CadastroRemedio(utilsSwing input, ConnectionDAOImpl connectDAO, ProdutoDAOImpl produtoDAO){
        
        initComponents();
        this.utils = input;
        this.connectOp = connectDAO;
        this.produtoOp = produtoDAO;
    }
    
    public String getDataValidade(){
        return this.dataValidade;
    }
    
    public String getDataFabricacao(){
        return this.dataFabricacao;
    }

    public boolean verifyFields(){
        try{
            
            this.textFields.add(tfComposicaoRemedio.getText());
            this.textFields.add(tfMarca.getText());
            this.textFields.add(tfNome.getText());
            this.textFields.add(tfPreco.getText());
            this.textFields.add(cbReceita.getSelectedItem().toString());
            this.textFields.add(tfQuantidade.getText());
            this.textFields.add(tfTipo.getText());
            
            if (utils.verifyTextField(textFields, this.dataValidade, this.dataFabricacao)){
                return true;
            }else{
                return false;
            }
        }catch(Exception e){
            return false;
        }
    }

    public void insertDatabase(){
       Produto produtoNovo = factory.createProduto(tfNome.getText(),
               Double.parseDouble(tfPreco.getText()),
               tfMarca.getText(),
               Integer.parseInt(tfQuantidade.getText()),
               tfTipo.getText(),
                (cbReceita.getSelectedItem().toString() == "Sim" ? true : false),
                cbTipoTarja.getSelectedItem().toString(),
                cbFormaAdministracao.getSelectedItem().toString(),
                tfComposicaoRemedio.getText(),
                getDataValidade(),
                getDataFabricacao(),
                null);
       
        String allData = tfNome.getText() + "," +
                        tfPreco.getText().trim() + "," +
                        tfMarca.getText() + "," +
                        tfQuantidade.getText().trim() + "," +
                        tfTipo.getText() + ", " +
                        cbReceita.getSelectedItem() + "," +
                        cbTipoTarja.getSelectedItem() + "," +
                        cbFormaAdministracao.getSelectedItem() + "," +
                        tfComposicaoRemedio.getText() + "," +
                        getDataValidade() + "," +
                        getDataFabricacao() + "," +
                        "null";

        String[] arrayAllData = allData.split(",");

       produtoOp.add(produtoNovo);
       
    JOptionPane.showMessageDialog(null, "nome: " + arrayAllData[0] + "\npreco: " + arrayAllData[1] + "\nmarca: " + arrayAllData[2] + "\nquantidade: " + arrayAllData[3] + "\ntipo_remedio: " + arrayAllData[4]
                    + "\nreceita: " + arrayAllData[5] + "\ntipo_tarja: " + arrayAllData[6] + "\nforma_de_admin: " + arrayAllData[7] + "\ncomposicao: " + arrayAllData[8] + "\ndata_v: " + arrayAllData[9]
            + "\ndata_f: " + arrayAllData[10] + "\nsecao: " + arrayAllData[11]);

       //Conectando ao banco de dados com as credenciais
       getConnection connect = utils.getConnect();
       Connection conn = connect.startConnection();
       
       boolean sysResponse = connectOp.insertData("produto", conn, connect, arrayAllData);
       if(sysResponse){
           //JOptionPane.showMessageDialog(null, "Insercao feita");
       }else{
           //JOptionPane.showMessageDialog(null, "Erro ao Inserir");
       }
       
    }       
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PrecoCompra = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        tfNome = new javax.swing.JTextField();
        tfTipo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tfComposicaoRemedio = new javax.swing.JTextField();
        tfMarca = new javax.swing.JTextField();
        Marca = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tgDataValidade = new javax.swing.JToggleButton();
        DataFabricacao = new javax.swing.JLabel();
        tgDataFabricacao = new javax.swing.JToggleButton();
        PrecoCompra1 = new javax.swing.JLabel();
        tfPreco = new javax.swing.JTextField();
        cbTipoTarja = new javax.swing.JComboBox<>();
        cbFormaAdministracao = new javax.swing.JComboBox<>();
        lbNameTela = new javax.swing.JLabel();
        PrecoCompra2 = new javax.swing.JLabel();
        tfQuantidade = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cbReceita = new javax.swing.JComboBox<>();
        tgVoltar = new javax.swing.JToggleButton();
        btnEnviar = new javax.swing.JButton();
        jLayeredPane1 = new javax.swing.JLayeredPane();

        PrecoCompra.setText("Preço de compra:");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nome:");

        jLabel2.setText("Tipo do Remédio:");

        jLabel4.setText("Tipo de Tarja:");

        jLabel5.setText("Forma de Administração:");

        jLabel6.setText("Composição do remédio:");

        Marca.setText("Marca:");

        jLabel7.setText("Data de Validade:");

        tgDataValidade.setText("selecionar data");
        tgDataValidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tgDataValidadeActionPerformed(evt);
            }
        });

        DataFabricacao.setText("Data de Fabricação:");

        tgDataFabricacao.setText("selecionar data");
        tgDataFabricacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tgDataFabricacaoActionPerformed(evt);
            }
        });

        PrecoCompra1.setText("Preço:");

        cbTipoTarja.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Vermelha", "Amarela", "Branca" }));

        cbFormaAdministracao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Injetável", "Oral" }));

        lbNameTela.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        lbNameTela.setForeground(new java.awt.Color(255, 0, 0));
        lbNameTela.setText("Cadastrar Remédio");

        PrecoCompra2.setText("Quantidade:");

        jLabel8.setText("Receita");

        cbReceita.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sim", "Não" }));

        tgVoltar.setText("< Voltar");
        tgVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tgVoltarActionPerformed(evt);
            }
        });

        btnEnviar.setText("Enviar");
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(258, 258, 258)
                        .addComponent(lbNameTela))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(cbFormaAdministracao, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addComponent(tgDataFabricacao))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel2)
                        .addGap(107, 107, 107)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addComponent(PrecoCompra1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel4)
                        .addGap(131, 131, 131)
                        .addComponent(jLabel7))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(cbTipoTarja, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(tgDataValidade))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tfTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(tfComposicaoRemedio, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbReceita, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(136, 136, 136)
                                .addComponent(tfMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(172, 172, 172)
                                .addComponent(Marca)))
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PrecoCompra2)
                            .addComponent(tfQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel1)
                        .addGap(179, 179, 179)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addComponent(DataFabricacao))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(tgVoltar)
                        .addGap(124, 124, 124)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lbNameTela)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(DataFabricacao)))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbFormaAdministracao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tgDataFabricacao))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6)
                    .addComponent(PrecoCompra1))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfComposicaoRemedio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Marca)
                        .addComponent(PrecoCompra2)))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbReceita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbTipoTarja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tgDataValidade))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(tgVoltar))
                    .addComponent(btnEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tgDataFabricacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tgDataFabricacaoActionPerformed
        // TODO add your handling code here:
        Data newDate = new Data();

        newDate.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                
                dataFabricacao = newDate.getAllDate();
            }
        });

        newDate.setVisible(true);
    }//GEN-LAST:event_tgDataFabricacaoActionPerformed

    private void tgDataValidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tgDataValidadeActionPerformed
        Data newDate = new Data();

        newDate.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                dataValidade = newDate.getAllDate();
            }
        });

        newDate.setVisible(true);
    }//GEN-LAST:event_tgDataValidadeActionPerformed

    
    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
        Component frame = null;
        if (verifyFields()){
                JOptionPane.showConfirmDialog(frame, "Cadastro realizado com sucesso!", "Sucesso",JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
                insertDatabase();
        }else{
            JOptionPane.showConfirmDialog(frame, "Erro ao cadastrar", "Error",JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEnviarActionPerformed

    private void tgVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tgVoltarActionPerformed

        setRetornar(true);
        dispose();

    }//GEN-LAST:event_tgVoltarActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            private utilsSwing utils;
            private ConnectionDAOImpl connectOp;
            private ProdutoDAOImpl produtoOp;            
            public void run() {
                new CadastroRemedio(utils, connectOp, produtoOp).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DataFabricacao;
    private javax.swing.JLabel Marca;
    private javax.swing.JLabel PrecoCompra;
    private javax.swing.JLabel PrecoCompra1;
    private javax.swing.JLabel PrecoCompra2;
    private javax.swing.JButton btnEnviar;
    private javax.swing.JComboBox<String> cbFormaAdministracao;
    private javax.swing.JComboBox<String> cbReceita;
    private javax.swing.JComboBox<String> cbTipoTarja;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLabel lbNameTela;
    private javax.swing.JTextField tfComposicaoRemedio;
    private javax.swing.JTextField tfMarca;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfPreco;
    private javax.swing.JTextField tfQuantidade;
    private javax.swing.JTextField tfTipo;
    private javax.swing.JToggleButton tgDataFabricacao;
    private javax.swing.JToggleButton tgDataValidade;
    private javax.swing.JToggleButton tgVoltar;
    // End of variables declaration//GEN-END:variables
}
