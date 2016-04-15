/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package events;

import core.Event;
import core.SimCore;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Car;

/**
 *
 * @author Jožko
 */
public class Refresh extends Event {

    private boolean plan;
    private boolean repeat;
    private double howTime;
    private long sleep;

    public Refresh(double howTime, SimCore core, long sleep) {
        super(core.getAktCas() + howTime, core, null);
        plan = false;
        repeat = false;
        this.howTime = howTime;
        this.sleep = sleep;
    }

    public double getHowTime() {
        return howTime;
    }

    public void setHowTime(double howTime) {
        this.howTime = howTime;
    }

    public boolean isPlan() {
        return plan;
    }

    public void setPlan(boolean plan) {
        this.plan = plan;

    }

    public boolean isRepeat() {
        return repeat;
    }

    public void setRepeat(boolean repeat) {
        this.repeat = repeat;
    }

    @Override
    public void vykonaj() {
        if (isPlan()) {
            try {

                core.refresh();
                Thread.sleep(sleep);
                casVykonania = casVykonania + getHowTime();
                core.naplanujEvent(this);
            } catch (InterruptedException ex) {
                System.out.println("Refresh error");
            }
        }

    }

    public long getSleep() {
        return sleep;
    }

    public void setSleep(long sleep) {
        this.sleep = sleep;
    }

}
