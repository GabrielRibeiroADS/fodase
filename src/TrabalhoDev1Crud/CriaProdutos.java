package TrabalhoDev1Crud;

import java.sql.*;
import java.util.Scanner;

public class CriaProdutos {
    public Boolean criarProduto() throws SQLException {
        try {
            Scanner key = new Scanner(System.in);

            ConnectionFactory factory = new ConnectionFactory();
            Connection connection = factory.recuperarConexao();

            String query = "INSERT INTO produto(nome, descricao) values(?,?)";
            PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);


            System.out.print("Informe o nome do produto: ");
            ps.setString(1, key.next());
            System.out.print("Informe a descricao do produto: ");
            ps.setString(2, key.next());

            ps.executeUpdate();

            ResultSet resultset = ps.getGeneratedKeys();


            while(resultset.next()){
                Integer id = resultset.getInt(1);
                System.out.println("O ID criado foi: " + id);
            }

            System.out.println("Produto criado com sucesso!");

            System.out.println("Fechando a conexao");
            connection.close();
        } catch (Error e){
            System.out.println("alguma coisa");
        }
        return true;
    }
}
