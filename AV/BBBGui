import javax.swing.*;
import java.util.ArrayList;

public class BBBGui {
    private ArrayList<Jogador> jogadores;

    public BBBGui() {
        jogadores = new ArrayList<>();
        cadastrarJogadores();
    }

    private void cadastrarJogadores() {
        String[] nomes = {"Alane Dias", "Beatriz Reis", "Davi Brito", "Deniziane Ferreira", "Fernanda Bande", "Giovanna Lima", "Giovanna Pitel", "Isabelle Nogueira", "Juninho", "Leidy Elin", "Lucas Henrique", "Lucas Luigi", "Lucas Pizane", "Marcus Vinicius", "Matteus Amaral", "Maycon Cosmer", "MC Bin Laden", "Michel Nogueira", "Nizam", "Raquele Cardozo", "Rodriguinho", "Thalyta Alves", "Vanessa Lopes", "Vinicius Rodrigues", "Wanessa Camargo", "Yasmin Brunet"};
        for (String nome : nomes) {
            jogadores.add(new Jogador(nome));
        }
    }

    public void iniciarVotacao() {
        String votoEm;
        while (true) {
            votoEm = JOptionPane.showInputDialog(null, "Em quem você vota para sair da casa? Digite 'sair' para encerrar a votação.");
            if (votoEm == null || votoEm.equalsIgnoreCase("sair")) {
                break;
            }
            registrarVoto(votoEm);
        }
        anunciarEliminacao();
    }

    private void registrarVoto(String nome) {
        boolean encontrado = false;
        for (Jogador jogador : jogadores) {
            if (jogador.getNome().equalsIgnoreCase(nome)) {
                jogador.incrementaUmVoto();
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "Jogador não encontrado. Tente novamente.");
        }
    }

    private void anunciarEliminacao() {
        Jogador maisVotado = null;
        for (Jogador jogador : jogadores) {
            if (maisVotado == null || jogador.getVotos() > maisVotado.getVotos()) {
                maisVotado = jogador;
            }
        }
        JOptionPane.showMessageDialog(null, String.format("Se eu conseguir mover montanhas, se eu conseguir surfar um tsunami, se eu conseguir domar o sol, se eu conseguir fazer o mar virar sertão, e o sertão virar mar, se eu conseguir dizer o que eu nunca vou conseguir dizer, aí terá chegado o dia em que eu vou conseguir te eliminar com alegria. Com %d votos, é você quem sai %s.", maisVotado.getVotos(), maisVotado.getNome()));
    }

    public static void main(String[] args) {
        new BBBGui().iniciarVotacao();
    }
}
