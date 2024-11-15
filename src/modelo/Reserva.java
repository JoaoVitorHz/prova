package modelo;

public class Reserva extends Observable {
    private String idReserva;
    private String nomeCliente;
    private String dataReserva;
    private EstadoReserva estado;

    public Reserva(String idReserva, String nomeCliente, String dataReserva) {
        try {
            this.idReserva = idReserva;
            this.nomeCliente = nomeCliente;
            this.dataReserva = dataReserva;
            this.estado = new ReservaPendente(); // Estado inicial

            System.out.println("Reserva criada: ID = " + idReserva + ", Cliente = " + nomeCliente + ", Data = " + dataReserva);
            notifyObservers("Reserva inicializada para o cliente: " + nomeCliente);
        } catch (Exception e) {
            System.out.println("Erro ao criar a reserva: " + e.getMessage());
        }
    }

    public void setEstado(EstadoReserva estado) {
        try {
            if (getObservers().isEmpty()) {
                throw new IllegalStateException("A reserva não pode mudar de estado sem ter pelo menos um observador.");
            }

            if (!isOperacaoConcretizada()) {
                throw new IllegalStateException("A operação relacionada não foi concretizada. O estado não pode ser alterado.");
            }

            this.estado = estado;
            System.out.println("Estado da reserva atualizado para: " + estado.getClass().getSimpleName());
            notifyObservers("Estado da reserva alterado para: " + estado.getClass().getSimpleName());
        } catch (IllegalStateException e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro inesperado ao alterar o estado da reserva: " + e.getMessage());
        }
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
        try {
            estado.confirmar();
        } catch (Exception e) {
            System.out.println("Erro ao confirmar a reserva: " + e.getMessage());
        }
    }

    public void cancelar() {
        try {
            estado.cancelar();
        } catch (Exception e) {
            System.out.println("Erro ao cancelar a reserva: " + e.getMessage());
        }
    }

    public void concluir() {
        try {
            estado.concluir();
        } catch (Exception e) {
            System.out.println("Erro ao concluir a reserva: " + e.getMessage());
        }
    }

    private boolean isOperacaoConcretizada() {
        return true; 
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "idReserva='" + idReserva + '\'' +
                ", nomeCliente='" + nomeCliente + '\'' +
                ", dataReserva='" + dataReserva + '\'' +
                ", estado=" + estado.getClass().getSimpleName() +
                '}';
    }

}

