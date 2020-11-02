package com.epam.adilkhan.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

public class ExchangerExample {
    public static void main(String[] args) {
        Exchanger<Action> exchanger = new Exchanger<>();

        List<Action> friend1 = new ArrayList<>();
        friend1.add(Action.NOJNICY);
        friend1.add(Action.BUMAGA);
        friend1.add(Action.NOJNICY);

        List<Action> friend2 = new ArrayList<>();
        friend2.add(Action.BUMAGA);
        friend2.add(Action.KAMEN);
        friend2.add(Action.KAMEN);

        new BestFriend("Vanya", friend1, exchanger);
        new BestFriend("Petya", friend2, exchanger);
    }
}

enum Action {
    KAMEN,
    NOJNICY,
    BUMAGA
}

class BestFriend extends Thread {
    private String name;

    private List<Action> myActions;

    private Exchanger<Action> exchanger;

    public BestFriend(String name, List<Action> myActions, Exchanger<Action> exchanger) {
        this.name = name;
        this.myActions = myActions;
        this.exchanger = exchanger;
        this.start();
    }

    @Override
    public void run() {
        Action reply;
        for (Action action : myActions) {
            try {
                reply = exchanger.exchange(action);
                whoWins(action, reply);
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void whoWins(Action myAction, Action friendsAction) {
        if ((myAction == Action.KAMEN && friendsAction == Action.NOJNICY)
                || (myAction == Action.NOJNICY && friendsAction == Action.BUMAGA)
                || (myAction == Action.BUMAGA && friendsAction == Action.KAMEN)) {
            System.out.println(name + " Wins!!!");
        }
    }
}