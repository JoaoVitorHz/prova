
package controle;

import modelo.Reserva;
import modelo.Cliente;
import modelo.Observer;
import modelo.ReservaCancelada;
import modelo.ReservaConfirmada;
import modelo.ReservaPendente;

public class Controle implements Observer {
private Reserva reserva;

    public Controle(String nomeCliente, String emailCliente) {
        Cliente cliente = new Cliente(nomeCliente, emailCliente);
        this.reserva = new Reserva(cliente);
        reserva.addObserver(this);
    }

    public void confirmarReserva() {
        reserva.setEstado(new ReservaConfirmada());
        reserva.confirmar();
    }

    public void cancelarReserva() {
        reserva.setEstado(new ReservaCancelada());
        reserva.cancelar();
    }

    public void concluirReserva() {
        reserva.concluir();
    }

    public void cancelarDefinitivamente() {
        if (reserva.getEstadoAtual() instanceof ReservaConfirmada || reserva.getEstadoAtual() instanceof ReservaPendente) {
            System.out.println("Cancelando definitivamente a reserva...");
            reserva.setEstado(new ReservaCancelada());
        } else {
            System.out.println("A reserva não pode ser cancelada definitivamente neste estado.");
        }
    }

    @Override
    public void update(String mensagem) {
        System.out.println("Notificação: " + mensagem);
    }
}
