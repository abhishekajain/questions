package com.abhi.opencv;

import java.util.ArrayList;
import java.util.List;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Rect;
import org.opencv.core.Size;
import org.opencv.highgui.Highgui;
import org.opencv.imgproc.Imgproc;

public class Dimensions {
	
	private static long[] midpoint(long[] pointA, long[] pointB){
		long a = (pointA[0] + pointB[0]) /2;
		long b = (pointA[1] + pointB[1]) /2;

		long[] midPoint = {a, b};
		return midPoint;
	}
	
	public static void main(String[] args){
		System.out.println("Welcome to OpenCV " + Core.VERSION);
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		Mat m = Mat.eye(3, 3, CvType.CV_8UC1);
		System.out.println("m = " + m.dump());
//		load the image, convert it to grayscale, and blur it slightly
		String imageFile = "/home/isengard/Downloads/size-of-objects/images/example_01.png";
		Mat image = Highgui.imread(imageFile);
		Imgproc.cvtColor(image, image, Imgproc.COLOR_BGR2GRAY);
		Imgproc.GaussianBlur(image, image, new Size(7, 7), 0);
		
//		# perform edge detection, then perform a dilation + erosion to
//		# close gaps in between object edges
		Imgproc.Canny(image, image, 50, 100);
		Imgproc.dilate(image, image, new Mat());
		Imgproc.erode(image, image, new Mat());
		
//		# find contours in the edge map
		List<MatOfPoint> contours = new ArrayList<MatOfPoint>();
		Imgproc.findContours(image.clone(), contours, new Mat(), Imgproc.RETR_EXTERNAL,
				Imgproc.CHAIN_APPROX_SIMPLE);
		int counter = 1;
		for(MatOfPoint contour: contours){
			if(contour == null || Imgproc.contourArea(contour)< 100){
				continue;
			}
			Mat orig = image.clone();
			try{
				Rect rect = Imgproc.boundingRect(contour);
				System.out.println(rect.area());
			}catch(Exception e){
				System.err.println(e);
				//continue;
			}
			
			Highgui.imwrite(imageFile+counter+".jpg", orig);
			counter++;
			
		}
	
	}

}
