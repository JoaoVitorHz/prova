package modelo;

// import modelo.Observable;
// import modelo.EstadoReserva;
// import modelo.ReservaConfirmada;

public class Reserva extends Observable {
    private String idReserva;
    private String nomeCliente;
    private String dataReserva;
    private EstadoReserva estado;

    public Reserva(String idReserva, String nomeCliente, String dataReserva) {
        this.idReserva = idReserva;
        this.nomeCliente = nomeCliente;
        this.dataReserva = dataReserva;
        this.estado = new ReservaPendente(); // Estado inicial

        System.out.println("Reserva criada: ID = " + idReserva + ", Cliente = " + nomeCliente + ", Data = " + dataReserva);
        notifyObservers("Reserva inicializada para o cliente: " + nomeCliente);
    }

    public void setEstado(EstadoReserva estado) {
        this.estado = estado;
        System.out.println("Estado da reserva atualizado para: " + estado.getClass().getSimpleName());
        notifyObservers("Estado da reserva alterado para: " + estado.getClass().getSimpleName());
    }

    public EstadoReserva getEstado() {
        return estado;
    }

    public String getIdReserva() {
        return idReserva;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public String getDataReserva() {
        return dataReserva;
    }

    public void confirmar() {
        estado.confirmar();
    }

    public void cancelar() {
        estado.cancelar();
    }

    public void concluir() {
        estado.concluir();
    }

    @Override
    public String toString() {
        return "ReservaTAD{" +
                "idReserva='" + idReserva + '\'' +
                ", nomeCliente='" + nomeCliente + '\'' +
                ", dataReserva='" + dataReserva + '\'' +
                ", estado=" + estado.getClass().getSimpleName() +
                '}';
    }
}

