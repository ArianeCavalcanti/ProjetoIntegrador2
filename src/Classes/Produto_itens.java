package Classes;

import javax.swing.JComboBox;

public class Produto_itens {

    private int idProduto;
    private int idProdutoItens;
    private int idVenda;
    private int quantidade;
    private double valorUnitario;
    private double subtotal;
    private String nomeProduto;
    private String fabricante;
    private String dataVencimento;
    private int quantidadeEstoque;
    private int quantidadeVendida;

    // Construtor com todos os parâmetros necessários
    public Produto_itens(int idProduto, int quantidade, double valorUnitario, double subtotal, String fabricante, int idVenda, int idProdutoItens) {
        this.idProduto = idProduto;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
        this.subtotal = subtotal;
        this.fabricante = fabricante;
        this.idVenda = idVenda;
        this.idProdutoItens = idProdutoItens;
    }

    // Construtor com nome do produto, valor unitário e quantidade em estoque
    public Produto_itens(String nomeProduto, double valorUnitario, int quantidadeEstoque) {
        this.nomeProduto = nomeProduto;
        this.valorUnitario = valorUnitario;
        this.quantidadeEstoque = quantidadeEstoque;
        this.quantidadeVendida = 0; // Inicialmente, a quantidade vendida é 0
    }

    // Construtor padrão
    public Produto_itens() {
        this.idProduto = 0;
        this.idProdutoItens = 0;
        this.idVenda = 0;
        this.quantidade = 0;
        this.valorUnitario = 0.0;
        this.subtotal = 0.0;
        this.nomeProduto = "";
        this.fabricante = "";
        this.dataVencimento = "";
        this.quantidadeEstoque = 0;
        this.quantidadeVendida = 0;
    }

    public String getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(String dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public String getNome() {
        return this.nomeProduto;
    }

    // Getters e Setters
    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getIdProdutoItens() {
        return idProdutoItens;
    }

    public void setIdProdutoItens(int idProdutoItens) {
        this.idProdutoItens = idProdutoItens;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public int getQuantidadeVendida() {
        return quantidadeVendida;
    }

    public void setQuantidadeVendida(int quantidadeVendida) {
        this.quantidadeVendida = quantidadeVendida;
    }

    // Métodos de controle de estoque
    public void adicionarEstoque(int quantidade) {
        this.quantidadeEstoque += quantidade;
    }

    public void removerEstoque(int quantidade) throws IllegalArgumentException {
        if (this.quantidadeEstoque >= quantidade) {
            this.quantidadeEstoque -= quantidade;
        } else {
            throw new IllegalArgumentException("Quantidade em estoque insuficiente!");
        }
    }

    public void exibirEstoque() {
        System.out.println("Quantidade em estoque de " + nomeProduto + ": " + quantidadeEstoque);
    }

    public double calcularSubTotal() {
        return this.valorUnitario * this.quantidade;
    }

    // Método para obter o item selecionado do JComboBox de nome do produto
    public String getSelectedNomeProduto(JComboBox<String> comboBox) {
        if (comboBox != null && comboBox.getSelectedItem() != null) {
            return comboBox.getSelectedItem().toString();
        } else {
            return null;
        }
    }

    // Método para obter o item selecionado do JComboBox de fabricante
    public String getSelectedFabricante(JComboBox<String> comboBox) {
        if (comboBox != null && comboBox.getSelectedItem() != null) {
            return comboBox.getSelectedItem().toString();
        } else {
            return null;
        }
    }
}
