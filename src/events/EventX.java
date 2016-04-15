/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package events;

import core.Event;
import core.SimCore;
import static events.PrichodC.VZDIALENOST;
import model.Car;
import model.Stavba;

/**
 *
 * @author Jožko
 */
public class EventX extends Event{
    
    public final static double VZDIALENOST = 0;
    

    public EventX(double casVykonania, SimCore core, Car car) {
        super(casVykonania, core, car);
    }

    @Override
    public void vykonaj() {
        
        car.setUsek("Cesta XC");
        Stavba st = (Stavba) core;
        
        
         double time = (VZDIALENOST / car.getRychlost()) * 60.0 + casVykonania;
        
        time = st.getLastPrichodC() < time ? time : st.getLastPrichodC();
        st.setLastPrichodC(time);
        
        st.naplanujEvent(new PrichodC(time, core, car));
        
        
    }
    
}
