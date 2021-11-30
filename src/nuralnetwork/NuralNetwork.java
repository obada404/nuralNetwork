/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nuralnetwork;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import static javafx.scene.input.KeyCode.T;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javax.swing.JFrame;

public class NuralNetwork {

    public static void min_max(double age[], double min, double max) {

        double new_min = 0;
        double new_max = 1;

        System.out.println("min= " + min + " max= " + max + "\n");

        double v1;

        for (int i = 0; i < age.length; i++) {

            v1 = (((age[i] - Arrays.stream(age).min().getAsDouble()) * (max - min)) / (Arrays.stream(age).max().getAsDouble() - Arrays.stream(age).min().getAsDouble())) + 0;
            System.out.println("value v1 for " + age[i] + "=" + v1);
        }
    }

    public double softmax(double input, double[] neuronValues) {
        double total;
        total = Arrays.stream(neuronValues).map(Math::exp).sum();
        return Math.exp(input) / total;
    }

    public ArrayList<nural> layer(int numOfNural, ArrayList<nural> prev) {
        ArrayList<nural> layer = new ArrayList<nural>();
        for (int i = 0; i < numOfNural; i++) {
            layer.add(new nural());
        }

        for (nural x : prev) {
            for (nural y : layer) {
                x.next.add(y);
                y.previos.add(x);
            }
        }
        for (int j = 0; j < layer.size(); j++) {
            for (int i = 0; i < prev.size(); i++) {

                Wight h = new Wight();

                prev.get(i).nexwight.add(h);

                layer.get(j).prewight.add(h);
            }
        }

        return layer;
    }

    public ArrayList<nural> firstlayer(int numOfNural, ArrayList<inputnural> prev) {

        ArrayList<nural> layer = new ArrayList<nural>();
        for (int i = 0; i < numOfNural; i++) {
            layer.add(new nural());
        }
        for (inputnural x : prev) {
            for (nural y : layer) {
                x.next.add(y);
                y.previos.add(x);
//                System.out.println( y.previos.get(0).Y);
            }
        }
        for (int j = 0; j < layer.size(); j++) {
            for (int i = 0; i < prev.size(); i++) {

                Wight h = new Wight();

                prev.get(i).intialNextWight(h);

                layer.get(j).prewight.add(h);
            }
        }

        return layer;
    }

    public ArrayList<nural> lastlayer(ArrayList<nural> prev) {

        ArrayList<nural> layer = new ArrayList<nural>();
        for (int i = 0; i < 10; i++) {
            layer.add(new nural());
        }
        for (nural x : prev) {
            for (nural y : layer) {
                x.next.add(y);
                y.previos.add(x);

            }
        }
        for (int j = 0; j < layer.size(); j++) {
            for (int i = 0; i < prev.size(); i++) {

                Wight h = new Wight();

                prev.get(i).nexwight.add(h);

                layer.get(j).prewight.add(h);
            }
        }

//              for (int i = 0; i <prev.size(); i++) { 
//             for (int j = 0; j < layer.size(); j++) { 
//            System.out.println(prev.get(i).nexwight.get(j).w );
//              System.out.println(layer.get(j).prewight.get(i).w);
//
//             }
//        }
        return layer;
    }
    public ArrayList<ArrayList<nural>> allNetwork = new ArrayList<ArrayList<nural>>();
    public ArrayList<inputnural> inputlayer = new ArrayList<inputnural>();
    public ArrayList<nural> layerout;

    public NuralNetwork(int numofnural, int numberoflayer, ArrayList< sample> sample,  double yde, int maxNumOfitra) {

        for (int i = 0; i < numberoflayer; i++) {
            ArrayList<nural> layer1 = new ArrayList<>();
            for (int j = 0; j < numofnural; j++) {
                layer1.add(new inputnural());

            }
            allNetwork.add(layer1);
        }

        for (int i = 0; i < 35; i++) {

            inputlayer.add(new inputnural());
        }
        allNetwork.set(0, firstlayer(numofnural, inputlayer));
        for (int i = 1; i < numberoflayer; i++) {

            allNetwork.set(i, layer(numofnural, layer(numofnural, allNetwork.get(i - 1))));
        }

        layerout = lastlayer(allNetwork.get(allNetwork.size() - 1));

        int z = 0;

        outerloop:
        while (true) {
           
                int i = ThreadLocalRandom.current().nextInt(0, sample.size());
                
//               for(int i=0;i< sample.size();i++){
                  
                    z++;
                    if (z == maxNumOfitra) {
                        break outerloop;
                    }
                    
//                     if (sample.get(i).intnumber != 0) 
//                         continue;
                     
                      System.out.println();
                    printarray(sample.get(i).number);
                    
                   printarray(sample.get(i).yde);
                    this.claculate(sample.get(i).number,sample.get(i).yde);

                    System.out.println(sample.get(i).intnumber);
                
              System.out.println();
//               }

        }

//        for (int i = 0; i < sample.size(); i++) {
//            for (int j = sample.get(i).size() - 5; j < sample.get(i).size(); j++) {
//                this.claculate(sample.get(i).get(j));
//                System.out.println(i);
//            }
//        }
    }

