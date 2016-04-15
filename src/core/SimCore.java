/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import events.Refresh;
import java.util.Hashtable;
import java.util.Observable;
import java.util.PriorityQueue;
import java.util.Random;
import rozdelenia.Generator;

/**
 *
 * @author Jožko
 */
public abstract class SimCore extends Observable {

    protected PriorityQueue<Event> casovaOs;
    protected Random mainRnd;
    protected double aktCas;
    protected double trvanie;

   
    protected Refresh refreshEvent;
    private long evenIdCounter;
    protected Statistic statistic;
    protected Hashtable<String, Generator> rozdelenia;
    private boolean simMode;
    private double pocRep;
    private boolean stop;

    private boolean running;

    public SimCore(double trvanie) {
        this.trvanie = trvanie;
        this.casovaOs = new PriorityQueue<>();
        this.aktCas = 0.0;
        this.mainRnd = new Random();
        this.evenIdCounter = Long.MIN_VALUE;
        this.statistic = new Statistic();
        this.rozdelenia = new Hashtable<>();
        this.running = true;
        this.stop = true;
        this.pocRep = 1;

    }

    public Statistic getStatistic() {
        return statistic;
    }

    abstract public void simuluj();

    abstract public void initCar();

    abstract public void initVariant();

    protected void resetSim() {

    }

    public void naplanujEvent(Event e) {

        if (e.getCasVykonania() > this.trvanie) {
            return;
        }

        e.eventId = e.core.getNextEventId();
        this.casovaOs.add(e);

    }

    public double getAktCas() {
        return aktCas;
    }

    public long getNextEventId() {
        return evenIdCounter++;
    }

    public void runReplikacie() {

        Thread t = new Thread("simCore") {
            public void run() {

                for (int i = 0; i < getPocRep(); i++) {
                    initVariant();
                    simuluj();
                    resetSim();
                    // setValue();

                    if (isStop()) {
                        break;
                    }

                }
                running = false;
                stop = true;
                System.out.println(
                        "Priemerný čas trvania: " + statistic.getAvgTrvania());
                System.out.println(
                        "Dní: " + statistic.getAvgTrvania() / 24);

                System.out.println("Priemerny cas cakanai nakl " + statistic.getAvgTimeNakladac());
                System.out.println("Priemerny cas cakanai vykl " + statistic.getAvgTimeVykladac());

                System.out.println("Priem pocet nakl " + statistic.getRadNakPocet() / statistic.getAktReplikacia());
               // System.out.println("Priem pocet vykl " + statistic.getRadVykPocet() / 1000);
                System.out.println("< " + statistic.getSpodny90PercIS() + " ; " + statistic.getHorny90PercIS() + " >");

            }

        };
        t.start();

    }

    protected void checkForPaused() {

        while (!this.running) {
            try {
                Thread.sleep(10);
                wait();
            } catch (Exception e) {
            }
        }

    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public void clearCasOs() {
        casovaOs.clear();
    }

    public Refresh getRefreshEvent() {
        return refreshEvent;
    }

    public void refresh() {
        setChanged();
        notifyObservers();
    }

    public double getPocRep() {
        return pocRep;
    }

    public void setPocRep(double pocRep) {
        this.pocRep = pocRep;
    }

    public void runRest() {
        statistic.resetStatistic();
        resetSim();

    }

    public boolean isStop() {
        return stop;
    }

    public void setStop(boolean stop) {
        this.stop = stop;
    }
    
     public double getTrvanie() {
        return trvanie;
    }

    public void setTrvanie(double trvanie) {
        this.trvanie = trvanie;
    }

}
