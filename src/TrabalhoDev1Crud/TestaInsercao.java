/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabalhoDev1Crud;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author monte
 */
public class TestaInsercao {
    
    public static void main(String[] args) throws SQLException {
        
        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.recuperarConexao();
        
        Statement statement = connection.createStatement();
        
     //   boolean resultado = statement.execute("INSERT INTO PRODUTO (nome, descricao) VALUES ('Monitor', 'LG ULTRWIDE 29UM69G')");
     ///   System.out.println(resultado);
        
        
        //o retorno do id eh fundamental

        statement.execute("INSERT INTO produto (nome, descricao) VALUES ('Monitor', 'LG ULTRWIDE 29UM69G')", Statement.RETURN_GENERATED_KEYS);

        ResultSet resultSet = statement.getGeneratedKeys();
        
        while(resultSet.next()){
            Integer id = resultSet.getInt(1);
            System.out.println("O ID criado foi: " + id);
        }
        
    }

    
}
