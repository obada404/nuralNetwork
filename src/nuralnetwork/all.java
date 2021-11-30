/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nuralnetwork;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import javafx.util.Pair;

/**
 *
 * @author Eng_Obada Qasrawi
 */
public class all {

    public static double softmax(double input, double[] neuronValues) {
        double total;
        total = Arrays.stream(neuronValues).map(Math::exp).sum();
        return Math.exp(input) / total;
    }
    public 
    ArrayList< double[]> zero = new ArrayList< double[]>();
    ArrayList< double[]> one = new ArrayList< double[]>();
    ArrayList< double[]> two = new ArrayList< double[]>();
    ArrayList< double[]> three = new ArrayList< double[]>();
    ArrayList< double[]> four = new ArrayList< double[]>();
    ArrayList< double[]> five = new ArrayList< double[]>();
    ArrayList< double[]> six = new ArrayList< double[]>();
    ArrayList< double[]> seven = new ArrayList< double[]>();
    ArrayList< double[]> eight = new ArrayList< double[]>();
    ArrayList< double[]> nine = new ArrayList< double[]>();
public
    double[] zero0 = {
        0.0, 0.0, 0.0, 0.0, 0.0,
        0.0, 0.0, 0.0, 0.0, 0.0,
        0.0, 0.0, 1.0, 1.0, 0.0,
        0.0, 0.0, 1.0, 1.0, 0.0,
        0.0, 0.0, 0.0, 0.0, 0.0,
        0.0, 0.0, 0.0, 0.0, 0.0,
        0.0, 0.0, 0.0, 0.0, 0.0
    };
    double[] one0 = {
        0.0, 0.0, 0.0, 0.0, 0.0,
        0.0, 0.0, 1.0, 0.0, 0.0,
        0.0, 0.0, 1.0, 0.0, 0.0,
        0.0, 0.0, 1.0, 0.0, 0.0,
        0.0, 0.0, 1.0, 0.0, 0.0,
        0.0, 0.0, 1.0, 0.0, 0.0,
        0.0, 0.0, 0.0, 0.0, 0.0
    };
    double[] two0 = {
        0.0, 0.0, 0.0, 0.0, 0.0,
        1.0, 0.0, 0.0, 1.0, 0.0,
        1.0, 1.0, 1.0, 0.0, 0.0,
        1.0, 0.0, 0.0, 0.0, 0.0,
        1.0, 0.0, 0.0, 0.0, 0.0,
        1.0, 0.0, 0.0, 0.0, 0.0,
        0.0, 0.0, 0.0, 0.0, 0.0
    };
    double[] three0 = {
        0.0, 0.0, 0.0, 0.0, 0.0,
        1.0, 0.0, 1.0, 0.0, 1.0,
        1.0, 1.0, 0.0, 1.0, 0.0,
        1.0, 0.0, 0.0, 0.0, 0.0,
        1.0, 0.0, 0.0, 0.0, 0.0,
        1.0, 0.0, 0.0, 0.0, 0.0,
        0.0, 0.0, 0.0, 0.0, 0.0
    };
    double[] four0 = {
        0.0, 0.0, 0.0, 0.0, 0.0,
        0.0, 1.0, 1.0, 1.0, 1.0,
        0.0, 0.0, 1.0, 0.0, 0.0,
        0.0, 0.0, 0.0, 1.0, 0.0,
        0.0, 0.0, 1.0, 0.0, 0.0,
        0.0, 1.0, 0.0, 0.0, 0.0,
        0.0, 1.0, 1.0, 1.0, 1.0
    };
    double[] five0 = {
        0.0, 0.0, 0.0, 0.0, 0.0,
        0.0, 0.0, 1.0, 0.0, 0.0,
        0.0, 1.0, 0.0, 1.0, 0.0,
        1.0, 0.0, 0.0, 0.0, 1.0,
        1.0, 0.0, 0.0, 0.0, 1.0,
        1.0, 0.0, 0.0, 0.0, 1.0,
        0.0, 1.0, 1.0, 1.0, 0.0
    };
    double[] six0 = {
        0.0, 0.0, 0.0, 0.0, 0.0,
        0.0, 1.0, 0.0, 0.0, 1.0,
        0.0, 0.0, 1.0, 1.0, 1.0,
        0.0, 0.0, 0.0, 0.0, 1.0,
        0.0, 0.0, 0.0, 0.0, 1.0,
        0.0, 0.0, 0.0, 0.0, 1.0,
        0.0, 0.0, 0.0, 0.0, 1.0
    };
    double[] seven0 = {
        0.0, 0.0, 0.0, 0.0, 0.0,
        0.0, 0.0, 0.0, 0.0, 0.0,
        1.0, 0.0, 0.0, 0.0, 1.0,
        1.0, 0.0, 0.0, 1.0, 0.0,
        1.0, 0.0, 1.0, 0.0, 0.0,
        1.0, 1.0, 0.0, 0.0, 0.0,
        1.0, 0.0, 0.0, 0.0, 0.0
    };
    double[] eight0 = {
        0.0, 0.0, 0.0, 0.0, 1.0,
        0.0, 0.0, 0.0, 1.0, 1.0,
        0.0, 0.0, 1.0, 0.0, 1.0,
        0.0, 1.0, 0.0, 0.0, 1.0,
        1.0, 0.0, 0.0, 0.0, 1.0,
        0.0, 0.0, 0.0, 0.0, 0.0,
        0.0, 0.0, 0.0, 0.0, 0.0
    };
    double[] nine0 = {
        0.0, 0.0, 0.0, 0.0, 0.0,
        0.0, 0.0, 0.0, 0.0, 0.0,
        0.0, 0.0, 1.0, 1.0, 0.0,
        0.0, 1.0, 0.0, 0.0, 1.0,
        0.0, 0.0, 1.0, 1.0, 1.0,
        0.0, 0.0, 0.0, 0.0, 1.0,
        0.0, 0.0, 0.0, 0.0, 1.0
    };

