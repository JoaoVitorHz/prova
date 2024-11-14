package modelo;


public class ReservaController {
    private Reserva reserva;

    public ReservaController(String idReserva, String nomeCliente, String dataReserva) {
        this.reserva = new Reserva(idReserva, nomeCliente, dataReserva);
        
        // Adicionando observadores
        Observer clienteObserver = new ClienteNotificacaoObserver();
        Observer gerenteObserver = new GerenteNotificacaoObserver();
        
        this.reserva.addObserver(clienteObserver);
        this.reserva.addObserver(gerenteObserver);
    }

    public void adicionarObservador(Observer observer) {
        reserva.addObserver(observer);
    }

    public void removerObservador(Observer observer) {
        reserva.removeObserver(observer);
    }

    public void confirmarReserva() {
        if (reserva.getEstado() instanceof ReservaPendente) {
            reserva.setEstado(new ReservaConfirmada());
            reserva.confirmar();
        } else {
            System.out.println("A reserva não pode ser confirmada neste estado.");
        }
    }

    public void cancelarReserva() {
        if (reserva.getEstado() instanceof ReservaPendente || reserva.getEstado() instanceof ReservaConfirmada) {
            reserva.setEstado(new ReservaCancelada());
            reserva.cancelar();
        } else {
            System.out.println("A reserva não pode ser cancelada neste estado.");
        }
    }

    public void concluirReserva() {
        if (reserva.getEstado() instanceof ReservaConfirmada) {
            reserva.setEstado(new ReservaConcluida());
            reserva.concluir();
        } else {
            System.out.println("A reserva não pode ser concluída neste estado.");
        }
    }

    public void cancelarDefinitivamente() {
        if (reserva.getEstado() instanceof ReservaPendente || reserva.getEstado() instanceof ReservaConfirmada) {
            System.out.println("Cancelando definitivamente a reserva...");
            reserva.setEstado(new ReservaCancelada());
        } else {
            System.out.println("A reserva não pode ser cancelada definitivamente neste estado.");
        }
    }
}
