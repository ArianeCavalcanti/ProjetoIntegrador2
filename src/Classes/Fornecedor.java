package Classes;

import java.util.ArrayList;
import java.util.List;

public class Fornecedor {

    private static final List<Fornecedor> fornecedores = new ArrayList<>();

    public static void registrarFornecedor(Fornecedor novoFornecedor) {
        fornecedores.add(novoFornecedor);
        System.out.println("Fornecedor cadastrado com sucesso!");
    }

    public static List<Fornecedor> listarTodos() {
        return new ArrayList<>(fornecedores);
    }

    private int idFornecedor;  
    private String razaoSocial;
    private String cnpj;
    private String telefoneFixo;
    private String celular;
    private String email;
    private String endereco;
    private String bairro;
    private String cep;
    private String cidade;

    // Construtor padrão
    public Fornecedor() {
        this.idFornecedor = 0;  
        this.razaoSocial = "";
        this.cnpj = "";
        this.telefoneFixo = "";
        this.celular = "";
        this.email = "";
        this.endereco = "";
        this.bairro = "";
        this.cep = "";
        this.cidade = "";
    }

    // Construtor parametrizado
    public Fornecedor(int idFornecedor, String razaoSocial, String cnpj, String telefoneFixo, String celular, String email,
                      String endereco, String bairro, String cep, String cidade) {

        this.idFornecedor = idFornecedor;  
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.telefoneFixo = telefoneFixo;
        this.celular = celular;
        this.email = email;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
    }

    // Construtor alternativo
    public Fornecedor(String razaoSocial, String cnpj, String telefoneFixo, String celular, String email,
                      String endereco, String bairro, String cep, String cidade) {
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.telefoneFixo = telefoneFixo;
        this.celular = celular;
        this.email = email;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
    }

    // Getters e Setters
    public int getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(int idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
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

    @Override
    public String toString() {
        return "Fornecedor{" +
                "idFornecedor=" + idFornecedor +  
                ", razaoSocial='" + razaoSocial + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", telefoneFixo='" + telefoneFixo + '\'' +
                ", celular='" + celular + '\'' +
                ", email='" + email + '\'' +
                ", endereco='" + endereco + '\'' +
                ", bairro='" + bairro + '\'' +
                ", cep='" + cep + '\'' +
                ", cidade='" + cidade + '\'' +
                '}';
    }

 
}
