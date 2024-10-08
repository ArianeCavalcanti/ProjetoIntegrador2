package View.imagens.telas;

import Classes.Usuario;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public final class Login extends javax.swing.JFrame {

    private final List<Usuario> usuarios = new ArrayList<>();
    private boolean lembrarSenha = false;

    public Login() {
        initComponents();
        setTitle("Tela Login - Distribuidora de Água");

        // Usuários teste
        usuarios.add(new Usuario(0, "gerente", "QA6ktQ24", "admin"));

        // Preencher campos de login e senha com valores padrão
        jTextUsuarios.setText("gerente");
        textSenha.setText("QA6ktQ24");

        carregarCredenciaisSalvas();
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jCheckBoxLembrarSenha = new javax.swing.JCheckBox();
        jTextUsuarios = new javax.swing.JTextField();
        textSenha = new javax.swing.JPasswordField();
        jButtonLogin = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jButtonCadastrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setForeground(new java.awt.Color(153, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Login");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 70, 230, 70));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Se você já é membro pode entrar com seu ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 130, 470, 50));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("endereço de email e senha ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 180, -1, -1));

        jCheckBoxLembrarSenha.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jCheckBoxLembrarSenha.setText("Lembrar minha senha");
        jCheckBoxLembrarSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxLembrarSenhaActionPerformed(evt);
            }
        });
        jPanel1.add(jCheckBoxLembrarSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 420, -1, -1));

        jTextUsuarios.setBackground(new java.awt.Color(228, 228, 228));
        jTextUsuarios.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel1.add(jTextUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 290, 290, 40));

        textSenha.setBackground(new java.awt.Color(228, 228, 228));
        textSenha.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        textSenha.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(textSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 350, 290, 40));

        jButtonLogin.setBackground(new java.awt.Color(0, 102, 204));
        jButtonLogin.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButtonLogin.setText("Login");
        jButtonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoginActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 460, 290, 40));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("Ainda não tem um cadastro? Cadastre-se aqui!");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 550, -1, -1));

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 123, 460, 10));

        jButtonCadastrar.setBackground(new java.awt.Color(200, 195, 195));
        jButtonCadastrar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButtonCadastrar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonCadastrar.setText("Cadastrar");
        jButtonCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastrarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonCadastrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 580, 110, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/imagens/telas/login.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, 650));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBoxLembrarSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxLembrarSenhaActionPerformed
        lembrarSenha = jCheckBoxLembrarSenha.isSelected();
        if (!lembrarSenha) {
            limparCredenciaisSalvas();
        }
    }//GEN-LAST:event_jCheckBoxLembrarSenhaActionPerformed

    private void jButtonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoginActionPerformed
        String login = jTextUsuarios.getText();
        String senha = new String(textSenha.getPassword());

        Usuario usuarioAutenticado = autenticarUsuario(login, senha);
        if (usuarioAutenticado != null) {
            if (lembrarSenha) {
                lembrarSenha(login, senha);
            }
            new MenuPrincipal().setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Login ou senha incorretos.", "Erro de autenticação", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_jButtonLoginActionPerformed

    private void jButtonCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadastrarActionPerformed

        new CadastroUsuarios().setVisible(true);


    }//GEN-LAST:event_jButtonCadastrarActionPerformed

    private Usuario autenticarUsuario(String login, String senha) {
        for (Usuario usuario : usuarios) {
            if (usuario.getLogin().equals(login) && usuario.autenticar(senha)) {
                return usuario;
            }
        }
        return null;
    }

    private void lembrarSenha(String login, String senha) {
        try ( BufferedWriter writer = new BufferedWriter(new FileWriter("credenciais.txt"))) {
            writer.write(login + "\n");
            writer.write(senha + "\n");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Erro ao salvar as credenciais: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void carregarCredenciaisSalvas() {
        File file = new File("credenciais.txt");
        if (file.exists()) {
            try ( Scanner scanner = new Scanner(file)) {
                if (scanner.hasNextLine()) {
                    String login = scanner.nextLine().trim();
                    jTextUsuarios.setText(login);
                }
                if (scanner.hasNextLine()) {
                    String senha = scanner.nextLine().trim();
                    textSenha.setText(senha);
                }
                jCheckBoxLembrarSenha.setSelected(true);
                lembrarSenha = true;
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Erro ao carregar as credenciais: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void limparCredenciaisSalvas() {
        jTextUsuarios.setText("");
        textSenha.setText("");
        File file = new File("credenciais.txt");
        if (file.exists()) {
            file.delete();
        }
    }

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Login().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCadastrar;
    private javax.swing.JButton jButtonLogin;
    private javax.swing.JCheckBox jCheckBoxLembrarSenha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextUsuarios;
    private javax.swing.JPasswordField textSenha;
    // End of variables declaration//GEN-END:variables

}
