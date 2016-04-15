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
public class EndNakladania extends Event {
    
    public final static double VZDIALENOST = 45;
    
    public EndNakladania(double casVykonania, SimCore core, Car car) {
        super(casVykonania, core, car);
    }
    
    @Override
    public void vykonaj() {
        
        car.setUsek("Cesta AB");
        
        Stavba st = (Stavba) core;
        Car next = st.getNextNakladanie();
        if (next == null) {
            st.setNakladac(false);
            
        } else {
            st.naplanujEvent(new StartNakladania(casVykonania, core, next));
        }
        
        car.setNalozene(Math.min(st.getMnozMat(), car.getObjem()));
        st.setMnozMat(st.getMnozMat() - car.getNalozene());
        
        double time = (VZDIALENOST / car.getRychlost()) * 60.0 + casVykonania;
        
        time = st.getLastPrichodB() < time ? time : st.getLastPrichodB();
        st.setLastPrichodB(time);
        
        st.naplanujEvent(new PrichodB(time, core, car));
        
    }
    
}
