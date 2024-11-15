package principal;

import controle.ReservaController;
import modelo.ClienteNotificacaoObserver;
import modelo.GerenteNotificacaoObserver;

public class Academia {
    public static void main(String[] args) {
        ReservaController controller = new ReservaController("12345", "Maria Santos", "2024-11-15");

        ClienteNotificacaoObserver clienteObserver = new ClienteNotificacaoObserver();
        GerenteNotificacaoObserver gerenteObserver = new GerenteNotificacaoObserver();

        controller.adicionarObservador(clienteObserver);
        controller.adicionarObservador(gerenteObserver);

        System.out.println("Simulando controle de reservas na academia:");
        controller.confirmarReserva();
        controller.removerObservador(gerenteObserver); 
        controller.cancelarReserva(); 
        controller.removerObservador(clienteObserver); 
        controller.concluirReserva(); 
        controller.cancelarDefinitivamente();
    }
}

