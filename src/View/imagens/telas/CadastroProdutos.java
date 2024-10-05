package View.imagens.telas;

import Classes.Dao.ProdutosDao;
import Classes.Produto_itens;
import Conexao.ConexaoDb;
import java.sql.Statement;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

public class CadastroProdutos extends javax.swing.JFrame {

    private final String[] tableColumns = {"ID Produto", "ID Produto Itens", "ID Venda", "Nome Produto", "Fabricante", "Data de Vencimento", "Estoque", "Quantidade Vendida", "Valor Unitário", "SubTotal"};
    DefaultTableModel tableModel = new DefaultTableModel(tableColumns, 0);
    private final ArrayList<Produto_itens> ListaProduto = new ArrayList<>();
    private final String url = "jdbc:mysql://localhost:3306/distribuidora_de_agua";
    private final String user = "root";
    private final String password = "T#7aB3$0m2@i";

    public CadastroProdutos() {
        initComponents();
        setupListeners();
        geraAcessibilidade();
        gerarIdsAutomaticos();
        setTitle("Cadastro de Produtos");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Carregar os dados do banco de dados para a tabela
        loadData();
    }

    private void geraAcessibilidade() {
        jButtonSalvar.setMnemonic(KeyEvent.VK_S);
        jButtonLimpar.setMnemonic(KeyEvent.VK_L);
        jButtonPesquisar.setMnemonic(KeyEvent.VK_P);
        jButtonExcluir.setMnemonic(KeyEvent.VK_E);
        jButtonVoltar.setMnemonic(KeyEvent.VK_V);

        jButtonSalvar.setToolTipText("Salvar (Alt+S)");
        jButtonLimpar.setToolTipText("Limpar (Alt+L)");
        jButtonPesquisar.setToolTipText("Pesquisar (Alt+P)");
        jButtonExcluir.setToolTipText("Excluir (Alt+E)");
        jButtonVoltar.setToolTipText("Sair (Alt+V)");

        jTextIdProdutos.setToolTipText("Insira o ID do Produto");
        jTextIdProdutoItens.setToolTipText("Insira o ID Produto Itens");
        jTextIdVenda.setToolTipText("Insira o ID da Venda");
        jComboBoxNomeProduto.setToolTipText("Insira o nome do Produto");
        jComboBoxFabricante.setToolTipText("Insira o nome do Fabricante");
        jTextDataVencimento.setToolTipText("Insira a Data de Vencimento");
        jTextEstoque.setToolTipText("Insira a quantidade de estoque");
        jTextQuantidadeVendida.setToolTipText("Insira a quantidade Vendida");
        jTextValorUnitario.setToolTipText("Insira o Valor Unitário");
        jTextSubTotal.setToolTipText("SubTotal");

        jTextIdProdutos.setNextFocusableComponent(jTextIdProdutoItens);
        jTextIdProdutoItens.setNextFocusableComponent(jTextIdVenda);
        jTextIdVenda.setNextFocusableComponent(jComboBoxNomeProduto);
        jComboBoxNomeProduto.setNextFocusableComponent(jComboBoxFabricante);
        jComboBoxFabricante.setNextFocusableComponent(jTextDataVencimento);
        jTextDataVencimento.setNextFocusableComponent(jTextEstoque);
        jTextEstoque.setNextFocusableComponent(jTextQuantidadeVendida);
        jTextQuantidadeVendida.setNextFocusableComponent(jTextValorUnitario);
        jTextValorUnitario.setNextFocusableComponent(jButtonSalvar);
        jButtonSalvar.setNextFocusableComponent(jButtonLimpar);
        jButtonLimpar.setNextFocusableComponent(jButtonPesquisar);
        jButtonPesquisar.setNextFocusableComponent(jButtonExcluir);
        jButtonExcluir.setNextFocusableComponent(jButtonVoltar);
    }

