
package main.impl.dao;

//Importando as bibliotecas necessarias para trabalharmos com conexao com bd
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//Importando um collection para ajudar nos métodos 
import java.util.ArrayList;

//Importando classes que fazem conexao com o BD
import main.dao.IConnectionDAO;
import main.singlenton.getConnection;


public class ConnectionDAOImpl implements IConnectionDAO{
    
    private ArrayList<String> columnNames;
    
    public static String primeiraLetraMaiuscula(String texto) {
        if (texto == null || texto.isEmpty()) {
            return texto; 
        } else if ("CPF".equalsIgnoreCase(texto) || "CNPJ".equalsIgnoreCase(texto) || "ID".equalsIgnoreCase(texto)) {
            return texto.toUpperCase(); 
        } else {
            return texto.substring(0, 1).toUpperCase() + texto.substring(1);
        }
    }

    public void cleanColumnNames(){
        this.columnNames = new ArrayList<>();
    }
    
    public void arrayColumnsProduto(){
        
        columnNames.add("nome");
        columnNames.add("preco");
        columnNames.add("marca");
        columnNames.add("quantidade");
        columnNames.add("tipo_remedio"); 
        columnNames.add("receita");
        columnNames.add("tipo_tarja");
        columnNames.add("forma_de_administracao"); 
        columnNames.add("composicao_remedio");
        columnNames.add("data_validade");
        columnNames.add("data_fabricacao");
        columnNames.add("secao");
        
    }
    
    
    public void arrayColumnsFuncionario(){
        
        columnNames.add("cpf");
        columnNames.add("nome");
        columnNames.add("telefone"); 
        columnNames.add("certificado");
        columnNames.add("cargo");
        columnNames.add("comissao"); 
        columnNames.add("salario");
        
    }
    
    
    public void arrayColumnsFornecedor(){
        
        columnNames.add("cnpj");
        columnNames.add("nome");
        columnNames.add("telefone");
        columnNames.add("endereco"); 
        columnNames.add("portifolio");
        
    }
    
    //Funcao responsavel por toda a parte de inserção de dados no BD
    @Override 
    public boolean insertData (String table, Connection conn, getConnection connect, String[] dados){
        
        cleanColumnNames();
        String constructQuery = "INSERT INTO " + table + " (";
        String valuesPlaceholder = "";

        if(table.equals("produto")){
            arrayColumnsProduto();
        }else if(table.equals("funcionario")){
            arrayColumnsFuncionario();
        }else if(table.equals ("fornecedor")){
            arrayColumnsFornecedor();
        }
        
        for (int i = 0; i < columnNames.size(); i++) {
            constructQuery += columnNames.get(i);
            valuesPlaceholder += "?";

            if (i < columnNames.size() - 1) {
                constructQuery += ", ";
                valuesPlaceholder += ", ";
            }
        }

        constructQuery += ") VALUES " + "(" + valuesPlaceholder + ")"; 
        try {
            
            PreparedStatement pstmt = conn.prepareStatement(constructQuery);
            if(table.equals("produto")){

                pstmt.setString(1, dados[0]);
                pstmt.setDouble(2, Double.parseDouble(dados[1]));
                pstmt.setString(3, dados[2]);
                pstmt.setInt(4, Integer.parseInt(dados[3]));
                pstmt.setString(5, dados[4]);
                pstmt.setBoolean(6, (dados[5] == "Sim" ? true : false));
                pstmt.setString(7, dados[6]);
                pstmt.setString(8, dados[7]);
                pstmt.setString(9, dados[8]);
                pstmt.setString(10, dados[9]);
                pstmt.setString(11, dados[10]);
                pstmt.setString(12, dados[11]);
                
            }else if(table.equals("funcionario")){

                pstmt.setString(1, dados[0]);
                pstmt.setString(2, dados[1]);
                pstmt.setString(3, dados[2]);
                pstmt.setBoolean(4, (dados[3] == "Sim" ? true : false));
                pstmt.setString(5, dados[4]);
                pstmt.setDouble(6, Double.parseDouble(dados[5]));
                pstmt.setDouble(7, Double.parseDouble(dados[6]));
                
            }else if(table.equals ("fornecedor")){
                pstmt.setString(1, dados[0]);
                pstmt.setString(2, dados[1]);
                pstmt.setString(3, dados[2]);
                pstmt.setString(4, dados[3]);
                pstmt.setString(5, dados[4]); 
            }          
            
            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                return true; 
            } else {
                return false; 
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Ocorreu um erro durante a inserção
        }
 
    }
    
