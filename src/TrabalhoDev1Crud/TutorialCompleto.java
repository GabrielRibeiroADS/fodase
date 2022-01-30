/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabalhoDev1Crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author monte
 */
public class TutorialCompleto {
    public static void main(String[] args) throws SQLException {
        
        // 1 - Conexao: recuperar a conexao do banco de dado com a aplicacao java 
        //Interface Connection 
        // Driver Manager - getConection (url, user, password) 
        
        /*
        url = jdbc:mysql//host_name/database_name... informacoes sobre fuso horario
        usuario = root
        passaword = ` ` ou root 
        */
        
        
        //2 - Verificar import das bibs 
        
        // 3 - Recuparada a conexao  - vamos acesssar e depois inserir dados do banco
        //Stamenet - comandos SQL 
        //referncia para a criacao de codigo SQL no Java
        
        String url = "jdbc:mysql://localhost/lojaProdutos?useTimezone=true&serverTimezone=UTC";
        String user = "root";
        String password = "root";
    
        Connection connection = DriverManager.getConnection(url, user, password);
        
        //criando um Statement
        Statement statement = connection.createStatement();
        
        //executando a query que compoe um statement
     //   statement.execute("SELECT ID, NOME, DESCRICAO FROM PRODUTO");
        //o que esta entre aspas eh o comando utilizado no BANCO, mas aqui dessas forma ele esta dentro do java.
        //Temos um comando SQL dentro da aplicacao Java
        
        // e se eu tiver um ou mais produtos?
        //Verificar se a tabela tem ou nao, mais de um item
        //Retorno padrao booleano
        //boolean retorno_stm = statement.execute("SELECT ID, NOME, DESCRICAO FROM PRODUTO");
      //  System.out.println(retorno_stm);
        
        //Lista para recuperar os dados do banco
        
 //       List<String> resultado = statement.execute("SELECT ID, NOME, DESCRICAO FROM PRODUTO");
        
        ResultSet resultset = statement.getResultSet();
        
        while(resultset.next()) {
            //montando as informacoes do banco aqui na aplicacao
            Integer id = resultset.getInt("id"); // Coluna id 
            System.out.println("ID: " + id);
            
            String nome = resultset.getString("descricao"); // Coluna id 
            System.out.println("Nome: " + nome);
            
            String descricao = resultset.getString("nome");
            System.out.println("Nome: " + nome);
        }
        
        
        System.out.println("-- FECHANDO A CONEXAO ---- ");
        connection.close();
    }
    

    //4 - Inserindo itens na coluna do banco de dos
    
    //5 - Factory 
    
    

    
}
