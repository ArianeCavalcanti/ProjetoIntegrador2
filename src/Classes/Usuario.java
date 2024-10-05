package Classes;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Usuario implements Autenticavel {
    
    private int idUsuario;
    private String senha; 
    private String tipo;
    private String login;
    private String senhaHash; // Armazena a senha como hash MD5

    // Construtor principal
    public Usuario(int idUsuario, String login, String senha, String tipo) {
        this.idUsuario = idUsuario;
        this.login = login;
        this.senha = senha;
        this.senhaHash = hashSenha(senha); // Salva a senha como hash MD5
        this.tipo = tipo;
    }

    // Este construtor permite criar um usuário com uma senha já criptografada
    public Usuario(int idUsuario, String login, String senhaHash, String tipo, boolean isHash) {
        this.idUsuario = idUsuario;
        this.login = login;
        this.tipo = tipo;
        if (isHash) {
            this.senhaHash = senhaHash;
        } else {
            this.senha = senha;
            this.senhaHash = hashSenha(senha);
        }
    }

    // Construtor adicional sem ID, caso seja necessário (por exemplo, antes de inserir no banco de dados)
    public Usuario(String login, String senha, String tipo) {
        this(0, login, senha, tipo); // O ID é 0, pois ainda não foi definido
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getSenhaHash() {
        return senhaHash;
    }

    @Override
    public boolean autenticar(String senha) {
        // Verifica se a senha fornecida corresponde ao hash armazenado
        return this.senhaHash.equals(hashSenha(senha));
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
        this.senhaHash = hashSenha(senha); // Atualiza o hash da senha sempre que a senha for alterada
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    // Método privado para calcular o hash MD5 da senha
    private String hashSenha(String senha) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(senha.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);
            String hashText = no.toString(16);
            while (hashText.length() < 32) {
                hashText = "0" + hashText;
            }
            return hashText;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}

interface Autenticavel {

    boolean autenticar(String senha);
}