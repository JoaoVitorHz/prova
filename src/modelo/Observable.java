package modelo;

import java.util.ArrayList;
import java.util.List;

public class Observable {
    private List<Observer> observers = new ArrayList<>();

    // Método para adicionar um observador
    public void addObserver(Observer observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
            System.out.println("Observador adicionado: " + observer.getClass().getSimpleName());
        }
    }

    // Método para remover um observador
    public void removeObserver(Observer observer) {
        if (observers.remove(observer)) {
            System.out.println("Observador removido: " + observer.getClass().getSimpleName());
        } else {
            System.out.println("Observador não encontrado: " + observer.getClass().getSimpleName());
        }
    }

    // Método para notificar todos os observadores
    public void notifyObservers(String mensagem) {
        for (Observer observer : observers) {
            observer.update(mensagem);
        }
    }
}
