
package fullyconnectednetwork;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import trainingset.TrainSet;

/**
 *
 * @author anish
 */
public class NetworkTest {
    
    public NetworkTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of calculate method, of class Network.
     */
    @org.junit.Test
    public void testCalculate() {
        System.out.println("calculate");
        double[] input = null;
        Network instance = null;
        double[] expResult = null;
        double[] result = instance.calculate(input);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of train method, of class Network.
     */
    @org.junit.Test
    public void testTrain_3args_1() {
        System.out.println("train");
        TrainSet set = null;
        int loops = 0;
        int batch_size = 0;
        Network instance = null;
        instance.train(set, loops, batch_size);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of MSE method, of class Network.
     */
    @org.junit.Test
    public void testMSE_doubleArr_doubleArr() {
        System.out.println("MSE");
        double[] input = null;
        double[] target = null;
        Network instance = null;
        double expResult = 0.0;
        double result = instance.MSE(input, target);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of MSE method, of class Network.
     */
    @org.junit.Test
    public void testMSE_TrainSet() {
        System.out.println("MSE");
        TrainSet set = null;
        Network instance = null;
        double expResult = 0.0;
        double result = instance.MSE(set);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of train method, of class Network.
     */
    @org.junit.Test
    public void testTrain_3args_2() {
        System.out.println("train");
        double[] input = null;
        double[] target = null;
        double eta = 0.0;
        Network instance = null;
        instance.train(input, target, eta);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of backpropError method, of class Network.
     */
    @org.junit.Test
    public void testBackpropError() {
        System.out.println("backpropError");
        double[] target = null;
        Network instance = null;
        instance.backpropError(target);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateWeights method, of class Network.
     */
    @org.junit.Test
    public void testUpdateWeights() {
        System.out.println("updateWeights");
        double eta = 0.0;
        Network instance = null;
        instance.updateWeights(eta);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
