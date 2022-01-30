package TrabalhoDev1Crud;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.Scanner;

public class RecuperaProdutos {
    public Boolean recuperarProdutos() throws SQLException {
        try {
            System.out.println("---------------------------------------");

            ConnectionFactory factory = new ConnectionFactory();
            Connection connection = factory.recuperarConexao();

            Statement statement = connection.createStatement();
            statement.execute("SELECT idlivros, nome, descricao from produto");
            ResultSet resultset = statement.getResultSet();

            while(resultset.next()) {
                Integer id = resultset.getInt("idlivros"); // Coluna id
                System.out.println("ID: " + id);

                String nome = resultset.getString("nome"); // Coluna id
                System.out.println("Nome: " + nome);

                String descricao = resultset.getString("descricao");
                System.out.println("Descricao: " + descricao);
            }

            System.out.println("Produtos Recuperados!");
            System.out.println("Fechando a conexao");
            System.out.println("---------------------------------------");
            connection.close();
        }
        catch (Error e){
            System.out.println("Não existe produtos cadastrados");
            System.out.println("---------------------------------------");
        }
        return true;
    }

    public Boolean umProduto() throws SQLException{
        try{
            System.out.println("---------------------------------------");

            Scanner key = new Scanner(System.in);

            ConnectionFactory factory = new ConnectionFactory();
            Connection connection = factory.recuperarConexao();

            String query = "SELECT idlivros, nome, descricao from produto where idlivros = ?";
            PreparedStatement ps = connection.prepareStatement(query);

            System.out.print("Informe o id do produto que voce queira: ");
            ps.setInt(1,key.nextInt());

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

            System.out.println("Produto Recuperado!");
            System.out.println("Fechando conexao");
            System.out.println("---------------------------------------");
            connection.close();
        }
        catch (SQLException e){
            System.out.println("Produto não encontrado");
            System.out.println("---------------------------------------");
        }

        return true;
    }
}
