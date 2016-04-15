/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import model.Car;

/**
 *
 * @author Jožko
 */
public abstract class Event implements Comparable<Event> {
    
    protected double casVykonania;
    protected SimCore core;
    protected Car car;
    protected long eventId;
    
    
     public Event(double casVykonania, SimCore core, Car car) {
        
        this.core = core;
        this.casVykonania = casVykonania;
        this.car = car;
    }

    public double getCasVykonania() {
        return casVykonania;
    }
    
    abstract public void vykonaj();

    public Car getCar() {
        return car;
    }

    @Override
    public int compareTo(Event ev) {
       
        int cmp = Double.compare(casVykonania, ev.getCasVykonania());
		if (cmp == 0) {
			return Long.compare(eventId, ev.eventId);
		}
		else {
			return cmp;
		}

         
    }
    
}
