package TrabalhoDev1Crud;

import com.mysql.cj.protocol.Resultset;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.Scanner;

public class TestaUpdate  {
    public static void main(String[] args) throws SQLException{
        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.recuperarConexao();
        Scanner key = new Scanner(System.in);


        String query = "update produto set nome = ?, descricao = ? where idlivros=?";

        PreparedStatement ps = connection.prepareStatement(query);



        System.out.print("Informe o novo nome a ser alterado: ");
        ps.setString(1, key.next());
        System.out.print("Informe a descricao do usuário a ser alterado: ");
        ps.setString(2, key.next());
        System.out.println("Informe o id do usuário a ser alterado: ");
        int id = key.nextInt();
        ps.setInt(3, id);

        ps.executeUpdate();

        recuperaDado(id);

        connection.close();

    }

    public static String recuperaDado(int id) throws SQLException{
        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.recuperarConexao();

        String query = "SELECT idlivros, nome, descricao FROM produto where idlivros = ?";
        PreparedStatement ps = connection.prepareStatement(query);

        ps.setInt(1,id);

        ps.executeQuery();

        ResultSet resultset = ps.getResultSet();



        while(resultset.next()) {
            Integer ID = resultset.getInt("idlivros"); // Coluna id
            System.out.println("ID: " + ID);

            String nome = resultset.getString("nome"); // Coluna id
            System.out.println("Nome: " + nome);

            String descricao = resultset.getString("descricao");
            System.out.println("Descricao: " + descricao);
        }

        System.out.println("O nome foi alterado com sucesso!");

        return "\nNome alterado com sucesso";
    }
//








}