    public void claculate(double[] arr, double Ydes) {

        for (int i = 0; i < 35; i++) {

            inputlayer.set(i, new inputnural(arr[i]));
        }

        for (ArrayList<nural> out : allNetwork) {
            for (nural in : out) {
                in.calculate_Y(false);
            }
        }

        for (int i = 0; i < layerout.size(); i++) {
            layerout.get(i).calculateYOutput();
            layerout.get(i).gradentErrorOutput(Ydes);
        }
        double[] arrgg = new double[layerout.size()];
        for (int i = 0; i < layerout.size(); i++) {
            arrgg[i] = layerout.get(i).Y;
            System.out.println(layerout.get(i).Y);
        }

        //  min_max(arrgg,0.0,1.0);
        for (int i = allNetwork.size() - 1; i > 0; i--) {
            for (nural in : allNetwork.get(i)) {
                in.gradenterror();

            }
        }

        for (nural x : layerout) {

            x.changeWight();
        }

        for (int i = allNetwork.size() - 1; i > 0; i--) {

            for (nural in : allNetwork.get(i)) {
                in.changeWight();
            }
        }

    }

    public void claculate(double[] arr, double[] Ydes) {

        for (int i = 0; i < 35; i++) {

            inputlayer.set(i, new inputnural(arr[i]));
        }

        for (ArrayList<nural> out : allNetwork) {
            for (nural in : out) {
                in.calculate_Y(false);
            }
        }

        for (int i = 0; i < layerout.size(); i++) {
            layerout.get(i).calculateYOutput();
            layerout.get(i).gradentErrorOutput(Ydes[i]);
        }
        double[] arrgg = new double[layerout.size()];
        for (int i = 0; i < layerout.size(); i++) {
            arrgg[i] = layerout.get(i).Y;
            System.out.println(layerout.get(i).Y);
        }

        for (int i = allNetwork.size() - 1; i > 0; i--) {
            for (nural in : allNetwork.get(i)) {
                in.gradenterror();

            }
        }

        for (nural x : layerout) {

            x.changeWight();
        }

        for (int i = allNetwork.size() - 1; i > 0; i--) {

            for (nural in : allNetwork.get(i)) {
                 in.changeWight();
            }
        }

      

    }

    void calcWight() {

        for (nural x : layerout) {

            x.changeWight2();
        }

        for (int i = allNetwork.size() - 1; i > 0; i--) {

            for (nural in : allNetwork.get(i)) {
                in.changeWight2();
            }
        }

    }

    public double[] claculate(double[] arr) {

        for (int i = 0; i < 35; i++) {

            inputlayer.set(i, new inputnural(arr[i]));
        }

        for (ArrayList<nural> out : allNetwork) {
            for (nural in : out) {
                in.calculate_Y(false);
            }
        }

        for (int i = 0; i < layerout.size(); i++) {
            layerout.get(i).calculateYOutput();
        }
        double[] arrgg = new double[layerout.size()];

        for (int i = 0; i < layerout.size(); i++) {
            arrgg[i] = softmax(layerout.get(i).Y, arrgg);
            System.out.println(softmax(layerout.get(i).Y, arrgg));
        }

//        System.out.println(" ");
//        System.out.println(" ");
//        System.out.println(" ");
        return arrgg;

        //  min_max(arrgg,0.0,1.0);
//           
//         for(ArrayList<nural> out :allNetwork){
//            for (nural in : out) {
//            in.gradenterror();
//        }
//        }
//         for (nural x : layerout) {
//            x.changeWight();
//        }
//         for(ArrayList<nural> out :allNetwork){
//            for (nural in : out) {
//            in.changeWight();
//        }
//        }
//        
    }

    public void printarray(double[] nums) {
        //while loop to iterate over elements of array
        //index is used to access elements of array
        int index = 0;
        int l = 0;
        while (index < nums.length) {
            //get element
            l++;
            double num = nums[index];
            //work with element
            System.out.print(num + " ");
            if (l == 5) {
                System.out.println();
                l = 0;
            }
            //increment index
            index++;
        }
    }

}
