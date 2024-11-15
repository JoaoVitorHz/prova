package controle;

import modelo.ClienteNotificacaoObserver;
import modelo.GerenteNotificacaoObserver;
import modelo.Observer;
import modelo.Reserva;
import modelo.ReservaCancelada;
import modelo.ReservaConcluida;
import modelo.ReservaConfirmada;
import modelo.ReservaPendente;

public class ReservaController {
    private Reserva reserva;

    public ReservaController(String idReserva, String nomeCliente, String dataReserva) {
        try {
            this.reserva = new Reserva(idReserva, nomeCliente, dataReserva);

            Observer clienteObserver = new ClienteNotificacaoObserver();
            Observer gerenteObserver = new GerenteNotificacaoObserver();

            this.reserva.addObserver(clienteObserver);
            this.reserva.addObserver(gerenteObserver);
        } catch (Exception e) {
            System.out.println("Erro ao criar a reserva no controller: " + e.getMessage());
        }
    }

    public void adicionarObservador(Observer observer) {
        try {
            reserva.addObserver(observer);
        } catch (Exception e) {
            System.out.println("Erro ao adicionar observador: " + e.getMessage());
        }
    }

    public void removerObservador(Observer observer) {
        try {
            reserva.removeObserver(observer);
        } catch (Exception e) {
            System.out.println("Erro ao remover observador: " + e.getMessage());
        }
    }

    public void confirmarReserva() {
        try {
            if (reserva.getEstado() instanceof ReservaPendente) {
                reserva.setEstado(new ReservaConfirmada());
                reserva.confirmar();
            } else {
                System.out.println("A reserva não pode ser confirmada neste estado.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao confirmar a reserva: " + e.getMessage());
        }
    }

    public void cancelarReserva() {
        try {
            if (reserva.getEstado() instanceof ReservaPendente || reserva.getEstado() instanceof ReservaConfirmada) {
                reserva.setEstado(new ReservaCancelada());
                reserva.cancelar();
            } else {
                System.out.println("A reserva não pode ser cancelada neste estado.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao cancelar a reserva: " + e.getMessage());
        }
    }

    public void concluirReserva() {
        try {
            if (reserva.getEstado() instanceof ReservaConfirmada) {
                reserva.setEstado(new ReservaConcluida());
                reserva.concluir();
            } else {
                System.out.println("A reserva não pode ser concluída neste estado.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao concluir a reserva: " + e.getMessage());
        }
    }

    public void cancelarDefinitivamente() {
        try {
            if (reserva.getEstado() instanceof ReservaPendente || reserva.getEstado() instanceof ReservaConfirmada) {
                System.out.println("Cancelando definitivamente a reserva...");
                reserva.setEstado(new ReservaCancelada());
            } else {
                System.out.println("A reserva não pode ser cancelada definitivamente neste estado.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao cancelar definitivamente a reserva: " + e.getMessage());
        }
    }
}

