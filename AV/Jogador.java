public class Jogador {
    private String nome;
    private int votos;

    public Jogador(String nome) {
        this.nome = nome;
        this.votos = 0;
    }

    public void incrementaUmVoto() {
        this.votos++;
    }

    public String getNome() {
        return nome;
    }

    public int getVotos() {
        return votos;
    }
}
