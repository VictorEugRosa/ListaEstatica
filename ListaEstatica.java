public class ListaEstatica {
    private int[] dados;
    private int tamanho;
    private int capacidade;

    public ListaEstatica(int capacidade) {
        this.capacidade = capacidade;
        this.dados = new int[capacidade];
        this.tamanho = 0;
    }

    public void limpar() {
        this.tamanho = 0;
    }

    public void adicionar(int dado) {
        if (!estaCheia()) {
            this.dados[tamanho] = dado;
            tamanho++;
        } else {
            System.out.println("A lista está cheia");
        }
    }

    public void adicionar(int dado, int posicao) {
        if (!estaCheia() && posicao >= 0 && posicao <= tamanho) {
            for (int i = tamanho; i > posicao; i--) {
                this.dados[i] = this.dados[i - 1];
            }
            this.dados[posicao] = dado;
            tamanho++;
        } else {
            System.out.println("Não é possível adicionar na posição " + posicao);
        }
    }

    public int remover(int posicao) {
        if (!estaVazia() && posicao >= 0 && posicao < tamanho) {
            int dadoRemovido = this.dados[posicao];
            for (int i = posicao; i < tamanho - 1; i++) {
                this.dados[i] = this.dados[i + 1];
            }
            tamanho--;
            return dadoRemovido;
        } else {
            System.out.println("Não é possível remover da posição " + posicao);
            return -1; 
        }
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }

    public boolean estaCheia() {
        return tamanho == capacidade;
    }

    public void definirDado(int dado, int posicao) {
        if (posicao >= 0 && posicao < tamanho) {
            this.dados[posicao] = dado;
        } else {
            System.out.println("Posição inválida " + posicao);
        }
    }

    public int obterDado(int posicao) {
        if (posicao >= 0 && posicao < tamanho) {
            return this.dados[posicao];
        } else {
            System.out.println("Posição inválida " + posicao);
            return -1; 
        }
    }

    public int obterTamanho() {
        return tamanho;
    }

    public int encontrar(int dado) {
        for (int i = 0; i < tamanho; i++) {
            if (this.dados[i] == dado) {
                return i;
            }
        }
        return -1; 
    }
}
