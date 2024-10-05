package Classes;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Funcionario {
    private int idFuncionario;
    private String nome;
    private Date dataNascimento;
    private String cpf;
    private String rg;
    private String endereco;
    private String bairro;
    private String cep;
    private String cidade;
    private String telefoneFixo;
    private String celular;
    private String email;
    private String senha;
    private int idUsuario;

    // Construtor com todos os atributos
    public Funcionario(int idFuncionario, String nome, Date dataNascimento, String cpf, String rg, String endereco,
                       String bairro, String cep, String cidade, String telefoneFixo,
                       String celular, String email, int idUsuario) {
        this.idFuncionario = idFuncionario;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.rg = rg;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
        this.telefoneFixo = telefoneFixo;
        this.celular = celular;
        this.email = email;
        this.idUsuario = idUsuario;
    }

    // Construtor para login
    public Funcionario(int idFuncionario, String nome, String email, String senha) {
        this.idFuncionario = idFuncionario;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    // Construtor vazio
    public Funcionario() {
        // Construtor vazio
    }

    // Getters e Setters
    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getTelefoneFixo() {
        return telefoneFixo;
    }

    public void setTelefoneFixo(String telefoneFixo) {
        this.telefoneFixo = telefoneFixo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String dataFormatada = (dataNascimento != null) ? sdf.format(dataNascimento) : "Data não informada";

        return "Funcionario{" +
                "idFuncionario=" + idFuncionario +
                ", nome='" + nome + '\'' +
                ", dataNascimento=" + dataFormatada +
                ", CPF='" + cpf + '\'' +
                ", RG='" + rg + '\'' +
                ", telefoneFixo='" + telefoneFixo + '\'' +
                ", celular='" + celular + '\'' +
                ", email='" + email + '\'' +
                ", endereco='" + endereco + '\'' +
                ", bairro='" + bairro + '\'' +
                ", CEP='" + cep + '\'' +
                ", cidade='" + cidade + '\'' +
                ", idUsuario=" + idUsuario +
                '}';
    }

    // Classe FuncionarioService - Segue SRP
    public static class FuncionarioService {
        private static final List<Funcionario> funcionarios = new ArrayList<>();

        public static void registrarFuncionario(Funcionario novoFuncionario) {
            funcionarios.add(novoFuncionario);
            System.out.println("Funcionário cadastrado com sucesso!");
        }

        public static List<Funcionario> listarTodos() {
            return new ArrayList<>(funcionarios);
        }
    }
}
