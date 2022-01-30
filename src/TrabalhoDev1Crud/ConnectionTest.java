/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabalhoDev1Crud;

import com.sun.xml.internal.ws.db.DatabindingImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author monte
 */
public class ConnectionTest {
    public static void main(String[] args) throws SQLException {
        System.out.println("---------------------------------------");


//        String url = "jdbc:mysql://localhost/lojaProduto?useTimezone=true&serverTimezone=UTC";
//        String user= "root";
//        String password = "92096055";
//
//        Connection connection = DriverManager.getConnection(url,user,password);
//
//        System.out.println("fechando conexao");
//        connection.close();

        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.recuperarConexao();
        System.out.println("Fechando conexao");
        connection.close();
    } 
    
    
}
