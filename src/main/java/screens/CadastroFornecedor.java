package screens;

import java.awt.Component;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import main.impl.dao.ConnectionDAOImpl;
import main.impl.dao.FornecedorDAOImpl;
import main.refactoring.abstract_factory.produtos.ConcreteEntity;
import main.serviços.Fornecedor;
import main.singlenton.getConnection;
import main.singlenton.utilsSwing;

public class CadastroFornecedor extends javax.swing.JFrame {

    private boolean retornar = false;
    private String dataValidade;
    private String dataFabricacao;
    private utilsSwing utils;
    private ArrayList<String> textFields = new ArrayList<>(); 
    private ConnectionDAOImpl connectOp;
    private FornecedorDAOImpl fornecedorOp;
    private ConcreteEntity factory = new ConcreteEntity();
    
    public CadastroFornecedor(utilsSwing input, ConnectionDAOImpl connectDAO,  FornecedorDAOImpl fornecedorOp) {
        initComponents();
        this.utils = input;
        this.connectOp = connectDAO;
        this.fornecedorOp = fornecedorOp;
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
            this.textFields.add(tfCNPJ.getText());
            this.textFields.add(tfTelefone.getText());
            this.textFields.add(cbPortifolio.getSelectedItem().toString());
            this.textFields.add(tfEndereco.getText());
            
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
        
       Fornecedor fornecedorNovo = factory.createFornecedor(tfCNPJ.getText(),
               tfNome.getText(),
               tfTelefone.getText(),
               tfEndereco.getText(),
               cbPortifolio.getSelectedItem().toString());
       
       String allData = tfCNPJ.getText() + ","
               +  tfNome.getText() + ","
               +  tfTelefone.getText() + ","
               +  tfEndereco.getText() + ", "
               + cbPortifolio.getSelectedItem().toString();
       
       String[] arrayAllData = allData.split(",");
       fornecedorOp.add(fornecedorNovo);
       
       //Conectando ao banco de dados com as credenciais
       getConnection connect = utils.getConnect();
       Connection conn = connect.startConnection();

       boolean sysResponse = connectOp.insertData("fornecedor", conn, connect, arrayAllData);
       if(sysResponse){
           //JOptionPane.showMessageDialog(null, "Insercao feita");
       }else{
           //JOptionPane.showMessageDialog(null, "Erro");
       }
       
    }  
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tfNome = new javax.swing.JTextField();
        tfEndereco = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfTelefone = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfCNPJ = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnEnviar = new javax.swing.JButton();
        cbPortifolio = new javax.swing.JComboBox<>();
        tgVoltar = new javax.swing.JToggleButton();
        jLayeredPane1 = new javax.swing.JLayeredPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("Letizia"); // NOI18N
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Cadastro Fornecedor");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, -1, -1));
        getContentPane().add(tfNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 111, 168, -1));
        getContentPane().add(tfEndereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(286, 166, 130, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 225, 10));

        jLabel2.setText("Nome:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 78, -1, -1));

        jLabel10.setText("Portfólio:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 80, -1, -1));

        jLabel5.setText("Endereço:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(286, 142, -1, -1));
        getContentPane().add(tfTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 231, 168, -1));

        jLabel3.setText("CNPJ:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 141, -1, -1));
        getContentPane().add(tfCNPJ, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 165, 168, -1));

        jLabel4.setText("Telefone:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 207, -1, -1));

        btnEnviar.setText("Enviar");
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEnviar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 230, 140, 58));

        cbPortifolio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Benzetacil", "Dipirona", "Neosoro", "Rivotril", "Torsilax", "Isotretinoína", "Ivermectica", "Ciclo 21", "Sal de Fruta", "Ácido Mefenâmico", "Resfenol", "Shampoo Anticaspa", "Fralda Supreme Care P", "Sabonete Líquido Relaxante Hora do Sono", "Fio Dental Johnson's", "Absorvente Externo Noturno Plus Noite e Dia Suave", "Gatorade Frutas Cítricas Isotônicos com 500ml", "Escova de dente portátil para viagem", "Protetor Solar Facial Sun Fresh Derm Care FPS 70 Pele Mista e Oleosa", "Hidratante Facial Vita C 50g", "Desodorante Rexona Men Antibacterial Aerossol Antitranspirante 150ml", "PERFUME J. ADORE DIOR FEMININO EAU DE PARFUM" }));
        getContentPane().add(cbPortifolio, new org.netbeans.lib.awtextra.AbsoluteConstraints(286, 108, 130, -1));

        tgVoltar.setText("< Voltar");
        tgVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tgVoltarActionPerformed(evt);
            }
        });
        getContentPane().add(tgVoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 279, 94, -1));

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        getContentPane().add(jLayeredPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 330, 250, 60));

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

        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CadastroFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            private utilsSwing utils;
            private ConnectionDAOImpl connectDAO;
            private FornecedorDAOImpl fornecedorOp;
            public void run() {
                new CadastroFornecedor(utils, connectDAO, fornecedorOp).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnviar;
    private javax.swing.JComboBox<String> cbPortifolio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField tfCNPJ;
    private javax.swing.JTextField tfEndereco;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfTelefone;
    private javax.swing.JToggleButton tgVoltar;
    // End of variables declaration//GEN-END:variables
}
