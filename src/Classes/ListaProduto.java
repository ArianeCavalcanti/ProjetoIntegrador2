package Classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ListaProduto {
    private static final ArrayList<Produto_itens> listaProdutos = new ArrayList<>();
    private static final String URL = "jdbc:mysql://localhost:3306/distribuidora_de_agua";
    private static final String USER = "root";
    private static final String PASSWORD = "T#7aB3$0m2@i";

    public static void adicionar(Produto_itens produto) {
        listaProdutos.add(produto);
    }

    public static ArrayList<Produto_itens> getListaProdutos() {
        return listaProdutos;
    }

    public static int size() {
        return listaProdutos.size();
    }

    public static void remove(int posProduto) {
        if (posProduto >= 0 && posProduto < listaProdutos.size()) {
            listaProdutos.remove(posProduto);
        } else {
            throw new IndexOutOfBoundsException("Posição do produto inválida: " + posProduto);
        }
    }

    public static void atualizarEstoqueNoBanco(int idProduto, int quantidadeVendida) throws SQLException {
        String query = "UPDATE produto SET estoque = estoque - ? WHERE idproduto = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, quantidadeVendida);
            statement.setInt(2, idProduto);
            statement.executeUpdate();
        }
    }

    public static void atualizarEstoqueNaLista(int idProduto, int quantidadeVendida) {
        for (Produto_itens produto : ListaProduto.getListaProdutos()) {
            if (produto.getIdProduto() == idProduto) {
                int estoqueAtual = produto.getQuantidade();
                int novoEstoque = estoqueAtual - quantidadeVendida;
                produto.setQuantidade(novoEstoque);
                return;
            }
        }
    }

    public void processarVenda(Produto_itens produto, int quantidadeVendida) throws SQLException {
        // Atualiza o estoque no banco de dados
        atualizarEstoqueNoBanco(produto.getIdProduto(), quantidadeVendida);

        // Atualiza o estoque na lista local
        atualizarEstoqueNaLista(produto.getIdProduto(), quantidadeVendida);

        // Insere o produto na tabela produto_itens
        inserirProdutoItens(produto, quantidadeVendida);
    }

    private void inserirProdutoItens(Produto_itens produto, int quantidadeVendida) throws SQLException {
        String sqlProdutoItens = "INSERT INTO produto_itens (quantidade, valor_unitario, subtotal, fabricante, venda_idvenda, produto_idproduto) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statementProdutoItens = connection.prepareStatement(sqlProdutoItens)) {

            statementProdutoItens.setInt(1, quantidadeVendida);
            statementProdutoItens.setDouble(2, produto.getValorUnitario());
            statementProdutoItens.setDouble(3, produto.getSubtotal());
            statementProdutoItens.setString(4, produto.getFabricante());
            statementProdutoItens.setInt(5, produto.getIdVenda()); 
            statementProdutoItens.setInt(6, produto.getIdProduto());

            statementProdutoItens.executeUpdate();
        }
    }

    public static void carregarProdutosDoBanco() throws SQLException {
        String query = "SELECT * FROM produto";
        listaProdutos.clear();

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int idProduto = resultSet.getInt("idproduto");
                int quantidade = resultSet.getInt("quantidade");
                double valorUnitario = resultSet.getDouble("valor_unitario");
                double subtotal = resultSet.getDouble("subtotal");
                String fabricante = resultSet.getString("fabricante");
                int vendaIdVenda = resultSet.getInt("venda_idvenda");
                int produtoIdProduto = resultSet.getInt("produto_idproduto");

                Produto_itens produto = new Produto_itens(idProduto, quantidade, valorUnitario, subtotal, fabricante, vendaIdVenda, produtoIdProduto);
                listaProdutos.add(produto);
            }
        }
    }
}
