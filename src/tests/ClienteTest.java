package tests;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalTime;

public class ClienteTest {

    @Test
    public void testConstrutorEGetter() {
        String rg = "123456789";
        Cliente cliente = new Cliente(rg);
        assertEquals(rg, cliente.getRg());
    }

    @Test
    public void testSetter() {
        Cliente cliente = new Cliente("123456789");
        String novoRg = "987654321";
        cliente.setRg(novoRg);
        assertEquals(novoRg, cliente.getRg());
    }

    @Test
    public void testEquals() {
        Cliente cliente1 = new Cliente("123456789");
        Cliente cliente2 = new Cliente("123456789");
        assertEquals(cliente1, cliente2);
    }

    @Test
    public void testHashCode() {
        Cliente cliente1 = new Cliente("123456789");
        Cliente cliente2 = new Cliente("123456789");
        assertEquals(cliente1.hashCode(), cliente2.hashCode());
    }
}


public class FilaEsperaOperacoesTest {

    // Implementação de teste da interface FilaEsperaOperacoes
    class FilaEsperaOperacoesImpl implements FilaEsperaOperacoes {
        private Cliente proximoCliente;

        @Override
        public void adicionarClienteNaFila(Cliente cliente) {
            // Aqui você poderia adicionar o cliente a uma estrutura de dados de fila, por exemplo
        }

        @Override
        public Requisicao proximoClienteNaFila() {
            // Retorna o próximo cliente na fila (simulado para os fins do teste)
            return new Requisicao(proximoCliente);
        }

        @Override
        public boolean filaDeEsperaVazia() {
            // Verifica se a fila está vazia (simulado para os fins do teste)
            return proximoCliente == null;
        }

        // Método de utilidade para definir o próximo cliente na fila (usado apenas para testes)
        public void setProximoCliente(Cliente cliente) {
            this.proximoCliente = cliente;
        }
    }

    @Test
    public void testAdicionarClienteNaFila() {
        FilaEsperaOperacoesImpl fila = new FilaEsperaOperacoesImpl();
        Cliente cliente = new Cliente("123456789");
        fila.adicionarClienteNaFila(cliente);
        assertFalse(fila.filaDeEsperaVazia());
    }

    @Test
    public void testProximoClienteNaFila() {
        FilaEsperaOperacoesImpl fila = new FilaEsperaOperacoesImpl();
        Cliente cliente = new Cliente("123456789");
        fila.setProximoCliente(cliente);
        assertEquals(cliente, fila.proximoClienteNaFila().getCliente());
    }

    @Test
    public void testFilaDeEsperaVazia() {
        FilaEsperaOperacoesImpl fila = new FilaEsperaOperacoesImpl();
        assertTrue(fila.filaDeEsperaVazia());
    }
}


public class MesaTest {

    @Test
    public void testConstrutorComCapacidade() {
        Mesa mesa = new Mesa(1, 4);
        assertEquals(1, mesa.getNumero());
        assertEquals(4, mesa.getCapacidade());
        assertFalse(mesa.isOcupada());
        assertNull(mesa.getHoraChegada());
        assertNull(mesa.getHoraSaida());
        assertNull(mesa.getCliente());
    }

    @Test
    public void testConstrutorCompleto() {
        LocalTime horaChegada = LocalTime.of(12, 0);
        LocalTime horaSaida = LocalTime.of(14, 0);
        Cliente cliente = new Cliente("João");
        Mesa mesa = new Mesa(2, 6, true, horaChegada, horaSaida, cliente);
        assertEquals(2, mesa.getNumero());
        assertEquals(6, mesa.getCapacidade());
        assertTrue(mesa.isOcupada());
        assertEquals(horaChegada, mesa.getHoraChegada());
        assertEquals(horaSaida, mesa.getHoraSaida());
        assertEquals(cliente, mesa.getCliente());
    }

    @Test
    public void testEquals() {
        Mesa mesa1 = new Mesa(1, 4);
        Mesa mesa2 = new Mesa(1, 4);
        assertEquals(mesa1, mesa2);
    }

    @Test
    public void testHashCode() {
        Mesa mesa1 = new Mesa(1, 4);
        Mesa mesa2 = new Mesa(1, 4);
        assertEquals(mesa1.hashCode(), mesa2.hashCode());
    }
}


public class MesaOperacoesTest {

    // Implementação de teste da interface MesaOperacoes
    class MesaOperacoesImpl implements MesaOperacoes {
        private Mesa mesaOcupada;

        @Override
        public void ocuparMesa(Mesa mesa) {
            this.mesaOcupada = mesa;
        }

        @Override
        public void desocuparMesa(Mesa mesa) {
            this.mesaOcupada = null;
        }

        @Override
        public Mesa alocarMesa(Cliente cliente) {
            Mesa mesa = new Mesa(1, 4); // Simulação de alocação de mesa
            mesa.setCliente(cliente);
            this.mesaOcupada = mesa;
            return mesa;
        }

        // Método de utilidade para obter a mesa ocupada (usado apenas para testes)
        public Mesa getMesaOcupada() {
            return mesaOcupada;
        }
    }

    @Test
    public void testOcuparMesa() {
        MesaOperacoesImpl operacoes = new MesaOperacoesImpl();
        Mesa mesa = new Mesa(1, 4);
        operacoes.ocuparMesa(mesa);
        assertEquals(mesa, operacoes.getMesaOcupada());
    }

    @Test
    public void testDesocuparMesa() {
        MesaOperacoesImpl operacoes = new MesaOperacoesImpl();
        Mesa mesa = new Mesa(1, 4);
        operacoes.ocuparMesa(mesa);
        operacoes.desocuparMesa(mesa);
        assertNull(operacoes.getMesaOcupada());
    }

