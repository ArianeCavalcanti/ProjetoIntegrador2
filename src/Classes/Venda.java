package Classes;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Venda {
    private int idVenda; 
    private final LocalDateTime dataVenda;
    private final String status;
    private final String tipoPagamento;
    private final String numeroCartao;
    private final String numeroParcelas;  
    private final int idCliente;
    private final int idFuncionario;
    private double valorTotal; 
    private final List<Produto_itens> produtosVendidos;

    // Construtor principal
    public Venda(int idVenda, LocalDateTime dataVenda, String status, String tipoPagamento, String numeroCartao, String numeroParcelas, int idCliente, int idFuncionario, double valorTotal) {
        this.idVenda = idVenda;
        this.dataVenda = dataVenda;
        this.status = status;
        this.tipoPagamento = tipoPagamento;
        this.numeroCartao = numeroCartao;
        this.numeroParcelas = numeroParcelas;  
        this.idCliente = idCliente;
        this.idFuncionario = idFuncionario;
        this.valorTotal = valorTotal;
        this.produtosVendidos = new ArrayList<>();
    }

    // Construtor alternativo (atualmente não utilizado)
    Venda(int i, LocalDateTime dataHoraAtual, String status, String tipoPagamento, String numeroCartao, int numeroParcelas, int idCliente, int idFuncionario, double valorTotal) {
        throw new UnsupportedOperationException("Not supported yet."); // Gerado automaticamente
    }

    // Getters e Setters
    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public LocalDateTime getDataVenda() {
        return dataVenda;
    }

    public String getStatus() {
        return status;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public String getTipoPagamento() {
        return tipoPagamento;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public String getNumeroParcelas() {
        return numeroParcelas;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public List<Produto_itens> getProdutosVendidos() {
        return produtosVendidos;
    }

    // Adiciona produto à venda
    public void adicionarProduto(Produto_itens produtoVendido) {
        this.produtosVendidos.add(produtoVendido);
    }

    // Método para formatar o valor total
    public String getValorTotalFormatado() {
        return String.format("%.2f", valorTotal);
    }

    // Método para ajustar o valor total
    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    // Retorna os produtos vendidos (ou seja, a lista de produtos)
    public Iterable<Produto_itens> getProdutos_itens() {
        return produtosVendidos;
    }
}
