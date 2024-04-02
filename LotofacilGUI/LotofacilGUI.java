import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class LotofacilGUI extends JFrame implements ActionListener {
    private JButton btnApostaNumero;
    private JButton btnApostaLetra;
    private JButton btnApostaParImpar;
    private JButton btnSair;

    private Random random;

    public LotofacilGUI() {
        setTitle("MENU LOTOFÁCIL DO GUSTAVO");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        random = new Random();

        // Configurações do painel principal
        JPanel panel = new JPanel(); // Cria um novo painel
        panel.setLayout(new GridLayout(4, 1)); // Define um layout de grade com 4 linhas e 1 coluna
        panel.setBackground(new Color(30, 0, 30)); // Define a cor de fundo do painel

        Font font = new Font("Arial", Font.BOLD, 14);

        Color pretoComRoxo = new Color(20, 0, 20); // Define uma cor preta com tons de roxo

     // Botão para realizar apostas em números de 0 a 100
        btnApostaNumero = new JButton("Apostar em um número de 0 a 100");
        btnApostaNumero.addActionListener(this); // Adiciona um ouvinte de ação ao botão
        btnApostaNumero.setBackground(pretoComRoxo); // Define a cor de fundo do botão
        btnApostaNumero.setForeground(Color.WHITE); // Define a cor do texto do botão
        panel.add(btnApostaNumero); // Adiciona o botão ao painel
        btnApostaNumero.setToolTipText("Clique aqui para fazer uma aposta em um número de 0 a 100."); // Adicionei um tooltip para deixar o menu mais interativo e mostrar certamente o que cada botão faz para o usuario

     // Botão para realizar apostas em letras de A a Z
        btnApostaLetra = new JButton("Apostar em uma letra de A à Z");
        btnApostaLetra.addActionListener(this); // Adiciona um ouvinte de ação ao botão
        btnApostaLetra.setBackground(pretoComRoxo); // Define a cor de fundo do botão
        btnApostaLetra.setForeground(Color.WHITE); // Define a cor do texto do botão
        panel.add(btnApostaLetra); // Adiciona o botão ao painel
        btnApostaLetra.setToolTipText("Clique aqui para fazer uma aposta em uma letra de A à Z."); // tooltip  para a aposta de A á Z

        // Botão para realizar apostas em números pares ou ímpares
        btnApostaParImpar = new JButton("Apostar em um número par ou ímpar");
        btnApostaParImpar.addActionListener(this); // Adiciona um ouvinte de ação ao botão
        btnApostaParImpar.setBackground(pretoComRoxo); // Define a cor de fundo do botão
        btnApostaParImpar.setForeground(Color.WHITE); // Define a cor do texto do botão
        panel.add(btnApostaParImpar); // Adiciona o botão ao painel
        btnApostaParImpar.setToolTipText("Clique aqui para fazer uma aposta em um número par ou ímpar."); // tooltip para a aposta do par ou impar

     // Botão para sair do menu
        btnSair = new JButton("Sair do Menu");
        btnSair.addActionListener(this); // Adiciona um ouvinte de ação ao botão
        btnSair.setBackground(pretoComRoxo); // Define a cor de fundo do botão
        btnSair.setForeground(Color.WHITE); // Define a cor do texto do botão
        panel.add(btnSair); // Adiciona o botão ao painel
        btnSair.setToolTipText("Clique aqui para sair do menu."); // ToolTipText  para a sair do menu

        add(panel); // Adiciona o painel à janela
        setVisible(true); // Define a janela como visível
    }

    public void actionPerformed(ActionEvent e) { // Método para lidar com ações de botões
        if (e.getSource() == btnApostaNumero) { processarApostaNumero(); } // Verifica qual botão foi clicado e executa a ação correspondente à aposta de número
        else if (e.getSource() == btnApostaLetra) { processarApostaLetra(); } // Verifica qual botão foi clicado e executa a ação correspondente à aposta de letra
        else if (e.getSource() == btnApostaParImpar) { processarApostaParImpar(); } // Verifica qual botão foi clicado e executa a ação correspondente à aposta de par ou ímpar
        else if (e.getSource() == btnSair) { // Verifica se o botão de sair foi clicado
        int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente sair do Menu?", "Sair", JOptionPane.YES_NO_OPTION); // Pergunta se o usuário realmente deseja sair do menu
        if (resposta == JOptionPane.YES_OPTION) { // Se a resposta for sim, fecha o programa
                JOptionPane.showMessageDialog(this, "Saindo do Menu. Volte sempre!"); // Exibe uma mensagem de saída
                System.exit(0); // Fecha o programa
            }
        }
    }


   
    // Método para processar a aposta de número
    private void processarApostaNumero() {
        int numeroSorteado = random.nextInt(101);
        String numeroStr = JOptionPane.showInputDialog(this, "Digite um número de 0 a 100:");
        if (numeroStr != null && !numeroStr.isEmpty()) {
            try {
                int numero = Integer.parseInt(numeroStr);
                if (numero >= 0 && numero <= 100) {
                    if (numero == numeroSorteado) {
                        JOptionPane.showMessageDialog(this, "Parabéns. Você ganhou R$ 1.000,00 reais, aproveite o seu prêmio :).");
                    } else {
                        JOptionPane.showMessageDialog(this, "Que pena :C ! O número sorteado foi " + numeroSorteado + ". A sorte estará com você na próxima vez, não desista.");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Número inválido. Digite um número de 0 a 100.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Número inválido. Digite um número inteiro.");
            }
        }
    }

    // Método para processar a aposta de letra
    private void processarApostaLetra() {
        char letraPremiada = 'G'; // Letra premiada definida como 'G'
        String letra = JOptionPane.showInputDialog(this, "Digite uma letra de A à Z:");
        if (letra != null && !letra.isEmpty() && letra.length() == 1) {
            char letraEscolhida = letra.toUpperCase().charAt(0);
            if (Character.isLetter(letraEscolhida)) {
                if (letraEscolhida == letraPremiada) {
                    JOptionPane.showMessageDialog(this, "Parabéns. Você ganhou R$ 500,00 reais, aproveite bem o seu prêmio :).");
                } else {
                    JOptionPane.showMessageDialog(this, "Que pena :C ! A letra sorteada foi " + letraPremiada + ", sorte na próxima vez.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Letra inválida. Digite uma letra de A à Z.");
            }
        }
    }

    // Método para processar a aposta de par ou ímpar
    private void processarApostaParImpar() {
        int numeroSorteado = random.nextInt(101);
        String opcao = JOptionPane.showInputDialog(this, "Digite um número inteiro:");
        if (opcao != null && !opcao.isEmpty()) {
            try {
                int numeroDigitado = Integer.parseInt(opcao);
                if (numeroDigitado % 2 == 0) {
                    JOptionPane.showMessageDialog(this, "Parabéns sortudo :). Você ganhou R$ 100,00 reais, aproveite seu prêmio.");
                } else {
                    JOptionPane.showMessageDialog(this, "Que pena :C ! O número digitado é ímpar e a premiação foi para números pares. Sorte na próxima vez");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Número inválido. Digite um número inteiro.");
            }
        }
    }

    public static void main(String[] args) {
        new LotofacilGUI(); // Criando uma instância da GUI
    }
}
