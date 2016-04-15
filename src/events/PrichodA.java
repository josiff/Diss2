/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package events;

import core.Event;
import core.SimCore;
import model.*;

/**
 *
 * @author Jožko
 */
public class PrichodA extends Event{
    
    
     public PrichodA(double casVykonania, SimCore core, Car car) {
        super(casVykonania, core, car);
    }

    @Override
    public void vykonaj() {
        
        car.setUsek("Prichod A");
        car.setZacCakania(casVykonania);
        Stavba st = (Stavba)core;
        if(st.getMnozMat() > 0){
        
            if(st.isNakladac()){
                st.addNakladanie(car);
            }else{
                st.setNakladac(true);
                st.naplanujEvent(new StartNakladania(getCasVykonania(), core, car));
            }
        
        
        }
        
    }
    
}
