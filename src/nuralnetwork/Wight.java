/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nuralnetwork;

import java.util.Random;

/**
 *
 * @author Eng_Obada Qasrawi
 */
public class Wight {
    
    
    double w;

    public Wight() {
        double result = 0.0;
        double random = 0.0;
            random = new Random().nextDouble();
            result = - 2.4/35 + (random * (2.4/35 + 2.4/35));
           
        this.w= result;
    
    }

    public void setW(double w) {
        this.w = w;
    }
    
    
}
