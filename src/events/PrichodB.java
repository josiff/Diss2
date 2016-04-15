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
public class PrichodB extends Event {

    public PrichodB(double casVykonania, SimCore core, Car car) {
        super(casVykonania, core, car);
    }

    @Override
    public void vykonaj() {
        
        car.setUsek("Prichod B");
        car.setZacCakania(casVykonania);
        
        Stavba st = (Stavba) core;
        if (st.isVykladac()) {
            st.addVykladanie(car);

        } else {
            st.setVykladac(true);
            st.naplanujEvent(new StartVykladania(casVykonania, core, car));

        }

    }

}
