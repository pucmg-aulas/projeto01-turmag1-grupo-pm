
import java.time.LocalTime;
import java.util.Objects;

public class Mesa {
    private int numero;
    private int capacidade;
    private boolean ocupada;
    private LocalTime horaChegada;
    private LocalTime horaSaida;
    private Cliente cliente;

    public Mesa(int numero, int capacidade) {
        this.numero = numero;
        this.capacidade = capacidade;
        this.ocupada = false;
    }

    public Mesa() {
    }

    public Mesa(int numero, int capacidade, boolean ocupada, LocalTime horaChegada, LocalTime horaSaida,
            Cliente cliente) {
        this.numero = numero;
        this.capacidade = capacidade;
        this.ocupada = ocupada;
        this.horaChegada = horaChegada;
        this.horaSaida = horaSaida;
        this.cliente = cliente;
    }

    public int getNumero() {
        return this.numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCapacidade() {
        return this.capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public boolean isOcupada() {
        return this.ocupada;
    }

    public boolean getOcupada() {
        return this.ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

    public LocalTime getHoraChegada() {
        return this.horaChegada;
    }

    public void setHoraChegada(LocalTime horaChegada) {
        this.horaChegada = horaChegada;
    }

    public LocalTime getHoraSaida() {
        return this.horaSaida;
    }

    public void setHoraSaida(LocalTime horaSaida) {
        this.horaSaida = horaSaida;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Mesa numero(int numero) {
        setNumero(numero);
        return this;
    }

    public Mesa capacidade(int capacidade) {
        setCapacidade(capacidade);
        return this;
    }

    public Mesa ocupada(boolean ocupada) {
        setOcupada(ocupada);
        return this;
    }

    public Mesa horaChegada(LocalTime horaChegada) {
        setHoraChegada(horaChegada);
        return this;
    }

    public Mesa horaSaida(LocalTime horaSaida) {
        setHoraSaida(horaSaida);
        return this;
    }

    public Mesa cliente(Cliente cliente) {
        setCliente(cliente);
        return this;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;

        Mesa other = (Mesa) obj;

        return numero == other.numero &&
                capacidade == other.capacidade &&
                ocupada == other.ocupada &&
                Objects.equals(horaChegada, other.horaChegada) &&
                Objects.equals(horaSaida, other.horaSaida) &&
                Objects.equals(cliente, other.cliente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero, capacidade, ocupada, horaChegada, horaSaida, cliente);
    }

}