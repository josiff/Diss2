package stavba;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import model.Stavba;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Jožko
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Stavba st = new Stavba(1000 * 24 * 60);
        /*st.initCar();
        st.runReplikacie();*/
      
        
    
       
       
        
        new gui.GUI().setVisible(true);

    }

}
