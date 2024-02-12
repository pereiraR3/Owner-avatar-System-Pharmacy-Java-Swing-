
package main.singlenton;

//
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

//
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

//
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class getConnection {

    private String username;
    private String password;
    private String database;
    private Connection conn;
    
    public getConnection(String username, String password, String database){
        this.username = username;
        this.password = password;
        this.database = database;
    }
   
    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }


    public String getDatabase() {
        return database;
    }


    public void setDatabase(String database) {
        this.database = database;
    }


    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }
    
    
    //Funcao para iniciar a conexao com o banco de dados
    public Connection startConnection(){
        try{
            this.setConn(DriverManager.getConnection("jdbc:mysql://localhost:3306/" + this.getDatabase(), this.getUsername(), this.getPassword()));
            return this.getConn();
        }catch(SQLException e){
            return null;
        }
    }
    
    //Método para fechar a conexao com o banco de dados
    public void closeConnection(Connection conn) throws SQLException{
        this.getConn().close();
    }
    
    public ArrayList<String> unityColumnNames(String table, String column, Connection conn){
        
        ArrayList<String> getAllNames = new ArrayList<>();
        
        String querySQL = "SELECT * FROM " + table;
        try{
            PreparedStatement pstmt = conn.prepareStatement(querySQL);
            ResultSet rst = pstmt.executeQuery();
            while(rst.next()){
                getAllNames.add(rst.getString(column));
            }
        }catch(SQLException e){
            return getAllNames;
        }
        
        return getAllNames;
        
    }
    
    //Funcao que obtem o nome de todas as colunas da tabela passada, retornando esses nomes em um arrayList
    public ArrayList tableInfoColumns(String table, Connection con){
        
        ArrayList<String> getNamesColumns = new ArrayList<>();
        try{
            
            //Buscando os nomes de todas as colunas
            String search = "SELECT * FROM " + table;

            JOptionPane.showMessageDialog(null, "table: " + table);
            
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(search);
            ResultSetMetaData metaData = rs.getMetaData();
            int numColumns = metaData.getColumnCount();
            
            for(int i = 1; i <= numColumns; i++){
                getNamesColumns.add(((String) metaData.getCatalogName(i)));
            }
            
            rs.close();
            stmt.close();
            con.close();
            
        }catch(SQLException e){
            return null;
        }
        
        return getNamesColumns;
    }
    
}
