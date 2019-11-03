package test;

import java.awt.image.BufferedImage;
import java.io.File;

import junit.framework.TestCase;
import mnist.MnistImageFile;
import mnist.MnistImageLoader;
/**
 *
 * @author mansi
 */
public class MnistImageLoaderTest extends TestCase {
	
	String path = new File("").getAbsolutePath();
	 
	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testLoadImage() throws Exception {
		BufferedImage im = MnistImageLoader.loadImage(path + "/res/dummy.jpg");
		BufferedImage im2 = MnistImageLoader.loadImage(path + "/res/dummy2.jpg");
		assertEquals(im.getRGB(0, 0),im2.getRGB(0, 0));
		assertEquals(im.getRGB(14, 14),im2.getRGB(14, 14));
	}


	public void testBufferedImageToArray() throws Exception {
		BufferedImage im = MnistImageLoader.loadImage(path + "/res/dummy.jpg");
		BufferedImage im2 = MnistImageLoader.loadImage(path + "/res/dummy2.jpg");
		int arr1[][] = MnistImageLoader.bufferedImageToArray(im);
		int arr2[][] = MnistImageLoader.bufferedImageToArray(im2);
		assertEquals(arr1[0][0],arr2[0][0]);
		assertEquals(arr1[12][12],arr1[12][12]);
	}

	public void testBufferedImageRedToArray() throws Exception {
		BufferedImage im = MnistImageLoader.loadImage(path + "/res/dummy.jpg");
		BufferedImage im2 = MnistImageLoader.loadImage(path + "/res/dummy2.jpg");
		int arr1[][] = MnistImageLoader.bufferedImageToArray(im);
		int arr2[][] = MnistImageLoader.bufferedImageToArray(im2);
		assertEquals(arr1[0][0],arr2[0][0]);
		assertEquals(arr1[20][20],arr1[20][20]);
	}

	public void testIntArrayToDoubleArray() throws Exception {
		BufferedImage im = MnistImageLoader.loadImage(path + "/res/dummy.jpg");
		int arr1[][] = MnistImageLoader.bufferedImageRedToArray(im);
		double arr[] = MnistImageLoader.intArrayToDoubleArray(arr1);
		assertEquals(arr1[0][0]/256,(int)arr[0]);
		assertEquals(arr1[27][27]/256,(int)arr[783]);
	}

	public void testIntArrayTointArray() throws Exception {
		BufferedImage im = MnistImageLoader.loadImage(path + "/res/dummy.jpg");
		int arr1[][] = MnistImageLoader.bufferedImageRedToArray(im);
		int arr[] = MnistImageLoader.intArrayTointArray(arr1);
		assertEquals(arr1[0][0],arr[0]);
		assertEquals(arr1[27][27],arr[783]);
	}

	public void testInvert() throws Exception {
		BufferedImage im = MnistImageLoader.loadImage(path + "/res/dummy.jpg");
		int arr1[][] = MnistImageLoader.bufferedImageRedToArray(im);
		double arr[] = MnistImageLoader.intArrayToDoubleArray(arr1);
		double arr2[] = MnistImageLoader.invert(arr); 
		assertEquals(0.9999,arr2[0]);
		assertEquals(0.9999,arr2[783]);
	}

}
