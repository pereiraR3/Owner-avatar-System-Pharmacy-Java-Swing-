/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package screens;

import java.awt.Component;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import main.impl.dao.ConnectionDAOImpl;
import main.impl.dao.FuncionarioDAOImpl;
import main.produtos.Produto;
import main.refactoring.abstract_factory.produtos.ConcreteEntity;
import main.serviços.Funcionario;
import main.singlenton.getConnection;
import main.singlenton.utilsSwing;

public class CadastroFuncionario extends javax.swing.JFrame {

    private boolean retornar = false;
    private String dataValidade;
    private String dataFabricacao;
    private utilsSwing utils;
    private ArrayList<String> textFields = new ArrayList<>(); 
    private ConnectionDAOImpl connectOp;
    private FuncionarioDAOImpl funcionarioOp;
    private ConcreteEntity factory = new ConcreteEntity();

    public CadastroFuncionario(utilsSwing input, ConnectionDAOImpl connectDAO, FuncionarioDAOImpl funcionarioDAO) {
        initComponents();
        this.utils = input;
        this.connectOp = connectDAO;
        this.funcionarioOp = funcionarioDAO;
    }
    
    public boolean getRetornar() {
        return retornar;
    }

    public void setRetornar(boolean retornar) {
        this.retornar = retornar;
    }

    public String getDataValidade(){
        return this.dataValidade;
    }
    
    public String getDataFabricacao(){
        return this.dataFabricacao;
    }

    public boolean verifyFields(){
        try{
            
            this.textFields.add(tfNome.getText());
            this.textFields.add(tfCPF.getText());
            this.textFields.add(tfTelefone.getText());
            this.textFields.add(tfSalario.getText());
            this.textFields.add(tfComissao.getText());
            this.textFields.add(cbCargo.getSelectedItem().toString());
            this.textFields.add(cbCertificado.getSelectedItem().toString());
            
            if (utils.verifyTextField(textFields, "null", "null")){
                return true;
            }else{
                return false;
            }
        }catch(Exception e){
            return false;
        }
    }    

    public void insertDatabase(){
       if(cbCargo.getSelectedItem().toString().equals("Vendedor")){
            Funcionario funcionarioNovo = factory.createVendedor(tfCPF.getText(), tfNome.getText(), tfTelefone.getText(), (cbCertificado.getSelectedItem().toString() == "Sim" ? true : false),
                    cbCargo.getSelectedItem().toString(), Double.parseDouble(tfComissao.getText()), Double.parseDouble(tfSalario.getText()));
            funcionarioOp.add(funcionarioNovo);

       }else{
            Funcionario funcionarioNovo = factory.createFarmaceutico(tfCPF.getText(), tfNome.getText(), tfTelefone.getText(), (cbCertificado.getSelectedItem().toString() == "Sim" ? true : false),
                    cbCargo.getSelectedItem().toString(), Double.parseDouble(tfComissao.getText()), Double.parseDouble(tfSalario.getText()));
            funcionarioOp.add(funcionarioNovo);
       }
       
       String allData = tfCPF.getText() + ", " +  tfNome.getText() + ", " + tfTelefone.getText() + ", " + cbCertificado.getSelectedItem().toString() + ", " +
                    cbCargo.getSelectedItem().toString() + ", " + Double.parseDouble(tfComissao.getText()) + ", " +  Double.parseDouble(tfSalario.getText()) ;
       String[] arrayAllData = allData.split(",");
       
       //Conectando ao banco de dados com as credenciais
       getConnection connect = utils.getConnect();
       Connection conn = connect.startConnection();
       
       boolean sysResponse = connectOp.insertData("funcionario", conn, connect, arrayAllData);
       if(sysResponse){
           //JOptionPane.showMessageDialog(null, "Insercao feita");
       }else{
           //JOptionPane.showMessageDialog(null, "Erro");
       }
       
    } 
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField2 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jTextField4 = new javax.swing.JTextField();
        tfTelefone = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfCPF = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnEnviar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        tfSalario = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tfComissao = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        cbCertificado = new javax.swing.JComboBox<>();
        tfNome = new javax.swing.JTextField();
        tgVoltar = new javax.swing.JToggleButton();
        cbCargo = new javax.swing.JComboBox<>();
        jLayeredPane1 = new javax.swing.JLayeredPane();

        jTextField2.setText("jTextField2");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 51, 0));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Cadastro Funcionário");

        jLabel2.setText("CPF:");

        jLabel3.setText("Nome:");

        jLabel4.setText("Telefone:");

        btnEnviar.setText("Enviar");
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });

        jLabel5.setText("Salário:");

        jLabel6.setText("Comissão:");

        jLabel7.setText("Cargo:");

        jLabel8.setText("Possui certificado ?");

        cbCertificado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sim", "Não" }));

        tgVoltar.setText("< Voltar");
        tgVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tgVoltarActionPerformed(evt);
            }
        });

        cbCargo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Vendedor", "Farmacêutico" }));

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 37, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(163, 163, 163)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(197, 197, 197)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(jLabel3)
                        .addGap(215, 215, 215)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(jLabel2)
                        .addGap(223, 223, 223)
                        .addComponent(jLabel7))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tfSalario, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(148, 148, 148)
                                .addComponent(btnEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tgVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(218, 218, 218)
                        .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(63, 63, 63)
                                    .addComponent(tfComissao, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(tfCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(62, 62, 62)
                                    .addComponent(cbCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(tfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(cbCertificado, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(82, 82, 82))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1)
                .addGap(6, 6, 6)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfComissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel7))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel8))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbCertificado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(jLabel5)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tfSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tgVoltar))
                    .addComponent(btnEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            private FuncionarioDAOImpl funcionarioOp;
            public void run() {
                new CadastroFuncionario(utils, connectOp, funcionarioOp).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnviar;
    private javax.swing.JComboBox<String> cbCargo;
    private javax.swing.JComboBox<String> cbCertificado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField tfCPF;
    private javax.swing.JTextField tfComissao;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfSalario;
    private javax.swing.JTextField tfTelefone;
    private javax.swing.JToggleButton tgVoltar;
    // End of variables declaration//GEN-END:variables
}
