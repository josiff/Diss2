/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package events;

import core.Event;
import core.SimCore;
import model.Car;
import model.Stavba;

/**
 *
 * @author Jožko
 */
public class StartVykladania extends Event {

    public final static double VYKLADANIE = 200;

    public StartVykladania(double casVykonania, SimCore core, Car car) {
        super(casVykonania, core, car);
    }

    @Override
    public void vykonaj() {

        car.setUsek("Vykladanie");
        Stavba st = (Stavba) core;

        core.getStatistic().addCakanieVykladac(casVykonania - car.getZacCakania());
        car.setZacCakania(0);

        double time = (car.getNalozene() / VYKLADANIE) * 60.0 + casVykonania;
        car.setEndObsluhy(time);
        car.setStartObsluhy(casVykonania);
        st.naplanujEvent(new EndVykladania(time, core, car));

    }

}