    @Test
    public void testAlocarMesa() {
        MesaOperacoesImpl operacoes = new MesaOperacoesImpl();
        Cliente cliente = new Cliente("123456789");
        Mesa mesa = operacoes.alocarMesa(cliente);
        assertNotNull(mesa);
        assertEquals(cliente, mesa.getCliente());
        assertEquals(mesa, operacoes.getMesaOcupada());
    }
}


public class RequisicaoTest {

    @Test
    public void testConstrutorEGetter() {
        Cliente cliente = new Cliente("123456789");
        Mesa mesa = new Mesa(1, 4);
        LocalTime horaChegada = LocalTime.of(12, 0);
        LocalTime horaSaida = LocalTime.of(14, 0);
        int quantidadeClientes = 4;
        
        Requisicao requisicao = new Requisicao(cliente, mesa, horaChegada, horaSaida, quantidadeClientes);
        
        assertEquals(cliente, requisicao.getCliente());
        assertEquals(mesa, requisicao.getMesa());
        assertEquals(horaChegada, requisicao.getHoraChegada());
        assertEquals(horaSaida, requisicao.getHoraSaida());
        assertEquals(quantidadeClientes, requisicao.getQuantidadeClientes());
    }

    @Test
    public void testSetter() {
        Requisicao requisicao = new Requisicao();
        Cliente cliente = new Cliente("123456789");
        Mesa mesa = new Mesa(1, 4);
        LocalTime horaChegada = LocalTime.of(12, 0);
        LocalTime horaSaida = LocalTime.of(14, 0);
        int quantidadeClientes = 4;
        
        requisicao.setCliente(cliente);
        requisicao.setMesa(mesa);
        requisicao.setHoraChegada(horaChegada);
        requisicao.setHoraSaida(horaSaida);
        requisicao.setQuantidadeClientes(quantidadeClientes);
        
        assertEquals(cliente, requisicao.getCliente());
        assertEquals(mesa, requisicao.getMesa());
        assertEquals(horaChegada, requisicao.getHoraChegada());
        assertEquals(horaSaida, requisicao.getHoraSaida());
        assertEquals(quantidadeClientes, requisicao.getQuantidadeClientes());
    }

    @Test
    public void testEquals() {
        Cliente cliente = new Cliente("123456789");
        Mesa mesa = new Mesa(1, 4);
        LocalTime horaChegada = LocalTime.of(12, 0);
        LocalTime horaSaida = LocalTime.of(14, 0);
        int quantidadeClientes = 4;
        
        Requisicao requisicao1 = new Requisicao(cliente, mesa, horaChegada, horaSaida, quantidadeClientes);
        Requisicao requisicao2 = new Requisicao(cliente, mesa, horaChegada, horaSaida, quantidadeClientes);
        
        assertEquals(requisicao1, requisicao2);
    }

    @Test
    public void testHashCode() {
        Cliente cliente = new Cliente("123456789");
        Mesa mesa = new Mesa(1, 4);
        LocalTime horaChegada = LocalTime.of(12, 0);
        LocalTime horaSaida = LocalTime.of(14, 0);
        int quantidadeClientes = 4;
        
        Requisicao requisicao1 = new Requisicao(cliente, mesa, horaChegada, horaSaida, quantidadeClientes);
        Requisicao requisicao2 = new Requisicao(cliente, mesa, horaChegada, horaSaida, quantidadeClientes);
        
        assertEquals(requisicao1.hashCode(), requisicao2.hashCode());
    }
}


public class RestauranteTest {

    @Test
    public void testOcuparMesa() {
        Restaurante restaurante = new Restaurante();
        Mesa mesa = new Mesa(1, 2);
        restaurante.adicionarMesa(mesa);
        restaurante.ocuparMesa(mesa);
        assertTrue(mesa.isOcupada());
    }

    @Test
    public void testDesocuparMesa() {
        Restaurante restaurante = new Restaurante();
        Mesa mesa = new Mesa(1, 2);
        restaurante.adicionarMesa(mesa);
        restaurante.ocuparMesa(mesa);
        restaurante.desocuparMesa(mesa);
        assertFalse(mesa.isOcupada());
    }

    @Test
    public void testAlocarMesa() {
        Restaurante restaurante = new Restaurante();
        Mesa mesa1 = new Mesa(1, 2);
        Mesa mesa2 = new Mesa(2, 4);
        Cliente cliente1 = new Cliente("123456");
        Cliente cliente2 = new Cliente("654321");
        restaurante.adicionarMesa(mesa1);
        restaurante.adicionarMesa(mesa2);
        Mesa mesaAlocada = restaurante.alocarMesa(cliente1);
        assertNotNull(mesaAlocada);
        assertTrue(mesaAlocada.isOcupada());
        assertEquals(cliente1, mesaAlocada.getCliente());
    }

    @Test
    public void testAdicionarClienteNaFila() {
        Restaurante restaurante = new Restaurante();
        Cliente cliente = new Cliente("123456");
        restaurante.adicionarClienteNaFila(cliente);
        assertFalse(restaurante.filaDeEsperaVazia());
    }

    @Test
    public void testProximoClienteNaFila() {
        Restaurante restaurante = new Restaurante();
        Cliente cliente = new Cliente("123456");
        restaurante.adicionarClienteNaFila(cliente);
        Requisicao requisicao = restaurante.proximoClienteNaFila();
        assertNotNull(requisicao);
        assertEquals(cliente, requisicao.getCliente());
    }

    @Test
    public void testFilaDeEsperaVazia() {
        Restaurante restaurante = new Restaurante();
        assertTrue(restaurante.filaDeEsperaVazia());
    }
}
