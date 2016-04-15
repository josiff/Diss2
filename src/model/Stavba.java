/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import core.Event;
import core.SimCore;
import events.PrichodA;
import events.Refresh;
import java.util.HashMap;
import java.util.LinkedList;
import rozdelenia.Generator;

/**
 *
 * @author Jožko
 */
public class Stavba extends SimCore {

    private LinkedList<Car> radNakladanie;
    private LinkedList<Car> radVykladanie;

    private HashMap<String, Car> garage;

    private boolean nakladac, vykladac;

    private double sklad = 5000;
    private double mnozMat = sklad;
    private double dovezene = 0;
    private Refresh refreshEvent;
    private double lastPrichodA, lastPrichodB, lastPrichodC;
    private int variant;
    private double repDelay;
    private double lastChanNak;
    private double lastChVyk;

    public Stavba(double trvanie) {
        super(trvanie);
        this.nakladac = false;
        this.vykladac = false;
        radNakladanie = new LinkedList<>();
        radVykladanie = new LinkedList<>();
        garage = new HashMap<>();
        refreshEvent = new Refresh(0.001, this, 10);
        lastPrichodA = 0;
        lastPrichodB = 0;
        lastPrichodC = 0;
        variant = 1;
        repDelay = 0.4;
        lastChanNak = 0;
        lastChVyk = 0;

    }

    @Override
    public void simuluj() {

        Event ev = this.casovaOs.remove();
        this.aktCas = ev.getCasVykonania();

        if (refreshEvent.isPlan()) {
            naplanujEvent(refreshEvent);

        } else {

            refresh();

        }
        while (this.aktCas <= this.trvanie) {

            checkForPaused();

            if (isStop()) {
                break;
            }

            // System.out.println(mnozMat + " --- " + dovezene);
            ev.vykonaj();

            //System.out.println(aktCas + " --- " + ev.getClass().getName() + "  -- " + ev.getCar().getTyp() + " -- " + ev.getCar().getNalozene());
            if (!this.casovaOs.isEmpty()) {
                ev = this.casovaOs.remove();

                this.aktCas = ev.getCasVykonania();

            } else {

                break;
            }

        }
        
       statistic.addRadNakPocet(statistic.getRadNakladac()/ statistic.getTest());
        ///   statistic.addRadVykPocet(statistic.getRadVykladac() / lastChVyk);
        statistic.addCasTrvania(this.aktCas);

    }

    @Override
    public void initCar() {

        Car car = null;

        //variant 1
        car = new Car("A1", 60, 0.12, 80, 10);
        addRozdelenie(car);
        addToGarage(car);

        car = new Car("A2", 50, 0.04, 50, 20);
        addRozdelenie(car);
        addToGarage(car);

        car = new Car("A3", 45, 0.04, 100, 25);
        addRozdelenie(car);
        addToGarage(car);

        car = new Car("A4", 70, 0.11, 44, 5);
        addRozdelenie(car);
        addToGarage(car);

        car = new Car("A5", 30, 0.06, 170, 40);

        addRozdelenie(car);
        addToGarage(car);

    }

    @Override
    public void initVariant() {

        switch (getVariant()) {
            case 1:
                naplanujEvent(new PrichodA(aktCas, this, getCar("A1")));
                naplanujEvent(new PrichodA(aktCas, this, getCar("A2")));
                naplanujEvent(new PrichodA(aktCas, this, getCar("A3")));
                naplanujEvent(new PrichodA(aktCas, this, getCar("A4")));
                break;
            case 2:
                naplanujEvent(new PrichodA(aktCas, this, getCar("A1")));
                naplanujEvent(new PrichodA(aktCas, this, getCar("A3")));
                naplanujEvent(new PrichodA(aktCas, this, getCar("A5")));
                break;
            case 3:
                naplanujEvent(new PrichodA(aktCas, this, getCar("A2")));
                naplanujEvent(new PrichodA(aktCas, this, getCar("A3")));
                naplanujEvent(new PrichodA(aktCas, this, getCar("A4")));

                break;
        }

    }

    public void addToGarage(Car car) {
        garage.put(car.getTyp(), car);
    }

    public Car getCar(String key) {
        return garage.get(key);
    }

    protected void addRozdelenie(Car car) {
        rozdelenia.put(car.getTyp(), new Generator(mainRnd));
    }

    public void addNakladanie(Car car) {
        //car.setZacCakania(getAktCas());

        statistic.addRadNakl(radNakladanie.size(), (aktCas - lastChanNak));

        lastChanNak = aktCas;
        radNakladanie.addLast(car);
    }

    public Car getNextNakladanie() {
        return radNakladanie.pollFirst();
    }

    public Car getNextVykladanie() {
        return radVykladanie.pollFirst();
    }

    public void addVykladanie(Car car) {
        // car.setZacCakania(getAktCas());

        double value = (aktCas - lastChVyk) * radVykladanie.size();
        // statistic.addRadVykl(value);
        lastChVyk = aktCas;
        radVykladanie.addLast(car);
    }

    public boolean isNakladac() {
        return nakladac;
    }

    public void setNakladac(boolean nakladac) {
        this.nakladac = nakladac;
    }

    public boolean isVykladac() {
        return vykladac;
    }

    public void setVykladac(boolean vykladac) {
        this.vykladac = vykladac;
    }

    public double getSklad() {
        return sklad;
    }

    public void setSklad(double sklad) {
        this.sklad = sklad;
    }

    public double getMnozMat() {
        return mnozMat;
    }

    public void setMnozMat(double mnozMat) {
        this.mnozMat = mnozMat;
    }

    public double getDovezene() {
        return dovezene;
    }

    public void setDovezene(double dovezene) {
        this.dovezene = dovezene;
    }

    public Refresh getRefreshEvent() {
        return refreshEvent;
    }

    public void setRefreshEvent(Refresh refreshEvent) {
        this.refreshEvent = refreshEvent;
    }

    public double getLastPrichodA() {
        return lastPrichodA;
    }

    public void setLastPrichodA(double lastPrichodA) {
        this.lastPrichodA = lastPrichodA;
    }

    public double getLastPrichodB() {
        return lastPrichodB;
    }

    public void setLastPrichodB(double lastPrichodB) {
        this.lastPrichodB = lastPrichodB;
    }

    public int getVariant() {
        return variant;
    }

    public void setVariant(int variant) {
        this.variant = variant;
    }

    @Override
    public void resetSim() {
        super.resetSim();

        aktCas = 0;
        dovezene = 0;
        mnozMat = sklad;
        casovaOs.clear();
        setLastPrichodA(0);
        setLastPrichodB(0);
        setLastPrichodC(0);
        radNakladanie.clear();
        radVykladanie.clear();
        setNakladac(false);
        setVykladac(false);
        lastChVyk = 0;
        lastChanNak = 0;
        statistic.setTest(0);
        statistic.setRadNakladac(0);
         //statistic.setRadVykladac(0);
        garage.values().stream().forEach((car) -> {
            car.setNalozene(0);
            car.setUsek("");
            car.setZacCakania(0);

        });

    }

    public double getOpravu(Car car) {

        return rozdelenia.get(car.getTyp()).getDlzkuOpravy(car);
    }

    public LinkedList<Car> getRadNakladanie() {
        return radNakladanie;
    }

    public LinkedList<Car> getRadVykladanie() {
        return radVykladanie;
    }

    public double getLastPrichodC() {
        return lastPrichodC;
    }

    public void setLastPrichodC(double lastPrichodC) {
        this.lastPrichodC = lastPrichodC;
    }
    
    

}
