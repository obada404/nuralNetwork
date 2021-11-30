/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nuralnetwork;

import java.util.*;
//import java.lang.Object
//ai.djl.nn.Activation

/**
 *
 * @author Eng_Obada Qasrawi
 */
public class nural {

    double Y ;
    double bias= 1;
    Wight biasw =new Wight();
    double gredintError;
    double alph = 0.1;
    boolean funcType;
   double daltabiasw=0;
    ArrayList<Double> daltawight = new ArrayList<>();
    ArrayList<nural> next = new ArrayList<nural>();
    ArrayList<nural> previos = new ArrayList<nural>();
    ArrayList<Wight> prewight = new ArrayList<Wight>();
    ArrayList<Wight> nexwight = new ArrayList<Wight>();
    public nural() {
   
    }

    public Double getY() {
        return Y;
    }

    public Double getBias() {
        return bias;
    }

    public void calculate_Y(boolean funcType ) {
        this.funcType=funcType;
      //  System.out.println(this.Y);
        
        double tmp=0;
        for (int i = 0; i < previos.size(); i++) {
//            System.out.println(previos.get(i).Y  +"                " +   prewight.get(i).w);
            tmp += previos.get(i).Y * prewight.get(i).w;
            
        }
        
        this.Y -= biasw.w;
        //System.out.println(this.Y);
//        if (funcType == false) {
            if (tmp < 0.0) {
                tmp = 0;
            } 
//        }
//        else
//        {
//            
//               tmp = Math.tanh(tmp);
//        }
        
        
        this.Y=tmp;
        
    }

    public void calculateYOutput() {
 double tmp=0;
        for (int i = 0; i < previos.size(); i++) {
            tmp += previos.get(i).Y * prewight.get(i).w;
           
        }
       tmp -= biasw.w;
//          System.out.println(Y  +"        ");
       
this.Y=tmp;
    }

    public void gradenterror() {
        double tmp  =0;
         double tmp2  =0;
//        if (funcType ==false) {
            if (this.Y < 0) {
                tmp = 0.0;
            } else {
                tmp = 1.0;
            }
//        } else {
//            tmp = 1 - Math.pow(Math.tanh(this.Y), 2);
//        }
        for (int i = 0; i < next.size(); i++) {
            tmp2 += next.get(i).gredintError * nexwight.get(i).w;
        }
         gredintError =tmp *tmp2;
    }
     public void gradentErrorOutput(double Ydes) {
                
                gredintError = Ydes - this.Y;
                
     }
     
             
             public  void calcWight(){
         
        for (int i = 0; i < previos.size(); i++) {
            if(daltawight.size() == previos.size())
                 daltawight.set(i,alph *
                         previos.get(i).Y * gredintError  +daltawight.get(i));
             else
            daltawight.add(alph * previos.get(i).Y * gredintError);
           
                
        }
      daltabiasw = ( -1*alph * gredintError +daltabiasw);
    }
    public  void changeWight(){
         double tmp  = biasw.w;
         biasw.w =0.0;
        for (int i = 0; i < previos.size(); i++) {
            prewight.get(i).setW(prewight.get(i).w + alph * previos.get(i).Y * gredintError);
        }
        biasw.w =tmp + ( -1* alph * gredintError );
    }
    
      public  void changeWight2(){
         double tmp  = biasw.w;
         biasw.w =0.0;
        for (int i = 0; i < previos.size(); i++) {
            prewight.get(i).setW(daltawight.get(i) + alph * previos.get(i).Y * gredintError);
        }
        biasw.w =daltabiasw + ( -1* alph * gredintError );
    }
//    public void backchngewight() {
//        for (int i = 0; i < previos.size(); i++) {
//            previos.get(i).nexwight.set(i, prewight.get(i));
//        }
//    }
    public void setBias(double bias) {
        this.bias = bias;
    }

    public void setGredintError(double gredintError) {
        this.gredintError = gredintError;
    }

    public double getGredintError() {
        return gredintError;
    }

     
}