    private void setupListeners() {
        jTextValorUnitario.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateSubTotal();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateSubTotal();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateSubTotal();
            }
        });

        jTextQuantidadeVendida.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateSubTotal();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateSubTotal();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateSubTotal();
            }
        });
    }

    private void updateSubTotal() {
        try {
            double valorUnitario = Double.parseDouble(jTextValorUnitario.getText());
            int quantidadeVendida = Integer.parseInt(jTextQuantidadeVendida.getText());
            double subTotal = valorUnitario * quantidadeVendida;
            jTextSubTotal.setText(String.valueOf(subTotal));
        } catch (NumberFormatException e) {
            jTextSubTotal.setText("");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextDataVencimento = new javax.swing.JTextField();
        jTextIdProdutos = new javax.swing.JTextField();
        jTextEstoque = new javax.swing.JTextField();
        jTextValorUnitario = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextIdProdutoItens = new javax.swing.JTextField();
        jTextIdVenda = new javax.swing.JTextField();
        jTextQuantidadeVendida = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTextSubTotal = new javax.swing.JTextField();
        jComboBoxNomeProduto = new javax.swing.JComboBox<>();
        jComboBoxFabricante = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableProdutos = new javax.swing.JTable();
        jButtonSalvar = new javax.swing.JButton();
        jButtonLimpar = new javax.swing.JButton();
        jButtonPesquisar = new javax.swing.JButton();
        jButtonVoltar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cadastro de Produtos", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 18), new java.awt.Color(51, 102, 255))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados  dos Produtos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Rounded MT Bold", 0, 14), new java.awt.Color(255, 51, 51))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel2.setText("Nome Produto:");

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel3.setText("Data Vencimento:");

        jLabel4.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel4.setText("ID Produto:");

        jLabel7.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel7.setText("Estoque:");

        jLabel9.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel9.setText("Valor Unitário:");

        jLabel11.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel11.setText("Fabricante:");

        jTextDataVencimento.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTextDataVencimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextDataVencimentoActionPerformed(evt);
            }
        });

        jTextIdProdutos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jTextEstoque.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jTextValorUnitario.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTextValorUnitario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextValorUnitarioActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel5.setText("Quantidade Vendida:");

        jLabel6.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel6.setText("ID Produto Itens:");

        jLabel8.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel8.setText("ID Venda:");

        jTextIdProdutoItens.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jTextIdVenda.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jTextQuantidadeVendida.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 51, 204));
        jLabel12.setText("SubTotal:");

        jTextSubTotal.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jComboBoxNomeProduto.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jComboBoxNomeProduto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione a opção", "Água Mineral Galão 20L", "Água Mineral Garrafa 500Ml", " " }));
        jComboBoxNomeProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxNomeProdutoActionPerformed(evt);
            }
        });

        jComboBoxFabricante.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jComboBoxFabricante.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione a opção", "Bonafont", "Crystal", "Lindoya" }));
        jComboBoxFabricante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxFabricanteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(4, 4, 4)
                                .addComponent(jTextIdProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel6)
                                .addGap(20, 20, 20)
                                .addComponent(jTextIdProdutoItens, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextEstoque)
                                    .addComponent(jTextQuantidadeVendida)
                                    .addComponent(jTextDataVencimento)
                                    .addComponent(jTextValorUnitario)
                                    .addComponent(jComboBoxNomeProduto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextIdVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBoxFabricante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(170, 170, 170))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(jTextIdProdutoItens, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jTextIdProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextIdVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel11)
                    .addComponent(jComboBoxNomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxFabricante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextDataVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextQuantidadeVendida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTextValorUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jTextSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 60, 780, 360));

        jTableProdutos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTableProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Produto ", "ID Produto Itens", "ID Venda", "Nome Produto", "Fabricante", "Data de Vencimento", "Estoque", "Quantidade Vendida", "Valor Unitário", "SubTotal"
            }
        ));
        jScrollPane2.setViewportView(jTableProdutos);

        jTabbedPane1.addTab("Produtos", jScrollPane2);

        jScrollPane1.setViewportView(jTabbedPane1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 470, 1250, 330));

        jButtonSalvar.setBackground(new java.awt.Color(226, 218, 218));
        jButtonSalvar.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jButtonSalvar.setForeground(new java.awt.Color(41, 83, 241));
        jButtonSalvar.setText("Salvar");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 430, 140, 30));

        jButtonLimpar.setBackground(new java.awt.Color(226, 218, 218));
        jButtonLimpar.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jButtonLimpar.setForeground(new java.awt.Color(41, 83, 241));
        jButtonLimpar.setText("Limpar");
        jButtonLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimparActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonLimpar, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 430, 120, 30));

        jButtonPesquisar.setBackground(new java.awt.Color(226, 218, 218));
        jButtonPesquisar.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jButtonPesquisar.setForeground(new java.awt.Color(41, 83, 241));
        jButtonPesquisar.setText("Pesquisar");
        jButtonPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonPesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 430, 140, 30));

        jButtonVoltar.setBackground(new java.awt.Color(226, 218, 218));
        jButtonVoltar.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jButtonVoltar.setForeground(new java.awt.Color(41, 83, 241));
        jButtonVoltar.setText("Voltar");
        jButtonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonVoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 430, 130, 30));

        jButtonExcluir.setBackground(new java.awt.Color(226, 218, 218));
        jButtonExcluir.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jButtonExcluir.setForeground(new java.awt.Color(41, 83, 241));
        jButtonExcluir.setText("Excluir");
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 430, 130, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/imagens/telas/fundo de tela.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 1280, 790));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 845, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarActionPerformed
        // Exibe uma caixa de diálogo para o usuário digitar o nome do fabricante
        String filtroFabricante = JOptionPane.showInputDialog(null, "Digite o nome do Fabricante que deseja pesquisar:");

        if (filtroFabricante != null && !filtroFabricante.trim().isEmpty()) {
            try {
                // Conexão com o banco de dados
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/distribuidora_de_agua", "root", "T#7aB3$0m2@i");

                // Preparar a consulta SQL para buscar produtos pelo fabricante
                String sql = "SELECT pi.idproduto_itens, pi.quantidade, pi.valor_unitario, pi.subtotal, pi.venda_idvenda, "
                        + "p.idproduto, p.nome, p.data_vencimento, p.estoque, p.fabricante "
                        + "FROM produto_itens pi "
                        + "JOIN produto p ON pi.produto_idproduto = p.idproduto "
                        + "WHERE p.fabricante LIKE ?";

                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, "%" + filtroFabricante.trim() + "%");  // Usar LIKE para buscar parcialmente

                ResultSet rs = ps.executeQuery();

                // Obter o modelo da tabela para preencher os dados
                DefaultTableModel model = (DefaultTableModel) jTableProdutos.getModel();
                model.setRowCount(0);  // Limpa a tabela antes de adicionar os novos dados

                if (!rs.next()) {  // Verifica se o ResultSet está vazio
                    JOptionPane.showMessageDialog(null, "Nenhum produto encontrado para o fabricante informado!");
                } else {
                    // Se houver resultados, adicionar ao modelo da tabela
                    do {
                        Object[] rowData = new Object[10];
                        rowData[0] = rs.getInt("idproduto");          // ID Produto
                        rowData[1] = rs.getInt("idproduto_itens");    // ID Produto Itens
                        rowData[2] = rs.getInt("venda_idvenda");      // ID Venda
                        rowData[3] = rs.getString("nome");            // Nome Produto
                        rowData[4] = rs.getString("fabricante");      // Fabricante
                        rowData[5] = rs.getDate("data_vencimento");   // Data de Vencimento
                        rowData[6] = rs.getInt("estoque");            // Estoque
                        rowData[7] = rs.getInt("quantidade");         // Quantidade
                        rowData[8] = rs.getDouble("valor_unitario");  // Valor Unitário
                        rowData[9] = rs.getDouble("subtotal");        // Subtotal

                        // Adicionar a linha ao modelo da tabela
                        model.addRow(rowData);
                    } while (rs.next());
                }

                // Fechar a consulta e a conexão
                ps.close();
                conn.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao buscar produtos: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, insira o nome de um fabricante para filtrar.");
        }
    }//GEN-LAST:event_jButtonPesquisarActionPerformed

    private void jTextDataVencimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextDataVencimentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextDataVencimentoActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed

        // Obter a linha selecionada na tabela
        int rowIndex = jTableProdutos.getSelectedRow();

        // Verificar se há uma linha selecionada
        if (rowIndex >= 0) {
            // Confirmar a exclusão
            String[] options = {"Sim", "Não"};
            int deletar = JOptionPane.showOptionDialog(
                    rootPane,
                    "Tem certeza que deseja excluir o registro?",
                    "Exclusão de Produto",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]
            );

            // Se o usuário confirmar a exclusão
            if (deletar == 0) {
                // Obter o ID do produto_itens da tabela
                String idString = jTableProdutos.getValueAt(rowIndex, 0).toString();
                int produtoItensId = Integer.parseInt(idString);

                ProdutosDao dao = new ProdutosDao();
                try {
                    // Chamar o método de exclusão
                    boolean sucesso = dao.excluirProdutoItens(produtoItensId);
                    if (sucesso) {
                        JOptionPane.showMessageDialog(rootPane, "Produto excluído com sucesso.");
                        // Atualizar a tabela para refletir a exclusão
                        atualizarTabela();
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(rootPane, "Erro ao excluir produto: " + ex.getMessage());
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Selecione um produto para excluir.");
        }

    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        // Verifica se todos os campos obrigatórios estão preenchidos
        if (!emptyFields()) {
            Produto_itens produto = getProduto();  // Obtenha o produto a partir dos campos
            if (produto != null) {
                try {
                    // Gera os IDs automáticos
                    int idProduto = gerarIdProduto();  // Gera o ID do produto
                    int idVenda = gerarIdVenda();  // Gera o ID da venda
                    String fabricante = produto.getFabricante();  // Obtenha o fabricante como String (pode alterar para ID se necessário)
                    int idProdutoItens = gerarIdProdutoItens();  // Gera o ID dos itens do produto

                    // Define os valores no objeto produto
                    produto.setIdProduto(idProduto);  // ID do produto
                    produto.setIdProdutoItens(idProdutoItens);  // ID dos itens do produto
                    produto.setIdVenda(idVenda);  // ID da venda
                    produto.setFabricante(fabricante);  // Nome do fabricante (ou ID se for o caso)

                    // Adiciona o produto à lista de produtos (se necessário)
                    ListaProduto.add(produto);

                    // Insere o produto no banco de dados
                    inserirProduto(produto);

                    // Salva os registros em arquivo, se necessário
                    salvarRegistrosEmArquivo("registros.csv");

                } catch (SQLException | IOException ex) {
                    Logger.getLogger(CadastroProdutos.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(this, "Erro ao salvar produto: " + ex.getMessage());
                } catch (ParseException ex) {
                    Logger.getLogger(CadastroProdutos.class.getName()).log(Level.SEVERE, null, ex);
                }

                // Atualiza os dados na tabela
                atualizarTabela();  // Atualiza a tabela após inserção
                // Limpa os campos 
                jTextIdProdutos.setText("");
                jTextIdProdutoItens.setText("");
                jTextIdVenda.setText("");
                jComboBoxNomeProduto.setSelectedIndex(0);
                jComboBoxFabricante.setSelectedIndex(0);
                jTextDataVencimento.setText("");
                jTextEstoque.setText("");
                jTextQuantidadeVendida.setText("");
                jTextValorUnitario.setText("");
                jTextSubTotal.setText("");

                jTextIdProdutos.requestFocus();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos obrigatórios.");
        }


    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimparActionPerformed

        jTextIdProdutos.setText("");
        jTextIdProdutoItens.setText("");
        jTextIdVenda.setText("");
        jComboBoxNomeProduto.setSelectedIndex(0);
        jComboBoxFabricante.setSelectedIndex(0);
        jTextDataVencimento.setText("");
        jTextEstoque.setText("");
        jTextQuantidadeVendida.setText("");
        jTextValorUnitario.setText("");
        jTextSubTotal.setText("");

        jTextIdProdutos.requestFocus();
    }//GEN-LAST:event_jButtonLimparActionPerformed

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoltarActionPerformed

        MenuPrincipal menuPrincipal = new MenuPrincipal();
        menuPrincipal.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_jButtonVoltarActionPerformed

    private void jTextValorUnitarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextValorUnitarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextValorUnitarioActionPerformed

    private void jComboBoxNomeProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxNomeProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxNomeProdutoActionPerformed

    private void jComboBoxFabricanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxFabricanteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxFabricanteActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new CadastroProdutos().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonLimpar;
    private javax.swing.JButton jButtonPesquisar;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JComboBox<String> jComboBoxFabricante;
    private javax.swing.JComboBox<String> jComboBoxNomeProduto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableProdutos;
    private javax.swing.JTextField jTextDataVencimento;
    private javax.swing.JTextField jTextEstoque;
    private javax.swing.JTextField jTextIdProdutoItens;
    private javax.swing.JTextField jTextIdProdutos;
    private javax.swing.JTextField jTextIdVenda;
    private javax.swing.JTextField jTextQuantidadeVendida;
    private javax.swing.JTextField jTextSubTotal;
    private javax.swing.JTextField jTextValorUnitario;
    // End of variables declaration//GEN-END:variables

    private boolean emptyFields() {
        if (jComboBoxNomeProduto.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "ATENÇÃO! Nome do Produto não pode ser vazio.");
            return true;

        } else if (jTextDataVencimento.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "ATENÇÃO! A Data de Vencimento não pode ser vazia.");
            return true;
        } else if (!validarDataVencimento(jTextDataVencimento.getText().trim())) {
            return true;  // Mensagem de erro já é exibida dentro do validarDataVencimento
        } else if (jTextEstoque.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "ATENÇÃO! O Estoque não pode ser vazio.");
            return true;
        } else if (jTextQuantidadeVendida.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "ATENÇÃO! A Quantidade vendida não pode ser vazia.");
            return true;
        } else if (jTextValorUnitario.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "ATENÇÃO! O Valor Unitário não pode ser vazio.");
            return true;
        } else if (jTextSubTotal.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "ATENÇÃO! SubTotal não pode ser vazio.");
            return true;
        } else {
            return false;
        }
    }

    private void loadData() {
        String query = "SELECT p.idproduto, pi.idproduto_itens, pi.venda_idvenda, p.nome, p.fabricante, p.data_vencimento, p.estoque, pi.quantidade, pi.valor_unitario, pi.subtotal "
                + "FROM produto p "
                + "JOIN produto_itens pi ON p.idproduto = pi.produto_idproduto";

        try ( Connection connection = DriverManager.getConnection(url, user, password);  PreparedStatement statement = connection.prepareStatement(query);  ResultSet resultSet = statement.executeQuery()) {

            tableModel.setRowCount(0);

            while (resultSet.next()) {
                Object[] rowData = {
                    resultSet.getInt("idproduto_itens"),
                    resultSet.getInt("idproduto"),
                    resultSet.getInt("venda_idvenda"),
                    resultSet.getString("nome"),
                    resultSet.getString("fabricante"),
                    resultSet.getString("data_vencimento"),
                    resultSet.getInt("estoque"),
                    resultSet.getInt("quantidade"),
                    resultSet.getDouble("valor_unitario"),
                    resultSet.getDouble("subtotal")
                };
                tableModel.addRow(rowData);
            }

            jTableProdutos.setModel(tableModel);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar os dados: " + ex.getMessage());
        }
    }

    private boolean validarValor(String valor) {
        try {
            Double.parseDouble(valor);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean validarNumInteiro(String valor) {
        try {
            Integer.parseInt(valor);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private double parseValor(String valor) {
        // Remove pontos e substitui vírgula por ponto
        String valorAjustado = valor.replace(".", "").replace(",", ".");
        return Double.parseDouble(valorAjustado);
    }

    private boolean validarDataVencimento(String data) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        try {
            sdf.parse(data);
            return true;
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "ATENÇÃO! A Data de Vencimento está em um formato inválido.");
            return false;
        }
    }

    private void gerarIdsAutomaticos() {
        try {
            int idProduto = gerarIdProduto(); // Gera o ID do produto
            jTextIdProdutos.setText(String.valueOf(idProduto)); // Preenche o campo do ID do produto

            int idProdutoItens = gerarIdProdutoItens(); // Gera o ID do item do produto
            jTextIdProdutoItens.setText(String.valueOf(idProdutoItens)); // Preenche o campo do ID do item do produto

            int idVenda = gerarIdVenda(); // Gera o ID da venda
            jTextIdVenda.setText(String.valueOf(idVenda)); // Preenche o campo do ID da venda
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Erro ao gerar IDs automáticos: " + e.getMessage());
        }
    }

    private int gerarIdVenda() throws SQLException {
        String query = "SELECT MAX(idvenda) AS maxId FROM venda";
        try ( Connection connection = DriverManager.getConnection(url, user, password);  PreparedStatement statement = connection.prepareStatement(query);  ResultSet resultSet = statement.executeQuery()) {

            if (resultSet.next()) {
                int maxId = resultSet.getInt("maxId");
                return maxId + 1; // Gera o próximo ID
            }
            return 100;  // Caso não haja nenhuma venda cadastrada, começa de 100
        }
    }

    private int gerarIdProduto() throws SQLException {
        String query = "SELECT MAX(idproduto) AS maxId FROM produto";
        try ( Connection connection = DriverManager.getConnection(url, user, password);  PreparedStatement statement = connection.prepareStatement(query);  ResultSet resultSet = statement.executeQuery()) {

            if (resultSet.next()) {
                int maxId = resultSet.getInt("maxId");
                return Math.max(maxId + 1, 6); // Gera o próximo ID ou começa a partir de 6
            }
            return 6;  // Caso não haja nenhum produto cadastrado, começa de 6
        }
    }

    private int gerarIdProdutoItens() throws SQLException {
        String query = "SELECT MAX(idproduto_itens) AS maxId FROM produto_itens";
        try ( Connection connection = DriverManager.getConnection(url, user, password);  PreparedStatement statement = connection.prepareStatement(query);  ResultSet resultSet = statement.executeQuery()) {

            if (resultSet.next()) {
                int maxId = resultSet.getInt("maxId");
                return Math.max(maxId + 1, 112); // Gera o próximo ID ou começa a partir de 112
            }
            return 112;  // Caso não haja nenhum item de produto cadastrado, começa de 112
        }
    }

// Método para converter a data de DD/MM/YYYY para YYYY-MM-DD
    public String converterDataParaBanco(String data) throws ParseException {
        SimpleDateFormat formatoEntrada = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formatoSaida = new SimpleDateFormat("yyyy-MM-dd");
        Date dataFormatada = formatoEntrada.parse(data);
        return formatoSaida.format(dataFormatada);
    }

    private void inserirProduto(Produto_itens produto) throws SQLException, ParseException {
        try ( Connection connection = DriverManager.getConnection(url, user, password)) {
            connection.setAutoCommit(false); // Iniciar uma transação

            try {
                // Inserir Venda
                String sqlVenda = "INSERT INTO venda (data_venda, status, valor_total, tipo_pagamento, numero_cartao, numero_parcelas, cliente_idcliente, funcionario_idfuncionario) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                int idVendaGerado = 0;
                try ( PreparedStatement statementVenda = connection.prepareStatement(sqlVenda, Statement.RETURN_GENERATED_KEYS)) {
                    statementVenda.setDate(1, new java.sql.Date(System.currentTimeMillis())); // Data atual
                    statementVenda.setString(2, "Pendente"); // Status inicial
                    statementVenda.setDouble(3, produto.getSubtotal()); // Subtotal da venda
                    statementVenda.setString(4, "Dinheiro"); // Tipo de pagamento
                    statementVenda.setString(5, "N/A"); // Número do cartão (caso necessário)
                    statementVenda.setInt(6, 1); // Número de parcelas (exemplo)
                    statementVenda.setInt(7, 1); // ID do cliente (exemplo)
                    statementVenda.setInt(8, 1); // ID do funcionário (exemplo)

                    statementVenda.executeUpdate();

                    // Obter o ID da venda gerada
                    try ( ResultSet generatedKeys = statementVenda.getGeneratedKeys()) {
                        if (generatedKeys.next()) {
                            idVendaGerado = generatedKeys.getInt(1); // Obter o ID gerado da venda
                        }
                    }
                }

                // Inserir Produto
                String sqlProduto = "INSERT INTO produto (nome, data_vencimento, estoque, fabricante) VALUES (?, ?, ?, ?)";
                try ( PreparedStatement statementProduto = connection.prepareStatement(sqlProduto, Statement.RETURN_GENERATED_KEYS)) {
                    statementProduto.setString(1, produto.getNomeProduto());

                    // Converter a data de vencimento antes de inserir
                    String dataConvertida = converterDataParaBanco(produto.getDataVencimento());
                    statementProduto.setString(2, dataConvertida);

                    statementProduto.setInt(3, produto.getQuantidadeEstoque());
                    statementProduto.setString(4, produto.getFabricante());

                    statementProduto.executeUpdate();

                    // Obter o ID do produto gerado
                    try ( ResultSet generatedKeys = statementProduto.getGeneratedKeys()) {
                        if (generatedKeys.next()) {
                            produto.setIdProduto(generatedKeys.getInt(1)); // Definir o ID do produto gerado
                        }
                    }
                }

                // Inserir Produto Itens
                String sqlProdutoItens = "INSERT INTO produto_itens (quantidade, valor_unitario, subtotal, fabricante, venda_idvenda, produto_idproduto) VALUES (?, ?, ?, ?, ?, ?)";
                try ( PreparedStatement statementProdutoItens = connection.prepareStatement(sqlProdutoItens)) {
                    statementProdutoItens.setInt(1, produto.getQuantidadeVendida());
                    statementProdutoItens.setDouble(2, produto.getValorUnitario());
                    statementProdutoItens.setDouble(3, produto.getQuantidadeVendida() * produto.getValorUnitario()); // Subtotal
                    statementProdutoItens.setString(4, produto.getFabricante());
                    statementProdutoItens.setInt(5, idVendaGerado); // Usar o ID da venda gerado
                    statementProdutoItens.setInt(6, produto.getIdProduto());

                    statementProdutoItens.executeUpdate();
                }

                // Atualizar o estoque do produto após a venda
                String sqlAtualizarEstoque = "UPDATE produto SET estoque = estoque - ? WHERE idproduto = ?";
                try ( PreparedStatement statementEstoque = connection.prepareStatement(sqlAtualizarEstoque)) {
                    statementEstoque.setInt(1, produto.getQuantidadeVendida());
                    statementEstoque.setInt(2, produto.getIdProduto());
                    statementEstoque.executeUpdate();
                }

                connection.commit(); // Comitar a transação se tudo der certo
            } catch (SQLException e) {
                connection.rollback(); // Fazer rollback em caso de erro
                throw e;
            }
        }
    }

    private void atualizarTabela() {
        // Limpa a tabela atual
        tableModel.setRowCount(0);

        String sql = "SELECT p.idproduto_itens, p.produto_idproduto, p.venda_idvenda, pr.nome, pr.fabricante, "
                + "pr.data_vencimento, p.quantidade, p.valor_unitario, p.subtotal "
                + "FROM produto_itens p "
                + "JOIN produto pr ON p.produto_idproduto = pr.idproduto";

        try ( Connection connection = DriverManager.getConnection(url, user, password);  PreparedStatement statement = connection.prepareStatement(sql);  ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Object[] rowData = {
                    resultSet.getInt("idproduto_itens"),
                    resultSet.getInt("produto_idproduto"),
                    resultSet.getInt("venda_idvenda"),
                    resultSet.getString("nome"),
                    resultSet.getString("fabricante"),
                    resultSet.getDate("data_vencimento"),
                    resultSet.getInt("quantidade"), // Quantidade vendida
                    resultSet.getDouble("valor_unitario"),
                    resultSet.getDouble("subtotal") // Subtotal
                };
                tableModel.addRow(rowData);
            }

            // Atualiza a tabela visualmente
            jTableProdutos.setModel(tableModel);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar a tabela: " + ex.getMessage());
        }
    }

    private void atualizarEstoque(Produto_itens produto) {
        try {
            // Obter a conexão com o banco de dados
            Connection conn = ConexaoDb.getConnection();

            // Obter a quantidade atual do produto no estoque
            String queryEstoque = "SELECT quantidade FROM produto WHERE idproduto = ?";
            PreparedStatement stmtEstoque = conn.prepareStatement(queryEstoque);
            stmtEstoque.setInt(1, produto.getIdProduto());
            ResultSet rsEstoque = stmtEstoque.executeQuery();

            if (rsEstoque.next()) {
                int quantidadeAtual = rsEstoque.getInt("quantidade");
                int novaQuantidade = quantidadeAtual - produto.getQuantidade();

                // Verificar se a nova quantidade é válida (não negativa)
                if (novaQuantidade >= 0) {
                    // Atualizar a quantidade do produto no banco de dados
                    String queryUpdate = "UPDATE produto SET quantidade = ? WHERE idproduto = ?";
                    PreparedStatement stmtUpdate = conn.prepareStatement(queryUpdate);
                    stmtUpdate.setInt(1, novaQuantidade);
                    stmtUpdate.setInt(2, produto.getIdProduto());
                    stmtUpdate.executeUpdate();

                    System.out.println("Estoque atualizado com sucesso!");
                } else {
                    System.out.println("Erro: Não há estoque suficiente para o produto " + produto.getIdProduto());
                }
            } else {
                System.out.println("Erro: Produto não encontrado.");
            }

            // Fechar recursos
            rsEstoque.close();
            stmtEstoque.close();
            conn.close();

        } catch (SQLException e) {
        }
    }

    public void reporEstoque(int idProduto, int quantidadeReposicao) throws SQLException {
        String update = "UPDATE produto SET estoque = estoque + ? WHERE idproduto = ?";

        try ( Connection connection = DriverManager.getConnection(url, user, password);  PreparedStatement statement = connection.prepareStatement(update)) {

            // Adicionar a quantidade de reposição ao estoque existente
            statement.setInt(1, quantidadeReposicao);
            statement.setInt(2, idProduto);
            statement.executeUpdate();

            JOptionPane.showMessageDialog(null, "O estoque foi reposto com sucesso.");
        }
    }

    public void adicionarProduto() throws SQLException, ParseException {
        // Verifica se os campos estão preenchidos e contêm valores válidos
        if (validarValor(jTextValorUnitario.getText())
                && !emptyFields()
                && validarNumInteiro(jTextIdVenda.getText())
                && validarNumInteiro(jTextEstoque.getText())
                && validarNumInteiro(jTextQuantidadeVendida.getText())) {

            Produto_itens produto = getProduto();
            if (produto == null) {
                return; // Se houver erro na conversão, sai do método
            }

            ListaProduto.add(produto);  // Adiciona o produto à lista
            inserirProduto(produto);    // Insere os dados na tabela produto e produto_itens

            // Atualiza o estoque do produto
            atualizarEstoque(produto);

            // Adiciona o produto à tabela de visualização
            Object[] rowData = {
                produto.getIdProdutoItens(),
                produto.getIdProduto(),
                produto.getIdVenda(),
                produto.getNomeProduto(),
                produto.getFabricante(),
                produto.getDataVencimento(),
                produto.getQuantidadeEstoque(),
                produto.getQuantidadeVendida(),
                produto.getValorUnitario(),
                produto.getSubtotal()
            };
            tableModel.addRow(rowData);

            // Atualiza o valor total da venda após inserir os itens
            atualizarValorTotalVenda(produto.getIdVenda());

            JOptionPane.showMessageDialog(null, """
    Os seguintes dados foram cadastrados com sucesso:
    Id do Produto: """ + jTextIdProdutos.getText()
                    + "\nId do Produto Itens: " + jTextIdProdutoItens.getText()
                    + "\nId da Venda: " + jTextIdVenda.getText()
                    + "\nNome do Produto: " + produto.getNomeProduto()
                    + "\nNome do Fabricante: " + produto.getFabricante()
                    + "\nData de Vencimento: " + jTextDataVencimento.getText()
                    + "\nQuantidade Vendida: " + jTextQuantidadeVendida.getText()
                    + "\nEstoque: " + jTextEstoque.getText()
                    + "\nValor Unitário: " + jTextValorUnitario.getText()
                    + "\nSubTotal: " + produto.getSubtotal()
            );
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, preencha todos os campos corretamente.");
        }
    }

// Método para atualizar o valor total da venda
    private void atualizarValorTotalVenda(int idVenda) throws SQLException {
        // Query para somar o subtotal dos itens da venda
        String query = "SELECT SUM(subtotal) AS valor_total FROM produto_itens WHERE venda_idvenda = ?";
        // Query para atualizar o valor total na tabela venda
        String update = "UPDATE venda SET valor_total = ? WHERE idvenda = ?";

        try ( Connection connection = DriverManager.getConnection(url, user, password);  PreparedStatement statement = connection.prepareStatement(query);  PreparedStatement updateStatement = connection.prepareStatement(update)) {

            // Passa o ID da venda para a query de soma dos subtotais
            statement.setInt(1, idVenda);

            // Executa a consulta para obter o valor total da venda
            try ( ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    // Pega o valor total calculado
                    double valorTotal = resultSet.getDouble("valor_total");

                    // Atualiza o valor total na tabela venda
                    updateStatement.setDouble(1, valorTotal);
                    updateStatement.setInt(2, idVenda);
                    updateStatement.executeUpdate();
                }
            }
        } catch (SQLException e) {
            // Lidar com exceções, se houver
            throw new SQLException("Erro ao atualizar o valor total da venda: " + e.getMessage(), e);
        }
    }

    private Produto_itens getProduto() {
        Produto_itens produto = new Produto_itens();

        try {
            // Verifique se os campos estão vazios antes de converter
            String idProdutoText = jTextIdProdutos.getText().trim();
            String idProdutoItensText = jTextIdProdutoItens.getText().trim();
            String idVendaText = jTextIdVenda.getText().trim();
            String nomeProduto = jComboBoxNomeProduto.getSelectedItem().toString().trim();
            String fabricante = jComboBoxFabricante.getSelectedItem().toString().trim();
            String dataVencimento = jTextDataVencimento.getText().trim();
            String estoqueText = jTextEstoque.getText().trim();
            String quantidadeVendidaText = jTextQuantidadeVendida.getText().trim();
            String valorUnitarioText = jTextValorUnitario.getText().trim();

            // Verifique se os campos são vazios
            if (idProdutoText.isEmpty() || idProdutoItensText.isEmpty() || idVendaText.isEmpty()
                    || nomeProduto.isEmpty() || fabricante.isEmpty() || dataVencimento.isEmpty()
                    || estoqueText.isEmpty() || quantidadeVendidaText.isEmpty() || valorUnitarioText.isEmpty()) {
                throw new NumberFormatException("Alguns campos estão vazios.");
            }

            int idProduto = Integer.parseInt(idProdutoText);
            int idProdutoItens = Integer.parseInt(idProdutoItensText);
            int idVenda = Integer.parseInt(idVendaText);
            int quantidadeEstoque = Integer.parseInt(estoqueText);
            int quantidadeVendida = Integer.parseInt(quantidadeVendidaText);
            double valorUnitario = parseValor(valorUnitarioText);
            double subTotal = valorUnitario * quantidadeVendida;

            // Configurando os valores no objeto produto
            produto.setIdProduto(idProduto);
            produto.setIdProdutoItens(idProdutoItens);
            produto.setIdVenda(idVenda);
            produto.setNomeProduto(nomeProduto);
            produto.setFabricante(fabricante);
            produto.setDataVencimento(dataVencimento);
            produto.setQuantidadeEstoque(quantidadeEstoque);
            produto.setQuantidadeVendida(quantidadeVendida);
            produto.setValorUnitario(valorUnitario);
            produto.setSubtotal(subTotal);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Erro ao converter valores: " + e.getMessage(), "Erro de Formato", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        return produto;
    }

    private void salvarRegistrosEmArquivo(String nomeArquivo) throws IOException {
        if (ListaProduto == null || ListaProduto.isEmpty()) {
            JOptionPane.showMessageDialog(null, "A lista de produtos está vazia.");
            return;
        }

        try ( BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {

            writer.write("ID do Produto,ID do Produto Itens,ID da Venda,Nome do Produto,Fabricante,Data de Vencimento,Quantidade Vendida,Estoque,Valor Unitário,SubTotal");
            writer.newLine();

            for (Produto_itens produto : ListaProduto) {
                writer.write(produto.getIdProduto()
                        + "," + produto.getIdProdutoItens()
                        + "," + produto.getIdVenda()
                        + "," + produto.getNomeProduto()
                        + "," + produto.getFabricante()
                        + "," + produto.getDataVencimento()
                        + "," + produto.getQuantidadeVendida()
                        + "," + produto.getQuantidadeEstoque()
                        + "," + produto.getValorUnitario()
                        + "," + produto.getSubtotal()
                );
                writer.newLine();
            }
            JOptionPane.showMessageDialog(null, "Registros salvos com sucesso em " + nomeArquivo);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar registros em arquivo: " + e.getMessage());
        }
    }

}
