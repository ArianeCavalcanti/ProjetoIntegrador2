package Classes.Dao;

import Classes.Cliente;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteDao {

    private Connection conn;
    private PreparedStatement st;
    private ResultSet rs;

    private static final String DB_URL = "jdbc:mysql://localhost:3306/distribuidora_de_agua";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "T#7aB3$0m2@i";  

    public boolean conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Erro ao conectar: " + ex.getMessage());
            return false;
        }
    }

    public int cadastrar(Cliente cliente) {
        int status;
        try {
            String sql = "INSERT INTO Cliente (nome, cpf, rg, telefone_fixo, celular, email, endereco, bairro, cep, cidade) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            st = conn.prepareStatement(sql);
            st.setString(1, cliente.getNome());
            st.setString(2, cliente.getCpf());
            st.setString(3, cliente.getRg());
            st.setString(4, cliente.getTelefoneFixo());
            st.setString(5, cliente.getCelular());
            st.setString(6, cliente.getEmail());
            st.setString(7, cliente.getEndereco()); 
            st.setString(8, cliente.getBairro());
            st.setString(9, cliente.getCep());
            st.setString(10, cliente.getCidade());

            status = st.executeUpdate();
            return status;
        } catch (SQLException ex) {
            System.out.println("Erro ao executar cadastro: " + ex.getMessage());
            return ex.getErrorCode();
        }
    }

    public Cliente pesquisarPorNome(String nome) {
        Cliente cliente = null;
        try {
            String sql = "SELECT * FROM Cliente WHERE nome LIKE ?";
            st = conn.prepareStatement(sql);
            st.setString(1, "%" + nome + "%");
            rs = st.executeQuery();

            if (rs.next()) {
                cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setRg(rs.getString("rg"));
                cliente.setTelefoneFixo(rs.getString("telefone_fixo"));
                cliente.setCelular(rs.getString("celular"));
                cliente.setEmail(rs.getString("email"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setBairro(rs.getString("bairro"));
                cliente.setCep(rs.getString("cep"));
                cliente.setCidade(rs.getString("cidade"));
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao pesquisar cliente: " + ex.getMessage());
        }
        return cliente;
    }

    public int excluirPorId(int id) {
        int status;
        try {
            String sql = "DELETE FROM Cliente WHERE id = ?";
            st = conn.prepareStatement(sql);
            st.setInt(1, id);

            status = st.executeUpdate();
            return status;
        } catch (SQLException ex) {
            System.out.println("Erro ao excluir cliente: " + ex.getMessage());
            return ex.getErrorCode();
        }
    }

    public void desconectar() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao desconectar: " + ex.getMessage());
        }
    }
}
