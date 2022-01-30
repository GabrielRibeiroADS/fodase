package TrabalhoDev1Crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {
        Boolean laço = true;
        Scanner key = new Scanner(System.in);
        CriaProdutos produto = new CriaProdutos();
        RecuperaProdutos rp = new RecuperaProdutos();
        DeletaProdutos dp = new DeletaProdutos();
        AtualizaProduto ap = new AtualizaProduto();



        while (laço){
            System.out.println("Digite: ");
            System.out.println("[1]Adicionar um produto");
            System.out.println("[2]Recuperar todos produtos");
            System.out.println("[3]Recuperar um produto");
            System.out.println("[4]Deletar um produto");
            System.out.println("[5]Atualizar um produto");
            System.out.println("[0]Sair");
            System.out.println("Informe o que deseja fazer: ");
            switch(key.nextInt()){
                case 1:
                    produto.criarProduto();
                    break;
                case 2:
                    rp.recuperarProdutos();
                    break;
                case 3:
                    rp.umProduto();
                    break;
                case 4:
                    dp.deletarProdutos();
                    break;
                case 5:
                    ap.atualizarProduto();
                    break;
                case 0:
                    System.out.println("Finalizando.");
                    laço=false;
                    break;
            }
        }

        // write your code here
    }

}
