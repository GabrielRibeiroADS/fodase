package TrabalhoDev1Crud;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author monte
 */
public class TestaRecuperacaoDados {
    
    public static void main(String[] args) throws SQLException {

        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.recuperarConexao();
        
        Statement statement = connection.createStatement();
        statement.execute("SELECT idlivros, NOME, DESCRICAO FROM PRODUTO");

        ResultSet resultset = statement.getResultSet();

        while(resultset.next()) {
            Integer id = resultset.getInt("idlivros"); // Coluna id
            System.out.println("ID: " + id);

            String nome = resultset.getString("nome"); // Coluna id
            System.out.println("Nome: " + nome);

            String descricao = resultset.getString("descricao");
            System.out.println("Descricao: " + descricao);
        }
        
        System.out.println("-- FECHANDO A CONEXAO ---- ");
        connection.close();

    }
    
}
