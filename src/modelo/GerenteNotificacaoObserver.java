package modelo;

public class GerenteNotificacaoObserver implements Observer{
    @Override
    public void update(String mensagem) {
        System.out.println("Notificação ao gerente: " + mensagem);
    }
}