    double[] Ydes0 = {
        1.0, 0.0, 0.0, 0.0, 0.0,
        0.0, 0.0, 0.0, 0.0, 0.0
    };
    double[] Ydes1 = {
        0.0, 1.0, 0.0, 0.0, 0.0,
        0.0, 0.0, 0.0, 0.0, 0.0
    };
    double[] Ydes2 = {
        0.0, 0.0, 1.0, 0.0, 0.0,
        0.0, 0.0, 0.0, 0.0, 0.0
    };
    double[] Ydes3 = {
        0.0, 0.0, 0.0, 1.0, 0.0,
        0.0, 0.0, 0.0, 0.0, 0.0
    };
    double[] Ydes4 = {
        0.0, 0.0, 0.0, 0.0, 1.0,
        0.0, 0.0, 0.0, 0.0, 0.0
    };
    double[] Ydes5 = {
        0.0, 0.0, 0.0, 0.0, 0.0,
        1.0, 0.0, 0.0, 0.0, 0.0
    };
    double[] Ydes6 = {
        0.0, 0.0, 0.0, 0.0, 0.0,
        0.0, 1.0, 0.0, 0.0, 0.0
    };
    double[] Ydes7 = {
        0.0, 0.0, 0.0, 0.0, 0.0,
        0.0, 0.0, 1.0, 0.0, 0.0
    };
    double[] Ydes8 = {
        0.0, 0.0, 0.0, 0.0, 0.0,
        0.0, 0.0, 0.0, 1.0, 0.0
    };
    double[] Ydes9 = {
        0.0, 0.0, 0.0, 0.0, 0.0,
        0.0, 0.0, 0.0, 0.0, 1.0
    };

    ArrayList< sample> allsample = new ArrayList< sample>();

    ArrayList< double[]> withoutnois = new ArrayList< double[]>();
    ArrayList< double[]> Ydes = new ArrayList< double[]>();

    public all() {

       

        Ydes.add(Ydes0);
        Ydes.add(Ydes1);
        Ydes.add(Ydes2);
        Ydes.add(Ydes3);
        Ydes.add(Ydes4);
        Ydes.add(Ydes5);
        Ydes.add(Ydes6);
        Ydes.add(Ydes7);
        Ydes.add(Ydes8);
        Ydes.add(Ydes9);
        
        
        
        
        withoutnois.add(zero0);
        withoutnois.add(one0);
        withoutnois.add(two0);
        withoutnois.add(three0);
        withoutnois.add(four0);
        withoutnois.add(five0);
        withoutnois.add(six0);
        withoutnois.add(seven0);
        withoutnois.add(eight0);
        withoutnois.add(nine0);

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 20; j++) {
                double[] tmp = new double[36];
                tmp = (double[]) withoutnois.get(i).clone();
                Random rand = new Random();
                int randomNum;
                int num = rand.nextInt((3 - 0) + 1) + 0;
                for (int k = 0; k < num; k++) {
                    randomNum = rand.nextInt((34 - 0) + 1) + 0;
                    if (tmp[randomNum] != 1.0) {
                        tmp[randomNum] = 0.4;
                    }
                }
                sample tmpp =new sample();
                
                tmpp.number=(tmp);
                  tmpp.intnumber=(i);
                    tmpp.yde=(Ydes.get(i));
                    allsample.add(tmpp);
            }

        }

    }

    public static int getIndexOfLargest(double[] array) {
        if (array == null || array.length == 0) {
            return -1; // null or empty
        }
        int largest = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[largest]) {
                largest = i;
            }
        }
        return largest; // position of the first largest found
    }

    public static double max(double[] t) {
        double maximum = t[0];   // start with the first value
        for (int i = 1; i < t.length; i++) {
            if (t[i] > maximum) {
                maximum = t[i];   // new maximum
            }
        }
        return maximum;
    }//end method max

     NuralNetwork zeronetwork;
    public void input(int numofnural, int numofhiden, double alpha, int itration, double[] mode) {

         zeronetwork = new NuralNetwork(numofnural, numofhiden, allsample, 0, itration);
//         NuralNetwork onenetwork = new NuralNetwork(numofnural, numofhiden, allsample, 1, itration);
        zeronetwork.claculate(mode);

    }
     public void train( double[] mode) {
 

       zeronetwork.claculate(mode); 
           }
    public static void main(String[] args) {
        all colection = new all();
        colection.input(9, 2, 0.5, 10000,colection.one0);

    }

}
