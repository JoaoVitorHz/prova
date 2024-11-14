package modelo;

public class ReservaConfirmada implements EstadoReserva {
    @Override
    public void confirmar() {
        System.out.println("A reserva já está confirmada.");
    }

    @Override
    public void cancelar() {
        System.out.println("Cancelando a reserva confirmada...");
    }

    @Override
    public void concluir() {
        System.out.println("Concluindo a reserva confirmada...");
    }
}