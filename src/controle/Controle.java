
package controle;

import modelo.Reserva;
import modelo.Cliente;
import modelo.Observer;
import modelo.ReservaCancelada;
import modelo.ReservaConcluida;
import modelo.ReservaConfirmada;
import modelo.ReservaPendente;

public class Controle implements Observer {
      private Reserva reserva;

    public Controle(String idReserva, String nomeCliente, String dataReserva) {
        this.reserva = new Reserva(idReserva, nomeCliente, dataReserva);
        reserva.addObserver(this);
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

    @Override
    public void update(String mensagem) {
        System.out.println("Notificação: " + mensagem);
    }
}
