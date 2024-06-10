public class Restaurante {
    private List<Mesa> mesas;
    private Cardapio cardapio;

    public Restaurante() {
        this.mesas = new ArrayList<>();
        this.cardapio = new Cardapio();

        // Adiciona 4 mesas com capacidade para 4 pessoas
        for (int i = 0; i < 4; i++) {
            this.mesas.add(new Mesa(i + 1, 4));
        }

        // Adiciona 4 mesas com capacidade para 6 pessoas
        for (int i = 4; i < 8; i++) {
            this.mesas.add(new Mesa(i + 1, 6));
        }

        // Adiciona 2 mesas com capacidade para 8 pessoas
        for (int i = 8; i < 10; i++) {
            this.mesas.add(new Mesa(i + 1, 8));
        }

        // Adiciona pratos ao cardápio
        this.cardapio.adicionarPrato(new ItemMenu("Moqueca de Tilápia", 20.00));
        this.cardapio.adicionarPrato(new ItemMenu("Falafel Assado", 15.00));
        this.cardapio.adicionarPrato(new ItemMenu("Salada Primavera com Macarrão Konjac", 12.00));
        this.cardapio.adicionarPrato(new ItemMenu("Escondidinho de Frango", 18.00));
        this.cardapio.adicionarPrato(new ItemMenu("Strogonoff", 22.00));
        this.cardapio.adicionarPrato(new ItemMenu("Caçarola de carne com legumes", 25.00));

        // Adiciona bebidas ao cardápio
        this.cardapio.adicionarBebida(new ItemMenu("Água", 2.00));
        this.cardapio.adicionarBebida(new ItemMenu("Suco", 5.00));
        this.cardapio.adicionarBebida(new ItemMenu("Refrigerante", 4.00));
        this.cardapio.adicionarBebida(new ItemMenu("Cerveja", 7.00));
        this.cardapio.adicionarBebida(new ItemMenu("Taça de vinho", 10.00));
    }

    // Outros métodos...
}
    public double calcularPorPessoa(int numeroDePessoas) {
        return this.calcularTotalComServico() / numeroDePessoas;
    }
}
