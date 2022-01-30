package TrabalhoDev1Crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class TestaDelete {
    public static void main(String[] args) throws SQLException {

       try {
           ConnectionFactory factory = new ConnectionFactory();
           Connection connection = factory.recuperarConexao();

           Scanner key = new Scanner(System.in);

           String query = "delete from produto where idlivros = ?";

           PreparedStatement ps = connection.prepareStatement(query);

           System.out.print("Informe o id do produto que queira deletar: ");
           ps.setInt(1, key.nextInt());

           ps.executeUpdate();

           System.out.println("Produto deletado com sucesso!");
       }catch (SQLException e) {
           System.out.println("Produto não existe.");
        }
    }
}
