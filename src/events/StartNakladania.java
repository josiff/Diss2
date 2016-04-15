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
public class StartNakladania extends Event {

    public final static double NAKLADANIE = 180;

    public StartNakladania(double casVykonania, SimCore core, Car car) {
        super(casVykonania, core, car);
    }

    @Override
    public void vykonaj() {
        
        car.setUsek("Nakladanie");
        Stavba st = (Stavba) core;
        
        
            core.getStatistic().addCakanieNakladac(casVykonania - car.getZacCakania());
            car.setZacCakania(0);
        
        
        
        
        
        if (st.getMnozMat() > 0) {

            double objem = Math.min(st.getMnozMat(), car.getObjem());
            double time = (objem / NAKLADANIE) * 60;
            car.setEndObsluhy(time + casVykonania);
            car.setStartObsluhy(casVykonania);

            st.naplanujEvent(new EndNakladania(time + getCasVykonania(), core, car));
        }

    }

}
