package Classes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DistribuidoraAgua {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Cliente> clientes = new ArrayList<>();
        List<Fornecedor> fornecedores = new ArrayList<>();
        List<Funcionario> funcionarios = new ArrayList<>();
        List<Produto_itens> produtos = new ArrayList<>();
        List<Venda> vendas = new ArrayList<>();
        List<Usuario> usuarios = new ArrayList<>();

        int opcao;
        do {
            System.out.println("\n=== Gerenciamento de Cadastros ===");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Cadastrar Fornecedor");
            System.out.println("3. Cadastrar Funcionario");
            System.out.println("4. Cadastrar Produto");
            System.out.println("5. Cadastrar Venda");
            System.out.println("6. Cadastrar Usuários");
            System.out.println("7. Listar Cadastros");
            System.out.println("8. Listar Vendas");
            System.out.println("9. Listar Clientes");
            System.out.println("10. Listar Funcionários");
            System.out.println("11. Listar Produtos");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            try {
                opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1 ->
                        cadastrarCliente(scanner, clientes);
                    case 2 ->
                        cadastrarFornecedor(scanner, fornecedores);
                    case 3 ->
                        cadastrarFuncionario(scanner, funcionarios);
                    case 4 ->
                        cadastrarProduto(scanner, produtos);
                    case 5 ->
                        cadastrarVenda(scanner, vendas, clientes, funcionarios, produtos);
                    case 6 ->
                        cadastrarUsuario(scanner, usuarios);
                    case 7 ->
                        listarCadastros(clientes, fornecedores, funcionarios, produtos);
                    case 8 ->
                        listarVendas(vendas);
                    case 9 ->
                        listarClientes(clientes);
                    case 10 ->
                        listarFuncionarios(funcionarios);
                    case 11 ->
                        listarProdutos(produtos);
                    case 0 ->
                        System.out.println("Saindo...");
                    default ->
                        System.out.println("Opção inválida! Por favor, escolha uma opção válida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, insira um número correspondente à opção do menu.");
                scanner.next();
                opcao = -1;
            }
        } while (opcao != 0);

        scanner.close();
    }

    private static void cadastrarCliente(Scanner scanner, List<Cliente> clientes) {
        System.out.println("=== Cadastro de Cliente ===");
        System.out.print("Nome do cliente: ");
        String nomeCliente = scanner.nextLine();
        System.out.print("Número do CPF: ");
        String numeroCpf = scanner.nextLine();
        System.out.print("Número do Rg: ");
        String numeroRg = scanner.nextLine();
        System.out.print("Número do Telefone Fixo: ");
        String numeroTelefoneFixo = scanner.nextLine();
        System.out.print("Número do Celular: ");
        String numeroCelular = scanner.nextLine();
        System.out.print("Email do cliente: ");
        String emailCliente = scanner.nextLine();
        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();
        System.out.print("Bairro: ");
        String bairro = scanner.nextLine();
        System.out.print("CEP: ");
        String cep = scanner.nextLine();
        System.out.print("Cidade: ");
        String cidade = scanner.nextLine();
        System.out.print("IdNome: ");
        int idCliente = scanner.nextInt();
        System.out.print("IdEndereco: ");

        Cliente novoCliente = new Cliente(idCliente, nomeCliente, numeroCpf, numeroRg, numeroTelefoneFixo, numeroCelular, emailCliente, endereco, bairro, cep, cidade);
        clientes.add(novoCliente);
        System.out.println("Cliente cadastrado com sucesso!");
    }

    private static void cadastrarFornecedor(Scanner scanner, List<Fornecedor> fornecedores) {
        System.out.println("=== Cadastro de Fornecedores ===");
        System.out.print("Razão Social: ");
        String razaoSocial = scanner.nextLine();
        System.out.print("Número do CNPJ: ");
        String cnpj = scanner.nextLine();
        System.out.print("Número do Telefone Fixo: ");
        String telefoneFixo = scanner.nextLine();
        System.out.print("Número do Celular: ");
        String celular = scanner.nextLine();
        System.out.print("Email do cliente: ");
        String emailFornecedor = scanner.nextLine();
        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();
        System.out.print("Bairro: ");
        String bairro = scanner.nextLine();
        System.out.print("CEP: ");
        String cep = scanner.nextLine();
        System.out.print("Cidade: ");
        String cidade = scanner.nextLine();

        Fornecedor novoFornecedor;
        novoFornecedor = new Fornecedor(razaoSocial, cnpj, telefoneFixo, celular, emailFornecedor, endereco, bairro, cep, cidade);
        fornecedores.add(novoFornecedor);
        System.out.println("fornecedor cadastrado com sucesso!");
    }

    private static void cadastrarFuncionario(Scanner scanner, List<Funcionario> funcionarios) {
        System.out.println("=== Cadastro de Funcionário ===");

        // Gera um novo ID para o funcionário baseado na quantidade atual de funcionários
        int idFuncionario = funcionarios.size() + 1;

        System.out.print("Nome do funcionário: ");
        String nome = scanner.nextLine();

        System.out.print("Data de nascimento do funcionário (dd/MM/yyyy): ");
        String dataNascimentoStr = scanner.nextLine();
        Date dataNascimento = null;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            dataNascimento = dateFormat.parse(dataNascimentoStr);
        } catch (ParseException e) {
            System.out.println("Data de nascimento inválida. Use o formato dd/MM/yyyy.");
            return;
        }

        System.out.print("CPF do funcionário: ");
        String cpf = scanner.nextLine();

        System.out.print("RG do funcionário: ");
        String rg = scanner.nextLine();

        System.out.print("Telefone fixo do funcionário: ");
        String telefoneFixo = scanner.nextLine();

        System.out.print("Celular do funcionário: ");
        String celular = scanner.nextLine();

        System.out.print("Email do funcionário: ");
        String email = scanner.nextLine();

        System.out.print("Endereço do funcionário: ");
        String endereco = scanner.nextLine();

        System.out.print("Bairro do funcionário: ");
        String bairro = scanner.nextLine();

        System.out.print("CEP do funcionário: ");
        String cep = scanner.nextLine();

        System.out.print("Cidade do funcionário: ");
        String cidade = scanner.nextLine();

        System.out.print("ID do Usuário: ");
        int idUsuario = scanner.nextInt();
        scanner.nextLine(); // Consome a nova linha deixada por nextInt()

        // Cria uma nova instância de Funcionario com o ID gerado e todos os parâmetros
        Funcionario novoFuncionario = new Funcionario(idFuncionario, nome, dataNascimento, cpf, rg, endereco, bairro, cep, cidade, telefoneFixo, celular, email, idUsuario);
        funcionarios.add(novoFuncionario);
        System.out.println("Funcionário cadastrado com sucesso!");
    }

    private static void cadastrarProduto(Scanner scanner, List<Produto_itens> produtos) {
        System.out.println("=== Cadastro de Produto ===");

        System.out.print("Nome do produto: ");
        String nomeProduto = scanner.nextLine();
        System.out.print("Valor unitário do produto: ");
        double valorUnitario = scanner.nextDouble();
        System.out.print("Quantidade em estoque: ");
        int quantidadeEstoque = scanner.nextInt();
        scanner.nextLine();

        // Criando um novo objeto Produto_itens com todos os parâmetros necessários
        Produto_itens novoProduto = new Produto_itens(nomeProduto, valorUnitario, quantidadeEstoque);

        // Adicionando o novo produto à lista
        produtos.add(novoProduto);

        System.out.println("Produto cadastrado com sucesso!");
    }

    private static void cadastrarVenda(Scanner scanner, List<Venda> vendas, List<Cliente> clientes, List<Funcionario> funcionarios, List<Produto_itens> produtos) {

        System.out.println("=== Cadastro de Venda ===");

        // Data e Hora da Venda
        LocalDateTime dataHoraAtual = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String dataHoraFormatada = dataHoraAtual.format(formatter);
        System.out.println("Data e Hora da Venda: " + dataHoraFormatada);

        // Status da Venda
        System.out.print("Status: ");
        String status = scanner.nextLine();

        double valorTotal = 0.0; // O valor total será calculado mais tarde

        // Tipo de Pagamento
        System.out.print("Tipo de Pagamento: ");
        String tipoPagamento = scanner.nextLine();

        // Número do Cartão
        System.out.print("Número de Cartão: ");
        String numeroCartao = scanner.nextLine();

        // Número de Parcelas
        System.out.print("Número de Parcelas: ");
        int numeroParcelas;
        while (true) {
            try {
                numeroParcelas = Integer.parseInt(scanner.nextLine());
                break; // Saímos do loop se a conversão foi bem-sucedida
            } catch (NumberFormatException e) {
                System.out.print("Número de Parcelas inválido. Digite um número válido: ");
            }
        }

        // ID do Cliente
        System.out.print("ID do Cliente: ");
        int idCliente = scanner.nextInt();
        scanner.nextLine(); // Consome o caractere de nova linha

        // ID do Funcionário
        System.out.print("ID do Funcionário: ");
        int idFuncionario = scanner.nextInt();
        scanner.nextLine(); // Consome o caractere de nova linha

        // Verifica se o cliente e o funcionário existem nas listas
        Cliente clienteSelecionado = clientes.stream().filter(c -> c.getIdCliente() == idCliente).findFirst().orElse(null);
        Funcionario funcionarioSelecionado = funcionarios.stream().filter(f -> f.getIdFuncionario() == idFuncionario).findFirst().orElse(null);

        if (clienteSelecionado == null) {
            System.out.println("Cliente não encontrado!");
            return;
        }
        if (funcionarioSelecionado == null) {
            System.out.println("Funcionário não encontrado!");
            return;
        }

        // Cria um objeto Venda com as informações fornecidas pelo usuário
        Venda novaVenda = new Venda(
                vendas.size() + 1, // ID gerado automaticamente
                dataHoraAtual,
                status,
                tipoPagamento,
                numeroCartao,
                numeroParcelas,
                idCliente,
                idFuncionario,
                valorTotal
        );

        System.out.println("Adicione os produtos vendidos:");

        boolean adicionandoProdutos = true;
        while (adicionandoProdutos) {
            System.out.println("Produtos disponíveis:");
            for (int i = 0; i < produtos.size(); i++) {
                Produto_itens produto = produtos.get(i);
                System.out.println((i + 1) + ". " + produto.getNomeProduto() + " - Quantidade em estoque: " + produto.getQuantidadeEstoque());
            }

            System.out.print("Selecione o número do produto para adicionar à venda (0 para terminar): ");
            int escolhaProduto = scanner.nextInt();
            scanner.nextLine(); // Consome o caractere de nova linha

            if (escolhaProduto == 0) {
                adicionandoProdutos = false;
            } else if (escolhaProduto > 0 && escolhaProduto <= produtos.size()) {
                Produto_itens produtoSelecionado = produtos.get(escolhaProduto - 1);

                System.out.print("Quantidade Vendida: ");
                int quantidadeVendida = scanner.nextInt();
                scanner.nextLine(); // Consome o caractere de nova linha

                // Verifica se a quantidade em estoque é suficiente para a venda
                if (quantidadeVendida > produtoSelecionado.getQuantidadeEstoque()) {
                    System.out.println("Quantidade em estoque insuficiente para este produto!");
                    continue;
                }

                // Atualiza a quantidade em estoque do produto
                produtoSelecionado.setQuantidadeEstoque(produtoSelecionado.getQuantidadeEstoque() - quantidadeVendida);

                // Adiciona o produto à lista de produtos da venda
                novaVenda.adicionarProduto(produtoSelecionado);

                // Atualiza o valor total da venda
                valorTotal += produtoSelecionado.getValorUnitario() * quantidadeVendida;

                // Exibe mensagem informando que o produto foi vendido
                System.out.println("Produto '" + produtoSelecionado.getNomeProduto() + "' vendido com sucesso!");

                // Atualiza a quantidade vendida do produto
                produtoSelecionado.setQuantidadeVendida(produtoSelecionado.getQuantidadeVendida() + quantidadeVendida);
            } else {
                System.out.println("Opção inválida!");
            }
        }

        // Atualiza o valor total da venda
        novaVenda.setValorTotal(valorTotal);

        // Adiciona a venda à lista de vendas
        vendas.add(novaVenda);

        System.out.println("Venda cadastrada com sucesso!");
    }

    private static void cadastrarUsuario(Scanner scanner, List<Usuario> usuarios) {
        System.out.println("Cadastro de novo usuário");

        System.out.print("Login: ");
        String login = scanner.nextLine();

        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        System.out.print("Tipo de usuário: ");
        String tipo = scanner.nextLine();

        Usuario novoUsuario = new Usuario(login, senha, tipo);
        usuarios.add(novoUsuario);

        System.out.println("Usuário cadastrado com sucesso!");
    }

    private static void listarClientes(List<Cliente> clientes) {
        System.out.println("=== Lista de Clientes ===");
        for (Cliente cliente : clientes) {

            System.out.println("Nome: " + cliente.getNome());
            System.out.println("CPF: " + cliente.getCpf());
            System.out.println("RG: " + cliente.getRg());
            System.out.println("Telefone Fixo: " + cliente.getTelefoneFixo());
            System.out.println("Celular: " + cliente.getCelular());
            System.out.println("Email: " + cliente.getEmail());
            System.out.println("Endereço: " + cliente.getEndereco());
            System.out.println("Bairro: " + cliente.getBairro());
            System.out.println("CEP: " + cliente.getCep());
            System.out.println("Cidade: " + cliente.getCidade());
            System.out.println();
        }
    }

    private static void listarFuncionarios(List<Funcionario> funcionarios) {
        System.out.println("=== Lista de Funcionários ===");
        for (Funcionario funcionario : funcionarios) {
            System.out.println("Nome: " + funcionario.getNome());
            System.out.println("CPF: " + funcionario.getCpf());
            System.out.println("RG: " + funcionario.getRg());
            System.out.println("Endereco: " + funcionario.getEndereco());
            System.out.println("Telefone Fixo: " + funcionario.getTelefoneFixo());
            System.out.println("Celular: " + funcionario.getCelular());
            System.out.println("Email: " + funcionario.getEmail());
            System.out.println();
        }
    }

    private static void listarProdutos(List<Produto_itens> produtos) {
        System.out.println("=== Lista de Produtos ===");
        for (Produto_itens produto : produtos) {
            System.out.println("Nome: " + produto.getNome());
            System.out.println("Valor Unitário: " + produto.getValorUnitario());
            System.out.println();
        }
    }

    private static void listarVendas(List<Venda> vendas) {
        System.out.println("\n=== Lista de Vendas ===");
        if (vendas.isEmpty()) {
            System.out.println("Não há vendas registradas.");
        } else {
            for (Venda venda : vendas) {

                System.out.println("Data da Venda: " + venda.getDataVenda());
                System.out.println("Status: " + venda.getStatus());
                System.out.println("Valor Total: " + venda.getValorTotal());
                System.out.println("Tipo de Pagamento: " + venda.getTipoPagamento());
                System.out.println("Número de Cartão: " + venda.getNumeroCartao());
                System.out.println("Número de Parcelas: " + venda.getNumeroParcelas());
                System.out.println("ID do Cliente: " + venda.getIdCliente());
                System.out.println("ID do Funcionário: " + venda.getIdFuncionario());
                System.out.println("Produtos Vendidos:");
                for (Produto_itens produto : venda.getProdutos_itens()) {
                    System.out.println("- Nome: " + produto.getNome() + ", Quantidade Vendida: " + produto.getQuantidadeVendida() + ", Quantidade em Estoque: " + produto.getQuantidadeEstoque());
                }
                System.out.println();
            }
        }
    }

    private static void listarCadastros(List<Cliente> clientes, List<Fornecedor> fornecedores, List<Funcionario> funcionarios, List<Produto_itens> produtos) {
        System.out.println("\n=== Lista de Cadastros ===");

        System.out.println("\nClientes:");
        for (Cliente cliente : clientes) {
            System.out.println("Nome: " + cliente.getNome());
            System.out.println("CPF: " + cliente.getCpf());
            System.out.println("RG: " + cliente.getRg());
            System.out.println("Endereço: " + cliente.getEndereco());
            System.out.println("Telefone Fixo: " + cliente.getTelefoneFixo());
            System.out.println("Celular: " + cliente.getCelular());
            System.out.println("Email: " + cliente.getEmail());
            System.out.println();
        }

        System.out.println("\nFornecedores:");
        for (Fornecedor fornecedor : fornecedores) {
            System.out.println("Razão Social: " + fornecedor.getRazaoSocial());

        }

        System.out.println("\nFuncionários:");
        for (Funcionario funcionario : funcionarios) {
            System.out.println("Nome: " + funcionario.getNome());
            System.out.println("CPF: " + funcionario.getCpf());
            System.out.println("RG: " + funcionario.getRg());
            System.out.println("Endereco: " + funcionario.getEndereco());
            System.out.println("Telefone Fixo: " + funcionario.getTelefoneFixo());
            System.out.println("Celular: " + funcionario.getCelular());
            System.out.println("Email: " + funcionario.getEmail());
            System.out.println();
        }

        System.out.println("\nProdutos:");
        for (Produto_itens produto : produtos) {
            System.out.println("Nome: " + produto.getNome());
            System.out.println("Valor Unitário: " + produto.getValorUnitario());
            System.out.println();

        }
    }

}
