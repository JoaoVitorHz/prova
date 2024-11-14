package principal;

import modelo.ClienteNotificacaoObserver;
import modelo.GerenteNotificacaoObserver;
import modelo.ReservaController;

public class Academia {
    public static void main(String[] args) {
        ReservaController controller = new ReservaController("12345", "Maria Santos", "2024-11-15");

        // Adicionando observadores dinamicamente
        ClienteNotificacaoObserver clienteObserver = new ClienteNotificacaoObserver();
        GerenteNotificacaoObserver gerenteObserver = new GerenteNotificacaoObserver();

        controller.adicionarObservador(clienteObserver);
        controller.adicionarObservador(gerenteObserver);

        System.out.println("Simulando controle de reservas na academia:");
        controller.confirmarReserva();
        controller.removerObservador(gerenteObserver); // Removendo observador
        controller.cancelarReserva();
        controller.concluirReserva();
        controller.cancelarDefinitivamente();
    }
}