    //Funcao responsavel por toda a parte de eliminação de dados no BD
    @Override 
    public boolean deleteData(String table, Connection conn, String[] dados){
        cleanColumnNames();
        String cond = "";
        
        if(table.equals("funcionario")){
            
            for (int i = 0; i < dados.length; i++) {
                String getValue = dados[i].trim(); // Remove espaços em branco extras do início e do fim
                String[] partes = getValue.split(":"); // Divide a string com base em ':'
                partes[1] = partes[1].trim();
                
                if (i == 0) {
                    cond += "funcionario.id = " + partes[1] + " AND ";
                }else if (i == 1){
                    cond += "funcionario.cpf = " +  "\"" +  partes[1] + "\"";
                }
            }
            
        }else if(table.equals("fornecedor")){
            
            for (int i = 0; i < dados.length; i++) {
                String getValue = dados[i].trim(); // Remove espaços em branco extras do início e do fim
                String[] partes = getValue.split(":"); // Divide a string com base em ':'
                partes[1] = partes[1].trim();
                
                if (i == 0) {
                    cond += "funcionario.id = " + partes[1] + " AND ";
                }else if (i == 1){
                    cond += "funcionario.cpf = " +  "\"" +  partes[1] + "\"";
                }
            }
            
        }else if(table.equals("produto")){
            
            for (int i = 0; i < dados.length; i++) {
                String getValue = dados[i].trim(); // Remove espaços em branco extras do início e do fim
                String[] partes = getValue.split(":"); // Divide a string com base em ':'
                partes[1] = partes[1].trim();

                if (i == 0) {
                    cond += "produto.id = " + partes[1] + " AND ";
                }else if (i == 1){
                    cond += "produto.nome = " + "\"" +partes[1] + "\"";
                }
            }
        }
        
        String querySQL = "DELETE FROM " + table + " WHERE " + cond;
        try {
            PreparedStatement pstmt = conn.prepareStatement(querySQL);
            int rowsAffected = pstmt.executeUpdate(); // Use executeUpdate para DELETE

            if (rowsAffected > 0) {
                return true; // Exclusão bem-sucedida
            } else {
                return false; // Nenhum registro foi excluído
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Trate ou registre o erro, não apenas retorne false
            return false;
        }
    }
    
    //Funcao responsavel por toda a parte de consulta de dados no BD
    //Neste caso, se trata de uma consulta geral por tabela
    @Override 
    public ArrayList<String> searchAllData(String table, Connection conn, getConnection connect){
        
        cleanColumnNames();
        ArrayList<String> result = new ArrayList<>();
        try{
            String cond = "";
            if(table.equals("produto")){
                arrayColumnsProduto();
                cond = "WHERE produto.secao != " +  "\"" + "null" + "\"";
            }else if(table.equals("remedio")){
                arrayColumnsProduto();
                table = "produto";
                cond = "WHERE produto.secao = " + "\"" + "null" + "\"";
            }else if(table.equals("funcionario")){
                arrayColumnsFuncionario();
            }else if(table.equals ("fornecedor")){
                arrayColumnsFornecedor();
            }
            //Construindo a selecao + preparando a execucao da selecacao
            String querySql = "SELECT * FROM " + table +  " " + cond; 
            PreparedStatement pstmt = conn.prepareStatement(querySql);
            ResultSet rst = pstmt.executeQuery();
            
            //loop para ler todas as informacoes buscadas
            while(rst.next()){
                int index = 0; 
                for (String column :  columnNames){
                    result.add(primeiraLetraMaiuscula(column) + ": " + rst.getString(column));
                    index++;
                }
                result.add(" ");
            }
            return result;
            
        }catch(SQLException e){
            return null; 
        }
        
    }
    
    //Funcao responsavel pela parte de obter alguns campos relativos a tabela, de modo
    //que essa informacao seja útil na construcao do comboBox usado na interação
    //para eliminar algum dado que já existe no BD
    @Override 
    public ArrayList<String> searchAllNames(String table, Connection conn, getConnection connect){
        
        try{
            cleanColumnNames();
            ArrayList<String> result = new ArrayList<>();
            String cond = "";
            String projecao = "";
            if(table.equals("produto")){
                columnNames.add("id");
                columnNames.add("nome");
                cond = "WHERE produto.receita = 0";
                projecao = "produto.id, produto.nome";
            }else if(table.equals("remedio")){
                columnNames.add("id");
                columnNames.add("nome");
                cond = "WHERE produto.secao = null";
                projecao = "remedio.id, remedio.nome";
            }else if(table.equals("funcionario")){
                columnNames.add("id");
                columnNames.add("cpf");
                columnNames.add("nome");
                projecao = "funcionario.id, funcionario.cpf, funcionario.nome";
            }else if(table.equals ("fornecedor")){
                columnNames.add("id");
                columnNames.add("cnpj");
                columnNames.add("nome");
                projecao = "fornecedor.id, fornecedor.cnpj, fornecedor.nome";
            }
            //Construindo a selecao + preparando a execucao da selecacao
            String querySql = "SELECT " + projecao  + " FROM " + table + " " + cond; 
            PreparedStatement pstmt = conn.prepareStatement(querySql);
            ResultSet rst = pstmt.executeQuery();
            
            //loop para ler todas as informacoes buscadas

            while (rst.next()) {
                String all = "";
                int index = 1;

                for (String column :  columnNames){
                    all += primeiraLetraMaiuscula(column) + ": " + rst.getString(column);
                    if(index != columnNames.size()){
                        all += ", ";
                    }
                    index++;
                }
                result.add(all);
            }
            return result;

            
        }catch(SQLException e){
            return null; 
        }
        
    }
    
}
