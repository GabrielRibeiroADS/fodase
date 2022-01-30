package TrabalhoDev1Crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AtualizaProduto {
    public Boolean atualizarProduto() throws SQLException{
        try {
            System.out.println("---------------------------------------");

            Scanner key = new Scanner(System.in);

            ConnectionFactory factory = new ConnectionFactory();
            Connection connection = factory.recuperarConexao();

            String query = "update produto set nome = ?, descricao = ? where idlivros=?";

            PreparedStatement ps = connection.prepareStatement(query);

            System.out.print("Informe o nome do produto que deseja alterar: ");
            ps.setString(1,key.next());

            System.out.print("Informe a descricao do produto que deseja alterar: ");
            ps.setString(2,key.next());

            System.out.print("Informe o id do produto que deseja alterar: ");
            ps.setInt(3,key.nextInt());


            ps.executeUpdate();

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
            System.out.println("---------------------------------------");
            connection.close();
        }
        catch (SQLException e){
            System.out.println("Produto não existe.");
            System.out.println("---------------------------------------");
        }

        return true;
    }
}
