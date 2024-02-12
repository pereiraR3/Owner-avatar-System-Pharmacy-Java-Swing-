package screens;

import java.awt.Component;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import main.impl.dao.ConnectionDAOImpl;
import main.impl.dao.ProdutoDAOImpl;
import main.produtos.Produto;
import main.refactoring.abstract_factory.produtos.ConcreteEntity;
import main.singlenton.getConnection;
import main.singlenton.utilsSwing;

public class CadastroProduto extends javax.swing.JFrame {

    private boolean retornar = false;
    private String dataValidade;
    private String dataFabricacao;
    private utilsSwing utils;
    private ArrayList<String> textFields = new ArrayList<>(); 
    private ConnectionDAOImpl connectOp;
    private ProdutoDAOImpl produtoOp;
    private ConcreteEntity factory = new ConcreteEntity();
    
    public CadastroProduto(utilsSwing input, ConnectionDAOImpl connectDAO, ProdutoDAOImpl produtoDAO) {
        initComponents();
        utils = input;
        this.connectOp = connectDAO;
        this.produtoOp = produtoDAO;
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
            
            this.textFields.add(tfMarca.getText());
            this.textFields.add(tfNome.getText());
            this.textFields.add(tfPreco.getText());
            this.textFields.add(tfQuantidade.getText());
            this.textFields.add(cbSecao.getSelectedItem().toString());
            
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
               Integer.parseInt(tfQuantidade.getText()) ,
               null,
               false,
               null,
               null,
               null,
               getDataValidade(),
               getDataFabricacao(),
               cbSecao.getSelectedItem().toString());
       
       String allData = tfNome.getText() + "," 
               + tfPreco.getText().trim() + ","
               + tfMarca.getText()+ ","
               + tfQuantidade.getText().trim() + ","
               + "null,false,null,null,null,"
               + getDataValidade()+ ","
               + getDataFabricacao()+ ","
               + cbSecao.getSelectedItem().toString();
       
       String[] arrayAllData = allData.split(",");
       produtoOp.add(produtoNovo);
       
       //Conectando ao banco de dados com as credenciais
       getConnection connect = utils.getConnect();
       Connection conn = connect.startConnection();
       
    JOptionPane.showMessageDialog(null, "nome: " + arrayAllData[0] + "\npreco: " + arrayAllData[1] + "\nmarca: " + arrayAllData[2] + "\nquantidade: " + arrayAllData[3] + "\ntipo_remedio: " + arrayAllData[4]
                    + "\nreceita: " + arrayAllData[5] + "\ntipo_tarja: " + arrayAllData[6] + "\nforma_de_admin: " + arrayAllData[7] + "\ncomposicao: " + arrayAllData[8] + "\ndata_v: " + arrayAllData[9]
            + "\ndata_f: " + arrayAllData[10]  + "secao: " +  arrayAllData[11]);
    
       boolean sysResponse = connectOp.insertData("produto", conn, connect, arrayAllData);
       if(sysResponse){
           //JOptionPane.showMessageDialog(null, "Insercao feita");
       }else{
           //JOptionPane.showMessageDialog(null, "Erro");
       }
       
    }    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        tfNome = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfMarca = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnEnviar = new javax.swing.JButton();
        tgDataFabricacao = new javax.swing.JToggleButton();
        tgDataValidade = new javax.swing.JToggleButton();
        cbSecao = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        tfQuantidade = new javax.swing.JTextField();
        tfPreco = new javax.swing.JTextField();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        tgVoltar = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel5.setText("Data de Fabricação:");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Cadastro Produto");

        jLabel2.setText("Nome:");

        jLabel10.setText("Seção:");

        jLabel11.setText("Preço:");

        jLabel3.setText("Marca:");

        jLabel4.setText("Data de Validade:");

        btnEnviar.setText("Enviar");
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });

        tgDataFabricacao.setText("Selecione");
        tgDataFabricacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tgDataFabricacaoActionPerformed(evt);
            }
        });

        tgDataValidade.setText("Selecione");
        tgDataValidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tgDataValidadeActionPerformed(evt);
            }
        });

        cbSecao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Higiene Pessoal", "Cuidados com o Bebê", "Higiene Feminina", "Bebidas", "Cuidados com a pele", "Cosméticos" }));

        jLabel12.setText("Quantidade:");

        tgVoltar.setText("< Voltar");
        tgVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tgVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(164, 164, 164))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(170, 170, 170)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(170, 170, 170)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(jLabel2)
                                .addGap(133, 133, 133)
                                .addComponent(jLabel11))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(tfPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(jLabel3)
                                .addGap(134, 134, 134)
                                .addComponent(jLabel10))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(tfMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(cbSecao, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(tgDataValidade, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(49, 49, 49)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(tgDataFabricacao, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12)
                                    .addComponent(tgVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(24, 24, 24)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(1, 1, 1)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(jLabel12)))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel10)))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(cbSecao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tgDataValidade)
                            .addComponent(tgDataFabricacao))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(btnEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tgVoltar)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tgDataFabricacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tgDataFabricacaoActionPerformed
        // TODO add your handling code here:
        Data newDate = new Data();

        newDate.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                
                dataFabricacao = newDate.getAllDate();
            }
        });

        newDate.setVisible(true);
    }//GEN-LAST:event_tgDataFabricacaoActionPerformed

    private void tgDataValidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tgDataValidadeActionPerformed
        Data newDate = new Data();

        newDate.addWindowListener(new java.awt.event.WindowAdapter() {
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
                new CadastroProduto(utils, connectOp, produtoOp).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnviar;
    private javax.swing.JComboBox<String> cbSecao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField tfMarca;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfPreco;
    private javax.swing.JTextField tfQuantidade;
    private javax.swing.JToggleButton tgDataFabricacao;
    private javax.swing.JToggleButton tgDataValidade;
    private javax.swing.JToggleButton tgVoltar;
    // End of variables declaration//GEN-END:variables
}
