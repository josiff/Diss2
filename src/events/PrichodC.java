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
public class PrichodC extends Event{
    
    public final static double VZDIALENOST = 35;

    public PrichodC(double casVykonania, SimCore core, Car car) {
        super(casVykonania, core, car);
    }

    @Override
    public void vykonaj() {
        
        car.setUsek("Prichod C");
        Stavba st = (Stavba) core;
        
        
         double time = (VZDIALENOST / car.getRychlost()) * 60.0 + casVykonania;
        
        time = st.getLastPrichodA() < time ? time : st.getLastPrichodA();
        st.setLastPrichodA(time);
        
        st.naplanujEvent(new PrichodA(time, core, car));
        
    }
    
}
