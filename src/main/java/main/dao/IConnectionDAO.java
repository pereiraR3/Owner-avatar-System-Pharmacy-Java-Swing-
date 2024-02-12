
package main.dao;

//Importando o collection ArrayList
import java.util.ArrayList;

//Importando duas classes que vão se comunicar com o BD
import java.sql.Connection;
import main.singlenton.getConnection;

public interface IConnectionDAO {
    boolean insertData(String table, Connection conn, getConnection connect, String[] data);
    ArrayList<String> searchAllData(String table, Connection conn, getConnection connect);
    ArrayList<String> searchAllNames(String table, Connection conn, getConnection connect);
    boolean deleteData(String table, Connection conn, String[] dados);
}
