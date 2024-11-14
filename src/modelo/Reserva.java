package modelo;

// import modelo.Observable;
// import modelo.EstadoReserva;
// import modelo.ReservaConfirmada;

public class Reserva extends Observable {
    private EstadoReserva estadoAtual;
    private Cliente cliente; // Novo atributo para o cliente

    public Reserva(Cliente cliente) {
        this.estadoAtual = new ReservaConfirmada(); // Estado inicial
        this.cliente = cliente; // Cliente adicionado automaticamente
        System.out.println("Novo pedido criado e cliente adicionado: " + cliente);
        notifyObservers("Nova reserva criada para o cliente: " + cliente.getNome());
    }

    public void setEstado(EstadoReserva estado) {
        this.estadoAtual = estado;
        notifyObservers("Estado da reserva mudou.");
    }

    public EstadoReserva getEstadoAtual() {
        return estadoAtual;
    }

    public void confirmar() {
        estadoAtual.confirmar();
    }

    public void cancelar() {
        estadoAtual.cancelar();
    }

    public void concluir() {
        estadoAtual.concluir();
    }
}

