package modelo;

//Estado para reserva pedente
public class ReservaPendente implements EstadoReserva{
    @Override
    public void confirmar() {
        System.out.println("Confirmando a reserva pendente...");
    }

    @Override
    public void cancelar() {
        System.out.println("Cancelando a reserva pendente...");
    }

    @Override
    public void concluir() {
        System.out.println("Reserva pendente não pode ser concluída diretamente.");
    }
}
