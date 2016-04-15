/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rozdelenia;

import java.util.Random;
import model.Car;

/**
 *
 * @author Jožko
 */
public class Generator {
      private Random rnd;

    public Generator(Random seed) {       
        this.rnd = new Random(seed.nextLong());   
    }

    public double getNext() {
        return rnd.nextDouble();

    }

    private boolean isPokazene(Car car) {
        double d = getNext();
        //System.out.println("*****" + d + " car " + car.getTyp() + " ********" );        
        return d < car.getPravPoruch();
    }

    public double getDlzkuOpravy(Car car) {

        if (isPokazene(car)) {

            return car.getOprava() ;
        } else {
            return 0.0;
        }

    }
}
