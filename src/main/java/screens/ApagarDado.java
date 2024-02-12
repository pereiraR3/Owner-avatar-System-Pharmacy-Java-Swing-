
package screens;

import java.awt.Component;
import java.sql.Connection;
import main.singlenton.getConnection;

import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

import main.impl.dao.ConnectionDAOImpl;
import main.impl.dao.FornecedorDAOImpl;
import main.impl.dao.FuncionarioDAOImpl;
import main.impl.dao.ProdutoDAOImpl;
import main.produtos.Produto;
import main.serviços.Fornecedor;
import main.serviços.Funcionario;

public class ApagarDado extends javax.swing.JFrame {
    
    private String table;
    private ConnectionDAOImpl connectionOp;
    private getConnection connect;
    private Connection conn;
    private boolean retornar;
    private FuncionarioDAOImpl funcionarioOp;
    private FornecedorDAOImpl fornecedorOp;
    private ProdutoDAOImpl produtoOp;
    public int flag = 0;

    public void constructComboBox(){
        ArrayList<String> lista = connectionOp.searchAllNames(this.table, this.conn, this.connect);

        if (lista.size() == 0) {
            
            if(flag != 1){
                Component frame = null;
                JOptionPane.showConfirmDialog(frame, "Erro - não há no banco de dados sobre " + table , "Error", JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE);
            }
            
            setRetornar(true);

            DefaultComboBoxModel<String> novoModelo = new DefaultComboBoxModel<>();
            novoModelo.addElement("Não há informação !");
            novoModelo.addElement("realize os cadastros");
            cbTable.setModel(novoModelo);

        } else {
            DefaultComboBoxModel<String> novoModelo = new DefaultComboBoxModel<>();

            for (String valueString : lista) {
                novoModelo.addElement(valueString);
            }
            
            cbTable.setModel(novoModelo);
            
        }
    }
    
    public ApagarDado(String input, ConnectionDAOImpl connectionOp, getConnection connect, FuncionarioDAOImpl funcionarioOp, ProdutoDAOImpl produtoOp, FornecedorDAOImpl fornecedorOp) {
        initComponents();
        this.table = input;
        this.connect = connect;
        this.connectionOp = connectionOp;
        this.conn = connect.startConnection();
        this.produtoOp = produtoOp;
        this.funcionarioOp = funcionarioOp;
        this.fornecedorOp = fornecedorOp;
        constructComboBox();
    }


    public boolean getRetornar() {
        return this.retornar;
    }

    public void setRetornar(boolean retornar) {
        this.retornar = retornar;
    }
    
    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    } 
    
    public void deleteDAO(String nome){
        if(this.table.equals("produto")){
            Produto produto = produtoOp.searchForName(nome);
            produtoOp.delete(produto);
        }else if(this.table.equals("funcionario")){
            Funcionario funcionario = funcionarioOp.searchForName(nome);
            funcionarioOp.delete(funcionario);
        }else{
            Fornecedor fornecedor = fornecedorOp.searchForName(nome);
            fornecedorOp.delete(fornecedor); 
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        cbTable = new javax.swing.JComboBox<>();
        btnConfirmar = new javax.swing.JButton();
        btnVoltar = new javax.swing.JToggleButton();
        jLayeredPane1 = new javax.swing.JLayeredPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Selecione uma opção para eliminar");

        cbTable.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnConfirmar.setText("Confirmar");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        btnVoltar.setText("< Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
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
            .addGap(0, 15, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(138, 138, 138)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(cbTable, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGap(12, 12, 12)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(cbTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnVoltar)
                .addGap(6, 6, 6)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        
        String valueDelete = cbTable.getSelectedItem().toString();
        String[] value = valueDelete.split(", ");
        String nameObject = "";

        for (int i = 0; i < value.length; i++) {
            if (value[i].contains("Nome")) {
                // Divida a parte que contém a chave e o valor em duas partes usando ":"
                String[] keyValue = value[i].split(":");
                if (keyValue.length == 2) {
                    // A primeira parte (keyValue[0]) contém a chave, e a segunda (keyValue[1]) contém o valor
                    if ("Nome".equals(keyValue[0].trim())) {
                        nameObject = keyValue[1].trim();
                        break; // Para o loop, uma vez que encontramos o valor desejado
                    }
                }
            }
        }
        
        boolean response = connectionOp.deleteData(this.table, this.conn, value);
        if(response){
            
           deleteDAO(nameObject);
           JOptionPane.showMessageDialog(null, "[Delete] - feito com sucesso");
           
           this.flag = 1;
           constructComboBox();
        }else{
           JOptionPane.showMessageDialog(null, "Erro ao deletar");
        }
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        setRetornar(true);
        dispose();
        
    }//GEN-LAST:event_btnVoltarActionPerformed

    
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            private String table;
            private ConnectionDAOImpl connectionOp;
            private getConnection connect;
            private FuncionarioDAOImpl funcionarioOp;
            private FornecedorDAOImpl fornecedorOp;
            private ProdutoDAOImpl produtoOp;
            public void run() {
                new ApagarDado(table, connectionOp, connect, funcionarioOp, produtoOp, fornecedorOp).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JToggleButton btnVoltar;
    private javax.swing.JComboBox<String> cbTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
