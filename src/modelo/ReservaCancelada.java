package modelo;

public class ReservaCancelada implements EstadoReserva {
    @Override
    public void confirmar() {
        System.out.println("A reserva foi cancelada, não pode ser confirmada.");
    }

    @Override
    public void cancelar() {
        System.out.println("A reserva já está cancelada.");
    }

    @Override
    public void concluir() {
        System.out.println("Reserva cancelada não pode ser concluída.");
    }
}
