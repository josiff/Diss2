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
public class EndVykladania extends Event {

    public final static double VZDIALENOST = 15;

    public EndVykladania(double casVykonania, SimCore core, Car car) {
        super(casVykonania, core, car);
    }

    @Override
    public void vykonaj() {
        car.setUsek("Cesta BX");
        Stavba st = (Stavba) core;
        st.setDovezene(st.getDovezene() + car.getNalozene());
        car.setNalozene(0);

        Car next = st.getNextVykladanie();
        if (next == null) {
            st.setVykladac(false);
        } else {
            st.naplanujEvent(new StartVykladania(casVykonania, core, next));
        }

        if (st.getMnozMat() > 0) {

            double time = (VZDIALENOST / (car.getRychlost()/2)) * 60.0 + casVykonania + st.getOpravu(car);
            st.naplanujEvent(new EventX(time, core, car));

        }

        if (st.getDovezene() == st.getSklad() && st.getMnozMat() == 0) {
            st.clearCasOs();
        }

    }

}
