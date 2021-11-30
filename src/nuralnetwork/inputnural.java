/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nuralnetwork;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class inputnural extends nural{


    public inputnural() {

    }

    inputnural(Double k) {
        this.Y=k;
    }

    public Double getY() {
        return Y;
    }
    public void intialNextWight( Wight result){
       
            nexwight.add(result);
        
        }

    
    
}