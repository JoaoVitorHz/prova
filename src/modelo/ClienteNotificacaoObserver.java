package modelo;


public class ClienteNotificacaoObserver implements Observer {
    @Override
    public void update(String mensagem) {
        System.out.println("Notificação ao cliente: " + mensagem);
    }
}
