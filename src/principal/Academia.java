package principal;

import controle.Controle;

public class Academia {
    public static void main(String[] args) {
        Controle controller = new Controle("12345", "Maria Santos", "2024-11-15");

        System.out.println("Simulando controle de reservas na academia:");
        controller.confirmarReserva();
        controller.concluirReserva();
        controller.cancelarReserva(); // Tentativa de cancelamento após conclusão
        controller.cancelarDefinitivamente(); // Verificação de cancelamento definitivo
    }
}

