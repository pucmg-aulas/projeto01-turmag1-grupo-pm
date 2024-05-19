
public interface FilaEsperaOperacoes {
    void adicionarClienteNaFila(Cliente cliente);
    Requisicao proximoClienteNaFila();
    boolean filaDeEsperaVazia();
}
