package modelo;

public class ReservaConcluida implements EstadoReserva {
    @Override
    public void confirmar() {
        System.out.println("Reserva já concluída, não pode ser confirmada.");
    }

    @Override
    public void cancelar() {
        System.out.println("Reserva concluída não pode ser cancelada.");
    }

    @Override
    public void concluir() {
        System.out.println("A reserva já está concluída.");
    }
}
