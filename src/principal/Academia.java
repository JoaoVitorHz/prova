package principal;

import controle.Controle;

public class Academia {
    public static void main(String[] args) {
        // Criando uma nova reserva e adicionando um cliente automaticamente
        Controle controller = new Controle("João Silva", "joao.silva@example.com");

        System.out.println("Simulando controle de reservas na academia:");
        controller.confirmarReserva();
        controller.cancelarReserva();
        controller.concluirReserva();
    }
}


