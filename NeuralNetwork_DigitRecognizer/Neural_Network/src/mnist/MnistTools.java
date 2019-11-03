
package mnist;

/**
 *
 * @author mansi
 */
import fullyconnectednetwork.Network;
import fullyconnectednetwork.NetworkTools;
import java.awt.image.BufferedImage;
import trainingset.TrainSet;
import mnist.MnistImageLoader;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MnistTools {


    

    public static TrainSet createTrainSet(int start, int end) {

        TrainSet set = new TrainSet(28 * 28, 10);

        try {

            String path = new File("").getAbsolutePath();

            MnistImageFile m = new MnistImageFile(path + "/res/trainImage.idx3-ubyte", "rw");
            MnistLabelFile l = new MnistLabelFile(path + "/res/trainLabel.idx1-ubyte", "rw");

            for(int i = start; i <= end; i++) {
                if(i % 1000 ==  0){
                    System.out.println("Images prepared: " + i);
                }

                double[] input = new double[28 * 28];
                double[] output = new double[10];

                output[l.readLabel()] = 1d;
                for(int j = 0; j < 28*28; j++){
                    input[j] = (double)m.read() / (double)256;
                }

                set.addData(input, output);
                m.next();
                l.next();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

         return set;
    }

    public static void trainData(Network net,TrainSet set, int epochs, int loops, int batch_size) {
        for(int e = 0; e < epochs;e++) {
            net.train(set, loops, batch_size);
            System.out.println(" \n\nEPOCH NUMBER :  "+ e+"\n\n");
        }
    }

    public static double testTrainSet(Network net, TrainSet set, int printSteps) {
        int correct = 0;
        for(int i = 0; i < set.size(); i++) {

            double highest = NetworkTools.indexOfHighestValue(net.calculate(set.getInput(i)));
            double actualHighest = NetworkTools.indexOfHighestValue(set.getOutput(i));
            if(highest == actualHighest) {

                correct ++ ;
            }
            if(i % printSteps == 0) {
                System.out.println(i + ": " + (double)correct / (double) (i + 1));
            }
        }
        System.out.println("Testing FINISHED, RESULT: " + correct + " / " + set.size()+ "  -> " + (double)correct * 100 / (double)set.size() +" %");
        
        return (double)correct * 100 / (double)set.size();
    }
}