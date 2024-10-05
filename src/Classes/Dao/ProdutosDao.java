package Classes.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProdutosDao {

    private final String url = "jdbc:mysql://localhost:3306/distribuidora_de_agua";
    private final String user = "root";
    private final String password = "T#7aB3$0m2@i";

    // Método para excluir um produto_itens pelo seu ID
   public boolean excluirProdutoItens(int produtoItensId) throws SQLException {
    Connection connection = null;
    boolean sucesso = false;

    try {
        connection = DriverManager.getConnection(url, user, password);
        connection.setAutoCommit(false);

        // 1. Excluir o registro da tabela produto_itens com o ID específico
        String sqlExcluirProdutoItens = "DELETE FROM produto_itens WHERE idproduto_itens = ?";
        try (PreparedStatement statementExcluirProdutoItens = connection.prepareStatement(sqlExcluirProdutoItens)) {
            statementExcluirProdutoItens.setInt(1, produtoItensId);
            int affectedRows = statementExcluirProdutoItens.executeUpdate();

            // Verifica se o registro foi realmente excluído
            if (affectedRows == 0) {
                throw new SQLException("Nenhum registro encontrado para o ID fornecido.");
            }
        }

        // 2. Atualizar o valor total da venda (somar os subtotais restantes após a exclusão)
        String sqlAtualizarVenda = "UPDATE venda SET valor_total = (SELECT SUM(subtotal) FROM produto_itens WHERE venda_idvenda = venda.idvenda) WHERE idvenda = (SELECT venda_idvenda FROM produto_itens WHERE idproduto_itens = ?)";
        try (PreparedStatement statementAtualizarVenda = connection.prepareStatement(sqlAtualizarVenda)) {
            statementAtualizarVenda.setInt(1, produtoItensId);
            statementAtualizarVenda.executeUpdate();
        }

        // 3. Obter o ID do produto e a quantidade para atualizar o estoque
        String sqlObterProdutoId = "SELECT produto_idproduto, quantidade FROM produto_itens WHERE idproduto_itens = ?";
        int produtoId = -1;
        int quantidadeVendida = 0;
        try (PreparedStatement statementObterProdutoId = connection.prepareStatement(sqlObterProdutoId)) {
            statementObterProdutoId.setInt(1, produtoItensId);
            try (ResultSet rs = statementObterProdutoId.executeQuery()) {
                if (rs.next()) {
                    produtoId = rs.getInt("produto_idproduto");
                    quantidadeVendida = rs.getInt("quantidade");
                }
            }
        }

        // 4. Atualizar o estoque do produto (restaurar a quantidade excluída)
        if (produtoId != -1) {
            String sqlAtualizarEstoque = "UPDATE produto SET estoque = estoque + ? WHERE idproduto = ?";
            try (PreparedStatement statementAtualizarEstoque = connection.prepareStatement(sqlAtualizarEstoque)) {
                statementAtualizarEstoque.setInt(1, quantidadeVendida);
                statementAtualizarEstoque.setInt(2, produtoId);
                statementAtualizarEstoque.executeUpdate();
            }
        }

        // Confirmar a transação
        connection.commit();
        sucesso = true;

    } catch (SQLException ex) {
        if (connection != null) {
            connection.rollback(); // Reverter a transação em caso de erro
        }
        throw ex;
    } finally {
        if (connection != null) {
            connection.setAutoCommit(true);
            connection.close();
        }
    }
    return sucesso;
}
}