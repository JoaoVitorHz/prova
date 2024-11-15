package modelo;

import java.util.ArrayList;
import java.util.List;

public class Observable {
    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        try {
            if (!observers.contains(observer)) {
                observers.add(observer);
                System.out.println("Observador adicionado: " + observer.getClass().getSimpleName());
            }
        } catch (Exception e) {
            System.out.println("Erro ao adicionar observador: " + e.getMessage());
        }
    }

    public void removeObserver(Observer observer) {
        try {
            if (observers.remove(observer)) {
                System.out.println("Observador removido: " + observer.getClass().getSimpleName());
            } else {
                System.out.println("Observador não encontrado: " + observer.getClass().getSimpleName());
            }
        } catch (Exception e) {
            System.out.println("Erro ao remover observador: " + e.getMessage());
        }
    }

    public void notifyObservers(String mensagem) {
        for (Observer observer : observers) {
            try {
                observer.update(mensagem);
            } catch (Exception e) {
                System.out.println("Erro ao notificar observador " + observer.getClass().getSimpleName() + ": " + e.getMessage());
            }
        }
    }

    protected List<Observer> getObservers() {
        return observers;
    }
}
