package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fullyconnectednetwork.Network;
import junit.framework.TestCase;
import trainingset.TrainSet;

/**
 *
 * @author janvi
 */

public class NetworkTesting extends TestCase {
	
	Network net = new Network(2,2,2,2);

	protected void setUp() throws Exception {
		super.setUp();
		net = new Network(2,2,2,2);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	
	public void testNetwork() {
		assertEquals(net.INPUT_SIZE,net.NETWORK_LAYER_SIZES[0]);
		assertEquals(net.NETWORK_LAYER_SIZES.length,net.NETWORK_SIZE);
		Network net2 = new Network(2,2,2,2);
		assertNotSame(net2.output[3][1],net.output[3][1]);
		assertNotSame(net2.output[3][1],net.output[3][1]);
	}


	public void testCalculate() {
		Network net1 = new Network(1,1,1,1);
		Network net2 = new Network(1,1,1,1);
		
        for(int i = 0; i < net1.NETWORK_SIZE; i++) {
        	double a[] = {0.0};
        	net1.bias[i] =a;
            net2.bias[i]=a;
            net1.weights[i]=net2.weights[i];
            
        }
        double inputs[] = {1.0};
        double i1[] = net1.calculate(inputs);
        double i2[] = net2.calculate(inputs);
        
        assertEquals(i1[0],i2[0]);
        //assertEquals(i1[1],i2[1]);
	}



	@SuppressWarnings({ "restriction" })
	@Test
	public void testMSEDoubleArrayDoubleArray() {
		double a[] = {0.0,0.0};
		double b[] = {1,2,3};
		double c[] = {0.0,0.0};
		assertEquals((int)net.MSE(a,b),(int) 0.0);
		assertEquals((int) net.MSE(a,c), (int) 0.0);
		
	}


	public void testMSETrainSet() {
		TrainSet ts = new TrainSet(1,1);
		double in[] = {0.0};
		double out[] = {0.0};
		ts.addData(in,out);
		Network n = new Network(1,1);
        for(int i = 0; i < n.NETWORK_SIZE; i++) {
            double a[] = {0.0};
        	n.bias[i] = a;

            if(i > 0) {
            	double b[] = {1.0};
            	double c[][] = {b};
                n.weights[i] = c;
            }
        }
		assertEquals((int) n.MSE(ts),(int) 0.0);
	}
	

	public void testSigmoid() {
		assertEquals(net.sigmoid(0),0.5);
	}

}
